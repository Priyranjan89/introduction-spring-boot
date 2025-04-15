package com.learn.spring.boot.introduction_spring_boot;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class ResultTest {

    @Test
    public void testGetPhoneNumbers_ValidCountry() {
        // Example input
        String country = "Afghanistan";
        String phoneNumber = "656445445";

        // Expected output
        String expected = "+93 656445445";

        // Actual output from method
        String actual = Result.getPhoneNumbers(country, phoneNumber);

        // Assertion
        assertEquals(expected, actual);
    }

    @Test
    public void testGetPhoneNumbers_InvalidCountry() {
        // Country not found in data
        String country = "UnknownCountryXYZ";
        String phoneNumber = "123456789";

        String expected = "-1";
        String actual = Result.getPhoneNumbers(country, phoneNumber);

        assertEquals(expected, actual);
    }
}

