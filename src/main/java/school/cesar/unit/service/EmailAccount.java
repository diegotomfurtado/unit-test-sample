package school.cesar.unit.service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

/*
 * @author Diego Furtado
 * */
public class EmailAccount {

	private String user;
	private String domain;
	private String password;
	private Instant lastPasswordUpdate;

	private static final int DAYS_91 = 91;

	public EmailAccount(String user, String domain, String password, Instant lastPasswordUpdate) {
		super();
		this.user = user;
		this.domain = domain;
		this.password = password;
		this.lastPasswordUpdate = lastPasswordUpdate;
	}

	public void setLastPasswordUpdate(Instant lastPasswordUpdate) {

		this.lastPasswordUpdate = lastPasswordUpdate;
	}

	public void setUser(String user) {

		this.user = user;
	}

	public void setDomain(String domain) {

		this.domain = domain;
	}

	public void setPassword(String password) {

		this.password = password;
	}

	public boolean checkIfAUserIsAbleToUse() {

		return user.matches("[(.)|(\\-)|(_)0-9a-zA-Z]+");
	}

	public boolean checkIdADomainIsAbleToUse() {

		return domain.matches("\\b((?=[a-z0-9-]{1,}\\.)[a-z0-9]+(-[a-z0-9]+)*\\.)+[a-z]{2,}\\b");
	}

	public int getPasswordLength(EmailAccount account) {

		return account.password.length();
	}

	public boolean validUserAndDomain(EmailAccount account) {

		if (account.checkIfAUserIsAbleToUse() && account.checkIdADomainIsAbleToUse()) {
			return true;
		} else {
			return false;
		}
	}

	public boolean verifyPasswordExpiration() {

		Instant instantNow = Instant.now();
		Instant instant89DaysAgo = instantNow.plus(-DAYS_91, ChronoUnit.DAYS);

		return instant89DaysAgo.isAfter(lastPasswordUpdate);
	}

	public String getEmailAddress() {
		return user + "@" + domain;
	}

}
