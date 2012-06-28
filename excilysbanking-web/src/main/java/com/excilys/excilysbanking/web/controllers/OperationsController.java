
package com.excilys.excilysbanking.web.controllers;

import java.util.ArrayList;
import java.util.List;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.excilys.excilysbanking.services.OperationService;
import com.excilys.excilysbanking.services.UserService;

@Controller
@RequestMapping("/secured")
public class OperationsController {
	
	@Autowired
	private OperationService operationService;
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/operations/id/{id}/year/{year}/month/{month}")
	public String operations(Model m, @PathVariable Integer id, @PathVariable Integer year, @PathVariable Integer month) {
		
		if (userService.isAdmin(SecurityContextHolder.getContext().getAuthentication()))
			m.addAttribute("isAdmin", "true");
		
		DateTime now = DateTime.now();
		m.addAttribute("id", id);
		m.addAttribute("carteSum", operationService.getMontantOperationsCarteByCompteIdAndYearMonth(id, year, month));
		m.addAttribute("operationsList", operationService.getOperationsVirementByCompteIdAndYearMonth(id, year, month));
		m.addAttribute("operationsCarteList", operationService.getOperationsCarteByCompteIdAndYearMonth(id, year, month));
		
		List<String> prevMonths = new ArrayList<String>(5);
		for (int i = 0; i < 5; i++)
			prevMonths.add("month" + (now = now.plusMonths(1)).getMonthOfYear());
		m.addAttribute("previousMonths", prevMonths);
		
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
