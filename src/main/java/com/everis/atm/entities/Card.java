package com.everis.atm.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Card {
	
	private String cardNumber;
	private Boolean active;

}
