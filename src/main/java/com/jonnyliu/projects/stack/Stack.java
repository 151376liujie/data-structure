package com.jonnyliu.projects.stack;

/**
 * Author: jonny
 * Time: 2018-11-06 22:29.
 */
public interface Stack<E> {

    /**
     * 获取栈中元素个数
     *
     * @return
     */
    int getSize();

    /**
     * 栈是否为空栈
     *
     * @return
     */
    boolean isEmpty();

    /**
     * 将制定元素压入栈
     *
     * @param e
     */
    void push(E e);

    /**
     * 从栈顶弹出元素
     *
     * @return
     */
    E pop();

    /**
     * 查看栈顶元素
     *
     * @return
     */
    E peek();

}
