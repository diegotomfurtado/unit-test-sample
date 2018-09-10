package school.cesar.unit.builders;

import java.time.Instant;
import java.util.Arrays;

import school.cesar.unit.entidade.Email;

public class EmailBuilder {
	private Email email;

	private EmailBuilder() {
	}

	public static EmailBuilder setEmail() {
		EmailBuilder builder = new EmailBuilder();
		standardDataInicialization(builder);
		return builder;
	}

	public static void standardDataInicialization(EmailBuilder builder) {
		builder.email = new Email();
		Email email = builder.email;

		email.setCreationDate(null);
		email.setFrom("");
		email.setTo(null);
		email.setCc(null);
		email.setBcc(null);
		email.setSubject("");
		email.setMessage("");
	}

	public EmailBuilder comCreationDate(Instant creationDate) {
		email.setCreationDate(creationDate);
		return this;
	}

	public EmailBuilder setFrom(String from) {
		email.setFrom(from);
		return this;
	}

	public EmailBuilder setListTo(String... listTo) {
		email.setTo(Arrays.asList(listTo));
		return this;
	}

	public EmailBuilder setListCc(String... listCc) {
		email.setCc(Arrays.asList(listCc));
		return this;
	}

	public EmailBuilder setListBcc(String... listBcc) {
		email.setBcc(Arrays.asList(listBcc));
		return this;
	}

	public EmailBuilder setSubject(String subject) {
		email.setSubject(subject);
		return this;
	}

	public EmailBuilder sethMessage(String message) {
		email.setMessage(message);
		return this;
	}

	public Email build() {
		return email;
	}

}
