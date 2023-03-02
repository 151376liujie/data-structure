package com.jonnyliu.projects.list;

class Node {

    int data;
    Node next;

    public Node() {
        this(-1);
    }

    public Node(int data) {
        this(data, null);
    }

    public Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(data).append("->").append(next);
        return sb.toString();
    }
}