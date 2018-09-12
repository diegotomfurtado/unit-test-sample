package school.cesar.unit.service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

public class EmailAccount {

	private String user;
	private String domain;
	private String password;
	private Instant lastPasswordUpdate;

	public EmailAccount(String user, String domain, String password) {
		super();
		this.user = user;
		this.domain = domain;
		this.password = password;
		this.lastPasswordUpdate = Instant.now();
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

	public int getPasswordLength() {

		return password.length();
	}

	public boolean getEmailAddress(EmailAccount account) {
		if (checkIfAUserIsAbleToUse() == true && checkIdADomainIsAbleToUse() == true) {

			return true;
		} else
			return false;
	}

	public boolean verifyPasswordExpiration() {

		Instant instantNow = Instant.now();
		Instant instant90DaysAgo = instantNow.plus(-90, ChronoUnit.DAYS);

		return instant90DaysAgo.isAfter(lastPasswordUpdate);
	}

}
