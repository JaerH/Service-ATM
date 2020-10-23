package com.everis.atm.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "service-person", url = "localhost:9001")
public interface IPersonClientRest {
	
	@GetMapping("/core/persons/{dni}")
	public Boolean finByDni(@PathVariable Integer dni) ;
	

}
