package school.cesar.unit.test;

import java.util.List;

import org.junit.jupiter.api.Test;

import school.cesar.unit.entidade.Email;
import school.cesar.unit.interfac.EmailService;
import school.cesar.unit.service.EmailAccount;

public class EmailServiceTest {

	@Test
	public void interfaceTest() {

		EmailService emailService = new EmailService() {

			@Override
			public boolean sendEmail(Email email) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public List<Email> emailList(EmailAccount account) {
				// TODO Auto-generated method stub
				return null;
			}

		};

	}

}
