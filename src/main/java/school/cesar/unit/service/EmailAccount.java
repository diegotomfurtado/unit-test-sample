package school.cesar.unit.service;

import java.util.Calendar;
import java.util.Date;

public class EmailAccount {

	private String user;
	private String domain;
	private String password;
	private Date lastPasswordUpdate;

	public EmailAccount(String user, String domain, String password) {
		super();
		this.user = user;
		this.domain = domain;
		this.password = password;
		this.lastPasswordUpdate = new Date();
	}

	public void setLastPasswordUpdate(Date lastPasswordUpdate) {

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

	public String getEmailAddress() {
		return user + "@" + domain;
	}

	public boolean verifyPasswordExpiration() {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());

		calendar.add(Calendar.MONTH, -90);

		return calendar.getTime().after(lastPasswordUpdate);

	}

}
