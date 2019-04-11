package com.jonnyliu.projects.tree;

/**
 * Project Name: data-structure
 * Package Name: com.jonnyliu.projects.tree
 * Author:       fanpu
 * Date:         2019-04-11 09:32
 * Description:  二分搜索树
 * Revision history: 1、fanpu created at 2019-04-11
 */
public class BinarySearchTree<E extends Comparable<E>> {

    /**
     * 二分搜索树的根节点
     */
    private Node<E> root;

    /**
     * 二分搜索树中节点个数
     */
    private int size;

    public BinarySearchTree() {
        root = null;
        size = 0;
    }

    /**
     * 获取二分搜索树中节点的个数
     *
     * @return 二分搜索树中节点的个数
     */
    public int getSize() {
        return size;
    }

    /**
     * 是否为空的二分搜索树
     *
     * @return true : 空二分搜索树
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 向当前二分搜索树中添加元素e
     *
     * @param e 元素
     */
    public void add(E e) {

        if (root == null) {
            root = new Node<>(e);
            size++;
            return;
        }

        Node<E> cur = root;
        Node<E> prev = null;
        while (cur != null) {
            if (cur.data.compareTo(e) > 0) {
                prev = cur;
                cur = cur.left;
            } else if (cur.data.compareTo(e) < 0) {
                prev = cur;
                cur = cur.right;
            }
        }
        if (prev.data.compareTo(e) > 0) {
            size++;
            prev.left = new Node<>(e);
        } else {
            size++;
            prev.right = new Node<>(e);
        }


    }

    private class Node<E> {

        private E data;

        private Node<E> left;

        private Node<E> right;

        public Node(E data) {
            this(data, null, null);
        }

        public Node(E data, Node<E> left, Node<E> right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }
}
