
package com.excilys.excilysbanking.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/secured/admin/")
public class AdminController {

	@RequestMapping("admin.html")
	public String admin() {
		return "/secured/admin/admin";
	}

}
