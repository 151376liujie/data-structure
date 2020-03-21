package com.jonnyliu.projects.map;


import java.util.StringJoiner;

/**
 * Author: jonny
 * Time: 2020-03-21 19:44.
 */
public class LinkedListMap<K, V> implements Map<K, V> {


    private Node dummyHead;

    private int size;

    public LinkedListMap() {
        dummyHead = new Node(null, null);
        size = 0;
    }

    private class Node {
        K key;
        V value;
        Node next;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public Node(K key, V value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }


        @Override
        public String toString() {
            return new StringJoiner(", ", Node.class.getSimpleName() + "[", "]")
                    .add("key=" + key)
                    .add("value=" + value)
                    .add("next=" + next)
                    .toString();
        }
    }

    private Node getNode(K key) {
        Node cur = dummyHead.next;
        while (cur != null) {
            if (cur.key.equals(key)) {
                return cur;
            }
            cur = cur.next;
        }
        return cur;
    }

    @Override
    public V get(K k) {
        Node node = getNode(k);
        return node == null ? null : node.value;
    }

    @Override
    public void set(K k, V v) {
        Node node = getNode(k);
        if (node == null) {
            throw new IllegalArgumentException(k + " does not exists!");
        } else {
            node.value = v;
        }
    }

    @Override
    public void add(K key, V value) {
        Node node = getNode(key);
        if (node == null) {
            dummyHead.next = new Node(key, value, dummyHead.next);
            size++;
        } else {
            node.value = value;
        }
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(K k) {
        return getNode(k) != null;
    }

    @Override
    public V remove(K k) {

        Node prev = dummyHead;
        while (prev.next != null) {
            if (prev.next.value.equals(k)) {
                break;
            }
            prev = prev.next;
        }
        if (prev.next != null) {
            Node delNode = prev.next;
            prev.next = delNode.next;
            delNode.next = null;
            size--;
            return delNode.value;
        }
        return null;
    }
}
