package com.everis.atm.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Account{

	private String accountNumber;
	
	@JsonProperty(access = Access.WRITE_ONLY)
	private Integer amount;

}
