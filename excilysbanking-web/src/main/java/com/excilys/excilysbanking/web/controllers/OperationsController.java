
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
import org.springframework.web.bind.annotation.ResponseBody;
import com.excilys.excilysbanking.entities.Operation;
import com.excilys.excilysbanking.services.OperationService;
import com.excilys.excilysbanking.services.UserService;

@Controller
@RequestMapping("/secured")
public class OperationsController {
	
	@Autowired
	private OperationService operationService;
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/operations/id/{id}/year/{year}/month/{month}/cartes")
	public @ResponseBody
	List<Operation> operationsCarteJSON(@PathVariable Integer id, @PathVariable Integer year, @PathVariable Integer month) {
		List<Operation> operations = operationService.getOperationsCarteByCompteIdAndYearMonth(id, new YearMonth(year, month));
		return operations;
	}
	
	@RequestMapping("/operations/id/{id}/year/{year}/month/{month}")
	public String operations(Model m, @PathVariable Integer id, @PathVariable Integer year, @PathVariable Integer month) {
		
		if (userService.isAdmin(SecurityContextHolder.getContext().getAuthentication()))
			m.addAttribute("isAdmin", "true");
		
		YearMonth ym = new YearMonth(year, month);
		m.addAttribute("id", id);
		m.addAttribute("carteSum", operationService.getMontantOperationsCarteByCompteIdAndYearMonth(id, ym));
		m.addAttribute("operationsList", operationService.getOperationsVirementByCompteIdAndYearMonth(id, ym));
		m.addAttribute("operationsCarteList", operationService.getOperationsCarteByCompteIdAndYearMonth(id, ym));
		
		DateTime now = DateTime.now();
		YearMonth tmp = new YearMonth(now.year().get(), now.monthOfYear().get());
		List<YearMonth> months = new ArrayList<YearMonth>(6);
		tmp = tmp.minusMonths(5);
		for (int i = 0; i < 6; i++) {
			months.add(tmp);
			tmp = tmp.plusMonths(1);
		}
		m.addAttribute("months", months);
		m.addAttribute("requestedMonth", ym);
		
		return "/secured/operations";
	}
}
