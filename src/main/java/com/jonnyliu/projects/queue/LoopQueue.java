package com.jonnyliu.projects.queue;

/**
 * 循环队列不额外浪费一个空间的实现版本
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
    }

    public LoopQueue(int capacity) {
        data = (E[]) new Object[capacity];
        front = 0;
        tail = 0;
        size = 0;
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

    public static void main(String[] args) {
        LoopQueue<Integer> queue = new LoopQueue<>();
        for (int i = 0; i < 16; i++) {

            queue.enqueue(i);
            System.out.println("i= " + i + queue);
            if (i % 3 == 1) {
                queue.dequeue();
                System.out.println(queue);
            }
        }
    }

    /**
     * 入队
     *
     * @param e
     */
    @Override
    public void enqueue(E e) {
        //队列已满,需要扩容
        if (getSize() >= getCapacity()) {
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
        // 显式设置front索引所在的元素为null
        data[front] = null;
        front = (front + 1) % data.length;
        size--;
        if (size <= getCapacity() / 4 && getCapacity() / 2 != 0) {
            resize(getCapacity() / 2);
        }
        return es;
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

    private void resize(int newCapacity) {

        if (newCapacity <= DEFAULT_CAPACITY) {
            return;
        }
        E[] newData = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[(front + i) % data.length];
        }
        data = newData;
        front = 0;
        tail = size;
    }

    private int getCapacity() {
        return data.length;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(
                        String.format(" loop queue: size=%d, capacity=%d, front=%d, tail=%d ", size, getCapacity(), front,
                                tail))
                .append("\n")
                .append("front [");
        for (int i = 0; i < size; i++) {
            builder.append(data[(i + front) % data.length]);
            if ((i + front + 1) % data.length != tail) {
                builder.append(", ");
            }
        }
        builder.append("] tail");
        return builder.toString();
    }

}