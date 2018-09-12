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
	public void isValidAdressWithDot() {

		emailClient = new EmailClient();
		assertTrue(emailClient.isValidAdress(".diego.furtado.@gmail.com"));
	}

	@Test
	public void isValidAdressWithUnderline() {

		emailClient = new EmailClient();
		assertTrue(emailClient.isValidAdress("_diego_furtado_@gmail.com"));
	}

	@Test
	public void isValidAdressWithTrace() {

		emailClient = new EmailClient();
		assertTrue(emailClient.isValidAdress("-diego-furtado-@gmail.com"));
	}

	@Test
	public void isValidAdressWithSomeSpecialsCharacters() {

		emailClient = new EmailClient();
		assertTrue(emailClient.isValidAdress("-diego.furtado_@gmail.com"));
	}

	@Test
	public void isValidAdressWithAlphanumerics_Numbers_SpecialCharacters() {

		emailClient = new EmailClient();
		assertTrue(emailClient.isValidAdress("-12diego.furtado32_@gmail.com"));
	}

	@Test
	public void isNotValidAdressWithoutUser() {

		emailClient = new EmailClient();
		assertFalse(emailClient.isValidAdress("@gmail.com"));
	}

	@Test
	public void isNotValidAdressWithoutDomain() {

		emailClient = new EmailClient();

		assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
			emailClient.isValidAdress("diego_furtado@");
		});
	}

	@Test
	public void isValidAdressWithDoubleDotInSequence() {

		emailClient = new EmailClient();
		assertFalse(emailClient.isValidAdress("diego_furtado@gmail..com"));
	}

	@Test
	public void isValidAdressWithDoubleDotinDomain() {

		emailClient = new EmailClient();
		assertTrue(emailClient.isValidAdress("diego_furtado@gmail.com.br"));
	}

	@Test
	public void isNotValidEmailByEmptyCreationDate() {

		email.setCreationDate(null);
		assertFalse(emailClient.isValidEmail(email));
	}

	@Test
	public void isValidEmailByCreationDate() {

		email.setCreationDate(Instant.now());
		assertTrue(emailClient.isValidEmail(email));
	}

	@Test
	public void isValidEmailByInvalidToAddress() {

		List<String> targetInvalidEmails = Arrays.asList("habemus-@email.com", "mamu$te@email.com",
				"email.ok@email.com");
		email.setTo(targetInvalidEmails);

		assertTrue(emailClient.isValidEmail(email));
	}

	@Test
	void isNotValidEmailByInvalidFromAddress() {

		email.setFrom("des$c*onhecido@nada.com");
		assertFalse(emailClient.isValidEmail(email));
	}

	@Test
	public void validEmailSuccess() {

		assertTrue(emailClient.isValidEmail(email));
	}

}
