
package com.excilys.excilysbanking.dao.impl.base;

import com.mysema.query.hql.hibernate.HibernateQuery;

public abstract class AbstractDAOQueryDSLHelper extends AbstractDAO {
	
	protected HibernateQuery query() {
		return new HibernateQuery(sessions.getCurrentSession());
	}
	
}
