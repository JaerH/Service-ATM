package com.everis.atm.clients;

import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.everis.atm.entities.Card;

@FeignClient(name = "service-card" , url = "localhost:9004")
public interface ICardClientRest {
	
	@GetMapping("/core/cards/{dni}")
	public List<Card> listCards(@PathVariable Integer dni);

}
