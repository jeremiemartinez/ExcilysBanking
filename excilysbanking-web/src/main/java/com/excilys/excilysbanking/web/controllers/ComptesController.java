
package com.excilys.excilysbanking.web.controllers;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
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
		m.addAttribute("comptesList", compteService.getComptesByUsername(userService.getConnectedUser().getUsername()));
		DateTime datetime = DateTime.now();
		m.addAttribute("year", datetime.getYear());
		m.addAttribute("month", datetime.getMonthOfYear());
		return "/secured/comptes";
	}
}
