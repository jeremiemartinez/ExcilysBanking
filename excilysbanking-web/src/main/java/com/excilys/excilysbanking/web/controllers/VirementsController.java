
package com.excilys.excilysbanking.web.controllers;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.excilys.excilysbanking.entities.User;
import com.excilys.excilysbanking.services.CompteService;
import com.excilys.excilysbanking.services.UserService;
import com.excilys.excilysbanking.web.views.VirementForm;

@Controller
@RequestMapping("/secured/virement")
public class VirementsController {

	@Autowired
	private UserService userService;

	@Autowired
	private CompteService compteService;

	@RequestMapping(method = RequestMethod.GET)
	public String displayVirementForm(Model m) {
		User currentUser = userService.getConnectedUser();
		if (userService.isAdmin(SecurityContextHolder.getContext().getAuthentication()))
			m.addAttribute("isAdmin", "true");
		m.addAttribute("comptesList", compteService.getComptesByUsername(currentUser.getUsername()));
		VirementForm virementForm = new VirementForm();
		m.addAttribute("virementForm", virementForm);
		return "/secured/virement";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String validateVirementForm(@Valid @ModelAttribute("virementForm") VirementForm virementForm, BindingResult result, Model m) {
		User currentUser = userService.getConnectedUser();
		if (userService.isAdmin(SecurityContextHolder.getContext().getAuthentication()))
			m.addAttribute("isAdmin", "true");
		if (result.hasErrors()) {
			m.addAttribute("error", "true");
			m.addAttribute("comptesList", compteService.getComptesByUsername(currentUser.getUsername()));
			m.addAttribute("virementForm", virementForm);
			return "/secured/virement";
		}
		return "/secured/comptes";

	}
}
