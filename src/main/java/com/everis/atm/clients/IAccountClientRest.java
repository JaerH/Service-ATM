package com.everis.atm.clients;

import com.everis.atm.entities.Account;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "service-account" , url = "localhost:9005")
public interface IAccountClientRest {

	@GetMapping("/core/accounts/{cardNumber}")
	public Account findAccountNumber(@PathVariable String cardNumber);
}
