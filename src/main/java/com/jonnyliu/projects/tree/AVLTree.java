package com.jonnyliu.projects.tree;

import java.util.ArrayList;
import java.util.LinkedList;
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

    public void remove(K key) {
        root = remove(root, key);
    }

    private TreeNode remove(TreeNode node, K key) {
        if (node == null) {
            return null;
        }
        TreeNode retNode = null;
        if (node.key.compareTo(key) > 0) {
            node.left = remove(node.left, key);
            retNode = node;
        } else if (node.key.compareTo(key) < 0) {
            node.right = remove(node.right, key);
            retNode = node;
        } else {
            //左子树为空
            if (node.left == null) {
                TreeNode right = node.right;
                node.right = null;
                size--;
                retNode = right;
            }
            //右子树为空
            else if (node.right == null) {
                TreeNode left = node.left;
                node.left = null;
                size--;
                retNode = left;
            }
            //左右子树都不为空
            else {
                //比node节点大的最小值
                TreeNode successor = min(node.right);
                successor.right = remove(node.right, successor.key);
                successor.left = node.left;

                node.left = node.right = null;
                retNode = successor;
            }
        }

        retNode = maintainTreeNodeBalance(retNode);
        return retNode;
    }

    V min() {
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
     * @param node  根节点
     * @param key   key
     * @param value value
     * @return 插入节点后的根节点
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

        node = maintainTreeNodeBalance(node);
        return node;
    }

    /**
     * 插入/删除节点后维护节点的平衡性
     *
     * @param node 节点
     * @return
     */
    private TreeNode maintainTreeNodeBalance(TreeNode node) {

        if (node == null) {
            return null;
        }

        //因为不管插入了左子树还是右子树，插入后node节点本身的高度值可能会发生变化，所以需要重新计算node当前节点的高度
        node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));
        //计算平衡因子
        int balanceFactor = getBalanceFactor(node);
        //不需要维护平衡
        if (Math.abs(balanceFactor) <= 1) {
            return node;
        }

        //平衡状态被打破，且新加节点在左子树的左边中添加（LL）
        if (balanceFactor > 1 && getBalanceFactor(node.left) >= 0) {
            return rightRotate(node);
        }
        //平衡状态被打破，且新加节点在左子树的左边中添加（LR）
        if (balanceFactor > 1 && getBalanceFactor(node.left) < 0) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        //平衡状态被打破，且新加节点在右子树的右边中添加（RR）
        if (balanceFactor < -1 && getBalanceFactor(node.right) < 0) {
            return leftRotate(node);
        }

        //平衡状态被打破，且新加节点在右子树的左边中添加（RL）
        if (balanceFactor < -1 && getBalanceFactor(node.right) > 0) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }
        return node;
    }

    /**
     * 对节点y进行左旋转操作，并返回旋转后新的新节点x
     * <pre>
     *   y                                        x
     *  /  \                                    /  \
     * T4   x            向左旋转(y)            y    z
     *     / \     ------------------->      / \   / \
     *    T3  z                            T4  T3 T1  T2
     *       / \
     *      T1  T2
     * </pre>
     *
     * @param y
     * @return
     */
    private TreeNode leftRotate(TreeNode y) {
        TreeNode x = y.right;
        TreeNode T3 = x.left;
        x.left = y;
        y.right = T3;
        //更新节点的height值,只需要更新x,y节点的值。而且先更新y的值，再更新x的值
        y.height = Math.max(getHeight(y.left), getHeight(y.right)) + 1;
        x.height = Math.max(getHeight(x.left), getHeight(x.right)) + 1;
        return x;
    }

    /**
     * 对节点y进行右旋转操作，并返回旋转后新的新节点x
     * <pre>
     *        y                                       x
     *      /  \                                    /  \
     *     x    T4           向右旋转(y)            z     y
     *    / \          ------------------->      / \   / \
     *   z   T3                                T1  T2 T3  T4
     *  / \
     * T1  T2
     * </pre>
     *
     * @param y
     * @return
     */
    private TreeNode rightRotate(TreeNode y) {

        TreeNode x = y.left;
        TreeNode T3 = x.right;

        x.right = y;
        y.left = T3;

        //更新节点的height值,只需要更新x,y节点的值。而且先更新y的值，再更新x的值
        y.height = Math.max(getHeight(y.left), getHeight(y.right)) + 1;
        x.height = Math.max(getHeight(x.left), getHeight(x.right)) + 1;
        return x;
    }

    /**
     * 校验🌲是否符合二分搜索树的特性
     * 利用二分搜索树中序遍历的有序性来验证
     *
     * @return
     */
    boolean isBST() {
        List<K> keys = inOrder();
        for (int i = 0; i < keys.size() - 1; i++) {
            if (keys.get(i).compareTo(keys.get(i + 1)) > 0) {
                return false;
            }
        }
        return true;
    }

    boolean isBalanced() {
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
        return getHeight(node.left) - getHeight(node.right);
    }

    private List<K> inOrder() {
        //非递归实现
        List<K> res = new ArrayList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            res.add(cur.key);
            cur = cur.right;
        }
        return res;
    }

    /**
     * 中序遍历，递归实现
     *
     * @param node
     * @param keys
     */
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

        TreeNode(K key, V value) {
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
