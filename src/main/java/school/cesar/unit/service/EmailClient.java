package school.cesar.unit.service;

import java.util.Collection;

import school.cesar.unit.entidade.Email;
import school.cesar.unit.interfac.EmailService;

public class EmailClient extends Email implements EmailService {

	Collection<EmailAccount> accounts;
	EmailService emailService;
	Email email;
	EmailAccount emailAccount;

	public void setEmailService(EmailService emailService) {
		this.emailService = emailService;
	}

	public boolean isValidAdress(String emailAddress) {

		boolean returnAdressInformation = false;
		String[] returnFromValidAdress = emailAddress.split("@");

		EmailAccount emailAccount = new EmailAccount(returnFromValidAdress[0], returnFromValidAdress[1], null);
		if (emailAccount.checkIfAUserIsAbleToUse() == true) {

			if (emailAccount.checkIdADomainIsAbleToUse() == true) {
				return returnAdressInformation = true;
			}

		}
		return returnAdressInformation;
	}

	public boolean isValidEmail(Email email) {

		boolean validCreationDate = validateCreationDate(email);
		boolean validFrom = validateFromMail(email);
		boolean validToMail = validateToMails(email);

		return validCreationDate && validFrom && validToMail;
	}

	private boolean validateCreationDate(Email email) {
		return email.getCreationDate() != null;
	}

	private boolean validateFromMail(Email email) {
		return isValidAdress(email.getFrom());
	}

	private boolean validateToMails(Email email) {

		boolean validTos = false;
		for (String toMailAdress : email.getTo()) {
			validTos = validTos || isValidAdress(toMailAdress);
		}
		return validTos;

	}

	@Override
	public Collection<Email> emailList(EmailAccount account) {

		if (emailAccount.getPasswordLength() > 6 && emailAccount.verifyPasswordExpiration()) {

			return emailService.emailList(account);
		} else {
			throw new RuntimeException();
		}
	}

	@Override
	public boolean sendEmail(Email email) {

		if (isValidEmail(email) == true) {

			return emailService.sendEmail(email);
		} else {
			throw new RuntimeException("Invalid email to send!");
		}
	}

	public boolean createAccount(EmailAccount account) {

		if (isValidEmail(email) == true && emailAccount.getPasswordLength() > 6) {

//			emailAccount.setLastPasswordUpdate(Instant.now());
		}
		return false;
	}

	public void setEmailAccount(EmailAccount emailAccount) {
		// TODO Auto-generated method stub

	}

	public void setAccounts(Collection<EmailAccount> asList) {
		// TODO Auto-generated method stub

	}

}
