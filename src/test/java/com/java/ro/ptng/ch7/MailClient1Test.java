package com.java.ro.ptng.ch7;

import org.mockito.Mockito;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class MailClient1Test {

    public static final String ADDRESS = "address";
    public static final String TITLE = "title";
    public static final String BODY = "body";

    @Test
    public void testSendEmail() throws Exception {
        // given
        Email email = new Email(ADDRESS, TITLE, BODY);
        EmailServer1 emailServer1 = Mockito.mock(EmailServer1.class);
        MailClient1 mailClient1 = new MailClient1();

        // when
        mailClient1.sendEmail(email, emailServer1);

        // then
        Mockito.verify(emailServer1).sendEmail(email);
    }
}