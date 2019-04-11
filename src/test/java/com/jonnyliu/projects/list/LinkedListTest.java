package com.jonnyliu.projects.list;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Project Name: data-structure
 * Package Name: com.jonnyliu.projects.list
 * Author:       fanpu
 * Date:         2019-04-11 09:31
 * Description:  【干嘛用的？】
 * Revision history: 1、fanpu created at 2019-04-11
 */
public class LinkedListTest {

    @Test
    public void getSize() {

        LinkedList<Integer> list = new LinkedList<>();
        assertEquals(0, list.getSize());

        list.addFirst(9);
        assertEquals(1, list.getSize());

    }

    @Test
    public void isEmpty() {
        LinkedList<Integer> list = new LinkedList<>();
        assertTrue(list.isEmpty());

        list.addFirst(9);
        assertFalse(list.isEmpty());
    }

    @Test
    public void addFirst() {
        LinkedList<Integer> list = new LinkedList<>();
        assertTrue(list.isEmpty());

        list.addFirst(9);
        assertFalse(list.isEmpty());
        assertEquals(Integer.valueOf(9), list.getFirst());
    }

    @Test
    public void addLast() {
        LinkedList<Integer> list = new LinkedList<>();
        assertTrue(list.isEmpty());

        list.addLast(9);
        assertFalse(list.isEmpty());
        assertEquals(Integer.valueOf(9), list.getLast());
    }

    @Test
    public void get() {
        LinkedList<Integer> list = new LinkedList<>();
        assertTrue(list.isEmpty());

        list.addFirst(9);
        assertFalse(list.isEmpty());
        assertEquals(Integer.valueOf(9), list.get(0));
    }

    @Test
    public void getFirst() {
        LinkedList<Integer> list = new LinkedList<>();
        assertTrue(list.isEmpty());

        list.addFirst(9);
        assertFalse(list.isEmpty());
        assertEquals(Integer.valueOf(9), list.getFirst());
    }

    @Test
    public void getLast() {
        LinkedList<Integer> list = new LinkedList<>();
        assertTrue(list.isEmpty());

        list.addLast(9);
        assertFalse(list.isEmpty());
        assertEquals(Integer.valueOf(9), list.getLast());
    }

    @Test
    public void set() {
        LinkedList<Integer> list = new LinkedList<>();
        assertTrue(list.isEmpty());

        list.addLast(1);
        assertFalse(list.isEmpty());

        list.set(0, 9);
        assertEquals(Integer.valueOf(9), list.get(0));
    }

    @Test
    public void contains() {
        LinkedList<Integer> list = new LinkedList<>();
        assertTrue(list.isEmpty());

        list.addFirst( 9);
        assertFalse(list.isEmpty());
        assertTrue(list.contains(9));
    }

    @Test
    public void remove() {
        LinkedList<Integer> list = new LinkedList<>();
        assertTrue(list.isEmpty());

        list.addFirst( 9);
        assertFalse(list.isEmpty());
        assertTrue(list.contains(9));

        list.remove(0);
        assertTrue(list.isEmpty());
    }

    @Test
    public void removeFirst() {
        LinkedList<Integer> list = new LinkedList<>();
        assertTrue(list.isEmpty());

        list.addFirst( 9);
        assertFalse(list.isEmpty());
        assertTrue(list.contains(9));

        list.removeFirst();
        assertTrue(list.isEmpty());
    }

    @Test
    public void removeLast() {
        LinkedList<Integer> list = new LinkedList<>();
        assertTrue(list.isEmpty());

        list.addLast( 9);
        assertFalse(list.isEmpty());
        assertTrue(list.contains(9));

        list.removeLast();
        assertTrue(list.isEmpty());
    }
}