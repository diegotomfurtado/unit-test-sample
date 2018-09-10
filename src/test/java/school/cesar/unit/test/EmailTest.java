package school.cesar.unit.test;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import school.cesar.unit.builders.EmailAccountBuilder;
import school.cesar.unit.builders.EmailBuilder;
import school.cesar.unit.service.EmailAccount;
import school.cesar.unit.service.EmailClient;

public class EmailTest {

	public static final String ADRESS_VALID = "diego.furtado@gmail.com";
	public static final String CREATION_DATE = "";
	public static final String TO = "";
	public static final String FROM = "SomeWhere";

	EmailClient emailClient;
	EmailAccount emailAccount = new EmailAccount();
	EmailBuilder emailBuilder;

	@Test
	// Está levantando NullPointException
	public void checkingAValidAdress() {

		Assertions.assertTrue(emailClient.isValidAdress(ADRESS_VALID));
		
		EmailAccountBuilder.setEmailAccount().setUser("Diego");
	}
	
	@Test
	public void createValidAccount() {
//		emailAccount.createAccount()
//			.isValidAdress("")
//			.isPassworkHasMoreThanSixCharacters("")
//			.addingActualDate("")
//			.addingAccount();
	}
	
	@Test
	public void creatingNewEmail() {
		
		List<EmailBuilder> email = Arrays.asList(emailBuilder.setFrom(FROM));
		
//		emailClient.sendEmail();
	}

}
