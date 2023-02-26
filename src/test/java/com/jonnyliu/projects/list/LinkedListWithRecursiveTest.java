package com.jonnyliu.projects.list;

import org.junit.Before;
import org.junit.Test;

public class LinkedListWithRecursiveTest {

    private LinkedListWithRecursive<Integer> list;

    @Before
    public void setUp() throws Exception {
        list = new LinkedListWithRecursive<>();
        for (int i = 0; i < 10; i++) {
            if (i % 2 == 0) {
                list.addFirst(i);
                System.out.println(i + ", after add first: " + list);
            } else {
                list.addLast(i);
                System.out.println(i + ", after add last: " + list);
            }
        }
    }


    @Test
    public void get() {
        for (int i = 0; i < list.getSize(); i++) {
            System.out.println("index: " + i + ", element: " + list.get(i));
        }
    }


    @Test
    public void set() {
        for (int i = 0; i < list.getSize(); i++) {
            list.set(i, i);
            System.out.println("index: " + i + ", after set element: " + list);
        }
    }

    @Test
    public void contains() {
        System.out.println("list contains 9 ?  " + list.contains(list.getSize() - 1));
        System.out.println("list contains -1 ? " + list.contains(-1));
    }

    @Test
    public void remove() {
        int index = 0;
        while (!list.isEmpty()) {
            if (index % 2 == 0) {
                Integer delLast = list.removeLast();
                System.out.println("index: " + index + ", after del last: " + delLast + ", list: " + list);
            } else {
                Integer delFirst = list.removeFirst();
                System.out.println("index: " + index + ", after del first: " + delFirst + ", list: " + list);
            }
            index++;
        }
    }
}