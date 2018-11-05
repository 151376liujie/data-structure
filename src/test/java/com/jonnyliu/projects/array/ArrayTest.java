package com.jonnyliu.projects.array;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Author: jonny
 * Time: 2018-11-04 23:42.
 */
public class ArrayTest {

    private Array<Integer> array;

    @Before
    public void init() {
        this.array = new Array<>(10);
        Assert.assertTrue(this.array.isEmpty());
        Assert.assertEquals(10, this.array.getCapacity());
    }

    @Test
    public void getSize() {
        Assert.assertTrue(this.array.isEmpty());
        this.array.addLast(1);
        Assert.assertEquals(1, this.array.getSize());
        Assert.assertEquals(10, this.array.getCapacity());
    }

    @Test
    public void isEmpty() {
        Assert.assertTrue(this.array.isEmpty());
        this.array.addLast(1);
        Assert.assertFalse(this.array.isEmpty());
    }

    @Test
    public void getCapacity() {
        Assert.assertEquals(10, this.array.getCapacity());
        this.array.addLast(1);
        Assert.assertEquals(10, this.array.getCapacity());
    }

    @Test
    public void addLast() {
    }

    @Test
    public void addFirst() {
    }

    @Test
    public void add() {
    }

    @Test
    public void contains() {
    }

    @Test
    public void get() {
    }

    @Test
    public void set() {
    }

    @Test
    public void find() {
    }

    @Test
    public void removeFirst() {
    }

    @Test
    public void removeLast() {
    }

    @Test
    public void removeElement() {
    }

    @Test
    public void remove() {
    }
}