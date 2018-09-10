package school.cesar.unit.service;

import java.time.LocalDate;

public class EmailAccount {

	String user;
	String domain;
	String password;
	LocalDate lastPasswordUpdate;

	public boolean checkIfAUserIsAbleToUse() {

		return this.user.matches("[(.)|(\\-)|(_)0-9a-zA-Z]+");
	}

	public boolean checkIdADomainIsAbleToUse() {

		return domain.matches("\\b((?=[a-z0-9-]{1,}\\.)[a-z0-9]+(-[a-z0-9]+)*\\.)+[a-z]{2,}\\b");
	}

	public int getPasswordLength() {

		return password.length();
	}

	public boolean verifyPasswordExpiration() {

		return LocalDate.now().minusDays(90).isAfter(this.lastPasswordUpdate);
	}

//	public static void main(String[] args) {
//		verifyPasswordExpiration("05/09/2018");
//	}

//	public boolean verifyPasswordExpiration(String startDate) throws ParseException {
//
//		boolean checkingIfPasswordExpiration = false;
//
//		long totalDaysInProgress = checkingHowLongDaysBetweenActualDateAndLastUpdate(startDate);
//
//		if (totalDaysInProgress > 90) {
//
//			return checkingIfPasswordExpiration = true;
//
//		} else {
//
//			return checkingIfPasswordExpiration;
//		}
//	}
//
//	public long checkingHowLongDaysBetweenActualDateAndLastUpdate(String startDate) throws ParseException {
//
//		SimpleDateFormat englishMask = new SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH);
//		Date firstDate = englishMask.parse(startDate);
//		LocalDate localDate = LocalDate.now();
//		Date date = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
//
//		long diffInMillies = Math.abs(date.getTime() - firstDate.getTime());
//		long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
//
//		return diff;
//	}

	public void setLastPasswordUpdate(LocalDate lastPasswordUpdate) {
		// TODO Auto-generated method stub

		this.lastPasswordUpdate = lastPasswordUpdate;
	}

	public void setUser(String user) {
		// TODO Auto-generated method stub
		this.user = user;
	}

	public void setDomain(String domain) {
		// TODO Auto-generated method stub
		this.domain = domain;
	}

	public void setPassword(String password) {
		// TODO Auto-generated method stub
		this.password = password;
	}

}
