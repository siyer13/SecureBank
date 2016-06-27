package com.securebank.cxfrestservice.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="account")
public class Account {
	
	private String onlineId;
	private String guid;
	private AccountType accountType;
	private double totalBalance;
	
	public String getOnlineId() {
		return onlineId;
	}
	public void setOnlineId(String onlineId) {
		this.onlineId = onlineId;
	}
	public String getGuid() {
		return guid;
	}
	public void setGuid(String guid) {
		this.guid = guid;
	}
	public AccountType getAccountType() {
		return accountType;
	}
	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}
	public double gettotalBalance() {
		return totalBalance;
	}
	public void settotalBalance(double totalBalance) {
		this.totalBalance = totalBalance;
	}
	
	private Account() {
		
	}
	@Override
	public String toString() {
		return "Account [onlineId=" + onlineId + ", guid=" + guid
				+ ", accountType=" + accountType + ", totalBalance=" + totalBalance + "]";
	}
}
