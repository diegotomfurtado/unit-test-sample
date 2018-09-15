package school.cesar.unit.builders;

import java.time.Instant;
import java.util.Collection;

import school.cesar.unit.entidade.Email;

/*
 * @author Diego Furtado
 * */
public class EmailBuilder {

	private Instant creationDate;
	private String from;
	private Collection<String> listTo;
	private Collection<String> listCc;
	private Collection<String> listBcc;
	private String subject;
	private String message;

	public EmailBuilder setCreationDate(Instant creationDate) {
		this.creationDate = creationDate;
		return this;
	}

	public EmailBuilder setFrom(String from) {
		this.from = from;
		return this;
	}

	public EmailBuilder setSubject(String subject) {
		this.subject = subject;
		return this;
	}

	public EmailBuilder sethMessage(String message) {
		this.message = message;
		return this;
	}

	public EmailBuilder setTo(Collection<String> listTo) {
		this.listTo = listTo;
		return this;
	}

	public EmailBuilder setCc(Collection<String> listCc) {
		this.listCc = listCc;
		return this;
	}

	public EmailBuilder setBcc(Collection<String> listBcc) {
		this.listBcc = listBcc;
		return this;
	}

	public Email build() {
		Email email = new Email();

		email.setCreationDate(this.creationDate);
		email.setSubject(this.subject);
		email.setSubject(this.subject);
		email.setMessage(this.message);
		email.setTo(this.listTo);
		email.setCc(this.listCc);
		email.setBcc(this.listBcc);
		email.setFrom(this.from);

		return email;
	}

}
