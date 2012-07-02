
package com.excilys.excilysbanking.web.controllers;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.excilys.excilysbanking.entities.User;
import com.excilys.excilysbanking.services.CompteService;
import com.excilys.excilysbanking.services.OperationService;
import com.excilys.excilysbanking.services.UserService;
import com.excilys.excilysbanking.web.views.VirementForm;

@Controller
@RequestMapping("/secured")
public class VirementsController {

	public static final int CARTES_PER_PAGE = 5;
	public static final int VIREMENTS_PER_PAGE = 20;

	@Autowired
	private UserService userService;

	@Autowired
	private CompteService compteService;

	@Autowired
	private OperationService operationService;

	@RequestMapping(value = "/virement", method = RequestMethod.GET)
	public String displayVirementForm(Model m) {
		User currentUser = userService.getConnectedUser();
		if (userService.isAdmin(SecurityContextHolder.getContext().getAuthentication()))
			m.addAttribute("isAdmin", "true");
		m.addAttribute("comptesList", compteService.getComptesByUsername(currentUser.getUsername()));
		VirementForm virementForm = new VirementForm();
		m.addAttribute("virementForm", virementForm);
		return "/secured/virement";
	}

	@RequestMapping(value = "/virement", method = RequestMethod.POST)
	public String validateVirementForm(@Valid @ModelAttribute("virementForm") VirementForm virementForm, BindingResult result, Model m) {
		User currentUser = userService.getConnectedUser();
		if (userService.isAdmin(SecurityContextHolder.getContext().getAuthentication()))
			m.addAttribute("isAdmin", "true");
		if (result.hasErrors()) {
			m.addAttribute("comptesList", compteService.getComptesByUsername(currentUser.getUsername()));
			m.addAttribute("virementForm", virementForm);
			return "/secured/virement";
		}
		processVirement(virementForm, m);
		return "redirect:/secured/comptes";

	}

	private void processVirement(VirementForm virementForm, Model m) {
		operationService.createVirementOperations(virementForm.compteDebit, virementForm.compteCredit, Double.valueOf(virementForm.montant),
				virementForm.libelle);
		m.addAttribute("virementSucceed", true);
	}

	@RequestMapping("/historiqueVirements/id/{id}")
	public String historiqueVirement(Model m, @PathVariable Integer id) {
		return historiqueVirementPaged(m, id, 1);
	}

	@RequestMapping("/historiqueVirements/id/{id}/page/{page}")
	public String historiqueVirementPaged(Model m, @PathVariable Integer id, @PathVariable Integer page) {

		if (userService.isAdmin(SecurityContextHolder.getContext().getAuthentication()))
			m.addAttribute("isAdmin", "true");

		// Infos
		m.addAttribute("id", id);

		// Pages navigation
		Long totalOperations = operationService.getNumberOperationsVirementNegatifLast6Months(id);
		long lastPage = totalOperations / VIREMENTS_PER_PAGE;
		if (totalOperations % VIREMENTS_PER_PAGE != 0)
			lastPage++;

		m.addAttribute("operationsList", operationService.getOperationsVirementNegatifLast6Months(id, VIREMENTS_PER_PAGE, page));
		m.addAttribute("currentPage", page);
		m.addAttribute("nextPage", page + 1);
		m.addAttribute("previousPage", page - 1);
		m.addAttribute("firstPage", 1);
		m.addAttribute("lastPage", lastPage);
		m.addAttribute("isLastPage", page == lastPage);
		m.addAttribute("isFirstPage", page == 1);

		return "/secured/historiqueVirements";

	}
}
