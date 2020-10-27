package com.everis.atm.entities;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ATM  {
	
	private String fingerprintEntityName;
	private List<Account> validAccounts;
	private Integer customerAmount;

	
}
