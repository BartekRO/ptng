package com.java.ro.ptng.ch10;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Bartek on 2015-03-04.
 */
public class Stack<T> {

    private Deque<T> data = new LinkedList<>();

    public boolean isEmpty() {
        return data.isEmpty();
    }

    public int size() {
        return data.size();
    }

    public boolean push(T element) {
        data.add(element);
        return true;
    }
}
