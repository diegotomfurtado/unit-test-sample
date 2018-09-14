package school.cesar.unit.interfac;

import java.util.Collection;

import school.cesar.unit.entidade.Email;
import school.cesar.unit.service.EmailAccount;

public interface EmailService {

	boolean sendEmail(Email email);

	Collection<Email> emailList(EmailAccount account);

}