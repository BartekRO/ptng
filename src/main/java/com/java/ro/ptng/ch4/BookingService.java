package com.java.ro.ptng.ch4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Bartek on 2015-02-22.
 */
public class BookingService {
    private List<Integer> availableHours;
    private List<Integer> bookedHours;

    public BookingService(int startHour, int finishHour) {
        if (startHour < 0 || finishHour < 0 || startHour >= finishHour || finishHour > 24) {
            throw new IllegalArgumentException("Illegal values of start and finish hour of booking service");
        }

        availableHours = new ArrayList<>();
        for (int h = startHour; h < finishHour; h++) {
            availableHours.add(h);
        }
        bookedHours = new LinkedList<>();
    }

    public List<Integer> getAvailableHours() {
        return availableHours;
    }

    public boolean book(int hourToBook) {
        if (availableHours.remove(new Integer(hourToBook))) {
            bookedHours.add(hourToBook);
            return true;
        }
        return false;
    }

    public List<Integer> getBookedHours() {
        return bookedHours;
    }
}
