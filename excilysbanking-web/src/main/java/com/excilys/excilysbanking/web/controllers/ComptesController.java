
package com.excilys.excilysbanking.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.excilys.excilysbanking.entities.User;
import com.excilys.excilysbanking.services.CompteService;
import com.excilys.excilysbanking.services.UserService;

@Controller
@RequestMapping("/secured")
public class ComptesController {

	@Autowired
	private UserService userService;

	@Autowired
	private CompteService compteService;

	@RequestMapping("/comptes.html")
	public String comptes(Model m) {
		String username = ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername();
		User currentUser = userService.getUserByUsername(username);
		String name = currentUser.getFirstname() + " " + currentUser.getLastname();
		m.addAttribute("name", name);
		m.addAttribute("comptesList", compteService.getComptesByUsername(username));
		return "/secured/comptes";
	}
}
