package com.jonnyliu.projects.heap;

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

        int[] array = {62, 41, 30, 28, 16, 22, 13, 19, 17, 15};

        for (int i : array) {
            heap.add(i);
        }

        System.out.println(heap);

        heap.add(52);
        System.out.println(heap);
    }

    @Test
    public void remove() {
        int[] array = {62, 41, 30, 28, 16, 22, 13, 19, 17, 15};

        for (int i : array) {
            heap.add(i);
        }

        System.out.println(heap);

        for (int i = 0; i < 10; i++) {
            System.out.println(heap.remove());
            System.out.println(heap);
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

        Integer[] array = {41, 30, 28, 19, 16, 22, 62, 13, 17, 15};
        heap.heapify(array);
        System.out.println(heap);
    }
}