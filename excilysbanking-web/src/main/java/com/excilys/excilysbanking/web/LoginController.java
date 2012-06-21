
package com.excilys.excilysbanking.web;

import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
	
	public static void main(String[] args) {
		ShaPasswordEncoder enc = new ShaPasswordEncoder();
		System.out.println(enc.encodePassword("lucestunbizu", "jmartinez"));
	}
	
	@RequestMapping("/index.html")
	public String index() {
		return "/index";
	}
	
	@RequestMapping("/login.html")
	public String login() {
		return "/login";
	}
	
	@RequestMapping("/loginfail.html")
	public String loginFail(Model m) {
		m.addAttribute("error", true);
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
