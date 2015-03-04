package com.java.ro.ptng.ch6;

import org.fest.assertions.Assertions;
import org.fest.assertions.GenericAssert;

/**
 * Created by Bartek on 2015-02-27.
 */
public class OperatingSystemAssert extends GenericAssert<OperatingSystemAssert, OperatingSystem> {

    public OperatingSystemAssert(OperatingSystem actual) {
        super(OperatingSystemAssert.class, actual);
    }

    public static OperatingSystemAssert assertThat(OperatingSystem actual) {
        return new OperatingSystemAssert(actual);
    }

    public OperatingSystemAssert is128bit() {
        String errorMessage = String.format("Expected 128bit but was %s bit", this.actual.getNbOfBits());
        Assertions.assertThat(this.actual.getNbOfBits()).overridingErrorMessage(errorMessage).isEqualTo(128);
        return this;
    }

    public OperatingSystemAssert wasReleasedIn(int year) {
        String errorMessage = String.format("Expected release year %s but was %s.", year, this.actual.getReleaseYear());
        Assertions.assertThat(this.actual.getReleaseYear()).overridingErrorMessage(errorMessage).isEqualTo(year);
        return this;
    }

    public OperatingSystemAssert hasVersion(String versionNumber) {
        String errorMessage = String.format("Expected versionNumber: %s but was %s.", versionNumber, this.actual.getVersion());
        Assertions.assertThat(this.actual.getVersion()).overridingErrorMessage(errorMessage).isEqualTo(versionNumber);
        return this;
    }

}
