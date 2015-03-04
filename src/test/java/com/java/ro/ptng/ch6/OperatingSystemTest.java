package com.java.ro.ptng.ch6;


import org.testng.annotations.Test;

public class OperatingSystemTest  {

    @Test
    public void customAssertTest() {
        OperatingSystem os = new OperatingSystem();
        os.setNbOfBits(128);
        os.setReleaseYear(2001);
        os.setVersion("9");
        OperatingSystemAssert.assertThat(os).is128bit().wasReleasedIn(2001).hasVersion("9");
    }


}