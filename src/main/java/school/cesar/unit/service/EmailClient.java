package school.cesar.unit.service;

import java.time.Instant;
import java.util.Collection;

import exceptions.MyException;
import school.cesar.unit.entidade.Email;
import school.cesar.unit.interfac.EmailService;

/*
 * @author Diego Furtado
 * */
public class EmailClient extends Email implements EmailService {

	Collection<EmailAccount> accounts;
	EmailService emailService;
	Email email;
	EmailAccount emailAccount = new EmailAccount(null, null, null, null);

	public void setEmailService(EmailService emailService) {
		this.emailService = emailService;
	}

	public boolean isValidAddress(String emailAddress) {

		boolean returnAdressInformation = false;
		String[] returnFromValidAdress = emailAddress.split("@");

		EmailAccount emailAccountToValid = new EmailAccount(returnFromValidAdress[0], returnFromValidAdress[1], null, null);
		if (emailAccountToValid.checkIfAUserIsAbleToUse()  && emailAccountToValid.checkIdADomainIsAbleToUse() ) {

			return returnAdressInformation = true;
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
		return isValidAddress(email.getFrom());
	}

	private boolean validateToMails(Email email) {

		boolean validTos = false;
		for (String toMailAdress : email.getTo()) {
			validTos = validTos || isValidAddress(toMailAdress);
		}
		
		return validTos;
	}

	private boolean validateCcMails(Email email) {

		boolean validCcs = false;
		for (String ccMailAdress : email.getCc()) {
			validCcs = validCcs || isValidAddress(ccMailAdress);
		}
		return validCcs;

	}

	private boolean validateBccMails(Email email) {

		boolean validBccs = false;
		for (String bccMailAdress : email.getBcc()) {
			validBccs = validBccs || isValidAddress(bccMailAdress);
		}
		return validBccs;
	}

	@Override
	public Collection<Email> emailList(EmailAccount account) {

		if (account.getPasswordLength(account) > 6 && account.verifyPasswordExpiration() == false) {

			return emailService.emailList(account);
		} else {
			throw new MyException("Emails List is not valid!");
		}
	}

	@Override
	public boolean sendEmail(Email email) {

		if (isValidEmail(email)) {

			return emailService.sendEmail(email);
		} else {
			throw new MyException("Invalid email to send!");
		}
	}

	public boolean createAccount(EmailAccount account) {

		if (emailAccount.validUserAndDomain(account) == true && emailAccount.getPasswordLength(account) > 6) {

			emailAccount.setLastPasswordUpdate(Instant.now());
			emailList(account);

			return true;
		}
		return false;
	}

}
