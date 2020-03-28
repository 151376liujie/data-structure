package com.jonnyliu.projects.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

/**
 * AVL平衡🌲
 * Author: jonny
 * Time: 2020-03-19 17:19.
 */
public class AVLTree<K extends Comparable<K>, V> {

    private TreeNode root;
    private int size;

    public boolean isEmpty() {
        return size == 0;
    }

    public int getSize() {
        return size;
    }

    private int getHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return node.height;
    }

    /**
     * 计算指定节点的平衡因子
     *
     * @param node
     * @return
     */
    private int getBalanceFactor(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return Math.abs(getHeight(node.left) - getHeight(node.right));
    }

    public void remove(K key) {
        root = remove(root, key);
    }

    private TreeNode remove(TreeNode node, K key) {
        if (node == null) {
            return null;
        }

        if (node.key.compareTo(key) > 0) {
            node.left = remove(node.left, key);
        } else if (node.key.compareTo(key) < 0) {
            node.right = remove(node.right, key);
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

    public V removeMax() {
        V e = max();
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

    public V removeMin() {
        V e = min();
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

    public V max() {
        if (root == null) {
            throw new IllegalArgumentException("tree is empty。");
        }
        return max(root).value;
    }

    private TreeNode max(TreeNode node) {
        if (node.right == null) {
            return node;
        }
        return max(node.right);
    }

    public V min() {
        if (root == null) {
            throw new IllegalArgumentException("tree is empty。");
        }
        return min(root).value;
    }

    private TreeNode min(TreeNode node) {
        if (node.left == null) {
            return node;
        }
        return min(node.left);
    }

    public boolean contains(K key) {
        return contains(root, key);
    }

    private boolean contains(TreeNode node, K key) {
        if (node == null) {
            return false;
        }
        if (node.key.compareTo(key) == 0) {
            return true;
        } else if (node.key.compareTo(key) > 0) {
            return contains(node.left, key);
        } else {
            return contains(node.right, key);
        }
    }

    public void add(K key, V value) {
        root = add(root, key, value);
    }

    /**
     * 在以node为根的二分搜索树中插入data，并返回插入后的二分搜索树的根
     *
     * @param node
     * @param data
     * @return
     */
    private TreeNode add(TreeNode node, K key, V value) {
        //在一棵NULL树中插入元素data，则返回以data代表的根
        if (node == null) {
            size++;
            return new TreeNode(key, value);
        }
        //说明🌲中已经包含该元素，直接返回即可
        if (node.key.compareTo(key) == 0) {
            return node;
        }

        if (node.key.compareTo(key) > 0) {
            node.left = add(node.left, key, value);
        } else {
            node.right = add(node.right, key, value);
        }

        //因为不管插入了左子树还是右子树，插入后node节点本身的高度值可能会发生变化，所以需要重新计算node当前节点的高度
        node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));
        //计算平衡因子
        int balanceFactor = getBalanceFactor(node);
        //平衡状态被打破，
        if (balanceFactor > 1) {
            System.out.println("unbalanced : " + balanceFactor);
        }

        return node;
    }

    /**
     * 校验🌲是否符合二分搜索树的特性
     * 利用二分搜索树中序遍历的有序性来验证
     *
     * @return
     */
    public boolean isBST() {
        List<K> keys = inOrder();
        for (int i = 0; i < keys.size() - 1; i++) {
            if (keys.get(i).compareTo(keys.get(i + 1)) > 0) {
                return false;
            }
        }
        return true;
    }

    public boolean isBalanced() {
        if (root == null) {
            return true;
        }
        return isBalanced(root);
    }

    private boolean isBalanced(TreeNode node) {

        if (node == null) {
            return true;
        }

        int balanceFactor = getBalanceFactor(node);
        if (balanceFactor > 1) {
            return false;
        }

        return isBalanced(node.left) && isBalanced(node.right);
    }

    private List<K> inOrder() {
        ArrayList<K> keys = new ArrayList<>();
        inOrder(root, keys);
        return keys;
    }

    private void inOrder(TreeNode node, List<K> keys) {
        if (node == null) {
            return;
        }
        inOrder(root.left, keys);
        keys.add(node.key);
        inOrder(root.right, keys);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", AVLTree.class.getSimpleName() + "[", "]")
                .add("root=" + root)
                .add("size=" + size)
                .toString();
    }

    private class TreeNode {

        K key;
        V value;
        TreeNode left, right;
        //该节点的高度
        int height;

        public TreeNode(K key, V value) {
            this.key = key;
            this.value = value;
            height = 1;
        }

        @Override
        public String toString() {
            return new StringJoiner(", ", TreeNode.class.getSimpleName() + "[", "]")
                    .add("key=" + key)
                    .add("value=" + value)
                    .add("left=" + left)
                    .add("right=" + right)
                    .add("height=" + height)
                    .toString();
        }
    }
}
