package com.securebank.cxfrestservice.dao;

import com.securebank.cxfrestservice.exception.AddCustomerException;
import com.securebank.cxfrestservice.model.Customer;

public interface CustomerDao {

	public Customer addCustomer(String firstName, String lastName, String email, String phone, String onlineId) throws AddCustomerException ;
}
