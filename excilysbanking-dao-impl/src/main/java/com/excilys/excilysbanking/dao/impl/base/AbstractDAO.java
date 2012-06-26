
package com.excilys.excilysbanking.dao.impl.base;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractDAO {
	
	@Autowired
	protected SessionFactory sessions;
	
	public void setSessions(SessionFactory sessions) {
		this.sessions = sessions;
	}
	
}
