package com.jonnyliu.projects.queue;

/**
 * Project Name: data-structure
 * Package Name: com.jonnyliu.projects.queue
 * Author:       fanpu
 * Date:         2018-11-7 下午1:52
 * Description:  【干嘛用的？】
 * Revision history: 1、fanpu created at 2018-11-7
 */
public class LoopArrayQueue<E> implements Queue<E> {

    private static final int DEFAULT_CAPACITY = 10;

    private E[] data;
    /**
     * 队列为空：front == tail
     * 队列为满：front == (tail + 1) % capacity
     */
    private int front, tail;
    private int size;

    public LoopArrayQueue() {
        this(DEFAULT_CAPACITY);
    }

    public LoopArrayQueue(int capacity) {
        // 因为我们要有目的的浪费一个空间大小，所以此处需要 + 1
        data = (E[]) new Object[capacity + 1];
        front = tail = 0;
        size = 0;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void enqueue(E e) {

    }

    @Override
    public E dequeue() {
        return null;
    }

    @Override
    public E getFront() {
        return null;
    }
}
