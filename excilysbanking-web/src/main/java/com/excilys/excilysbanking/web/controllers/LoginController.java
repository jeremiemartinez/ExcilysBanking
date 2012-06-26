
package com.excilys.excilysbanking.web.controllers;

import java.util.Locale;
import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import com.excilys.excilysbanking.services.UserService;

@Controller
public class LoginController {
	
	@Autowired
	private UserService userService;
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@RequestMapping("/_change_locale_to_{lang}")
	public String changeLocale(@PathVariable String lang, HttpSession session) {
		Locale l = null;
		if ("fr".equals(lang))
			l = Locale.FRENCH;
		else
			l = Locale.ENGLISH;
		session.setAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME, l);
		return "redirect:/index";
	}
	
	@RequestMapping(value = { "/", "/index" })
	public String index() {
		log.debug("I go through LoginController");
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (userService.isConnected(auth))
			return "/index";
		else {
			if (userService.isAdmin(auth))
				return "redirect:/secured/admin/admin";
			else
				return "redirect:/secured/comptes";
		}
	}
	
	@RequestMapping("/loginFail")
	public String loginFail(Model m) {
		m.addAttribute("errorLogin", true);
		return "/index";
	}
	
	@RequestMapping("/sessionTimeOut")
	public String sessionTimeOut(Model m) {
		m.addAttribute("errorSessionTimeOut", true);
		return "/index";
	}
	
	@RequestMapping("/tooManySession")
	public String tooManySessions(Model m) {
		m.addAttribute("errorTooManySessions", true);
		return "/index";
	}
	
	@RequestMapping("/404")
	public String error404() {
		return "/404";
	}
	
	@RequestMapping("/403")
	public String error403() {
		return "/403";
	}
}
