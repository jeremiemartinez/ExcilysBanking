package com.excilys.excilysbanking.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/secured")
public class ComptesController {

	@RequestMapping("/comptes.html")
	public String comptes() {
		return "/secured/comptes";
	}
}
