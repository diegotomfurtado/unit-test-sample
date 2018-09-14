package school.cesar.unit.test;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

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
	private EmailAccount account;

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
//				mockMails.add(account.getPasswordLength());
				account = new EmailAccountBuilder()
								.setUser("Diego.Furtado")
								.setDomain("Gmail.com")
								.setPassword("123456")
								.setLastPasswordUpdate(null)
								.build();
//				Email mail2 = mockMails.addAll(mockMails); //("user2","domain", "password");
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

//		Instant instantNow = Instant.now();
//		Instant instant90DaysAgo = instantNow.plus(-90, ChronoUnit.DAYS);

		EmailAccount validAccount = new EmailAccount("Diego.Furtado.2", "gmail.com.br", "1234567890", Instant.now());

		Collection<Email> emailList = emailClient.emailList(validAccount);

		Assertions.assertEquals(3, emailList.size());
		// asserts...

	}

	@Test
	public void invalidEmailAccounts() {

	}

}
