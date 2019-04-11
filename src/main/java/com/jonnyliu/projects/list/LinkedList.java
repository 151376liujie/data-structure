package com.jonnyliu.projects.list;

/**
 * Author: jonny
 * Time: 2018-11-11 21:34.
 */
public class LinkedList<E> {

    private class Node {
        E data;
        Node next;

        public Node(E data) {
            this(data, null);
        }

        public Node(E data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    /**
     * 虚拟头结点
     */
    private Node dummyHead;
    private int size;

    public LinkedList() {
        dummyHead = new Node(null);
        size = 0;
    }


    public LinkedList(E[] array) {
        dummyHead = new Node(null);
        for (E e : array) {
            addLast(e);
        }
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return getSize() == 0;
    }


    private void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("index must <= size.");
        }

        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        Node node = new Node(e);
        node.next = prev.next;
        prev.next = node;
        size++;
    }

    public void addFirst(E e) {
        add(0, e);
    }

    public void addLast(E e) {
        add(size, e);
    }

    public E get(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("index must <= size.");
        }
        Node curr = dummyHead.next;
        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }
        return curr.data;
    }

    public E getFirst() {
        return get(0);
    }

    public E getLast() {
        return get(size - 1);
    }

    public void set(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("index must <= size.");
        }
        Node curr = dummyHead.next;
        if (curr == null) {
            throw new IllegalArgumentException("can not set value into an empty linkedList");
        }
        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }
        curr.data = e;
    }

    public boolean contains(E e) {
        Node curr = dummyHead.next;
        while (curr != null) {
            if (curr.data.equals(e)) {
                return true;
            }
            curr = curr.next;
        }
        return false;
    }

    public E remove(int index) {
        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        Node curr = prev.next;
        E data = curr.data;
        prev.next = curr.next;
        curr.next = null;
        size--;
        return data;
    }

    public E removeFirst() {
        return remove(0);
    }

    public E removeLast() {
        return remove(size - 1);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        Node curr = dummyHead.next;
        while (curr != null) {
            builder.append(curr.data).append(" -> ");
            curr = curr.next;
        }
        builder.append("null");

        return builder.toString();
    }

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.addFirst(1);
        System.out.println(list);

        list = new LinkedList(new Integer[]{1, 2, 3});
        System.out.println(list);
        list.add(2, 4);
        System.out.println(list);

        System.out.println(list.get(0));
        System.out.println(list.get(1));

        System.out.println(list.contains(4));
        System.out.println(list.contains(14));

        System.out.println(list.remove(1));
        System.out.println(list);
    }
}
