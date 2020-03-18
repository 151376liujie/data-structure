package com.jonnyliu.projects.queue;

import java.util.stream.IntStream;

/**
 * Author: jonny
 * Time: 2020-03-14 16:32.
 */
public class LoopQueue<E> implements Queue<E> {

    /**
     * 队首
     */
    private int front;
    /**
     * 队尾
     */
    private int tail;
    /**
     * 队列中元素的个数
     */
    private int size;

    /**
     * 队列元素
     */
    private E[] data;

    private static final int DEFAULT_CAPACITY = 10;

    public LoopQueue() {
        this(DEFAULT_CAPACITY);
        front = 0;
        tail = 0;
        size = 0;
    }

    public LoopQueue(int capacity) {
        data = (E[]) new Object[capacity + 1];
    }

    /**
     * 获取队列中元素个数
     *
     * @return
     */
    @Override
    public int getSize() {
        return size;
    }

    /**
     * 是否空队列
     *
     * @return
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 入队
     *
     * @param e
     */
    @Override
    public void enqueue(E e) {
        //队列已满,需要扩容
        if ((tail + 1) % data.length == front) {
            resize(getCapacity() * 2);
        }
        data[tail] = e;
        tail = (tail + 1) % data.length;
        size++;
    }

    /**
     * 出队
     */
    @Override
    public E dequeue() {

        if (isEmpty()) {
            throw new IllegalArgumentException("can not dequeue from an empty queue.");
        }
        E es = data[front];
        front = (front + 1) % data.length;
        size--;
        if (size <= getCapacity() / 4 && getCapacity() / 2 != 0) {
            resize(getCapacity() / 2);
        }
        return es;
    }

    private void resize(int newCapacity) {

        if (newCapacity <= DEFAULT_CAPACITY) {
            return;
        }
        E[] newData = (E[]) new Object[newCapacity + 1];
        for (int i = 0; i < tail + data.length - front; i++) {
            newData[i] = data[(front + i) % data.length];
        }
        data = newData;
        front = 0;
        tail = size;
    }

    /**
     * 获取队首元素
     *
     * @return
     */
    @Override
    public E getFront() {
        if (isEmpty()) {
            throw new IllegalArgumentException("can not dequeue from an empty queue.");
        }
        return data[front];
    }

    private int getCapacity() {
        return data.length - 1;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("loop queue: size=%d, capacity=%d ", size, getCapacity()))
                .append("\n")
                .append("front [");
        for (int i = front; i != tail; i = (i + 1) % data.length) {
            builder.append(data[i]);
            if ((i + 1) % data.length != tail) {
                builder.append(", ");
            }
        }
        builder.append("] tail");
        return builder.toString();
    }


    public static void main(String[] args) {
        LoopQueue<Integer> queue = new LoopQueue<>();
        IntStream.range(0, 10).forEach(queue::enqueue);
        System.out.println(queue);
        System.out.println(queue.dequeue() == 0);
        System.out.println(queue);
        System.out.println(queue.dequeue() == 1);
        System.out.println(queue);
    }
}
