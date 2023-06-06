package com.example.demo.service;

import java.util.List;

import com.example.demo.dao.CustomerDao;
import com.example.demo.model.Customer;

//@Service
public class CustomerServiceImpl implements CustomerService{

	private final CustomerDao customerDao;
	
	
	public CustomerServiceImpl(CustomerDao customerDao) {
		super();
		this.customerDao = customerDao;
	}

	@Override
	public List<Customer> getAllCustomers() {
		// TODO Auto-generated method stub
		return customerDao.findAll() ;
	}

	@Override
	public Customer createCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return customerDao.createCustomer(customer);
	}

	@Override
	public Customer getCustomer(int theId) {
		// TODO Auto-generated method stub
		Customer customer= customerDao.getCustomer(theId);
		return customer;
	}

	@Override
	public void deleteCustomer(int theId) {
		// TODO Auto-generated method stub
		customerDao.deleteById(theId);
		
	}

}
