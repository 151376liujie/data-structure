package com.jonnyliu.projects.map;

import org.junit.Before;
import org.junit.Test;

/**
 * Author: jonny
 * Time: 2020-03-21 22:09.
 */
public class BSTMapTest {

    private BSTMap<Integer, Integer> map;

    @Before
    public void init() {
        map = new BSTMap<>();
    }

    @Test
    public void get() {
        map.add(10, 10);
        map.add(5, 5);
        map.add(17, 17);
        System.out.println(map.get(5));
    }

    @Test
    public void set() {
        map.add(10, 10);
        map.add(5, 5);
        map.set(55, 55);
        System.out.println(map);
    }

    @Test
    public void add() {

        map.add(10, 10);
        map.add(5, 5);
        map.add(17, 17);

        System.out.println(map);

    }

    @Test
    public void contains() {
        map.add(10, 10);
        System.out.println(map.contains(12));
    }

    @Test
    public void remove() {

        map.add(10, 10);
        map.add(5, 5);
        map.add(17, 17);
        map.add(11, 11);
        map.add(7, 7);
        map.add(14, 14);

        System.out.println(map.remove(10));
        System.out.println(map);
    }
}