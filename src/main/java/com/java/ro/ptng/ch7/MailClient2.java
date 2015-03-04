package com.java.ro.ptng.ch7;

/**
 * Created by Bartek on 2015-02-28.
 */
public class MailClient2 {

    public void sendEmail(String address, String title, String body) {
        Email email = getEmail(address, title, body);
        getEmailServer1().sendEmail(email);
    }

    protected Email getEmail(String address, String title, String body) {
        return new Email(address, title, body);
    }

    protected  EmailServer1 getEmailServer1() {
        return new EmailServer1();
    }
}
