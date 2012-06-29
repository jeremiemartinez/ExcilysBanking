
package com.excilys.excilysbanking.dao.util;

import java.util.List;
import com.excilys.excilysbanking.entities.Operation;

public interface DataSetRenderer {
	
	void openDataSet();
	
	void closeDataSet();
	
	void newHugeSection(String comment);
	
	void newBigSection(String comment);
	
	void newSection(String comment);
	
	void populateDataSet(Operation o);
	
	void populateDataSet(List<Operation> operations);
	
	String render();
}
