package com.java.ro.ptng.ch4;

import com.java.ro.ptng.ch4.PasswordValidator;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Created by Bartek on 2015-02-22.
 */
public class PasswordValidatorTest {

    @DataProvider
    public Object[][] getValidPassword() {
        return new Object[][] {{"asdfhjk1"}, {"asdfhjkl2"}, {"asd3hjklg;"}};
    }

    @DataProvider
    public Object[][] getNotValidLongPasswords() {
        return new Object[][] {{"a"}, {"as"}, {"asd"}, {"asdf"}, {"asdfg"}, {"asdfgh"}, {"asdfghj"}};
    }

    @DataProvider
    public Object[][] getNotValidWithoutDigitPasswords() {
        return new Object[][] {{"asdfhjkl"}, {"asdfhjkle"}, {"asdrhjklg;"}};
    }

    @Test(dataProvider = "getValidPassword")
    public void passwordShouldBeAtLeast8CharactersLong(String password) {
        assertNull(PasswordValidator.validate(password));
    }

    @Test(dataProvider = "getNotValidLongPasswords")
    public void toShortPasswordReturnCorrectMessage(String password) {
        assertEquals(PasswordValidator.validate(password), PasswordValidator.PASSWORD_SHOULD_BE_MORE_THAN_OR_EQUAL_THEN_8_CHARACTERS);
    }

    @Test(dataProvider = "getValidPassword")
    public void passwordShouldHaveAtLeastOneDigit(String password) {
        assertNull(PasswordValidator.validate(password));
    }

    @Test(dataProvider = "getNotValidWithoutDigitPasswords")
    public void passwordWithNoDigitReturnCorrectMessage(String password) {
        assertEquals(PasswordValidator.validate(password), PasswordValidator.PASSWORD_SHOULD_HAVE_AT_LEAST_ONE_DIGIT);
    }

}
