package com.java.ro.ptng.ch6;


import org.mockito.Mockito;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Calendar;
import java.util.GregorianCalendar;

import static org.mockito.Mockito.mock;

@Test
public class HelpDeskTest  {

    private HelpDesk helpDesk;
    private Issue issue = new Issue();
    private DateUtil dateUtil;

    @BeforeMethod
    public void setup() {
        helpDesk = new HelpDesk();
        dateUtil = mock(DateUtil.class);
        helpDesk.setDateUtil(dateUtil);
    }

    @DataProvider
    public Object[][] getWeekendDaysAndTimes() {
        return new Object[][] {{Calendar.SATURDAY, 0},{Calendar.SUNDAY, 0}, {Calendar.SATURDAY, 7},{Calendar.SUNDAY, 7},
                {Calendar.SATURDAY, 9},{Calendar.SUNDAY, 9}, {Calendar.SATURDAY, 16},{Calendar.SUNDAY, 16},
                {Calendar.SATURDAY, 23},{Calendar.SUNDAY, 23}, {Calendar.FRIDAY, 18},{Calendar.FRIDAY, 23}};
    }

    @DataProvider
    public Object[][] getWeekDaysAndTimes() {
        return new Object[][] {{Calendar.MONDAY, 0},{Calendar.MONDAY, 8}, {Calendar.MONDAY, 13}, {Calendar.MONDAY, 23},
                {Calendar.TUESDAY, 0},{Calendar.TUESDAY, 8}, {Calendar.TUESDAY, 13}, {Calendar.TUESDAY, 23},
                {Calendar.WEDNESDAY, 0},{Calendar.WEDNESDAY, 8}, {Calendar.WEDNESDAY, 13}, {Calendar.WEDNESDAY, 23},
                {Calendar.THURSDAY, 0},{Calendar.THURSDAY, 8}, {Calendar.THURSDAY, 13}, {Calendar.THURSDAY, 23},
                {Calendar.FRIDAY, 0},{Calendar.FRIDAY, 8}, {Calendar.FRIDAY, 13}, {Calendar.FRIDAY, 17}};
    }

    @Test(dataProvider = "getWeekendDaysAndTimes")
    public void willNotHandleIssueOnWeekend(int day, int hour) {
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.set(Calendar.DAY_OF_WEEK, day);
        calendar.set(Calendar.HOUR_OF_DAY, hour);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        Mockito.when(dateUtil.getCurrentDateAsCalendar()).thenReturn(calendar);
        Assert.assertFalse(helpDesk.willHandleIssue(issue));
    }

    @Test(dataProvider = "getWeekDaysAndTimes")
    public void willHandleIssueOnWeek(int day, int hour) {
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.set(Calendar.DAY_OF_WEEK, day);
        calendar.set(Calendar.HOUR_OF_DAY, hour);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        Mockito.when(dateUtil.getCurrentDateAsCalendar()).thenReturn(calendar);
        Assert.assertTrue(helpDesk.willHandleIssue(issue));
    }
}