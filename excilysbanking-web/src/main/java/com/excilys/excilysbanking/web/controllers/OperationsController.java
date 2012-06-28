
package com.excilys.excilysbanking.web.controllers;

import java.util.ArrayList;
import java.util.List;
import org.joda.time.DateTime;
import org.joda.time.YearMonth;
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
		YearMonth ym = new YearMonth(now.getYear(), now.getMonthOfYear());
		m.addAttribute("id", id);
		m.addAttribute("carteSum", operationService.getMontantOperationsCarteByCompteIdAndYearMonth(id, ym));
		m.addAttribute("operationsList", operationService.getOperationsVirementByCompteIdAndYearMonth(id, ym));
		m.addAttribute("operationsCarteList", operationService.getOperationsCarteByCompteIdAndYearMonth(id, ym));
		
		List<String> prevMonths = new ArrayList<String>(5);
		for (int i = 0; i < 5; i++)
			prevMonths.add("month" + (now = now.minusMonths(1)).getMonthOfYear());
		m.addAttribute("previousMonths", prevMonths);
		
		return "/secured/operations";
	}
}
