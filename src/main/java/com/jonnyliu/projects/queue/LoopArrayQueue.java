package com.jonnyliu.projects.queue;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

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

    private int getCapacity() {
        return data.length - 1;
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
        if (front == (tail + 1) % data.length) {
            resize(getCapacity() * 2);
        }
        data[tail] = e;
        tail = (tail + 1) % data.length;
        size++;
    }

    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity + 1];
        for (int i = 0; i < getSize(); i++) {
            newData[i] = data[(i + front) % data.length];
        }
        data = newData;
        front = 0;
        tail = size;
    }

    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new IllegalArgumentException("can not dequeue from a empty queue.");
        }
        E datum = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size--;
        if (getCapacity() > DEFAULT_CAPACITY) {
            if (getSize() == getCapacity() / 4 && getCapacity() / 2 != 0) {
                resize(getCapacity() / 2);
            }
        }
        return datum;
    }

    @Override
    public E getFront() {
        if (isEmpty()) {
            throw new IllegalArgumentException(" queue is empty.");
        }
        return data[front];
    }


    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
                .append("data", data)
                .append("front", front)
                .append("tail", tail)
                .append("size", size)
                .toString();
    }
}
