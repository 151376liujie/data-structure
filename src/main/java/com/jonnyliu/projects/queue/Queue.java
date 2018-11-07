package com.jonnyliu.projects.queue;

/**
 * Project Name: data-structure
 * Package Name: com.jonnyliu.projects.queue
 * Author:       fanpu
 * Date:         2018-11-7 下午1:45
 * Description:  队列接口
 * Revision history: 1、fanpu created at 2018-11-7
 */
public interface Queue<E> {

    /**
     * 获取队列中元素个数
     * @return
     */
    int getSize();

    /**
     * 是否空队列
     * @return
     */
    boolean isEmpty();

    /**
     * 入队
     * @param e
     */
    void enqueue(E e);

    /**
     * 出队
     */
    E dequeue();

    /**
     * 获取队首元素
     * @return
     */
    E getFront();

}
