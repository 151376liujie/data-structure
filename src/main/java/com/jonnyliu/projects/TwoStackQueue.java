package com.jonnyliu.projects;

import com.jonnyliu.projects.queue.Queue;
import com.jonnyliu.projects.stack.ArrayStack;
import com.jonnyliu.projects.stack.Stack;

/**
 * 使用两个栈来实现队列
 */
public class TwoStackQueue implements Queue<Integer> {

    /**
     * 主要操作的栈
     */
    private Stack<Integer> leftStack;

    /**
     * 辅助操作的栈
     */
    private Stack<Integer> rightStack;

    /**
     * 队列中的元素个数
     */
    private int size;


    public TwoStackQueue() {
        this.leftStack = new ArrayStack<>();
        this.rightStack = new ArrayStack<>();
        size = 0;
    }

    public TwoStackQueue(int capacity) {
        this.leftStack = new ArrayStack<>(capacity);
        this.rightStack = new ArrayStack<>(capacity);
        size = 0;
    }

    public static void main(String[] args) {
        TwoStackQueue queue = new TwoStackQueue();
        for (int i = 0; i < 5; i++) {
            queue.enqueue(i);
            if (queue.getSize() != i + 1) {
                throw new IllegalArgumentException("algo error");
            }
        }
        for (int i = 0; i < 5; i++) {
            if (queue.dequeue() != i) {
                throw new IllegalArgumentException("algo error");
            }
        }
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return getSize() == 0;
    }

    @Override
    public void enqueue(Integer ele) {
        /**
         * 实现思路:
         *  两个栈,每次要入队时,先将左边的栈中的元素全部移到右边的栈中,然后将元素push到左边的栈中;
         *  再把右边的栈中的元素全部push到左边的栈中
         */
        while (!leftStack.isEmpty()) {
            rightStack.push(leftStack.pop());
        }
        leftStack.push(ele);
        while (!rightStack.isEmpty()) {
            leftStack.push(rightStack.pop());
        }
        size++;
    }

    @Override
    public Integer dequeue() {
        return leftStack.pop();
    }

    @Override
    public Integer getFront() {
        return leftStack.peek();
    }
}