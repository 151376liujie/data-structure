package com.jonnyliu.projects.list;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;

/**
 * 尝试使用递归方式实现一个单链表
 * Author: jonny
 * Time: 2023-02-22 14:42
 */
public class LinkedListWithRecursive<E> {

    /**
     * 虚拟头结点
     */
    private Node head;
    private int size;
    public LinkedListWithRecursive() {
        head = null;
        size = 0;
    }

    public LinkedListWithRecursive(E[] array) {
        head = null;
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
        head = add(head, index, e);
        size++;
    }

    /**
     * 在以node为头结点的链表中的index位置插入元素e,
     * 并返回插入元素e后的头结点
     *
     * @param node  链表的头结点
     * @param index 插入元素的索引位置
     * @param e     待插入的元素
     * @return 插入元素后的链表头结点
     */
    private Node add(Node node, int index, E e) {
        // 递归基本问题,在以node为头结点的链表中的头部(即index = 0)插入元素e
        if (index == 0) {
            return new Node(e, node);
        }
        node.next = add(node.next, index - 1, e);
        return node;
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
        return get(head, index);
    }

    /**
     * 在以node为头结点的链表中查找index位置的元素
     *
     * @param node  头结点
     * @param index 索引位置
     * @return 指定index位置的元素
     */
    private E get(Node node, int index) {

        if (index == 0) {
            return node.data;
        }
        return get(node.next, index - 1);
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
        set(head, index, e);
    }

    /**
     * 在以node为头结点的链表中设置第index位的元素为e
     *
     * @param node  链表头结点
     * @param index 索引位置
     * @param e     要修改的元素值
     */
    private void set(Node node, int index, E e) {
        // 基本问题
        if (index == 0) {
            node.data = e;
            return;
        }
        set(node.next, index - 1, e);
    }

    public boolean contains(E e) {
        return contains(head, e);
    }

    private boolean contains(Node node, E e) {
        if (node == null) {
            return false;
        }
        if (node.data.equals(e)) {
            return true;
        }
        return contains(node.next, e);
    }

    public E remove(int index) {

        if (size == 0) {
            throw new IllegalArgumentException("can not remove from an empty linked list");
        }

        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("index illegal. must >= 0 and < size");
        }

        Pair<Node, E> pair = remove(head, index);
        size--;
        head = pair.getKey();
        return pair.getValue();
    }

    /**
     * 在以node为头结点的链表中删除索引为index位置的元素
     *
     * @param node  头结点
     * @param index 索引位置
     * @return 删除的元素
     */
    private Pair<Node, E> remove(Node node, int index) {
        // 删除头结点
        if (index == 0) {
            Node delNode = node;
            node = node.next;
            return new ImmutablePair<>(node, delNode.data);
        }

        Pair<Node, E> pair = remove(node.next, index - 1);
        node.next = pair.getKey();
        return new ImmutablePair<>(node, pair.getValue());
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
        Node curr = head;
        while (curr != null) {
            builder.append(curr).append("->");
            curr = curr.next;
        }
        builder.append("null");

        return builder.toString();
    }

    private class Node {

        E data;
        Node next;

        public Node() {
            this(null);
        }

        public Node(E data) {
            this(data, null);
        }

        public Node(E data, Node next) {
            this.data = data;
            this.next = next;
        }

        @Override
        public String toString() {
            return data == null ? null : data.toString();
        }
    }

}