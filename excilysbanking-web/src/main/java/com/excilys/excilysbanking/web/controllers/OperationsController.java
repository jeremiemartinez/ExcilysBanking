
package com.excilys.excilysbanking.web.controllers;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.excilys.excilysbanking.services.OperationService;

@Controller
@RequestMapping("/secured")
public class OperationsController {

	@Autowired
	private OperationService operationService;

	@RequestMapping("/operations/{id}/{year}_{month}")
	public String operations(Model m, @PathVariable Integer id, @PathVariable Integer year, @PathVariable Integer month) {
		DateTime now = DateTime.now();
		if (!(year.equals(now.getYear()) && month.equals(now.getMonthOfYear())))
			m.addAttribute("laterDate", calculateLaterDate(year, month));
		m.addAttribute("previousDate", calculatePreviousDate(year, month));
		m.addAttribute("id", id);
		m.addAttribute("carteSum", operationService.getMontantOperationsCarteByCompteIdAndYearMonth(id, year, month));
		m.addAttribute("operationsList", operationService.getOperationsVirementByCompteIdAndYearMonth(id, year, month));
		return "/secured/operations";
	}

	private String calculatePreviousDate(Integer year, Integer month) {
		StringBuilder sb = new StringBuilder();
		if (month.equals(new Integer(1)))
			sb.append(year - 1).append("_").append(12);
		else
			sb.append(year).append("_").append(month - 1);
		return sb.toString();
	}

	private String calculateLaterDate(Integer year, Integer month) {
		StringBuilder sb = new StringBuilder();
		if (month.equals(new Integer(12)))
			sb.append(year + 1).append("_").append(1);
		else
			sb.append(year).append("_").append(month + 1);
		return sb.toString();
	}
}
