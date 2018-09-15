package school.cesar.unit.test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Instant;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import school.cesar.unit.entidade.Email;
import school.cesar.unit.service.EmailClient;

public class EmailIsValidAdressTest {

	private EmailClient emailClient;
	private Email email;

	@BeforeEach
	public void setup() {

		List<String> targetEmails = Arrays.asList("habemus@email.com", "mamute@email.com");

		email = new Email();
		email.setCreationDate(Instant.now());
		email.setBcc(targetEmails);
		email.setCc(targetEmails);
		email.setTo(targetEmails);
		email.setFrom("diego.furtado@gmail.com");
		email.setMessage("Hello, its me!");
		email.setSubject("Nothing to declare!");

		emailClient = new EmailClient();

	}

	@Test
	public void isValidAdress_contaisDot_True() {

		emailClient = new EmailClient();
		assertTrue(emailClient.isValidAddress(".diego.furtado.@gmail.com"));
	}

	@Test
	public void isValidAdress_contaisUnderline_True() {

		emailClient = new EmailClient();
		assertTrue(emailClient.isValidAddress("_diego_furtado_@gmail.com"));
	}

	@Test
	public void isValidAdress_contaisTrace_True() {

		emailClient = new EmailClient();
		assertTrue(emailClient.isValidAddress("-diego-furtado-@gmail.com"));
	}

	@Test
	public void isValidAdress_containsMixCharacters_True() {

		emailClient = new EmailClient();
		assertTrue(emailClient.isValidAddress("-diego.furtado_@gmail.com"));
	}

	@Test
	public void isValidAdress_contaisAlphanumericsNumbersSpecialCharacters_True() {

		emailClient = new EmailClient();
		assertTrue(emailClient.isValidAddress("-12diego.furtado32_@gmail.com"));
	}

	@Test
	public void isValidAdress_withoutUser_False() {

		emailClient = new EmailClient();
		assertFalse(emailClient.isValidAddress("@gmail.com"));
	}

	@Test
	public void isValidDomain_withoutDomain_Exception() {

		emailClient = new EmailClient();

		assertThrows(ArrayIndexOutOfBoundsException.class, () -> { emailClient.isValidAddress("diego_furtado@");	});
	}

	@Test
	public void isvalidDomain_dobleSequenceDotInto_False() {

		emailClient = new EmailClient();
		assertFalse(emailClient.isValidAddress("diego_furtado@gmail..com"));
	}

	@Test
	public void isValidDomain_dobleDotWithouSequence_True() {

		emailClient = new EmailClient();
		assertTrue(emailClient.isValidAddress("diego_furtado@gmail.com.br"));
	}
	
	@Test
	public void isvalidDomain_numbersAndDotAndLetters_True() {

		emailClient = new EmailClient();
		assertTrue(emailClient.isValidAddress("diego_furtado@gmail2.com.br"));
	}

	@Test
	public void isValidEmail_CreationDate_True() {

		email.setCreationDate(Instant.now());
		assertTrue(emailClient.isValidEmail(email));
	}
	
	@Test
	public void isValidEmail_CreationDate_False() {

		email.setCreationDate(null);
		assertFalse(emailClient.isValidEmail(email));
	}

	@Test
	public void isValidEmail_EmptyCreationDate_False() {
		
		email.setCreationDate(null);
		assertFalse(emailClient.isValidEmail(email));
	}

	@Test
	public void isValidEmail_InvalidToAddress_True() {

		List<String> targetInvalidEmails = Arrays.asList(
				"habemus-@email.com", 
				"mamu$te@email.com",	
				"email.ok@email.com"
				);
		email.setTo(targetInvalidEmails);

		assertTrue(emailClient.isValidEmail(email));
	}

	@Test
	void isValidEmail_InvalidFromAddress_False() {

		email.setFrom("des$c*onhecido@nada.com");
		assertFalse(emailClient.isValidEmail(email));
	}

	@Test
	public void isValidEmail_True() {

		assertTrue(emailClient.isValidEmail(email));
	}

}
