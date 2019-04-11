package com.jonnyliu.projects.LinkedList;

/**
 * Project Name: data-structure
 * Package Name: com.jonnyliu.projects.LinkedList
 * Author:       fanpu
 * Date:         2018-11-11 下午3:07
 * Description:  【干嘛用的？】
 * Revision history: 1、fanpu created at 2018-11-11
 */
public class LinkedList<E> {

    private class Node {
        E e;
        Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }
    }


    private Node head;
    private int size;

    public LinkedList() {
        this.head = null;
        size = 0;
    }

    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        return getSize() == 0;
    }

    public void addFirst(E e){
        head = new Node(e,head);
        size++;
    }
}
