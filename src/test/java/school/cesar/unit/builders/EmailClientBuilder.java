package school.cesar.unit.builders;

import school.cesar.unit.service.EmailAccount;
import java.util.Arrays;
import school.cesar.unit.impl.EmailService;
import school.cesar.unit.service.EmailClient;

public class EmailClientBuilder {
	private EmailClient emailClient;

	private EmailClientBuilder() {
	}

	public static EmailClientBuilder umEmailClient() {
		EmailClientBuilder builder = new EmailClientBuilder();
		standardDataInicialization(builder);
		return builder;
	}

	public static void standardDataInicialization(EmailClientBuilder builder) {
		builder.emailClient = new EmailClient();
		EmailClient emailClient = builder.emailClient;

		emailClient.setAccounts(null);
		emailClient.setEmailService(null);
		emailClient.setEmailAccount(null);
	}

	public EmailClientBuilder setListAccounts(EmailAccount... listAccount) {
		emailClient.setAccounts(Arrays.asList(listAccount));
		return this;
	}

	public EmailClientBuilder setEmailService(EmailService emailServive) {
		emailClient.setEmailService(emailServive);
		return this;
	}

	public EmailClientBuilder setEmailAccount(EmailAccount emailAccount) {
		emailClient.setEmailAccount(emailAccount);
		return this;
	}

	public EmailClient build() {
		return emailClient;
	}
}
