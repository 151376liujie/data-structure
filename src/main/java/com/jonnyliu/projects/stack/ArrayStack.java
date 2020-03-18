package com.jonnyliu.projects.stack;

import com.jonnyliu.projects.array.Array;

/**
 * 数组实现的栈
 * Author: jonny
 * Time: 2018-11-06 22:52.
 */
public class ArrayStack<E> implements Stack<E> {

    private Array<E> array;


    public ArrayStack() {
        array = new Array<>();
    }

    public ArrayStack(int capacity) {
        array = new Array<>(capacity);
    }

    /**
     * 获取栈中元素个数
     *
     * @return
     */
    @Override
    public int getSize() {
        return array.getSize();
    }

    /**
     * 栈是否为空栈
     *
     * @return
     */
    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    /**
     * 将制定元素压入栈
     *
     * @param e
     */
    @Override
    public void push(E e) {
        array.addLast(e);
    }

    /**
     * 从栈顶弹出元素
     *
     * @return
     */
    @Override
    public E pop() {
        return array.removeLast();
    }

    /**
     * 查看栈顶元素
     *
     * @return
     */
    @Override
    public E peek() {
        return array.get(getSize() - 1);
    }


    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("stack: ")
                .append("[");
        for (int i = 0; i < array.getSize(); i++) {
            builder.append(array.get(i));
            if (i != array.getSize() - 1) {
                builder.append(", ");
            }
        }
        builder.append("] top");
        return builder.toString();
    }
}
