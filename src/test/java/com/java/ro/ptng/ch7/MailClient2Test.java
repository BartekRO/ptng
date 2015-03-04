package com.java.ro.ptng.ch7;

import org.fest.assertions.Assertions;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MailClient2Test {

    public static final String ADDRESS = "address";
    public static final String TITLE = "title";
    public static final String BODY = "body";

    private EmailServer1 emailServer1;

    class SubMailClient2 extends MailClient2 {

        @Override
        protected EmailServer1 getEmailServer1() {
            return emailServer1;
        }
    }


    @BeforeMethod
    public void setup() {
        emailServer1 = Mockito.mock(EmailServer1.class);
    }

    @Test
    public void testSendEmail() throws Exception {
        MailClient2 mailClient2 = new SubMailClient2();

        mailClient2.sendEmail(ADDRESS, TITLE, BODY);

        ArgumentCaptor<Email> argumentCaptor = ArgumentCaptor.forClass(Email.class);

        Mockito.verify(emailServer1).sendEmail(argumentCaptor.capture());

        Email argumentCaptorValue = argumentCaptor.getValue();

        Assertions.assertThat(argumentCaptorValue.getAddress()).isEqualTo(ADDRESS);
        Assertions.assertThat(argumentCaptorValue.getTitle()).isEqualTo(TITLE);
        Assertions.assertThat(argumentCaptorValue.getBody()).isEqualTo(BODY);
    }
}