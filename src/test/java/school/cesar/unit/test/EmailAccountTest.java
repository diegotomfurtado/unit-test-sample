package school.cesar.unit.test;

import java.time.LocalDate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import school.cesar.unit.builders.EmailAccountBuilder;
import school.cesar.unit.service.EmailAccount;

public class EmailAccountTest {

	EmailAccount emailAccount = new EmailAccount();
	EmailAccountBuilder emailAccountBuilder = new EmailAccountBuilder();

	@Test
	public void testPasswordExpiration() {

		emailAccount.setLastPasswordUpdate(LocalDate.now());

		Assertions.assertTrue(emailAccount.verifyPasswordExpiration());
//		Assertions.assertTrue(emailAccountBuilder.setLastPasswordUpdate(null));
	}
}
