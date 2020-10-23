package com.everis.atm.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "service-fingerprint", url = "localhost:9002")
public interface IFingerprintClientRest {
	
	@GetMapping("/core/fingerprints/validate")
	public String getNameEntity();
	
	/*@GetMapping("/core/fingerprints/validate")
	public String isFinger();*/

}
