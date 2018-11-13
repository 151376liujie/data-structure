package com.jonnyliu.projects.queue;

/**
 * Author: jonny
 * Time: 2018-11-13 09:40.
 */
public class LinkedListQueue<E> implements Queue<E> {

    class Node {
        E data;
        Node next;

        public Node(E data, Node next) {
            this.data = data;
            this.next = next;
        }

        public Node(E data) {
            this(data, null);
        }

        public Node() {
            this(null, null);
        }
    }

    private Node head;
    private Node tail;
    private int size;

    public LinkedListQueue() {
        head = tail = null;
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
        return getSize() == 0;
    }

    /**
     * 入队
     *
     * @param e
     */
    @Override
    public void enqueue(E e) {
        //tail 为空时,head肯定也为空
        if (tail == null) {
            tail = new Node(e);
            head = tail;
        } else {
            tail.next = new Node(e);
            tail = tail.next;
        }
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
        Node cur = head;
        head = head.next;
        cur.next = null;
        //如果队列中只有一个元素时,当出队后,队列为空,head 和tail 须设为null
        if (head == null) {
            tail = null;
        }
        size--;
        return cur.data;
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
        return head.data;
    }


    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedListQueue<>();
        diff(queue);

        queue = new ArrayQueue<>();
        diff(queue);
    }

    private static void diff(Queue queue) {
        long start = System.currentTimeMillis();

        for (int i = 0; i < 1000000; i++) {
            queue.enqueue(i);
            if (i % 3 == 0) {
                queue.dequeue();
            }
        }
        long end = System.currentTimeMillis();

        System.out.println((end - start) / 1000.0);
    }
}
