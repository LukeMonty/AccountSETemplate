package com.qa.persistence.repository;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import com.qa.persistence.domain.Account;
import com.qa.util.JSONUtil;

@Transactional(SUPPORTS)
@Default
public class AccountDBRepo implements AccountRepository {

	@PersistenceContext(unitName = "primary")
	private EntityManager manager;
	
	@Inject
	private JSONUtil json;

	public String getAllAccounts() {

		TypedQuery<Account> query = manager.createQuery("SELECT a FROM Account a", Account.class);

		return json.getJSONForObject(query.getResultList());
	}

	@Transactional(REQUIRED)
	public String createAccount(String account) {
		Account acc = json.getObjectForJSON(account, Account.class);
		manager.persist(acc);
		return "{\"message\":\"Account added successfully\"}";
	}

	@Transactional(REQUIRED)
	public String deleteAccount(Long id) {

		Account a = manager.find(Account.class, id);

		if (manager.contains(a)) {
			manager.remove(a);
			return "Account " + a + " has been removed";
		} else {
			return "Account doesn't exist";
		}
	}

	@Transactional(REQUIRED)
	public String updateAccount(Long id, String account) {

		Account updated = json.getObjectForJSON(account, Account.class);
		manager.createQuery("UPDATE ACCOUNT SET firstName = " + updated.getFirstName() + ", lastName = "
				+ updated.getLastName() + " WHERE id = " + id, Account.class);
		return "Account updated to: " + updated.getFirstName() + " " + updated.getLastName();
	}

}
