package com.anywell.services.impl;

import com.anywell.dao.CustomerDao;
import com.anywell.dao.impl.CustomerDaoImpl;
import com.anywell.domain.Customer;
import com.anywell.services.CustomerService;

public class CustomerServiceImpl implements CustomerService {

	private CustomerDao dao = new CustomerDaoImpl();

	@Override
	public void save(Customer customer) {
		// TODO Auto-generated method stub
		dao.save(customer);
	}

}
