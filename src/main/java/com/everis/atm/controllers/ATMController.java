package com.everis.atm.controllers;

import com.everis.atm.entities.ATM;
import com.everis.atm.services.IATMService;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping(path = "/atm/deposits/")
public class ATMController {
	
	@Autowired
	@Qualifier("serviceFeign")
	private IATMService iATMService;
	
	/*@GetMapping("/atm/deposits/{dni}")
	public ATM findByDni(@PathVariable Integer dni) {
		return iATMService.findByDnii(dni);
		
	}*/
	
	@PostMapping(path = "/atm/deposits/")
	public ATM findByDni(@RequestBody Integer dni) {
		return iATMService.findByDni(dni);
		
	}

}
