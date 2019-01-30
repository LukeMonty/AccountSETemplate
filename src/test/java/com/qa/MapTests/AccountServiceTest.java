package com.qa.MapTests;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.qa.persistence.domain.Account;
import com.qa.persistence.repository.AccountMapRepository;
import com.qa.util.JSONUtil;

public class AccountServiceTest {

	private Account account;
	private AccountMapRepository repo = new AccountMapRepository();
	private JSONUtil json = new JSONUtil();

	@Before
	public void setup() {
		account = new Account("Luke", "Monty", 111L);
	}

	@Test
	public void addAccountTest() {
		account = new Account("firstName", "lastName", 111L);
		String ret = repo.createAccount(json.getJSONForObject(account));
		assertEquals("{\"firstName\":\"firstName\",\"lastName\":\"lastName\",\"accountNumber\":111}", ret);

	}

	@Test
	public void add2AccountTest() {
		account = new Account("Luke", "Monty", 111L);
		String ret = repo.createAccount(json.getJSONForObject(account));
		assertEquals("{\"firstName\":\"Luke\",\"lastName\":\"Monty\",\"accountNumber\":111}", ret);

	}

	@Test
	public void removeAccountTest() {
		repo.createAccount(json.getJSONForObject(account));
		String returnValue = repo.deleteAccount(0L);
		assertEquals("Removed: Luke", returnValue);
	}

	@Test
	public void remove2AccountTest() {
		Account account2 = new Account("h", "Monty", 111L);
		repo.createAccount(json.getJSONForObject(account));
		repo.createAccount(json.getJSONForObject(account2));
		String returnValue = repo.deleteAccount(1L);
		assertEquals("Removed: h", returnValue);

	}
	
	@Test
	public void testInteratingThroughMap() {
		
		
		
	}

	@Test
	public void remove2AccountTestAnd1ThatDoesntExist() {

	}

	@Test
	public void accountConversionToJSONTestWithEmptyMap() {

	}

	@Test
	public void accountConversionToJSONTestEmptyMapWithConversion() {

	}

	@Test
	public void accountConversionToJSONTest() {

	}

	@Test
	public void getCountForFirstNamesInAccountWhenZeroOccurances() {

	}

	@Test
	public void getCountForFirstNamesInAccountWhenOne() {

	}

	@Test
	public void getCountForFirstNamesInAccountWhenMult() {

	}

}
