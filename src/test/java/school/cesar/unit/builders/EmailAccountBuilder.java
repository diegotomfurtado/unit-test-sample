package school.cesar.unit.builders;

import java.time.Instant;

import school.cesar.unit.service.EmailAccount;

public class EmailAccountBuilder {

	private EmailAccount emailAccount;

	public EmailAccountBuilder() {
	}

	public static EmailAccountBuilder setEmailAccount() {
		EmailAccountBuilder builder = new EmailAccountBuilder();
		standardDataInicialization(builder);
		return builder;
	}

	public static void standardDataInicialization(EmailAccountBuilder builder) {
		builder.emailAccount = new EmailAccount(null, null, null);
		EmailAccount emailAccount = builder.emailAccount;

		emailAccount.setUser("Diego.furtado");
		emailAccount.setDomain("gmail.com");
		emailAccount.setPassword("123456");
		emailAccount.setLastPasswordUpdate(null);
	}

	public EmailAccountBuilder setUser(String user) {
		emailAccount.setUser(user);
		return this;
	}

	public EmailAccountBuilder setDomain(String domain) {
		emailAccount.setDomain(domain);
		return this;
	}

	public EmailAccountBuilder setPassword(String password) {
		emailAccount.setPassword(password);
		return this;
	}

	public EmailAccountBuilder setLastPasswordUpdate(Instant lastPassword) {
		emailAccount.setLastPasswordUpdate(lastPassword);
		return this;
	}

	public EmailAccount build() {
		return emailAccount;
	}

}