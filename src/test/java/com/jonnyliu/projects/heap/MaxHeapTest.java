package com.jonnyliu.projects.heap;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.RandomUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Author: jonny
 * Time: 2020-03-22 00:13.
 */
public class MaxHeapTest {

    private MaxHeap<Integer> heap;

    @Before
    public void init() {
        heap = new MaxHeap<>();
    }

    @Test
    public void add() {

        for (int i = 0; i < 1000; i++) {
            heap.add(RandomUtils.nextInt(0, 16384));
        }

        System.out.println(heap);

        List<Integer> list = new ArrayList<>(heap.getSize());
        for (int i = 0; i < heap.getSize(); i++) {
            list.add(heap.remove());
        }

        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) < list.get(i + 1)) {
                throw new IllegalArgumentException("error: " + list.get(i) + " > " + list.get(i + 1));
            }
        }
    }

    @Test
    public void remove() {
        int[] array = {13, 41, 30, 28, 16, 22, 62, 19, 17, 15};

        for (int i : array) {
            heap.add(i);
        }

        System.out.println(heap);

        List<Integer> list = new ArrayList<>(heap.getSize());
        for (int i = 0; i < heap.getSize(); i++) {
            list.add(heap.remove());
        }

        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) < list.get(i + 1)) {
                throw new IllegalArgumentException("error: " + list.get(i) + " > " + list.get(i + 1));
            }
        }
    }

    @Test
    public void findMax() {
        int[] array = {62, 41, 30, 28, 16, 22, 13, 19, 17, 15};

        for (int i : array) {
            heap.add(i);
        }

        System.out.println(heap);
        Assert.assertEquals(62, heap.findMax().intValue());

    }

    @Test
    public void replace() {
        int[] array = {62, 41, 30, 28, 16, 22, 13, 19, 17, 15};

        for (int i : array) {
            heap.add(i);
        }

        System.out.println(heap);
        Integer max = heap.replace(31);
        Assert.assertEquals(max.intValue(), 62);
        //41,31,30,28,16,22,13,19,17,15}
        System.out.println(heap);

    }

    @Test
    public void heapify() {

        Integer[] array = {13, 30, 28, 19, 16, 22, 62, 41, 17, 15};
        heap = new MaxHeap<>(array);
        System.out.println(heap);

        List<Integer> list = new ArrayList<>(heap.getSize());

        int heapSize = heap.getSize();
        for (int i = 0; i < heapSize; i++) {
            list.add(heap.remove());
        }

        System.out.println(list);

        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) < list.get(i + 1)) {
                throw new IllegalArgumentException("error");
            }
        }
    }
}