# unit-test-sample

## Implantation Detailing
1. Create a class `Email` that constains
    1. Attributes:
        * Instant creationDate
        * String from
        * Collection\<String> to
        * Collection\<String> cc
        * Collection\<String> bcc
        * String subject
        * String message
```java

public class Email {
    ...
}
```

2. Create class `EmailAccount` that contains:
    1. Attributes:
        * String user
            * Only letters, numbers and the following characters: dot (.), underline (_) e trace (-) 
        * String domain
            * letters, numbers and the dot character (.), not being at the beginning, end or followed by another point
        * String password
        * Instant lastPasswordUpdate
    2. Methods
        * boolean verifyPasswordExpiration
            * The password is considered expired if lastPasswordUpdate is greater than 90 days from the current system date
```java

public class EmailAccount {
    ...
}
```

3. Create Interface `EmailService` with the following signatures:
    *	boolean sendEmail(Email email)
    *	Collection\<Email> emailList(EmailAccount account)  
```java

import java.util.Collection;

public interface EmailService {
    
    boolean sendEmail(Email email);
    
    Collection<Email> emailList(EmailAccount account);
    
}
```

4. Create class `EmailClient` which has:
    1. Attributes
        * Collection\<EmailAccount> accounts
        * EmailService emailService
            * Stores an instance of an object that implements the interface `EmailService`
    2. Methods
        * void setEmailService(**EmailService emailService**)
        * boolean isValidAddress(**String emailAddress**)
            * An address is considered valid if it has a valid user, followed by the character at (@) and then a valid domain.
        * boolean isValidEmail(**Email email**)
            * It is considered valid e-mail that has a creationDate, a valid recipient, at least one valid from, and the other e-mails are also valid.
        * Collection\<Email> emailList(EmailAccount account)
            * Before getting emails check if password is valid **(password is valid if greater than 6 characters and lastPasswordUpdate less than or equal to 90 days)**
            * If the invalid password raises an exception of type `RuntimeException` 
            * Call `emailService.emailList(account)`
        * void sendEmail(**Email email**)
            * verifies that the email is valid (using the isValidEmail method)
            * call the emailService.sendEmail(Email email)
            * if return `false` throw a exception `RuntimeException`
        * boolean createAccount(EmailAccount account)
            * verifies that the user and domain are valid
            * checks if the password is longer than 6 characters
            * add actual data on `lastPasswordUpdate`
            * add object to collection `accounts`
            
```java
public class EmailClient {
    ...
}
```
