package school.cesar.unit.service;

import java.time.Instant;
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

		EmailAccount emailAccount = new EmailAccount(returnFromValidAdress[0], returnFromValidAdress[1], null, null);
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
		boolean validBccMail = validateBccMails(email);
		boolean validCcMail = validateCcMails(email);

		return validCreationDate && validFrom && validToMail && validBccMail && validCcMail;
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

	private boolean validateCcMails(Email email) {

		boolean validCcs = false;
		for (String ccMailAdress : email.getCc()) {
			validCcs = validCcs || isValidAdress(ccMailAdress);
		}
		return validCcs;

	}

	private boolean validateBccMails(Email email) {

		boolean validBccs = false;
		for (String bccMailAdress : email.getBcc()) {
			validBccs = validBccs || isValidAdress(bccMailAdress);
		}
		return validBccs;

	}

	@Override
	public Collection<Email> emailList(EmailAccount account) {

		if (account.getPasswordLength() > 6 && account.verifyPasswordExpiration()==false) {

			return emailService.emailList(account);
		} else {
			throw new RuntimeException("Emails List is not valid!");
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

		if (emailAccount.getEmailAddress(account) == true && emailAccount.getPasswordLength() > 6) {

			emailAccount.setLastPasswordUpdate(Instant.now());
			emailList(account);

			return true;
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
