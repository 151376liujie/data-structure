package com.jonnyliu.projects.stack;

import java.util.Arrays;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LinkedListStackTest {

    private Stack<Integer> stack;

    @Before
    public void setUp() {
        stack = new LinkedListStack<>();
    }

    @Test
    public void push() {

        for (int i = 0; i < 10; i++) {
            stack.push(i);
            System.out.println(stack);
        }

    }

    @Test
    public void pop() {
        for (int i = 0; i < 10; i++) {
            stack.push(i);
            System.out.println(stack);
            if (i % 3 == 1) {
                Assert.assertTrue(Arrays.asList(1, 4, 7).contains(stack.pop()));
                System.out.println(stack);
            }
        }
    }

    @Test
    public void peek() {
        for (int i = 0; i < 10; i++) {
            stack.push(i);
            Assert.assertEquals(i, stack.peek().intValue());
            if (i % 3 == 1) {
                Assert.assertTrue(Arrays.asList(1, 4, 7).contains(stack.pop()));
                Assert.assertEquals(i - 1, stack.peek().intValue());
            }
        }
    }
}