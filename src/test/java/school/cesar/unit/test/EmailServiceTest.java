package school.cesar.unit.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import school.cesar.unit.builders.EmailAccountBuilder;
import school.cesar.unit.builders.EmailBuilder;
import school.cesar.unit.entidade.Email;
import school.cesar.unit.interfac.EmailService;
import school.cesar.unit.service.EmailAccount;
import school.cesar.unit.service.EmailClient;

/*
 * @author Diego Furtado
 * */
public class EmailServiceTest {

	private EmailClient emailClient;
	private EmailAccount emailAccount;
	private EmailAccountBuilder emailAccountBuilder;
	private EmailBuilder emailBuilder;

	@BeforeEach
	public void setUp() {
		
		Map<String, List<Email>> accountFromMailToSentEmailsMockDB = new HashMap<>();

		Email e1 = new Email();
		e1.setFrom("sample1@email.com");
		e1.setCreationDate(Instant.now());
		e1.setTo(Arrays.asList("dest1@email.com", "dest2@email.com"));
		e1.setMessage("Teste 123");
		
		Email e2 = new Email();
		e2.setFrom("sample1@email.com");
		e2.setCreationDate(Instant.now());
		e2.setTo(Arrays.asList("dest3@email.com", "dest4@email.com"));
		e2.setMessage("Teste 456 ABC");
		
		accountFromMailToSentEmailsMockDB.put("sample1@email.com", Arrays.asList(e1, e2));
		
		emailAccountBuilder = new EmailAccountBuilder();
		emailBuilder = new EmailBuilder();
		EmailService emailService = new EmailService() {
			
			@Override
			public boolean sendEmail(Email email) {
				
				List<Email> sentEmails = accountFromMailToSentEmailsMockDB.getOrDefault(email.getFrom(), new ArrayList<>());
				sentEmails.add(email);

				accountFromMailToSentEmailsMockDB.put(email.getFrom(), sentEmails);
				return true;
			}

			@Override
			public Collection<Email> emailList(EmailAccount account) {
				
				return accountFromMailToSentEmailsMockDB.getOrDefault(account.getEmailAddress(), new ArrayList<>());
			}

		};

		emailClient = new EmailClient();
		emailClient.setEmailService(emailService);
	}

	@Test
	public void createAccount_isNotSuccess_false() {

		emailAccount = emailAccountBuilder.setPassword("123").build();
		emailAccount = emailAccountBuilder.setPassword("12345").build();
		assertFalse(emailClient.createAccount(emailAccount));
	}

	@Test
	public void createAccount_success_true() {

		emailAccount = emailAccountBuilder.setPassword("1234567").build();
		emailAccount = emailAccountBuilder.setPassword("1234567890").build();
		assertTrue(emailClient.createAccount(emailAccount));
	}
	
	@Test
	public void createAccount_userAdressIsNotValid_False() {

		emailAccount = emailAccountBuilder.setUser("diego$furtado").build();
		assertFalse(emailClient.createAccount(emailAccount));
	}
	
	@Test
	public void emailAccountList_shouldBeCreateAList_true() {

		EmailAccount acc = emailAccountBuilder
			.setUser("sample1")
			.setDomain("email.com")
			.setLastPasswordUpdate(Instant.now())
			.setPassword("1234567890")
			.build();
		
		Collection<Email> emailList = emailClient.emailList(acc);

		assertEquals(2, emailList.size());
		
	}
	
	@Test
	public void emailAccountList_shouldNotBeValidByRrongLenghtPassword_Exception() {

		EmailAccount acc = emailAccountBuilder
			.setUser("sample1")
			.setDomain("email.com")
			.setLastPasswordUpdate(Instant.now())
			.setPassword("123")
			.build();
		
		assertThrows(RuntimeException.class, () -> { emailClient.emailList(acc); });
		
	}

	@Test
	public void emailAccountList_sendertWithoutDeliveryList_shouldBeReturnZero_True() {
		
		EmailAccount acc = emailAccountBuilder
				.setUser("UserWithoutList")
				.setDomain("email.com")
				.setLastPasswordUpdate(Instant.now())
				.setPassword("1234567")
				.build();
		
		Collection<Email> emailList = emailClient.emailList(acc);
		
		assertEquals(0, emailList.size());
		
	}

	@Test
	public void emailAccountList_EmptyList_Exception() {

		EmailAccount acc = emailAccountBuilder
			.setUser("UserWithoutList")
			.setDomain("email.com")
			.setLastPasswordUpdate(Instant.now())
			.setPassword("123")
			.build();
		
		assertThrows(RuntimeException.class, () -> { emailClient.emailList(acc); });
		
	}
	
	@Test
	public void sendEmail_isValidEmail_True() {
		
		Email acc2 = emailBuilder
				.setFrom("Diego.Furtado@gmail.com")
				.sethMessage("One Piece.")
				.setSubject("One Piece.")
				.setTo(Arrays.asList("dest1@email.com", "dest2@email.com"))
				.setBcc(Arrays.asList("Bcc1@email.com", "Bcc2@email.com"))
				.setCc(Arrays.asList("Cc1@email.com", "Cc2@email.com"))
				.setCreationDate(Instant.now())
				.build();
			
		assertTrue(emailClient.sendEmail(acc2));
		
	}
	
	@Test
	public void sendEmail_isValidEmail_Exception() {
		
		Instant instantNow = Instant.now();
		Instant instant89DaysAgo = instantNow.plus(-91, ChronoUnit.DAYS);
		
		
		Email acc2 = emailBuilder
				.setFrom("Diego.Furtado@_#gmail.com")
				.sethMessage("One Piece.")
				.setSubject("One Piece.")
				.setTo(Arrays.asList("dest1@email.com", "dest2@email.com"))
				.setBcc(Arrays.asList("Bcc1@email.com", "Bcc2@email.com"))
				.setCc(Arrays.asList("Cc1@email.com", "Cc2@email.com"))
				.setCreationDate(instant89DaysAgo)
				.build();
		
		assertThrows(RuntimeException.class, () -> { emailClient.sendEmail(acc2); });
		
	}

}
