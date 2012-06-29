
package com.excilys.excilysbanking.dao.util;

import java.util.List;
import java.util.Locale;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import com.excilys.excilysbanking.entities.Operation;

public class DbUnitDataSetRenderer implements DataSetRenderer {
	
	private final static DateTimeFormatter fmt = DateTimeFormat.forPattern("yyyy-M-d h:m:s").withLocale(Locale.ENGLISH);
	
	private StringBuilder s = new StringBuilder();
	
	@Override
	public void openDataSet() {
		s.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>").append("\n");
		s.append("<dataset>").append("\n");
	}
	
	@Override
	public void closeDataSet() {
		s.append("</dataset>");
	}
	
	@Override
	public void newHugeSection(String comment) {
		s.append("\n\t<!-- ");
		for (int i = 0; i < comment.length(); i++)
			s.append(" ");
		s.append(" -->\n");
		
		s.append("\t<!-- ").append(comment).append(" -->\n");
		
		s.append("\t<!-- ");
		for (int i = 0; i < comment.length(); i++)
			s.append(" ");
		s.append(" -->\n");
	}
	
	@Override
	public void newBigSection(String comment) {
		s.append("\n\t<!-- ").append(comment).append(" -->\n");
	}
	
	@Override
	public void newSection(String comment) {
		s.append("\n\t<!-- ").append(comment).append(" -->\n");
	}
	
	@Override
	public void populateDataSet(Operation o) {
		s.append("\t").append(dataSetOperation(o)).append("\n");
	}
	
	@Override
	public void populateDataSet(List<Operation> operations) {
		for (Operation o : operations)
			populateDataSet(o);
	}
	
	private String dataSetOperation(Operation o) {
		StringBuilder s = new StringBuilder();
		
		s.append("<operations");
		
		s.append(dataSetOperationAttribute("operation_id", o.getId()));
		s.append(dataSetOperationAttribute("compte_id", o.getCompte().getId()));
		s.append(dataSetOperationAttribute("type", o.getType()));
		s.append(dataSetOperationAttribute("montant", o.getMontant()));
		s.append(dataSetOperationAttribute("date", o.getDate()));
		s.append(dataSetOperationAttribute("libelle", o.getLibelle()));
		
		s.append("/>");
		
		return s.toString();
	}
	
	private String dataSetOperationAttribute(String key, DateTime value) {
		StringBuilder s = new StringBuilder();
		s.append(" ").append(key).append("=\"").append(fmt.print(value)).append("\"");
		return s.toString();
	}
	
	private String dataSetOperationAttribute(String key, Object value) {
		StringBuilder s = new StringBuilder();
		s.append(" ").append(key).append("=\"").append(value.toString()).append("\"");
		return s.toString();
	}
	
	@Override
	public String render() {
		return s.toString();
	}
	
}
