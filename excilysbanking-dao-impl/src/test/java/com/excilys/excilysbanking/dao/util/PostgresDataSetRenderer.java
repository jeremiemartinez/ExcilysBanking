
package com.excilys.excilysbanking.dao.util;

import java.util.List;
import java.util.Locale;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import com.excilys.excilysbanking.entities.Operation;

public class PostgresDataSetRenderer implements DataSetRenderer {
	
	private final static DateTimeFormatter fmt = DateTimeFormat.forPattern("yyyy-M-d").withLocale(Locale.ENGLISH);
	
	private StringBuilder s = new StringBuilder();
	
	@Override
	public void openDataSet() {}
	
	@Override
	public void closeDataSet() {}
	
	@Override
	public void newHugeSection(String comment) {
		s.append("\n-- ");
		for (int i = 0; i < comment.length(); i++)
			s.append(" ");
		s.append(" --\n");
		
		s.append("-- ").append(comment).append(" --\n");
		
		s.append("-- ");
		for (int i = 0; i < comment.length(); i++)
			s.append(" ");
		s.append(" --\n");
	}
	
	@Override
	public void newBigSection(String comment) {
		s.append("\n-- ").append(comment).append(" --\n");
	}
	
	@Override
	public void newSection(String comment) {
		s.append("\n-- ").append(comment).append(" --\n");
	}
	
	@Override
	public void populateDataSet(Operation o) {
		s.append("INSERT INTO operations (operation_id, compte_id, type, montant, date, libelle) VALUES (");
		s.append(o.getId());
		s.append(", ");
		s.append(o.getCompte().getId());
		s.append(", ");
		s.append("'").append(o.getType()).append("'");
		s.append(", ");
		s.append(o.getMontant());
		s.append(", ");
		s.append("'").append(fmt.print(o.getDate())).append("'");
		s.append(", ");
		s.append("'").append(o.getLibelle()).append("'");
		s.append(");\n");
	}
	
	@Override
	public void populateDataSet(List<Operation> operations) {
		for (Operation o : operations)
			populateDataSet(o);
	}
	
	@Override
	public String render() {
		return s.toString();
	}
	
}
