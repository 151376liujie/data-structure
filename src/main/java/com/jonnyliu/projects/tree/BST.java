package com.jonnyliu.projects.tree;

import com.jonnyliu.projects.queue.ArrayQueue;
import java.util.StringJoiner;

/**
 * 二分搜索树
 * Author: jonny
 * Time: 2020-03-19 17:19.
 */
public class BST<E extends Comparable<E>> {

    private TreeNode root;
    private int size;

    public boolean isEmpty() {
        return size == 0;
    }

    public int getSize() {
        return size;
    }


    /**
     * 在二分搜索树中添加一个元素data(递归实现)
     *
     * @param data 待添加的元素
     */
    public void add(E data) {
        root = add(root, data);
    }

    /**
     * 在以node为根的二分搜索树中插入data，并返回插入后的二分搜索树的根
     *
     * @param node 二分搜索树的根节点
     * @param data 待插入的元素
     * @return 插入后二分搜索树的根节点
     */
    private TreeNode add(TreeNode node, E data) {
        //在一棵NULL树中插入元素data，则返回以data代表的根
        if (node == null) {
            size++;
            return new TreeNode(data);
        }
        //说明🌲中已经包含该元素，直接返回即可
        if (node.data.compareTo(data) == 0) {
            return node;
        }

        if (node.data.compareTo(data) > 0) {
            node.left = add(node.left, data);
        } else {
            node.right = add(node.right, data);
        }
        return node;
    }

    /**
     * 非递归实现往二分搜索树中添加一个元素
     *
     * @param data 待添加的元素
     */
    public void addByNonRecursive(E data) {

        if (root == null) {
            root = new TreeNode(data);
            size++;
            return;
        }
        TreeNode parent = root;
        TreeNode cur = root;
        while (cur != null) {

            if (cur.data.compareTo(data) == 0) {
                return;
            }

            if (cur.data.compareTo(data) > 0) {
                parent = cur;
                cur = cur.left;
            } else if (cur.data.compareTo(data) < 0) {
                parent = cur;
                cur = cur.right;
            }
        }

        if (parent.data.compareTo(data) > 0) {
            parent.left = new TreeNode(data);
        } else {
            parent.right = new TreeNode(data);
        }
        size++;
    }

    /**
     * 二分搜索树中是否包含元素data
     *
     * @param data 元素
     * @return true标识二分搜索树中包含该元素, 否则为false
     */
    public boolean contains(E data) {
        return contains(root, data);
    }

    /**
     * 在以node为根节点的二分搜索树中查找指定元素data
     *
     * @param node 二分搜索树中的根节点
     * @param data 元素
     * @return true标识包含, false标识不包含
     */
    private boolean contains(TreeNode node, E data) {
        if (node == null) {
            return false;
        }
        if (node.data.compareTo(data) == 0) {
            return true;
        } else if (node.data.compareTo(data) > 0) {
            return contains(node.left, data);
        } else {
            return contains(node.right, data);
        }
    }

    /**
     * 前序遍历
     */
    public void preOrder() {
        preOrder(root);
    }

