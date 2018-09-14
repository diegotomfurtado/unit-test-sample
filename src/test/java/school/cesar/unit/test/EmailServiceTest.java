package school.cesar.unit.test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Collection;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import school.cesar.unit.builders.EmailAccountBuilder;
import school.cesar.unit.entidade.Email;
import school.cesar.unit.interfac.EmailService;
import school.cesar.unit.service.EmailAccount;
import school.cesar.unit.service.EmailClient;

public class EmailServiceTest {

	private EmailService emailService;
	private EmailClient emailClient;
	private EmailAccountBuilder emailAccountBuilder;
	private EmailAccount emailAccount;

	@BeforeEach
	public void setUp() {

		emailAccountBuilder = new EmailAccountBuilder();
		emailService = new EmailService() {

			@Override
			public boolean sendEmail(Email email) {

				return true;
			}

			@Override
			public Collection<Email> emailList(EmailAccount account) {

				emailAccount = emailAccountBuilder.setUser("Josemar").setPassword("123").build();
//				emailAccount = emailAccountBuilder.setPassword("12345").build();

				return emailService.emailList(emailAccount);
			}

		};

		emailClient = new EmailClient();

		emailClient.setEmailService(emailService);

	}

	@Test
	public void createAccount_notSuccess() {

		emailAccount = emailAccountBuilder.setPassword("123").build();
		emailAccount = emailAccountBuilder.setPassword("12345").build();
		assertFalse(emailClient.createAccount(emailAccount));
	}

	@Test
	public void createAccount_success() {

		emailAccount = emailAccountBuilder.setPassword("1234567").build();
		emailAccount = emailAccountBuilder.setPassword("1234567890").build();
		assertTrue(emailClient.createAccount(emailAccount));
	}

	@Test
	public void valideEmailAccountList() {

		Collection<Email> emailList = emailService.emailList(emailAccount);

		Assertions.assertEquals(4, emailList.size());
		// asserts...
	}

}
