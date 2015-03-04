package com.java.ro.ptng.ch10;

import org.fest.assertions.Assertions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class StackTest {

    public static final String ELEMENT_1 = "element1";
    public static final String ELEMENT_2 = "element2";
    private Stack<String> stack;

    @BeforeMethod
    public void setUp() {
        stack = new Stack<>();
    }

    @Test
    public void createdStackShouldBeEmpty() {
        Assert.assertTrue(stack.isEmpty());
    }

    @Test
    public void createdStackShouldHaveSizeOfZero() {
        Assert.assertEquals(0, stack.size());
    }

    @Test
    public void shouldBeAbleToPushElementOnStack() {
        Assert.assertTrue(stack.push(ELEMENT_1));
    }

    @Test
    public void stackShouldNotBeEmptyAfterPush() {
        stack.push(ELEMENT_1);
        Assert.assertFalse(stack.isEmpty());
    }

    @Test
    public void stackShouldNotBeEmptyAfterMultiplePushes() {
        stack.push(ELEMENT_1);
        stack.push(ELEMENT_2);
        stack.push(ELEMENT_1);
        Assert.assertFalse(stack.isEmpty());
    }

    @Test
    public void stackShouldHaveCorrectSizeAfterPush() {
        stack.push(ELEMENT_1);
        Assert.assertEquals(1, stack.size());
    }

    @Test
    public void stackShouldHaveCorrectSizeAfterMultiplePushes() {
        stack.push(ELEMENT_1);
        stack.push(ELEMENT_2);
        stack.push(ELEMENT_1);
        Assert.assertEquals(3, stack.size());
    }

    //TODO
}