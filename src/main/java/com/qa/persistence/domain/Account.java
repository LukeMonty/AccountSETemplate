package com.qa.persistence.domain;

import com.qa.util.JSONUtil;

public class Account {
	
	JSONUtil json;
	Account acc;
	private String firstName;
	private String lastName;
	private Long accountNumber;

	public Account() {
		this.firstName = "FIRSTNAME";
		this.lastName = "LASTNAME";
		this.accountNumber = (long) 0;
	}

	public Account(String firstName, String lastName, Long accountNumber) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.accountNumber = accountNumber;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}
	
	public String toString() {
		return json.getJSONForObject(acc);
	}
	

}
