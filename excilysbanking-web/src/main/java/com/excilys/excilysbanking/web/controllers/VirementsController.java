
package com.excilys.excilysbanking.web.controllers;

import static com.excilys.excilysbanking.web.controllers.ControllerUtil.VIREMENTS_PER_PAGE;
import static com.excilys.excilysbanking.web.controllers.ControllerUtil.addPagingInformation;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.excilys.excilysbanking.services.CompteService;
import com.excilys.excilysbanking.services.OperationService;
import com.excilys.excilysbanking.services.UserService;
import com.excilys.excilysbanking.web.views.VirementForm;

@Controller
@RequestMapping("/secured")
public class VirementsController {

	@Autowired
	private UserService userService;

	@Autowired
	private CompteService compteService;

	@Autowired
	private OperationService operationService;

	// Virement Processor

	@RequestMapping(value = "/virement", method = RequestMethod.GET)
	public String displayVirementForm(Model m) {
		m.addAttribute("comptesList", compteService.getComptesByUsername(userService.getConnectedUser().getUsername()));
		m.addAttribute("virementForm", new VirementForm());
		return "/secured/virement";
	}

	@RequestMapping(value = "/virement", method = RequestMethod.POST)
	public String validateVirementForm(@Valid @ModelAttribute("virementForm") VirementForm virementForm, BindingResult result, Model m) {
		if (result.hasErrors()) {
			m.addAttribute("comptesList", compteService.getComptesByUsername(userService.getConnectedUser().getUsername()));
			m.addAttribute("virementForm", virementForm);
			return "/secured/virement";
		}
		processVirement(virementForm, m);
		return "redirect:/secured/comptes";

	}

	private void processVirement(VirementForm virementForm, Model m) {
		boolean result = operationService.createVirementOperations(userService.getConnectedUser(), virementForm.compteDebit, virementForm.compteCredit,
				Double.valueOf(virementForm.montant), virementForm.libelle);
		if (result)
			m.addAttribute("virementSucceed", true);
		else
			m.addAttribute("virementSucceed", false);
	}

	// Manager of Historique Virement

	@RequestMapping("/historiqueVirements/id/{id}")
	public String historiqueVirement(Model m, @PathVariable Integer id) {
		return historiqueVirementPaged(m, id, 1);
	}

	@RequestMapping("/historiqueVirements/id/{id}/page/{page}")
	public String historiqueVirementPaged(Model m, @PathVariable Integer id, @PathVariable Integer page) {

		// Infos
		m.addAttribute("id", id);

		// Pages navigation
		Long totalOperations = operationService.getNumberOperationsVirementNegatifLast6Months(id);
		long lastPage = totalOperations / VIREMENTS_PER_PAGE;
		if (totalOperations % VIREMENTS_PER_PAGE != 0)
			lastPage++;

		// Creating Model
		m.addAttribute("operationsList", operationService.getOperationsVirementNegatifLast6Months(id, VIREMENTS_PER_PAGE, page));
		addPagingInformation(m, page, lastPage);

		return "/secured/historiqueVirements";
	}
}
