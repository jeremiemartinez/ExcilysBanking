
package com.excilys.excilysbanking.web.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
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
import com.excilys.excilysbanking.entities.Operation.OperationType;
import com.excilys.excilysbanking.entities.util.CustomDateSerializer;
import com.excilys.excilysbanking.services.OperationService;
import com.excilys.excilysbanking.services.UserService;

@Controller
@RequestMapping("/secured")
public class OperationsController {

	public static final int CARTES_PER_PAGE = 5;
	public static final int VIREMENTS_PER_PAGE = 20;
	public static final int NUMBER_DISPLAYED_MONTHS = 6;

	@Autowired
	private OperationService operationService;

	@Autowired
	private UserService userService;

	// Operations Virement Paging used by JSP

	@RequestMapping("/operations/id/{id}")
	public String operations(Model m, @PathVariable Integer id) {
		return operations(m, id, DateTime.now().getYear(), DateTime.now().getMonthOfYear(), 1);
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
		m.addAttribute("carteSum", operationService.getMontantOperationsCarte(id, ym));

		// Pages navigation
		Long totalOperations = operationService.getNumberOperations(id, Operation.OperationType.VIREMENT, ym);
		long lastPage = totalOperations / VIREMENTS_PER_PAGE;
		if (totalOperations % VIREMENTS_PER_PAGE != 0)
			lastPage++;

		// Creating Model
		m.addAttribute("operationsList", operationService.getOperations(id, OperationType.VIREMENT, ym, VIREMENTS_PER_PAGE, page));
		m.addAttribute("currentPage", page);
		m.addAttribute("nextPage", page + 1);
		m.addAttribute("previousPage", page - 1);
		m.addAttribute("firstPage", 1);
		m.addAttribute("lastPage", lastPage);
		m.addAttribute("isLastPage", page == lastPage);
		m.addAttribute("isFirstPage", page == 1);

		return "/secured/operations";
	}

	// Operations Carte Paging used by AJAX

	@RequestMapping("/operations/id/{id}/year/{year}/month/{month}/cartes")
	public @ResponseBody
	List<Operation> operationsCarteJSON(Locale l, @PathVariable Integer id, @PathVariable Integer year, @PathVariable Integer month) {
		CustomDateSerializer.setLocale(l);
		return operationsCarteJSON(id, year, month, 1);
	}

	@RequestMapping("/operations/id/{id}/year/{year}/month/{month}/cartes/pages")
	public @ResponseBody
	Long numberOperationsCarteJSON(Locale l, @PathVariable Integer id, @PathVariable Integer year, @PathVariable Integer month) {
		CustomDateSerializer.setLocale(l);
		return operationService.getNumberOperations(id, OperationType.CARTE, new YearMonth(year, month));
	}

	@RequestMapping("/operations/id/{id}/year/{year}/month/{month}/cartes/page/{page}")
	public @ResponseBody
	List<Operation> operationsCarteJSON(@PathVariable Integer id, @PathVariable Integer year, @PathVariable Integer month, @PathVariable Integer page) {
		return operationService.getOperations(id, OperationType.CARTE, new YearMonth(year, month), CARTES_PER_PAGE, page);
	}

	// Util method

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
