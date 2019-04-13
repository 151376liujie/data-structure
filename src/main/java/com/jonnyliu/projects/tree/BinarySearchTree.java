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
     * 获取二分搜索树的根
     *
     * @return 二分搜索树的根
     */
    public Node<E> getRoot() {
        return root;
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
            if (cur.data.compareTo(e) == 0) {
                return;
            }
            prev = cur;
            if (cur.data.compareTo(e) > 0) {
                cur = cur.left;
            } else if (cur.data.compareTo(e) < 0) {
                cur = cur.right;
            }
        }
        if (prev.data.compareTo(e) > 0) {
            prev.left = new Node<>(e);
        } else {
            prev.right = new Node<>(e);
        }
        size++;
    }

    /**
     * 该方法和 @{link add(E e)}方法功能一样,但是采用递归的方式添加元素
     *
     * @param e 指定元素
     */
    public void addRecursive(E e) {

        root = add(root, e);

    }

    /**
     * 在以指定节点为根的二分搜索树中添加元素e,并返回添加之后二分搜索树的根
     *
     * @param node 二分搜索树的根
     * @param e    指定元素
     * @return
     */
    private Node<E> add(Node<E> node, E e) {

        if (node == null) {
            size++;
            return new Node<>(e);
        }

        //二分搜索树中没有两个元素相等的语义,当二分搜索树中已经有相等的元素,则默认什么都不做
        if (node.data.compareTo(e) == 0) {
            return node;
        }

        if (node.data.compareTo(e) > 0) {
            node.left = add(node.left, e);
        } else {
            node.right = add(node.right, e);
        }

        return node;
    }

    public class Node<E> {

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

        public E getData() {
            return data;
        }

        public Node<E> getLeft() {
            return left;
        }

        public Node<E> getRight() {
            return right;
        }
    }
}
