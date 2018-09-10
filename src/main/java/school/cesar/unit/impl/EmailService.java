package school.cesar.unit.impl;

import java.util.List;

import school.cesar.unit.entidade.Email;
import school.cesar.unit.service.EmailAccount;

public interface EmailService {
    
    boolean sendEmail(Email email);
    
    List<Email> emailList(EmailAccount account);
    
}
