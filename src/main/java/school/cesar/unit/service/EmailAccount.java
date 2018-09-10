package school.cesar.unit.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Collection;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import buildermaster.BuilderMaster;

public class EmailAccount {

	private String user;
	private String domain;
	private String password;
	private Instant lastPasswordUpdate;

	public boolean checkIfAUserIsAbleToUse(String user) {

		return user.matches("[(.)|(\\-)|(_)0-9a-zA-Z]+");
	}

	public boolean checkIdADomainIsAbleToUse(String domain) {

		return domain.matches("\\b((?=[a-z0-9-]{1,}\\.)[a-z0-9]+(-[a-z0-9]+)*\\.)+[a-z]{2,}\\b");
	}

	public boolean verifyPasswordExpiration(String startDate) throws ParseException {

		boolean checkingIfPasswordExpiration = false;

		long totalDaysInProgress = checkingHowLongDaysBetweenActualDateAndLastUpdate(startDate);

		if (totalDaysInProgress > 90) {

			return checkingIfPasswordExpiration = true;

		} else {

			return checkingIfPasswordExpiration;
		}
	}

	public long checkingHowLongDaysBetweenActualDateAndLastUpdate(String startDate) throws ParseException {

		SimpleDateFormat englishMask = new SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH);
		Date firstDate = englishMask.parse(startDate);
		LocalDate localDate = LocalDate.now();
		Date date = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());

		long diffInMillies = Math.abs(date.getTime() - firstDate.getTime());
		long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);

		return diff;
	}

	public void setLastPasswordUpdate(Instant param) {
		// TODO Auto-generated method stub

	}

	public void setUser(String user) {
		// TODO Auto-generated method stub

	}

	public void setDomain(String domain) {
		// TODO Auto-generated method stub

	}

	public void setPassword(String password) {
		// TODO Auto-generated method stub

	}

}
