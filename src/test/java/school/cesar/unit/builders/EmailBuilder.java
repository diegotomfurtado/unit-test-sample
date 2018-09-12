package school.cesar.unit.builders;

import java.time.Instant;
import java.util.Arrays;
import java.util.List;

import school.cesar.unit.entidade.Email;

public class EmailBuilder {
	
	private Email email;

	public EmailBuilder() {
	}

	public static EmailBuilder setEmail() {
		EmailBuilder builder = new EmailBuilder();
		standardDataInicialization(builder);
		return builder;
	}

	public static void standardDataInicialization(EmailBuilder builder) {
		builder.email = new Email();
		Email email = builder.email;
		
		List<String> targetEmails = Arrays.asList("habemus123_email.com", "mamute123@email.com");

		email.setCreationDate(Instant.now());
		email.setFrom("diego123.furtado@gmail.com");
		email.setTo(targetEmails);
		email.setCc(targetEmails);
		email.setBcc(targetEmails);
		email.setSubject("Hello, its me! 123");
		email.setMessage("Nothing to declare! 123");
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
