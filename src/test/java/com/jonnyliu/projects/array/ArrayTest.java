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
        Assert.assertEquals(10, this.array.getCapacity());
        for (int i = 0; i < 10; i++) {
            this.array.addLast(i);
        }
        Assert.assertEquals(10, this.array.getCapacity());
        Assert.assertEquals(10, this.array.getSize());


        this.array.addLast(10);
        Assert.assertEquals(20, this.array.getCapacity());
        Assert.assertEquals(11, this.array.getSize());
    }

    @Test
    public void addFirst() {
        Assert.assertEquals(10, this.array.getCapacity());
        for (int i = 0; i < 10; i++) {
            this.array.addLast(i);
        }
        Assert.assertEquals(10, this.array.getCapacity());
        Assert.assertEquals(10, this.array.getSize());


        this.array.addLast(10);
        Assert.assertEquals(20, this.array.getCapacity());
        Assert.assertEquals(11, this.array.getSize());
    }

    @Test
    public void add() {
        Assert.assertEquals(10, this.array.getCapacity());
        for (int i = 0; i < 10; i++) {
            this.array.addLast(i);
        }
        Assert.assertEquals(10, this.array.getCapacity());
        Assert.assertEquals(10, this.array.getSize());


        this.array.addLast(10);
        Assert.assertEquals(20, this.array.getCapacity());
        Assert.assertEquals(11, this.array.getSize());

        for (int i = 0; i < 6; i++) {
            this.array.removeLast();
        }
        Assert.assertEquals(10, this.array.getCapacity());
        Assert.assertEquals(5, this.array.getSize());
    }

    @Test
    public void contains() {
        Assert.assertFalse(this.array.contains(111));
        this.array.addLast(123);
        Assert.assertTrue(this.array.contains(123));
    }

    @Test
    public void get() {
        for (int i = 0; i < 10; i++) {
            this.array.addLast(i);
        }
        Integer integer = this.array.get(5);
        Assert.assertEquals(integer.intValue(), 5);
    }

    @Test(expected = IllegalArgumentException.class)
    public void set() {
        this.array.set(0, 0);
    }

    @Test
    public void set2() {
        Assert.assertEquals(10, this.array.getCapacity());
        Assert.assertEquals(0, this.array.getSize());
        this.array.addLast(2);
        Assert.assertEquals(10, this.array.getCapacity());
        Assert.assertEquals(1, this.array.getSize());
        this.array.set(0, 4);
        Assert.assertEquals(4, this.array.get(0).intValue());
        Assert.assertEquals(10, this.array.getCapacity());
        Assert.assertEquals(1, this.array.getSize());
    }

    @Test
    public void find() {
        this.array.addLast(2);
        int i = this.array.find(2);
        Assert.assertEquals(0, i);
        Assert.assertEquals(-1, this.array.find(5));

    }

    @Test
    public void removeFirst() {
        for (int i = 0; i < 10; i++) {
            this.array.addLast(i);
        }
        Assert.assertEquals(10, this.array.getCapacity());
        Assert.assertEquals(10, this.array.getSize());

        for (int i = 0; i < 10; i++) {
            this.array.removeFirst();
        }
        Assert.assertEquals(10, this.array.getCapacity());
        Assert.assertEquals(0, this.array.getSize());

        this.array.addLast(5);
        Assert.assertEquals(10, this.array.getCapacity());
        Assert.assertEquals(1, this.array.getSize());

        this.array.addLast(6);
        Assert.assertEquals(10, this.array.getCapacity());
        Assert.assertEquals(2, this.array.getSize());

        this.array.addLast(7);
        Assert.assertEquals(10, this.array.getCapacity());
        Assert.assertEquals(3, this.array.getSize());

        this.array.addLast(8);
        Assert.assertEquals(10, this.array.getCapacity());
        Assert.assertEquals(4, this.array.getSize());
    }

    @Test
    public void removeLast() {
        for (int i = 0; i < 10; i++) {
            this.array.addLast(i);
        }
        Assert.assertEquals(10, this.array.getCapacity());
        Assert.assertEquals(10, this.array.getSize());

        for (int i = 0; i < 10; i++) {
            this.array.removeLast();
        }
        Assert.assertEquals(10, this.array.getCapacity());
        Assert.assertEquals(0, this.array.getSize());

        this.array.addLast(5);
        Assert.assertEquals(10, this.array.getCapacity());
        Assert.assertEquals(1, this.array.getSize());

        this.array.addLast(6);
        Assert.assertEquals(10, this.array.getCapacity());
        Assert.assertEquals(2, this.array.getSize());

        this.array.addLast(7);
        Assert.assertEquals(10, this.array.getCapacity());
        Assert.assertEquals(3, this.array.getSize());

        this.array.addLast(8);
        Assert.assertEquals(10, this.array.getCapacity());
        Assert.assertEquals(4, this.array.getSize());
    }

    @Test
    public void removeElement() {
        for (int i = 0; i < 10; i++) {
            this.array.addLast(i);
        }
        Assert.assertEquals(10, this.array.getCapacity());
        Assert.assertEquals(10, this.array.getSize());

        this.array.addLast(10);
        Assert.assertEquals(20, this.array.getCapacity());
        Assert.assertEquals(11, this.array.getSize());

        for (int i = 0; i < 10; i++) {
            this.array.removeElement(i);
        }

        Assert.assertEquals(10, this.array.getCapacity());
        Assert.assertEquals(1, this.array.getSize());
    }

    @Test
    public void remove() {
        for (int i = 0; i < 10; i++) {
            this.array.addLast(i);
        }
        Assert.assertEquals(10, this.array.getCapacity());
        Assert.assertEquals(10, this.array.getSize());

        this.array.addLast(10);
        Assert.assertEquals(20, this.array.getCapacity());
        Assert.assertEquals(11, this.array.getSize());

        for (int i = 0; i < 10; i++) {
            this.array.remove(0);
        }

        Assert.assertEquals(10, this.array.getCapacity());
        Assert.assertEquals(1, this.array.getSize());
    }
}