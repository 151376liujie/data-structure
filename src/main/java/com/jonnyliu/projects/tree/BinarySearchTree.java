package com.jonnyliu.projects.tree;

import com.jonnyliu.projects.queue.LinkedListQueue;
import com.jonnyliu.projects.queue.Queue;
import com.jonnyliu.projects.stack.ArrayStack;
import com.jonnyliu.projects.stack.Stack;

import java.util.StringJoiner;

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
    private Node root;

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
    public Node getRoot() {
        return root;
    }

    /**
     * 向当前二分搜索树中添加元素e
     *
     * @param e 元素
     */
    public void add(E e) {

        if (root == null) {
            root = new Node(e);
            size++;
            return;
        }

        Node cur = root;
        Node prev = null;
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
            prev.left = new Node(e);
        } else {
            prev.right = new Node(e);
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
    private Node add(Node node, E e) {

        if (node == null) {
            size++;
            return new Node(e);
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

    /**
     * 在二分搜索树中查找是否有指定元素e
     *
     * @param e 要查找的指定元素
     * @return true 如果找到指定元素;否则返回false
     */
    public boolean contains(E e) {

        return contains(root, e);
    }

    private boolean contains(Node node, E e) {
        if (node == null) {
            return false;
        }
        if (node.data.compareTo(e) > 0) {
            return contains(node.left, e);
        } else if (node.data.compareTo(e) < 0) {
            return contains(node.right, e);
        }
        return true;
    }

    /**
     * 删除二分搜索树的最小节点
     *
     * @return 删除的节点的值
     */
    public E removeMin() {
        E min = min();
        root = removeMin(root);
        return min;
    }

    /**
     * 删除以 node 为根的二分搜索树的最小值，并返回删除后的
     * 二分搜索树的根
     *
     * @param node
     * @return
     */
    private Node removeMin(Node node) {

        //待删除的节点即为 node
        if (node.left == null) {
            //保存待删除节点的右子树
            Node right = node.right;
            node.right = null;
            size--;
            return right;
        }
        node.left = removeMin(node.left);
        return node;
    }

    /**
     * 删除二分搜索树的最小节点的非递归实现
     *
     * @return 删除后的节点
     */
    public E removeMinNonRecursive() {
        if (root == null) {
            throw new IllegalArgumentException("can not remove from an empty tree!");
        }

        // 说明 root 就是要被删除的节点
        if (root.left == null) {
            E data = root.data;
            root = root.right;
            size--;
            return data;
        }

        Node cur = root;
        Node parent = root;
        while (cur.left != null) {
            parent = cur;
            cur = cur.left;
        }

        parent.left = cur.right;
        cur.right = null;

        size--;

        return cur.data;
    }

    /**
     * 删除二分搜索树的最大节点
     *
     * @return 删除的节点的值
     */
    public E removeMax() {
        E max = max();
        root = removeMax(root);
        return max;
    }

    /**
     * 删除以 node 为根的二分搜索树的最大值，并返回删除后的
     * 二分搜索树的根
     *
     * @param node
     * @return
     */
    private Node removeMax(Node node) {

        //待删除的节点即为 node
        if (node.right == null) {
            //保存待删除节点的左子树
            Node left = node.left;
            node.left = null;
            size--;
            return left;
        }
        node.right = removeMax(node.right);
        return node;
    }

    /**
     * 删除二分搜索树的最大节点的非递归实现
     *
     * @return
     */
    public E removeMaxNonRecursive() {

        if (root == null) {
            throw new IllegalArgumentException("can not remove from an empty tree!");
        }

        // 说明 root 就是要被删除的节点
        if (root.right == null) {
            E data = root.data;
            root = root.left;
            size--;
            return data;
        }

        Node cur = root;
        Node parent = root;
        while (cur.right != null) {
            parent = cur;
            cur = cur.right;
        }

        parent.right = cur.left;
        cur.left = null;

        size--;

        return cur.data;
    }

    /**
     * 删除二分搜索树中的指定节点(非递归实现)
     *
     * @param e 待删除的节点
     */
    public void removeNonRecursive(E e) {

        if (root == null) {
            throw new IllegalArgumentException("can not remove node from an empty tree!");
        }
        Node cur = root;
        Node parent = root;
        while (cur != null && cur.data.compareTo(e) != 0) {
            parent = cur;
            if (cur.data.compareTo(e) > 0) {
                cur = cur.left;
            } else if (cur.data.compareTo(e) < 0) {
                cur = cur.right;
            }
        }

        if (cur == null) {
            throw new IllegalArgumentException(" node does not exists in tree!");
        }

        //cur即为待删除的节点
        //找到待删除节点的右节点的最小值，该值即为待删除节点的后继几点
        Node node = min(cur.right);

        if (parent.data.compareTo(node.data) > 0) {
            parent.left = node;
        } else {
            parent.right = node;
        }
        Node min = removeMin(cur.right);
        node.left = cur.left;
        node.right = cur.right;


    }

    public void remove(E e) {
        if (root == null) {
            throw new IllegalArgumentException("the tree is empty");
        }
        remove(root, e);
    }

    public void remove(Node node, E e) {
        if (node.data.compareTo(e) == 0) {

        }
    }

    public static void main(String[] args) {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        tree.add(5);
        tree.add(2);
        tree.add(8);
        tree.add(1);
        tree.add(3);
        tree.add(6);
        tree.add(10);
        tree.remove(2);
    }


    /**
     * 获取二分搜索树的最小值（非递归实现）
     *
     * @return 二分搜索树的最小值
     */
    public E minNonRecursive() {
        if (root == null) {
            throw new IllegalArgumentException("the binary search tree is empty...");
        }
        Node cur = root;
        while (cur.left != null) {
            cur = cur.left;
        }
        return cur.data;
    }

    /**
     * 获取二分搜索树的最小值（递归实现）
     *
     * @return 二分搜索树的最小值
     */
    public E min() {
        if (root == null) {
            throw new IllegalArgumentException("the binary search tree is empty...");
        }
        return min(root).data;
    }

    /**
     * 获取指定根的二分搜索树的最小节点
     *
     * @param node 二分搜索树的根
     * @return 最小节点
     */
    private Node min(Node node) {

        if (node.left == null) {
            return node;
        }
        return min(node.left);
    }

    /**
     * 获取二分搜索树的最大值（非递归实现）
     *
     * @return 二分搜索树的最大值
     */
    public E maxNonRecursive() {
        if (root == null) {
            throw new IllegalArgumentException("the binary search tree is empty...");
        }
        Node cur = root;
        while (cur.right != null) {
            cur = cur.right;
        }
        return cur.data;
    }

    /**
     * 获取二分搜索树的最大值（递归实现）
     *
     * @return
     */
    public E max() {
        if (root == null) {
            throw new IllegalArgumentException("the binary search tree is empty...");
        }
        return max(root).data;
    }

    /**
     * 获取指定根的二分搜索树的最大节点
     *
     * @param node 二分搜索树的根
     * @return 最大节点
     */
    private Node max(Node node) {

        if (node.right == null) {
            return node;
        }
        return max(node.right);
    }

    /**
     * 二分搜索树的前序遍历
     *
     * @return
     */
    public String preOrder() {
        StringJoiner joiner = new StringJoiner(",");

        preOrder(root, joiner);
        return joiner.toString();
    }

    private void preOrder(Node root, StringJoiner joiner) {
        if (root == null) {
            return;
        }
        joiner.add(root.data.toString());
        preOrder(root.left, joiner);
        preOrder(root.right, joiner);
    }

    /**
     * 非递归方法实现二分搜索树的前序遍历
     *
     * @return
     */
    public String preOrderNonRecursive() {
        StringJoiner joiner = new StringJoiner(",");
        Stack<Node> stack = new ArrayStack<>(size);
        stack.push(root);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            if (node != null) {
                joiner.add(node.data.toString());
                stack.push(node.right);
                stack.push(node.left);
            }
        }
        return joiner.toString();
    }

    /**
     * 二分搜索树的层次遍历
     *
     * @return
     */
    public String levelOrder() {
        StringJoiner joiner = new StringJoiner(",");
        Queue<Node> queue = new LinkedListQueue<>();
        queue.enqueue(root);
        while (!queue.isEmpty()) {
            Node node = queue.dequeue();
            if (node != null) {
                joiner.add(node.data.toString());
                queue.enqueue(node.left);
                queue.enqueue(node.right);
            }
        }
        return joiner.toString();
    }

    /**
     * 中序遍历二分搜索树
     *
     * @return
     */
    public String inOrder() {
        StringJoiner joiner = new StringJoiner(",");

        inOrder(root, joiner);
        return joiner.toString();
    }

    private void inOrder(Node root, StringJoiner joiner) {
        if (root == null) {
            return;
        }
        inOrder(root.left, joiner);
        joiner.add(root.data.toString());
        inOrder(root.right, joiner);
    }

    /**
     * 后序遍历二分搜索树
     *
     * @return
     */
    public String postOrder() {
        StringJoiner joiner = new StringJoiner(",");

        postOrder(root, joiner);
        return joiner.toString();
    }

    private void postOrder(Node root, StringJoiner joiner) {
        if (root == null) {
            return;
        }
        postOrder(root.left, joiner);
        postOrder(root.right, joiner);
        joiner.add(root.data.toString());
    }

    @Override
    public String toString() {
        return preOrder();
    }

    public class Node {

        private E data;

        private Node left;

        private Node right;

        public Node(E data) {
            this(data, null, null);
        }

        public Node(E data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }

        public E getData() {
            return data;
        }

        public Node getLeft() {
            return left;
        }

        public Node getRight() {
            return right;
        }
    }
}
