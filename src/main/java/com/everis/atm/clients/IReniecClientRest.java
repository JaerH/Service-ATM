package com.everis.atm.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "service-reniec" , url = "localhost:9003")
public interface IReniecClientRest {
	
	@GetMapping("/external/reniec/validate")
	public String getNameEntity() ;
	
	/*@GetMapping("/external/reniec/validate")
	public String isReniec() ;*/

}
