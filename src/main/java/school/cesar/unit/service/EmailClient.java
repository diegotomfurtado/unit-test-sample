package school.cesar.unit.service;

import java.util.Collection;

import school.cesar.unit.entidade.Email;
import school.cesar.unit.interfac.EmailService;

public class EmailClient extends Email implements EmailService {

	private Collection<EmailAccount> accounts;
	private EmailService emailService;
	Email email = new Email();
	EmailAccount emailAccount = new EmailAccount();

	public void setEmailService(EmailService emailService) {
		this.emailService = emailService;
	}

	public boolean isValidAdress(String validAdress) {

		boolean returnAdressInformation = false;
		String[] returnFromValidAdress = validAdress.split("@");

		if (emailAccount.checkIfAUserIsAbleToUse(returnFromValidAdress[0] == true) {

			if (emailAccount.checkIdADomainIsAbleToUse(returnFromValidAdress[1]) == true) {
				return returnAdressInformation = true;
			}

		}
		return returnAdressInformation;
	}

	public boolean isValidEmail(String email) {

		boolean validEmail = false;
		// tá beeem errado
//		if ((email.getCreationDate() != null && (!email.getTo().isEmpty() || email.getTo() != null)
//				&& (!email.getFrom().isEmpty() || email.getFrom() != null))) {
//			email.getTo();
//		}
		return validEmail;
	}

	@Override
	public Collection<Email> emailList(EmailAccount account) {

		return null;
	}

	@Override
	public boolean sendEmail(Email email) {

//		if (this.isValidEmail() == true) {
//			emailService.sendEmail(email);
//			return true;
//		} else {
//			throw new RuntimeException("Invalid email to send!");
//		}
		return false;

	}

	public boolean createAccount(EmailAccount account) {

//		account.setUser("");
//		account.setDomain(emailAccount.domain);
//
//		emailAccount.checkIfAUserIsAbleToUse(emailAccount.user);
//		if (emailAccount.getPasswordLength() > 6) {
//
//			emailAccount.setLastPasswordUpdate(LocalDate.now());
//		}
		return false;
	}

	public void setEmailAccount(EmailAccount emailAccount) {
		// TODO Auto-generated method stub

	}

	public void setAccounts(Collection<EmailAccount> asList) {
		// TODO Auto-generated method stub

	}

}
