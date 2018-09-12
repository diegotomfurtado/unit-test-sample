package school.cesar.unit.test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import school.cesar.unit.builders.EmailAccountBuilder;
import school.cesar.unit.builders.EmailBuilder;
import school.cesar.unit.entidade.Email;
import school.cesar.unit.interfac.EmailService;
import school.cesar.unit.service.EmailAccount;
import school.cesar.unit.service.EmailClient;

public class EmailServiceTest {

	private EmailService emailService;
	private EmailClient emailClient;
	private EmailAccountBuilder emailAccountBuilder;

	@BeforeEach
	public void setUp() {

		emailService = new EmailService() {

			@Override
			public boolean sendEmail(Email email) {
				// TODO Auto-generated method stub
				return true;
			}

			@Override
			public Collection<Email> emailList(EmailAccount account) {

				List<Email> mockMails = new ArrayList<>();

//				EmailAccount mail1 = new EmailAccount("user1", "domain", "password");
				Email mail2; // = new EmailAccount("user2","domain", "password");
				Email mail3; // = new EmailAccount("user3","domain", "password");
//				mockMails.add(mail1);
//				mockMails.add(mail2);
//				mockMails.add(mail3);
				return mockMails;
			}
		};

		emailClient = new EmailClient();

		emailClient.setEmailService(emailService);

	}

	@Test
	public void validEmailAccounts() {
		EmailAccount validAccount = new EmailAccount("user", "domain", "password");

		Collection<Email> emailList = emailClient.emailList(validAccount);

		Assertions.assertEquals(3, emailList.size());
		// asserts...

	}

	@Test
	public void invalidEmailAccounts() {

	}

}
