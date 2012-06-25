
package com.excilys.excilysbanking.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.excilys.excilysbanking.services.UserService;

@Controller
public class LoginController {

	// public static void main(String[] args) {
	// ShaPasswordEncoder enc = new ShaPasswordEncoder();
	// System.out.println(enc.encodePassword("lucestunbizu", "jmartinez"));
	// }

	@Autowired
	private UserService userService;

	// isConnected
	// isAdmin
	@RequestMapping("/index.html")
	public String index() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (userService.isConnected(auth))
			return "/index";
		else {
			if (userService.isAdmin(auth))
				return "redirect:/secured/admin/admin.html";
			else
				return "redirect:/secured/comptes.html";
		}
	}

	@RequestMapping("/loginFail.html")
	public String loginFail(Model m) {
		m.addAttribute("errorLogin", true);
		return "/index";
	}

	@RequestMapping("/sessionTimeOut.html")
	public String sessionTimeOut(Model m) {
		m.addAttribute("errorSessionTimeOut", true);
		return "/index";
	}

	@RequestMapping("/tooManySession.html")
	public String tooManySessions(Model m) {
		m.addAttribute("errorTooManySessions", true);
		return "/index";
	}

	@RequestMapping("/404.html")
	public String error404() {
		return "/404";
	}

	@RequestMapping("/403.html")
	public String error403() {
		return "/403";
	}
}
