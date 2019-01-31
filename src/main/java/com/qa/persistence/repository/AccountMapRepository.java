package com.qa.persistence.repository;

import java.util.HashMap;
import java.util.Map;

import javax.enterprise.inject.Alternative;
import javax.inject.Inject;

import com.qa.persistence.domain.Account;
import com.qa.util.JSONUtil;

@Alternative
public class AccountMapRepository implements AccountRepository {

	private Map<Long, Account> account = new HashMap<>();
	
	@Inject
	private JSONUtil json;
	
	private Long id;
	
	@Inject
	private Account acc;

	public String getAllAccounts() {
		return json.getJSONForObject(account);
	}

	public String createAccount(String accountString) {
		acc = json.getObjectForJSON(accountString, Account.class);
		account.put(id, acc);
		id++;
		return accountString;

	}

	public String deleteAccount(Long id) {

		String re = account.get(id).getFirstName();
		account.remove(id);

		return "Removed: " + re;
	}

	public String updateAccount(Long id, String accountString) {
		acc = json.getObjectForJSON(accountString, Account.class);
		account.get(id).equals(acc);

		return "Updated: " + acc;
	}

	public int findNumberByFirstName(String string) {

		int counter = 0;
		for (Account accountInAccount : account.values()) {
			if (accountInAccount.getFirstName().equals(string)) {
				counter++;
			}

		}
		return counter;
	}

}
