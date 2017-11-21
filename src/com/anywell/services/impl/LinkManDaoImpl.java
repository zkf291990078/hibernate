package com.anywell.services.impl;

import org.hibernate.Session;

import com.anywell.domain.LinkMan;
import com.anywell.services.LinkManDao;
import com.anywell.utils.HibernateUtils;

public class LinkManDaoImpl implements LinkManDao {

	@Override
	public void save(LinkMan linkMan) {
		// TODO Auto-generated method stub
		Session session=HibernateUtils.getCurrentSession();
		session.save(linkMan);
	}

}
