
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
	
	public static final int OPERATIONS_PER_PAGE = 20;
	public static final int NUMBER_DISPLAYED_MONTHS = 6;
	
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
		return operations(m, id, year, month, 1);
	}
	
	@RequestMapping("/operations/id/{id}/year/{year}/month/{month}/page/{page}")
	public String operations(Model m, @PathVariable Integer id, @PathVariable Integer year, @PathVariable Integer month, @PathVariable Integer page) {
		
		if (userService.isAdmin(SecurityContextHolder.getContext().getAuthentication()))
			m.addAttribute("isAdmin", "true");
		
		// Months navigation
		YearMonth ym = new YearMonth(year, month);
		m.addAttribute("requestedMonth", ym);
		m.addAttribute("months", getPreviousMonths());
		m.addAttribute("month", month);
		m.addAttribute("year", year);
		
		// Infos
		m.addAttribute("id", id);
		m.addAttribute("carteSum", operationService.getMontantOperationsCarteByCompteIdAndYearMonth(id, ym));
		
		// Pages navigation
		Long totalOperations = operationService.getNumberOperationsVirementByCompteIdAndYearMonth(id, ym);
		long lastPage = totalOperations / OPERATIONS_PER_PAGE;
		if (totalOperations % OPERATIONS_PER_PAGE != 0)
			lastPage++;
		
		m.addAttribute("operationsList", operationService.getPagedOperationsVirementByCompteIdAndYearMonth(id, ym, OPERATIONS_PER_PAGE, page));
		m.addAttribute("currentPage", page);
		m.addAttribute("nextPage", page + 1);
		m.addAttribute("previousPage", page - 1);
		m.addAttribute("firstPage", 1);
		m.addAttribute("lastPage", lastPage);
		m.addAttribute("isLastPage", page == lastPage);
		m.addAttribute("isFirstPage", page == 1);
		
		return "/secured/operations";
	}
	
	private List<YearMonth> getPreviousMonths() {
		DateTime now = DateTime.now();
		YearMonth tmp = new YearMonth(now.year().get(), now.monthOfYear().get());
		List<YearMonth> months = new ArrayList<YearMonth>(NUMBER_DISPLAYED_MONTHS);
		tmp = tmp.minusMonths(5);
		for (int i = 0; i < NUMBER_DISPLAYED_MONTHS; i++) {
			months.add(tmp);
			tmp = tmp.plusMonths(1);
		}
		return months;
	}
}
