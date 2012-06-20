
package com.excilys.excilysbanking.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.excilys.excilysbanking.services.UserService;

@Controller
@RequestMapping("/test.html")
public class ControllerListing {

	@Autowired
	private UserService userService;

	@RequestMapping(method = RequestMethod.GET)
	public String doJob(Model m) {
		// m.addAttribute("nameCaller", userService.getUserByLogin("jmartinez").getName());
		m.addAttribute("listAllUsers", userService.getAllUsers());
		return "listing";
	}
}
