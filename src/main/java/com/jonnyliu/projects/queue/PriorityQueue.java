package com.jonnyliu.projects.queue;

import com.jonnyliu.projects.heap.MaxHeap;

/**
 * 使用最大堆来实现优先队列
 * Author: jonny
 * Time: 2020-03-22 20:03.
 */
public class PriorityQueue<E extends Comparable<E>> implements Queue<E> {

    private MaxHeap<E> maxHeap;

    public PriorityQueue() {
        maxHeap = new MaxHeap<>();
    }

    /**
     * 获取队列中元素个数
     *
     * @return
     */
    @Override
    public int getSize() {
        return maxHeap.getSize();
    }

    /**
     * 是否空队列
     *
     * @return
     */
    @Override
    public boolean isEmpty() {
        return maxHeap.isEmpty();
    }

    /**
     * 入队
     *
     * @param e
     */
    @Override
    public void enqueue(E e) {
        maxHeap.add(e);
    }

    /**
     * 出队
     */
    @Override
    public E dequeue() {
        return maxHeap.remove();
    }

    /**
     * 获取队首元素
     *
     * @return
     */
    @Override
    public E getFront() {
        return maxHeap.findMax();
    }
}