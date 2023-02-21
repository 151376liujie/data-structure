package com.jonnyliu.projects.stack;

import com.jonnyliu.projects.list.LinkedList;
import java.util.StringJoiner;

/**
 * 使用单链表实现的栈,由于单链表只有头结点,而且在
 * 单链表的头结点插入和删除都非常方便,所以,头结点可以
 * 作为栈的栈顶
 * Author: jonny
 * Time: 2018-11-13 07:58.
 */
public class LinkedListStack<E> implements Stack<E> {

    private LinkedList<E> linkedList;

    public LinkedListStack() {
        linkedList = new LinkedList<>();
    }

    /**
     * 获取栈中元素个数
     *
     * @return
     */
    @Override
    public int getSize() {
        return linkedList.getSize();
    }

    /**
     * 栈是否为空栈
     *
     * @return
     */
    @Override
    public boolean isEmpty() {
        return linkedList.isEmpty();
    }

    /**
     * 将制定元素压入栈
     *
     * @param e
     */
    @Override
    public void push(E e) {
        linkedList.addFirst(e);
    }

    /**
     * 从栈顶弹出元素
     *
     * @return
     */
    @Override
    public E pop() {
        return linkedList.removeFirst();
    }

    /**
     * 查看栈顶元素
     *
     * @return
     */
    @Override
    public E peek() {
        return linkedList.getFirst();
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", LinkedListStack.class.getSimpleName() + "[", "]")
                .add(linkedList.toString())
                .toString();
    }
}