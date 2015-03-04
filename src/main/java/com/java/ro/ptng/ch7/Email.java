package com.java.ro.ptng.ch7;

/**
 * Created by Bartek on 2015-02-28.
 */
public class Email {

    private String address;
    private String title;
    private String body;

    public Email(String address, String title, String body) {
        this.address = address;
        this.title = title;
        this.body = body;
    }

    public String getAddress() {
        return address;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }
}
