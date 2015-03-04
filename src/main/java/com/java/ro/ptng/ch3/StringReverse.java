package com.java.ro.ptng.ch3;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bartek on 2015-02-21.
 */
public class StringReverse {

    public static String reverse(String s) {
        if (s == null) {
            throw new IllegalArgumentException("Cannot reverse null string.");
        }
        List<String> tempArray = new ArrayList<String>(s.length());
        for (int i = 0; i < s.length(); i++) {
            tempArray.add(s.substring(i, i + 1));
        }
        StringBuilder reversedString = new StringBuilder(s.length());
        for (int i = tempArray.size() - 1; i >= 0; i--) {
            reversedString.append(tempArray.get(i));
        }
        return reversedString.toString();
    }
}
