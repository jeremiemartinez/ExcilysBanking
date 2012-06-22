
package com.excilys.excilysbanking.web.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.excilys.excilysbanking.entities.Authority;

@Controller
public class LoginController {

	// public static void main(String[] args) {
	// ShaPasswordEncoder enc = new ShaPasswordEncoder();
	// System.out.println(enc.encodePassword("lucestunbizu", "jmartinez"));
	// }

	@RequestMapping("/index.html")
	public String index() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth.getPrincipal().equals("anonymousUser"))
			return "/index";
		else {
			for (GrantedAuthority a : auth.getAuthorities()) {
				if (a.getAuthority().equals(Authority.AuthorityType.ROLE_ADMIN.name())) {

					return "redirect:/secured/admin/admin.html";
				}
			}
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
