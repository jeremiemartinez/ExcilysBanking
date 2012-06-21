
package com.excilys.excilysbanking.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

	// public static void main(String[] args) {
	// ShaPasswordEncoder enc = new ShaPasswordEncoder();
	// System.out.println(enc.encodePassword("lucestunbizu", "jmartinez"));
	// }

	@RequestMapping("/index.html")
	public String index() {
		return "/index";
	}

	@RequestMapping("/login.html")
	public String login() {
		return "/login";
	}

	@RequestMapping("/loginFail.html")
	public String loginFail(Model m) {
		m.addAttribute("errorLogin", true);
		return "/login";
	}

	@RequestMapping("/sessionTimeOut.html")
	public String sessionTimeOut(Model m) {
		m.addAttribute("errorSessionTimeOut", true);
		return "/login";
	}

	@RequestMapping("/tooManySession.html")
	public String tooManySessions(Model m) {
		m.addAttribute("errorTooManySessions", true);
		return "/login";
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
