package com.java.ro.ptng.ch4;

/**
 * Created by Bartek on 2015-02-22.
 */
public class PasswordValidator {

    public static final int MIN_LENGTH = 8;
    public static final String PASSWORD_SHOULD_BE_MORE_THAN_OR_EQUAL_THEN_8_CHARACTERS = "Password should be more than or equal then 8 characters.";
    public static final String PASSWORD_SHOULD_HAVE_AT_LEAST_ONE_DIGIT = "Password should have at least one digit.";

    public static String validate(String password) {
        if (password.length() < MIN_LENGTH) {
            return PASSWORD_SHOULD_BE_MORE_THAN_OR_EQUAL_THEN_8_CHARACTERS;
        }
        if (!password.matches(".*\\d.*")) {
            return PASSWORD_SHOULD_HAVE_AT_LEAST_ONE_DIGIT;
        }
        return null;
    }
}
