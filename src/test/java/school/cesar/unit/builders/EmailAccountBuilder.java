package school.cesar.unit.builders;

import java.time.Instant;

import school.cesar.unit.service.EmailAccount;

/*
 * @author Diego Furtado
 * */
public class EmailAccountBuilder {

	private String user = "Diego.Furtado";
	private String domain = "gmail.com";
	private String password = null;
	private Instant lastPasswordUpdate = Instant.now();

	public EmailAccountBuilder setUser(String user) {
		this.user = user;
		return this;
	}

	public EmailAccountBuilder setDomain(String domain) {
		this.domain = domain;
		return this;
	}

	public EmailAccountBuilder setPassword(String password) {
		this.password = password;
		return this;
	}

	public EmailAccountBuilder setLastPasswordUpdate(Instant lastPasswordUpdate) {
		this.lastPasswordUpdate = lastPasswordUpdate;
		return this;
	}

	public EmailAccount build() {
		EmailAccount emailAccount = new EmailAccount(null, null, null, null);
		emailAccount.setUser(this.user);
		emailAccount.setDomain(this.domain);
		emailAccount.setPassword(this.password);
		emailAccount.setLastPasswordUpdate(this.lastPasswordUpdate);
		return emailAccount;
	}
}