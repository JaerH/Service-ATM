package com.everis.atm.services;

import com.everis.atm.entities.ATM;

public interface IATMService {

	public ATM findByDni(Integer dni);

}
