package com.training.ssh.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

public class LoanDao extends HibernateDaoSupport {
	public List selectAll(final int page) {
		return super.getHibernateTemplate().execute(new HibernateCallback<List>() {

			@Override
			public List doInHibernate(Session session) throws HibernateException {
				// TODO Auto-generated method stub
				return session.createQuery("from Loan")
							  .setFirstResult((page-1)*20)
							  .setMaxResults(20)
							  .list();
			}
			
		});
	}
}
