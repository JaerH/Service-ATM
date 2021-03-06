package com.everis.atm.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.everis.atm.clients.IAccountClientRest;
import com.everis.atm.clients.ICardClientRest;
import com.everis.atm.clients.IFingerprintClientRest;
import com.everis.atm.clients.IPersonClientRest;
import com.everis.atm.clients.IReniecClientRest;
import com.everis.atm.entities.ATM;
import com.everis.atm.entities.Account;
import com.everis.atm.entities.Card;
import com.everis.atm.entities.Person;

import lombok.RequiredArgsConstructor;

@Service("serviceFeign")
@RequiredArgsConstructor
public class ATMServiceFeign implements IATMService {

	//@Autowired
	private final IPersonClientRest iPersonClientRest;

	//@Autowired
	private final IFingerprintClientRest iFingerprintClientRest;

	//@Autowired
	private final IReniecClientRest iReniecClientRest;

	//@Autowired
	private final ICardClientRest iCardClientRest;

	//@Autowired
	private final IAccountClientRest iAccountClientRest;

	//@Override
	public ATM findByDni(Integer dni) {

		Person person = new Person(iPersonClientRest.finByDni(dni));
		ATM atm = null;

		if (person.getFingerprint()) {

			String fingerPrintEntityName = iFingerprintClientRest.getNameEntity();

			atm = new ATM(fingerPrintEntityName, validAccounts(dni), customerAmount(dni));

		} else {

			String reniecEntityName = iReniecClientRest.getNameEntity();

			atm = new ATM(reniecEntityName, validAccounts(dni), customerAmount(dni));
		}

		return atm;
	}

	public List<Account> validAccounts(Integer dni) {

		
		List<Account> listAccount = new ArrayList<Account>();
		List<Card> card = iCardClientRest.listCards(dni);
		List<Card> activeCards = card.stream().filter(c-> c.getActive()).collect(Collectors.toList());
		
		activeCards.parallelStream().forEach(c ->{
			System.out.println("TARJETAS: " + c);
			 listAccount.add(iAccountClientRest.findAccountNumber(c.getCardNumber()));
		 });
		
		
		return listAccount;

	}
	
	public Integer customerAmount(Integer dni) {

		Integer amount = 0;
		List<Account> listAcount = validAccounts(dni);
		
		for (Account account : listAcount) {
			
			amount += account.getAmount();
		}

		return amount;
	}

}





















//	for (Card card : cards) {
	//	if (card.getActive()) {
			
			//listAccount.add(iAccountClientRest.findAccountNumber(card.getCardNumber()));
			/*cards.parallelStream().forEach(tar -> {
				
				listAccount.add(iAccountClientRest.findAccountNumber(tar.getCardNumber()));	
			});*/
















