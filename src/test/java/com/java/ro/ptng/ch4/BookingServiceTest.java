package com.java.ro.ptng.ch4;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;

/**
 * Created by Bartek on 2015-02-22.
 */
public class BookingServiceTest {

    @Test
    public void bookingServiceConstructorShouldSaveBookingHours() {
        BookingService bookingService = new BookingService(12, 22);
        Assert.assertEquals(bookingService.getAvailableHours(), Arrays.asList(new Integer[] {12, 13, 14, 15, 16, 17, 18, 19, 20, 21}));
    }

    @DataProvider
    public Object[][] getIllegalBookingStartEnds() {
        return new Object[][] {{8,8}, {10,25}, {-1,2}, {1,-2}, {-2,-1}, {0,0}};
    }

    @Test(expectedExceptions = IllegalArgumentException.class, dataProvider = "getIllegalBookingStartEnds")
    public void bookingServiceConstructorShouldThrowIllegalArgumentExceptionOnIllegalValues(Integer illegalStart, Integer illegalEnd) {
        new BookingService(illegalStart, illegalEnd);
    }

    @Test
     public void bookingCorrectHourShouldReturnThisHour() {
        BookingService bookingService = new BookingService(12, 22);
        Assert.assertTrue(bookingService.book(16));
        Assert.assertEquals(bookingService.getBookedHours(), Arrays.asList(new Integer[]{16}));
    }

    @DataProvider
    public Object[][] getIllegalBookHours() {
        return new Object[][] {{0}, {10}, {11}, {22}, {24}, {26}};
    }

    @Test(dataProvider = "getIllegalBookHours")
    public void itShouldNotBePossibleToBookNotAvailableHour(Integer bookHour) {
        BookingService bookingService = new BookingService(12, 22);
        Assert.assertFalse(bookingService.book(bookHour));
        Assert.assertTrue(bookingService.getBookedHours().isEmpty());
    }

    @Test
    public void itShouldNotBePossibleToBookTheSameHourTwice() {
        BookingService bookingService = new BookingService(12, 22);
        Assert.assertTrue(bookingService.book(13));
        Assert.assertFalse(bookingService.book(13));
        Assert.assertEquals(bookingService.getBookedHours(), Arrays.asList(new Integer[]{13}));
    }

    @Test
    public void itShouldBePossibleToBookDifferentHours() {
        BookingService bookingService = new BookingService(12, 22);
        Assert.assertTrue(bookingService.book(13));
        Assert.assertTrue(bookingService.book(18));
        Assert.assertTrue(bookingService.book(21));
        Assert.assertEquals(bookingService.getBookedHours(), Arrays.asList(new Integer[]{13, 18, 21}));
    }

}
