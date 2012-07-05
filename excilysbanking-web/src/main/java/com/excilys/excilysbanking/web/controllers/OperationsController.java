
package com.excilys.excilysbanking.web.controllers;

import static com.excilys.excilysbanking.web.controllers.ControllerUtil.CARTES_PER_PAGE;
import static com.excilys.excilysbanking.web.controllers.ControllerUtil.VIREMENTS_PER_PAGE;
import static com.excilys.excilysbanking.web.controllers.ControllerUtil.addPagingInformation;
import static com.excilys.excilysbanking.web.controllers.ControllerUtil.getPreviousMonths;
import java.util.List;
import java.util.Locale;
import org.joda.time.DateTime;
import org.joda.time.YearMonth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.excilys.excilysbanking.dto.OperationDTO;
import com.excilys.excilysbanking.dto.converters.Converter;
import com.excilys.excilysbanking.dto.utils.CustomDateSerializer;
import com.excilys.excilysbanking.entities.Operation;
import com.excilys.excilysbanking.entities.Operation.OperationType;
import com.excilys.excilysbanking.services.OperationService;

@Controller
@RequestMapping("/secured")
public class OperationsController {
	
	@Autowired
	private OperationService operationService;
	
	@Autowired
	@Qualifier("operationToOperationDTOConverter")
	private Converter<Operation, OperationDTO> converter;
	
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
		addPagingInformation(m, page, lastPage);
		
		return "/secured/operations";
	}
	
	// Operations Carte Paging used by AJAX
	
	@RequestMapping("/operations/id/{id}/year/{year}/month/{month}/cartes")
	public @ResponseBody
	List<OperationDTO> operationsCarteJSON(Locale l, @PathVariable Integer id, @PathVariable Integer year, @PathVariable Integer month) {
		return operationsCarteJSON(l, id, year, month, 1);
	}
	
	@RequestMapping("/operations/id/{id}/year/{year}/month/{month}/cartes/pages")
	public @ResponseBody
	Long numberOperationsCarteJSON(Locale l, @PathVariable Integer id, @PathVariable Integer year, @PathVariable Integer month) {
		CustomDateSerializer.setLocale(l);
		return operationService.getNumberOperations(id, OperationType.CARTE, new YearMonth(year, month));
	}
	
	@RequestMapping("/operations/id/{id}/year/{year}/month/{month}/cartes/page/{page}")
	public @ResponseBody
	List<OperationDTO> operationsCarteJSON(Locale l, @PathVariable Integer id, @PathVariable Integer year, @PathVariable Integer month,
			@PathVariable Integer page) {
		CustomDateSerializer.setLocale(l);
		return converter.convert(operationService.getOperations(id, OperationType.CARTE, new YearMonth(year, month), CARTES_PER_PAGE, page));
	}
}
