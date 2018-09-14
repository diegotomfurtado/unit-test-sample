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
	private EmailAccountBuilder emailAccountBuilder = new EmailAccountBuilder();;
//	private EmailAccount account;
	private EmailAccount emailAccount;

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

//				List<Email> mockMails = new ArrayList<>();
////				mockMails.add(account.getPasswordLength());
//				account = new EmailAccountBuilder()
//								.setUser("Diego.Furtado")
//								.setDomain("Gmail.com")
//								.setPassword("123456")
//								.setLastPasswordUpdate(null)
//								.build();
//				Email mail2 = mockMails.addAll(mockMails); //("user2","domain", "password");
				Email mail3; // = new EmailAccount("user3","domain", "password");
//				mockMails.add(mail1);
//				mockMails.add(mail2);
//				mockMails.add(mail3);
//				return mockMails;
				
				emailAccount = new EmailAccount(null, null, null, null);
				
				emailAccount = emailAccountBuilder.setPassword("123").build();
				emailAccount = emailAccountBuilder.setPassword("12345").build();
				
				
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

		emailAccount = emailAccountBuilder.build();
		emailAccount = emailAccountBuilder.setUser("Augusto").setPassword("1234567890").build();
		emailAccount = emailAccountBuilder.setUser("Josemar").setDomain("hotmail.com").setPassword("1234567890").build();
		emailAccount = emailAccountBuilder.setUser("Jonathan").setPassword("1234567890").build();

		Collection<Email> emailList = emailClient.emailList(emailAccount);

		Assertions.assertEquals(4, emailList.size());
		// asserts...
	}

}
