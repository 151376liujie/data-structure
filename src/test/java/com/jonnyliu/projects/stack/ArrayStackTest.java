package com.jonnyliu.projects.stack;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Author: jonny
 * Time: 2018-11-06 22:55.
 */
public class ArrayStackTest {

    Stack<Integer> stack;

    @Before
    public void init() {
        stack = new ArrayStack<>();
    }

    @Test
    public void getSize() {
        Assert.assertEquals(0, stack.getSize());
    }

    @Test
    public void isEmpty() {
        Assert.assertTrue(stack.isEmpty());
        stack.push(0);
        Assert.assertFalse(stack.isEmpty());
    }

    @Test
    public void push() {
        Assert.assertTrue(stack.isEmpty());
        stack.push(0);
        Assert.assertEquals(0, stack.peek().intValue());
    }

    @Test
    public void pop() {
        Assert.assertTrue(stack.isEmpty());
        stack.push(0);
        Assert.assertEquals(0, stack.pop().intValue());
    }

    @Test
    public void peek() {
        Assert.assertTrue(stack.isEmpty());
        stack.push(0);
        stack.push(1);
        Assert.assertEquals(1, stack.peek().intValue());
        System.out.println(stack);
    }
}