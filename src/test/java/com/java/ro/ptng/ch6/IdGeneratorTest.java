package com.java.ro.ptng.ch6;

import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.Set;

import static org.testng.Assert.*;

public class IdGeneratorTest {

    private Set<Long> ids = new HashSet<>(1000);
    private IdGenerator idGenerator = new IdGenerator();

    @Test(threadPoolSize = 10, invocationCount = 1000)
    public void testNextId() throws Exception {
        assertTrue(ids.add(idGenerator.nextId()));
    }
}