
package com.excilys.excilysbanking.dao.impl.base;

import com.mysema.query.hql.hibernate.HibernateQuery;

public abstract class AbstractDAOQueryDSLHelper extends AbstractDAO {
	
	protected HibernateQuery query() {
		return new HibernateQuery(sessions.getCurrentSession());
	}
	
	protected HibernateQuery page(HibernateQuery hq, Integer pageSize, Integer pageNumber) {
		if (pageNumber > 0 && pageSize > 0) {
			hq = hq.offset((pageNumber - 1) * pageSize);
			hq = hq.limit(pageSize);
		}
		return hq;
	}
	
}
