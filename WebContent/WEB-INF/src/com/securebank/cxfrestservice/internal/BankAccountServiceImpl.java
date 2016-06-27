package com.securebank.cxfrestservice.internal;

import java.net.HttpURLConnection;


import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;


import com.securebank.cxfrestservice.BankAccount;
import com.securebank.cxfrestservice.dao.CustomerDaoImpl;
import com.securebank.cxfrestservice.exception.AddCustomerException;


public class BankAccountServiceImpl implements BankAccount {

	private static Logger log = Logger.getLogger(BankAccountServiceImpl.class.getName());
	
	@Autowired
	private CustomerDaoImpl customerDao;

	 
	@Override
	public Response createAccount(String firstName, String lastName, String email, String phone, String onlineId) {
		
		try {
			 if (firstName == null) throw new AddCustomerException("Missing field values"); 
			 
			 else {
				 return Response.ok(customerDao.addCustomer(firstName,lastName,email,phone,onlineId)).build();
			}
		}catch(AddCustomerException e) {
			log.error("");
			log.error("Adding Customer Exception",e);
			throw new WebApplicationException(
				      Response.status(HttpURLConnection.HTTP_BAD_REQUEST)
				        .entity("Invalid firstname, firstname cannot be null")
				        .build()
				    );
		}
		 	 
	}

}
