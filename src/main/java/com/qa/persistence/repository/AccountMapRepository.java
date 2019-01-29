package com.qa.persistence.repository;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.experimental.theories.FromDataPoints;

import com.qa.persistence.domain.Account;
import com.qa.util.JSONUtil;

public class AccountMapRepository implements AccountRepository {

	Map<Long, Account> account = new HashMap<Long, Account>();
	JSONUtil json = new JSONUtil();
	Long id = (long) 0;
	Account acc = new Account();

	String append = "";

	public String getAllAccounts() {
		
		for (Entry<Long, Account> pair : account.entrySet()) {
			append += pair.getValue().toString();
		}
		return append;
	}

	public String createAccount(String accountString) {
		acc = json.getObjectForJSON(accountString, Account.class);
		account.put(id, acc);
		id++;
		return accountString;
	}

	public String deleteAccount(Long id) {
		account.remove(id);
		return "Removed: " + id;
	}

	public String updateAccount(Long id, String accountString) {
		acc = json.getObjectForJSON(accountString, Account.class);
		account.get(id).equals(acc);

		return "Updated: " + acc;
	}

}
