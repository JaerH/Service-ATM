package com.everis.atm;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.everis.atm.clients.IAccountClientRest;
import com.everis.atm.clients.ICardClientRest;
import com.everis.atm.clients.IFingerprintClientRest;
import com.everis.atm.clients.IPersonClientRest;
import com.everis.atm.clients.IReniecClientRest;
import com.everis.atm.entities.ATM;
import com.everis.atm.entities.Person;
import com.everis.atm.services.ATMServiceFeign;
import com.everis.atm.services.IATMService;

@SpringBootTest
public class ServiceATMTest {
	

	  @Mock
	  private IPersonClientRest iPersonClientRest;
	  
	  @Mock
	  private IFingerprintClientRest iFingerprintClientRest;
	  
	  @Mock
	  private IReniecClientRest iReniecClientRest;
	  
	  @Mock
	  private  ICardClientRest iCardClientRest;
	  
	  @Mock
	  private  IAccountClientRest iAccountClientRest;
	  

	  
	  private IATMService iATMService;
	  
	  @BeforeEach
	  public void setup() {
		  MockitoAnnotations.initMocks(this);
		  iATMService = new ATMServiceFeign(iPersonClientRest,iFingerprintClientRest,
				  							iReniecClientRest,iCardClientRest,iAccountClientRest);
	
		buildPerson();
		buildATM();  
	
	  }
	 
	  public void buildPerson() {
		  Person person = Person.builder()
					 .fingerprint(true)
					 .build();
			  
			  
			 Mockito.when(iPersonClientRest.finByDni(10000000))
				.thenReturn(person.fingerprint);
	  }
	  
	  public void buildATM() {
		  ATM atm = ATM.builder()
					 .fingerprintEntityName("Core")
					 .validAccounts(null)
					// .customerAmount(3000)
					 .build();

		  Mockito.when(iFingerprintClientRest.getNameEntity())
			.thenReturn(atm.getFingerprintEntityName());
		  
		/*  Mockito.when(iAccountClientRest.findAccountNumber("1111222233334441"))
		    .thenReturn(atm.getValidAccounts());*/
	  }
	  
	  
	  @Test
	  public void whenValidDNI_ThenReturnEntityName() {
		  ATM atm = iATMService.findByDni(10000000);
		  Assertions.assertThat(atm.getFingerprintEntityName()).isEqualTo("Core");
	  }
	  
	  @Test
	  public void whenValidDNI_ThenReturnAccountValid() {
		  ATM atm = iATMService.findByDni(10000000);
		  Assertions.assertThat(atm.getValidAccounts()).isEqualTo("");
	  }
	  
	  @Test
	  public void whenValidDNI_ThenReturnCustomerAmount() {
		  ATM atm = iATMService.findByDni(10000000);
		  Assertions.assertThat(atm.getCustomerAmount()).isEqualTo(3000);
	  }

}
