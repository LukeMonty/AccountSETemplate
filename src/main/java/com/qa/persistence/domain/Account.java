package com.qa.persistence.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.qa.util.JSONUtil;

@Entity
public class Account {
	
//	@Inject
//	private JSONUtil json;
//	
//	@Inject
//	private Account acc;
	
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private Long id;
	private String firstName;
	private String lastName;
	private Long accountNumber;

	public Account() {
		
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
	
//	public String toString() {
//		return json.getJSONForObject(acc);
//	}
//	

}
