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
        array = new Array<>(10);
        Assert.assertTrue(array.isEmpty());
        Assert.assertEquals(10, array.getCapacity());
    }

    @Test
    public void getSize() {
        Assert.assertTrue(array.isEmpty());
        array.addLast(1);
        Assert.assertEquals(1, array.getSize());
        Assert.assertEquals(10, array.getCapacity());
    }

    @Test
    public void isEmpty() {
        Assert.assertTrue(array.isEmpty());
        array.addLast(1);
        Assert.assertFalse(array.isEmpty());
    }

    @Test
    public void getCapacity() {
        Assert.assertEquals(10, array.getCapacity());
        array.addLast(1);
        Assert.assertEquals(10, array.getCapacity());
    }

    @Test
    public void addLast() {
        Assert.assertEquals(10, array.getCapacity());
        for (int i = 0; i < 10; i++) {
            array.addLast(i);
        }
        Assert.assertEquals(10, array.getCapacity());
        Assert.assertEquals(10, array.getSize());


        array.addLast(10);
        Assert.assertEquals(20, array.getCapacity());
        Assert.assertEquals(11, array.getSize());
    }

    @Test
    public void addFirst() {
        Assert.assertEquals(10, array.getCapacity());
        for (int i = 0; i < 10; i++) {
            array.addLast(i);
        }
        Assert.assertEquals(10, array.getCapacity());
        Assert.assertEquals(10, array.getSize());


        array.addLast(10);
        Assert.assertEquals(20, array.getCapacity());
        Assert.assertEquals(11, array.getSize());
    }

    @Test
    public void add() {
        Assert.assertEquals(10, array.getCapacity());
        for (int i = 0; i < 10; i++) {
            array.addLast(i);
        }
        Assert.assertEquals(10, array.getCapacity());
        Assert.assertEquals(10, array.getSize());


        array.addLast(10);
        Assert.assertEquals(20, array.getCapacity());
        Assert.assertEquals(11, array.getSize());

        for (int i = 0; i < 6; i++) {
            array.removeLast();
        }
        Assert.assertEquals(10, array.getCapacity());
        Assert.assertEquals(5, array.getSize());
    }

    @Test
    public void contains() {
        Assert.assertFalse(array.contains(111));
        array.addLast(123);
        Assert.assertTrue(array.contains(123));
    }

    @Test
    public void get() {
        for (int i = 0; i < 10; i++) {
            array.addLast(i);
        }
        Integer integer = array.get(5);
        Assert.assertEquals(integer.intValue(), 5);
    }

    @Test(expected = IllegalArgumentException.class)
    public void set() {
        array.set(0, 0);
    }

    @Test
    public void set2() {
        Assert.assertEquals(10, array.getCapacity());
        Assert.assertEquals(0, array.getSize());
        array.addLast(2);
        Assert.assertEquals(10, array.getCapacity());
        Assert.assertEquals(1, array.getSize());
        array.set(0, 4);
        Assert.assertEquals(4, array.get(0).intValue());
        Assert.assertEquals(10, array.getCapacity());
        Assert.assertEquals(1, array.getSize());
    }

    @Test
    public void find() {
        array.addLast(2);
        int i = array.find(2);
        Assert.assertEquals(0, i);
        Assert.assertEquals(-1, array.find(5));

    }

    @Test
    public void removeFirst() {
        for (int i = 0; i < 10; i++) {
            array.addLast(i);
        }
        Assert.assertEquals(10, array.getCapacity());
        Assert.assertEquals(10, array.getSize());

        for (int i = 0; i < 10; i++) {
            array.removeFirst();
        }
        Assert.assertEquals(10, array.getCapacity());
        Assert.assertEquals(0, array.getSize());

        array.addLast(5);
        Assert.assertEquals(10, array.getCapacity());
        Assert.assertEquals(1, array.getSize());

        array.addLast(6);
        Assert.assertEquals(10, array.getCapacity());
        Assert.assertEquals(2, array.getSize());

        array.addLast(7);
        Assert.assertEquals(10, array.getCapacity());
        Assert.assertEquals(3, array.getSize());

        array.addLast(8);
        Assert.assertEquals(10, array.getCapacity());
        Assert.assertEquals(4, array.getSize());
    }

    @Test
    public void removeLast() {
        for (int i = 0; i < 10; i++) {
            array.addLast(i);
        }
        Assert.assertEquals(10, array.getCapacity());
        Assert.assertEquals(10, array.getSize());

        for (int i = 0; i < 10; i++) {
            array.removeLast();
        }
        Assert.assertEquals(10, array.getCapacity());
        Assert.assertEquals(0, array.getSize());

        array.addLast(5);
        Assert.assertEquals(10, array.getCapacity());
        Assert.assertEquals(1, array.getSize());

        array.addLast(6);
        Assert.assertEquals(10, array.getCapacity());
        Assert.assertEquals(2, array.getSize());

        array.addLast(7);
        Assert.assertEquals(10, array.getCapacity());
        Assert.assertEquals(3, array.getSize());

        array.addLast(8);
        Assert.assertEquals(10, array.getCapacity());
        Assert.assertEquals(4, array.getSize());
    }

    @Test
    public void removeElement() {
        for (int i = 0; i < 10; i++) {
            array.addLast(i);
        }
        Assert.assertEquals(10, array.getCapacity());
        Assert.assertEquals(10, array.getSize());

        array.addLast(10);
        Assert.assertEquals(20, array.getCapacity());
        Assert.assertEquals(11, array.getSize());

        for (int i = 0; i < 10; i++) {
            array.removeElement(i);
        }

        Assert.assertEquals(10, array.getCapacity());
        Assert.assertEquals(1, array.getSize());
    }

    @Test
    public void remove() {
        for (int i = 0; i < 10; i++) {
            array.addLast(i);
        }
        Assert.assertEquals(10, array.getCapacity());
        Assert.assertEquals(10, array.getSize());

        System.out.println(array);

        array.addLast(10);
        Assert.assertEquals(20, array.getCapacity());
        Assert.assertEquals(11, array.getSize());
        System.out.println(array);

        array.remove(5);
        Assert.assertEquals(20, array.getCapacity());
        Assert.assertEquals(10, array.getSize());
        System.out.println(array);

        for (int i = 0; i < 10; i++) {
            array.remove(0);
        }

        System.out.println(array);
        Assert.assertEquals(10, array.getCapacity());
        Assert.assertEquals(0, array.getSize());
    }
}