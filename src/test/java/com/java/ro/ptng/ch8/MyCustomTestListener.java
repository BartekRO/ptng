package com.java.ro.ptng.ch8;

import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import org.testng.annotations.Listeners;

/**
 * Created by Bartek on 2015-03-02.
 */
@Listeners(MyCustomTestListener.class)
public class MyCustomTestListener extends TestListenerAdapter {

    private int cnt = 0;

    private void log(String s) {
        System.out.print(s);
        if (cnt++ % 40 == 0) {
            System.out.println();
        }
    }

    @Override
    public void onTestSuccess(ITestResult tr) {
        log(".");
    }

    @Override
    public void onTestFailure(ITestResult tr) {
        log("F");
    }

    @Override
    public void onTestSkipped(ITestResult tr) {
        log("S");
    }
}
