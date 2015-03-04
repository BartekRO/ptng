package com.java.ro.ptng.ch7;

/**
 * Created by Bartek on 2015-02-28.
 */
public class MailClient1 {

    public void sendEmail(Email email, EmailServer1 emailServer) {
        emailServer.sendEmail(email);
    }
}
