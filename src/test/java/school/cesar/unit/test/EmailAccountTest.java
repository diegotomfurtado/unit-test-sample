package school.cesar.unit.test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import school.cesar.unit.builders.EmailAccountBuilder;
import school.cesar.unit.service.EmailAccount;
import school.cesar.unit.service.EmailClient;

/*
 * @author Diego Furtado
 * */
public class EmailAccountTest {

	EmailAccount emailAccount;
	EmailAccountBuilder emailAccountBuilder;
	Instant instantNow;
	EmailClient emailClient;

	private static final int DAYS_89 = -89;
	private static final int DAYS_90 = -90;
	private static final int DAYS_91 = -91;

	@BeforeEach
	public void setUp() {
		instantNow = Instant.now();
		emailAccountBuilder = new EmailAccountBuilder();
		emailClient = new EmailClient();
	}

	@Test
	public void isPasswordExpiration_89days_False() {

		Instant instant89DaysAgo = instantNow.plus(DAYS_89, ChronoUnit.DAYS);

		emailAccount = emailAccountBuilder.setLastPasswordUpdate(instant89DaysAgo).build();
		assertFalse(emailAccount.verifyPasswordExpiration());
	}

	@Test
	public void isPasswordExpiration_after90days_False() {

		Instant instant90DaysAgo = instantNow.plus(DAYS_90, ChronoUnit.DAYS);

		emailAccount = emailAccountBuilder.setLastPasswordUpdate(instant90DaysAgo).build();
		assertFalse(emailAccount.verifyPasswordExpiration());
	}

	@Test
	public void isPasswordExpiration_after91days_True() {

		Instant instant91DaysAgo = instantNow.plus(DAYS_91, ChronoUnit.DAYS);

		emailAccount = emailAccountBuilder.setLastPasswordUpdate(instant91DaysAgo).build();
		assertTrue(emailAccount.verifyPasswordExpiration());
	}

}
