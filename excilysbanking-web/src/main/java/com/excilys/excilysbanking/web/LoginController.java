
package com.excilys.excilysbanking.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
	
	@RequestMapping("/index.html")
	public String index() {
		return "/index";
	}
	
	@RequestMapping("/login.html")
	public String login() {
		// if
		// (SecurityContextHolder.getContext().getAuthentication().getPrincipal().equals("anonymousUser"))
		// return "/login";
		// return "redirect:/secured/comptes.html";
		return "/login";
	}
	
	@RequestMapping("/404.html")
	public String error404() {
		return "/404";
	}
}
