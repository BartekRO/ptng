package com.java.ro.ptng.ch6;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by Bartek on 2015-02-27.
 */
public class IdGenerator {

    private AtomicLong atomicLong = new AtomicLong();

    public long nextId() {
        return atomicLong.incrementAndGet();
    }
}
