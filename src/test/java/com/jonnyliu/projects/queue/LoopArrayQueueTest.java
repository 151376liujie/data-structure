package com.jonnyliu.projects.queue;

import org.junit.Before;
import org.junit.Test;

/**
 * Author: jonny
 * Time: 2018-11-10 22:31.
 */
public class LoopArrayQueueTest {

    private LoopArrayQueue<Integer> loopArrayQueue;

    @Before
    public void init() {
        loopArrayQueue = new LoopArrayQueue<>(10);
    }

    @Test
    public void enqueue() {
        for (int i = 0; i < 10; i++) {
            loopArrayQueue.enqueue(i);
            System.out.println(loopArrayQueue);
        }
        System.out.println("=======================");
//        loopArrayQueue.enqueue(10);
//        System.out.println(loopArrayQueue);

//        System.out.println("=======================");
        for (int i = 0; i < 10; i++) {
            loopArrayQueue.dequeue();
            System.out.println(loopArrayQueue);
        }

        System.out.println("=======================");
        loopArrayQueue.enqueue(22);
        System.out.println(loopArrayQueue);
        loopArrayQueue.enqueue(33);
        System.out.println(loopArrayQueue);
    }

    @Test
    public void dequeue() {
    }

    @Test
    public void getFront() {
    }
}