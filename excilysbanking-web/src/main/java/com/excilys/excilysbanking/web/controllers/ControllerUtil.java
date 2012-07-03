
package com.excilys.excilysbanking.web.controllers;

import java.util.ArrayList;
import java.util.List;
import org.joda.time.DateTime;
import org.joda.time.YearMonth;
import org.springframework.ui.Model;

public class ControllerUtil {
	
	static final int CARTES_PER_PAGE = 5;
	static final int VIREMENTS_PER_PAGE = 20;
	static final int NUMBER_DISPLAYED_MONTHS = 6;
	
	static void addPagingInformation(Model m, Integer currentPage, long lastPage) {
		m.addAttribute("currentPage", currentPage);
		m.addAttribute("nextPage", currentPage + 1);
		m.addAttribute("previousPage", currentPage - 1);
		m.addAttribute("firstPage", 1);
		m.addAttribute("lastPage", lastPage);
		m.addAttribute("isLastPage", currentPage == lastPage);
		m.addAttribute("isFirstPage", currentPage == 1);
	}
	
	static List<YearMonth> getPreviousMonths() {
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
