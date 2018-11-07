package com.jonnyliu.projects.queue;

import com.jonnyliu.projects.array.Array;

/**
 * Project Name: data-structure
 * Package Name: com.jonnyliu.projects.queue
 * Author:       fanpu
 * Date:         2018-11-7 下午1:48
 * Description:  使用数组实现队列
 * Revision history: 1、fanpu created at 2018-11-7
 */
public class ArrayQueue<E> implements Queue<E> {

    private Array<E> array;

    public ArrayQueue() {
        array = new Array<>();
    }

    public ArrayQueue(int capacity) {
        array = new Array<>(capacity);
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    @Override
    public void enqueue(E e) {
        array.addLast(e);
    }

    @Override
    public E dequeue() {
        return array.removeFirst();
    }

    @Override
    public E getFront() {
        return array.getFirst();
    }
}
