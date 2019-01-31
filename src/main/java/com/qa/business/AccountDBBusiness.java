package com.qa.business;

import javax.inject.Inject;

import com.qa.persistence.repository.AccountRepository;

public class AccountDBBusiness implements AccountBusinessInterface {

	@Inject
	private AccountRepository repo;

	@Override
	public String getAllAccounts() {
		return repo.getAllAccounts();
	}

	@Override
	public String createAccount(String account) {
		return repo.createAccount(account);
	}

	@Override
	public String updateAccount(Long id, String account) {
		return repo.updateAccount(id, account);
	}

	@Override
	public String deleteAccount(Long id) {
		return repo.deleteAccount(id);
	}

}
