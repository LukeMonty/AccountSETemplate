package com.qa.rest;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.qa.business.AccountBusinessInterface;

@Path("/account")
public class AccountREST {
	
	@Inject
	private AccountBusinessInterface business;
	
	@Path("/getAllAccounts")
	@GET
	@Produces({ "application/json" })
	public String getAllAccounts() {
		return business.getAllAccounts();
	}
	
	@Path("/createAccount")
	@POST
	@Produces({"application/json"})
	public String createAccount(String account) {
		return business.createAccount(account);
	}
	
	@Path("/deleteAccount/{id}")
	@DELETE
	@Produces({"application/json"})
	public String deleteAccount(@PathParam("id") Long id) {
		return business.deleteAccount(id);
	}
	
	@Path("/updateAccount/{id}")
	@PUT
	@Produces({"application/json"})
	public String updateAccount(@PathParam("id")Long id, String account) {
		return business.updateAccount(id, account);
	}
	
}
