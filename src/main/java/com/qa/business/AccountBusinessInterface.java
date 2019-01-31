package com.qa.business;

public interface AccountBusinessInterface {
	
	public String getAllAccounts();
	public String createAccount(String account);
	public String updateAccount(Long id, String account);
	public String deleteAccount(Long id);

}
