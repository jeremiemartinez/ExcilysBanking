
package com.excilys.excilysbanking.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.excilys.excilysbanking.services.CompteService;
import com.excilys.excilysbanking.services.UserService;

@Controller
@RequestMapping("/secured/admin/")
public class AdminController {

	@Autowired
	private UserService userService;

	@Autowired
	private CompteService compteService;

	@RequestMapping("admin.html")
	public String admin(Model m) {
		m.addAttribute("usersList", userService.getAllUsers());
		m.addAttribute("comptesList", compteService.getAllComptes());
		return "/secured/admin/admin";
	}
}
