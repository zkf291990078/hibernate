package com.anywell.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.anywell.domain.Customer;
import com.anywell.services.CustomerService;
import com.anywell.services.impl.CustomerServiceImpl;

/**
 * Servlet implementation class CustomerListServlet
 */
public class CustomerListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private CustomerService service = new CustomerServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String cust_name = request.getParameter("cust_name");
		DetachedCriteria dc = DetachedCriteria.forClass(Customer.class);
		if (cust_name != null) {
			dc.add(Restrictions.like("cust_name", "%" + cust_name + "%"));
		}
		
		List<Customer> list = service.findAll(dc);
		request.setAttribute("list", list);
		request.getRequestDispatcher("/jsp/customer/list.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
