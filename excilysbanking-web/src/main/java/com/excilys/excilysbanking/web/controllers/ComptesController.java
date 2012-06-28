
package com.excilys.excilysbanking.web.controllers;

import org.joda.time.DateTime;
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
	
	@RequestMapping("/comptes")
	public String comptes(Model m) {
		User currentUser = userService.getConnectedUser();
		if (userService.isAdmin(SecurityContextHolder.getContext().getAuthentication()))
			m.addAttribute("isAdmin", "true");
		m.addAttribute("comptesList", compteService.getComptesByUsername(currentUser.getUsername()));
		m.addAttribute("date", buildDate());
		return "/secured/comptes";
	}
	
	private String buildDate() {
		DateTime datetime = DateTime.now();
		StringBuilder sb = new StringBuilder();
		return sb.append(datetime.getYear()).append("_").append(datetime.getMonthOfYear()).toString();
	}
}
