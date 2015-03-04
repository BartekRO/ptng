package com.java.ro.ptng.ch6;

import java.util.Calendar;

/**
 * Created by Bartek on 2015-02-25.
 */
public class HelpDesk {

    public final static int EOB_HOUR = 17;
    private DateUtil dateUtil;

    public boolean willHandleIssue(Issue issue) {
        Calendar cal = dateUtil.getCurrentDateAsCalendar();
        int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
        if (Calendar.SUNDAY == dayOfWeek || Calendar.SATURDAY == dayOfWeek) {
            return false;
        }
        if (Calendar.FRIDAY == dayOfWeek) {
            int hour = cal.get(Calendar.HOUR_OF_DAY);
            if (hour > EOB_HOUR) {
                return false;
            }
        }
        return true;
    }

    public void setDateUtil(DateUtil dateUtil) {
        this.dateUtil = dateUtil;
    }
}
