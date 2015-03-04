package com.java.ro.ptng.ch3;


import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Created by Bartek on 2015-02-21.
 */
public class StringReverseTest {

    @DataProvider
    public Object[][] getString() {
        return new Object[][] {{"sadfhkj", "jkhfdas"}, {"gregregre", "ergergerg"}, {"a", "a"}};
    }


    @Test(dataProvider = "getString")
    public void shouldReverseEveryString(String s, String correctReversed) {
        String reversed = StringReverse.reverse(s);
        Assert.assertEquals(reversed, correctReversed);
    }

    @Test
    public void shouldWorkWithEmptyString() {
        Assert.assertEquals(StringReverse.reverse(""), "");
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void shouldThrowExceptionOnNull() {
        StringReverse.reverse(null);
    }




}
