package com.jonnyliu.projects.heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.apache.commons.lang3.RandomUtils;
import org.junit.Assert;
import org.junit.Test;

public class MinHeapTest {

    private MinHeap<Integer> minHeap;

    @Test
    public void getSize() {

        minHeap = new MinHeap<>(Arrays.asList(34, 23, 41, 8, 31, 22, 19, 39).toArray(new Integer[]{0}));
        Assert.assertEquals(8, minHeap.getSize());
    }

    @Test
    public void isEmpty() {
        minHeap = new MinHeap<>(Arrays.asList(34, 23, 41, 8, 31, 22, 19, 39).toArray(new Integer[]{0}));
        Assert.assertFalse(minHeap.isEmpty());
    }

    @Test
    public void add() {
        minHeap = new MinHeap<>(Arrays.asList(34, 23, 41, 8, 31, 22, 19, 39).toArray(new Integer[]{0}));
        minHeap.add(5);

        List<Integer> list = new ArrayList<>(minHeap.getSize());
        for (int i = 0; i < list.size(); i++) {
            list.add(minHeap.remove());
        }

        Assert.assertArrayEquals(new Integer[]{}, list.toArray(new Integer[0]));

        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) > list.get(i + 1)) {
                throw new IllegalArgumentException("error");
            }
        }
    }

    @Test
    public void findMax() {
        minHeap = new MinHeap<>(Arrays.asList(34, 23, 41, 8, 31, 22, 19, 39).toArray(new Integer[]{0}));
        Assert.assertEquals(8, minHeap.findMax().intValue());
    }

    @Test
    public void remove() {
        int nums = 10000000;
        List<Integer> list = new ArrayList<>(nums);

        minHeap = new MinHeap<>(nums);
        for (int i = 0; i < nums; i++) {
            int nextInt = RandomUtils.nextInt(0, 1000000);
            minHeap.add(nextInt);
        }

        for (int i = 0; i < nums; i++) {
            list.add(minHeap.remove());
        }

        for (int i = 0; i < nums - 1; i++) {
            Assert.assertTrue(list.get(i) <= list.get(i + 1));
        }

    }

    @Test
    public void replace() {
        minHeap = new MinHeap<>(Arrays.asList(34, 23, 41, 8, 31, 22, 19, 39).toArray(new Integer[]{0}));
        System.out.println(minHeap);
        Integer top = minHeap.replace(38);
        Assert.assertEquals(8, top.intValue());

        int size = minHeap.getSize();
        List<Integer> list = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            list.add(minHeap.remove());
        }
        System.out.println(list);
        for (int i = 0; i < list.size() - 1; i++) {
            Assert.assertTrue(list.get(i) <= list.get(i + 1));
        }
    }
}