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

	}

	@Test
	public void addAccountTest() {
		account = new Account("firstName", "lastName", (long) 111);
		String ret = repo.createAccount(json.getJSONForObject(account));
		assertEquals("{\"firstName\":\"firstName\",\"lastName\":\"lastName\",\"accountNumber\":111}", ret);

	}

	@Test
	public void add2AccountTest() {
		account = new Account("Luke", "Monty", (long) 111);
		String ret = repo.createAccount(json.getJSONForObject(account));
		assertEquals("{\"firstName\":\"Luke\",\"lastName\":\"Monty\",\"accountNumber\":111}", ret);

	}

	@Test
	public void removeAccountTest() {
		account = new Account("Luke", "Monty", (long) 111);
		String returnValue = repo.deleteAccount((long)0);
		assertEquals("Removed: 0", returnValue);
	}

	@Test
	public void remove2AccountTest() {
		account = new Account("Luke", "Monty", (long) 111);
		account = new Account("Luke1", "Monty", (long) 111);
		
		String returnValue = repo.deleteAccount((long)1);
		assertEquals("Removed: 1", returnValue);
		
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
