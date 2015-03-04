package com.java.ro.ptng.ch3;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashMap;

/**
 * Created by Bartek on 2015-02-22.
 */
public class HashMapTest {

    public static final String VALUE = "value";
    public static final String KEY = "key";
    public static final String VALUE_2 = "value2";
    public static final String KEY_2 = "key2";
    HashMap map;

    @BeforeMethod
    public void setup() {
        map = new HashMap();
    }

    @Test
    public void putObjectCanBeFetchedByGet() {
        map.put(KEY, VALUE);
        Assert.assertEquals(map.get(KEY), VALUE);
    }

    @Test
    public void secondValueReplaceFirst() {
        map.put(KEY, VALUE);
        map.put(KEY, VALUE_2);
        Assert.assertEquals(map.get(KEY), VALUE_2);
    }

    @Test
    public void nullCanBeUsedAsKey() {
        map.put(null, VALUE);
        Assert.assertEquals(map.get(null), VALUE);
    }

    @Test
    public void clearRemovesAllData() {
        map.put(KEY, VALUE);
        map.put(KEY_2, VALUE_2);
        map.clear();
        Assert.assertTrue(map.isEmpty());
    }
}
