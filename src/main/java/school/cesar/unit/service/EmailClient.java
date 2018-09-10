package school.cesar.unit.service;

import java.util.List;

import school.cesar.unit.entidade.Email;
import school.cesar.unit.impl.EmailService;

public class EmailClient implements EmailService {

	private List<EmailAccount> accounts;
	private EmailService emailService;
	EmailAccount emailAccount = new EmailAccount();

	public void setEmailService(EmailService emailService) {
		this.emailService = emailService;
	}

	public boolean isValidAdress(String validAdress) {

		boolean returnAdressInformation = false;
		String[] returnFromValidAdress = validAdress.split("@");

		if (new EmailAccount().checkIfAUserIsAbleToUse(returnFromValidAdress[0]) == true) {

			if (new EmailAccount().checkIdADomainIsAbleToUse(returnFromValidAdress[1]) == true) {
				return returnAdressInformation = true;
			}

		}
		return returnAdressInformation;

	}

	public boolean isValidEmail() {

		return false;
	}

	@Override
	public List<Email> emailList(EmailAccount account) {

		if (emailAccount.verifyPasswordExpiration("") == true) {
		
			for(Email email : account){
				emailService.emailList(email);
		    }
			return emailService;
		}else {
			throws 
		}
	}

	@Override
	public boolean sendEmail(Email email) {

		return false;
	}

	public boolean createAccount(EmailAccount account) {

//		emailAccount.checkIfAUserIsAbleToUse(user).
		return false;
	}

	public void setEmailAccount(EmailAccount emailAccount) {
		// TODO Auto-generated method stub

	}

	public void setAccounts(List<EmailAccount> asList) {
		// TODO Auto-generated method stub

	}

}