    /**
     * 前序遍历以node为根的二分搜索树
     *
     * @param node 二分搜索树的跟节点
     */
    private void preOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.println(node.data);
        preOrder(node.left);
        preOrder(node.right);
    }

    /**
     * 中序遍历二分搜索树
     */
    public void inOrder() {
        inOrder(root);
    }

    /**
     * 中序遍历以node为根的二分搜索树
     *
     * @param node 二分搜索树的根节点
     */
    private void inOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.println(node.data);
        inOrder(node.right);
    }

    /**
     * 后序遍历二分搜索树
     */
    public void postOrder() {
        postOrder(root);
    }

    /**
     * 中序遍历以node为根节点的二分搜索树
     *
     * @param node 二分搜索树的根节点
     */
    private void postOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.data);
    }

    public void remove(E e) {
        root = remove(root, e);
    }

    private TreeNode remove(TreeNode node, E e) {
        if (node == null) {
            return null;
        }

        if (node.data.compareTo(e) > 0) {
            node.left = remove(node.left, e);
        } else if (node.data.compareTo(e) < 0) {
            node.right = remove(node.right, e);
        } else {
            //左子树为空
            if (node.left == null) {
                TreeNode right = node.right;
                node.right = null;
                size--;
                return right;
            }
            //右子树为空
            if (node.right == null) {
                TreeNode left = node.left;
                node.left = null;
                size--;
                return left;
            }
            //左右子树都不为空
            if (node.left != null && node.right != null) {
                //比node节点大的最小值
                TreeNode successor = min(node.right);
                TreeNode newRoot = removeMin(node.right);
                successor.left = node.left;
                successor.right = newRoot;
                node.left = node.right = null;
                return successor;
            }
        }
        return node;
    }

    public E floor(E data) {
        if (root == null) {
            throw new IllegalArgumentException("tree is empty");
        }
        return floor(root, data);
    }

    private E floor(TreeNode node, E data) {
        if (node == null) {
            return null;
        }
        if (node.data.compareTo(data) == 0) {
            return node.data;
        }

        if (node.data.compareTo(data) > 0) {
            return floor(node.left, data);
        }
        E tmp = floor(node.right, data);
        if (tmp != null) {
            return tmp;
        }
        return node.data;
    }

    //比指定data大的最小元素
    public E ceil(E data) {
        if (root == null) {
            throw new IllegalArgumentException("tree is empty");
        }
        return ceil(root, data);
    }

    private E ceil(TreeNode node, E data) {
        if (node == null) {
            return null;
        }
        if (node.data.compareTo(data) == 0) {
            return node.data;
        }

        if (node.data.compareTo(data) < 0) {
            return ceil(node.right, data);
        }
        E tmp = ceil(node.left, data);
        if (tmp != null) {
            return tmp;
        }
        return node.data;
    }

    public E removeMinNR() {
        if (root == null) {
            throw new IllegalArgumentException("tree is empty。");
        }
        TreeNode parent = null;
        TreeNode cur = root;
        while (cur.left != null) {
            parent = cur;
            cur = cur.left;
        }
        // 说明要删除root
        if (parent == null) {
            E min = root.data;
            root = cur.right;
            cur.right = null;
            size--;
            return min;
        }
        parent.left = cur.right;
        cur.right = null;
        size--;
        return cur.data;
    }

    public E removeMaxNR() {

        if (root == null) {
            throw new IllegalArgumentException("tree is empty。");
        }

        TreeNode parent = null;
        TreeNode cur = root;
        while (cur.right != null) {
            parent = cur;
            cur = cur.right;
        }
        // 说明要删除root
        if (parent == null) {
            E max = root.data;
            root = cur.left;
            cur.left = null;
            size--;
            return max;
        }
        parent.right = cur.left;
        cur.left = null;
        size--;
        return cur.data;
    }

    public E removeMax() {
        E e = max();
        root = removeMax(root);
        return e;
    }

    private TreeNode removeMax(TreeNode node) {
        if (node == null) {
            return null;
        }

        if (node.right == null) {
            TreeNode left = node.left;
            node.left = null;
            size--;
            return left;
        }

        node.right = removeMax(node.right);
        return node;
    }

    public E removeMin() {
        E e = min();
        root = removeMin(root);
        return e;
    }

    private TreeNode removeMin(TreeNode node) {

        if (node == null) {
            return null;
        }

        if (node.left == null) {
            TreeNode right = node.right;
            node.right = null;
            size--;
            return right;
        }

        node.left = removeMin(node.left);
        return node;
    }

    public E minByNR() {
        TreeNode cur = root;
        while (cur.left != null) {
            cur = cur.left;
        }
        return cur.data;
    }

    public E maxByNR() {
        TreeNode cur = root;
        while (cur.right != null) {
            cur = cur.right;
        }
        return cur.data;
    }

    public E max() {
        if (root == null) {
            throw new IllegalArgumentException("tree is empty。");
        }
        return max(root).data;
    }

    private TreeNode max(TreeNode node) {
        if (node.right == null) {
            return node;
        }
        return max(node.right);
    }

    public E min() {
        if (root == null) {
            throw new IllegalArgumentException("tree is empty。");
        }
        return min(root).data;
    }

    private TreeNode min(TreeNode node) {
        if (node.left == null) {
            return node;
        }
        return min(node.left);
    }

    //层序遍历
    public void levelOrder() {
        ArrayQueue<TreeNode> queue = new ArrayQueue<>(size);
        queue.enqueue(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.dequeue();
            if (node != null) {
                System.out.println(node.data);
                queue.enqueue(node.left);
                queue.enqueue(node.right);
            }
        }
    }

    private class TreeNode {

        E data;
        TreeNode left, right;

        public TreeNode(E data) {
            this.data = data;
        }

        public TreeNode(E data, TreeNode left, TreeNode right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }


        @Override
        public String toString() {
            return new StringJoiner(", ", TreeNode.class.getSimpleName() + "[", "]")
                    .add("data=" + data)
                    .add("left=" + left)
                    .add("right=" + right)
                    .toString();
        }
    }


    @Override
    public String toString() {
        return new StringJoiner(", ", BST.class.getSimpleName() + "[", "]")
                .add("root=" + root)
                .add("size=" + size)
                .toString();
    }
}