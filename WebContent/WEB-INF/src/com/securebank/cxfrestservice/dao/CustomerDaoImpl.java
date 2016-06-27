package com.securebank.cxfrestservice.dao;

import java.util.List;
import java.util.UUID;

import javax.sql.DataSource;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.securebank.cxfrestservice.internal.BankAccountServiceImpl;
import com.securebank.cxfrestservice.model.Account;
import com.securebank.cxfrestservice.model.AccountType;
import com.securebank.cxfrestservice.model.Customer;

public class CustomerDaoImpl implements CustomerDao {
	
	private static Logger log = Logger.getLogger(CustomerDaoImpl.class.getName());

	@Autowired
	private Customer customer;
	@Autowired
	private Account account;
	@Autowired
	private AccountType accountType;
	@Autowired
	private List<Account> listOfAccounts;
	
	private DataSource dataSource;
	
	
	
	
	 public void setDataSource(DataSource dataSource) {
		    this.dataSource = dataSource;
	 }
	 
	 
	public Customer addCustomer(String firstName, String lastName, String email, String phone, String onlineId) {
		JdbcTemplate insert = new JdbcTemplate(dataSource);
		String customerId = RandomStringUtils.randomNumeric(9);
		customer.setCustomerId(customerId);
		customer.setFirstName(firstName);
		customer.setLastName(lastName);
		customer.setEmailAddress(email);
		customer.setPhoneNumber(phone);
		customer.setAccounts(generateAccount(onlineId));
		insert.update("INSERT INTO customer (firstname, lastname, email, phone, ssn, dateofbirth, customerid) VALUES (?, ?, ?, ?, ?, ?, ?)",
				new Object[] {customer.getFirstName(),customer.getLastName(),customer.getEmailAddress(),customer.getPhoneNumber(),customer.getSsn(),customer.getDateOfBirth(),customer.getCustomerId()});
		log.info("Added customer : " + customer); 
		return customer;
	}
	
	private List<Account> generateAccount(String onlineId) {
		listOfAccounts.clear();
		JdbcTemplate insert = new JdbcTemplate(dataSource);
		String guid = UUID.randomUUID().toString();
		String accountNumber = RandomStringUtils.randomNumeric(12);
		account.setGuid(guid);
		log.info(accountNumber);
		accountType.setAccountNumber(accountNumber);
		account.setOnlineId(onlineId);
		accountType.setType("Savings");
		account.setAccountType(accountType);
		insert.update("INSERT INTO account (accountnumber, guid, onlineid, accounttype, customerid) VALUES (?, ?, ?, ?, ?)",
			new Object[] {accountType.getAccountNumber(),account.getGuid(), account.getOnlineId(),accountType.getType(),customer.getCustomerId()});
		listOfAccounts.add(account);
		return listOfAccounts;
	}
}
