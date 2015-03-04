package com.java.ro.ptng.ch8;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Bartek on 2015-03-02.
 */
public class LogTest {

    private String[] headers;

    @BeforeClass
    public void setup() throws IOException {
        List<String> lines = IOUtils.readLines(LogTest.class.getClassLoader().getResourceAsStream("exampleData.csv"), "UTF-8");
        headers = lines.get(0).split(",");
    }


    @DataProvider
    public Iterator<Object[]> getPersonData() throws IOException {
        List<String> lines = IOUtils.readLines(LogTest.class.getClassLoader().getResourceAsStream("exampleData.csv"), "UTF-8");
        List<Object[]> data = new ArrayList<>();

        boolean first = false;
        for (String line : lines) {
            if (first) {
                first = true;
                continue;
            }
            String[] split = line.split(",");
            data.add(new Object[] {split[0], split[1], split[2]});
        }
        return data.iterator();
    }

    @Test(dataProvider = "getPersonData")
    public void testLog(String name, String surname, String age) {
        Reporter.log(String.format("%s: %s,%s: %s,%s: %s,",
                headers[0], headers[1], headers[2], name, surname, age));
    }
}
