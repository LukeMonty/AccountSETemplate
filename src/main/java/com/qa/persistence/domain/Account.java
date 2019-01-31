package com.qa.persistence.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.qa.util.JSONUtil;

@Entity
public class Account {
	
	private JSONUtil json;
	private Account acc;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(length=100)
	private String firstName;
	@Column(length=50)
	private String lastName;
	@Column(length=10)
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
