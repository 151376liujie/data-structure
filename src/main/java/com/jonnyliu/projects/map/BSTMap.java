package com.jonnyliu.projects.map;

import java.util.StringJoiner;

/**
 * Author: jonny
 * Time: 2020-03-21 20:15.
 */
public class BSTMap<K extends Comparable<K>, V> implements Map<K, V> {

    private Node root;

    private int size;

    private class Node {
        K key;
        V value;
        Node left, right;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }


        @Override
        public String toString() {
            return new StringJoiner(", ", Node.class.getSimpleName() + "[", "]")
                    .add("key=" + key)
                    .add("value=" + value)
                    .add("left=" + left)
                    .add("right=" + right)
                    .toString();
        }
    }

    @Override
    public V get(K k) {
        if (root == null) {
            throw new IllegalArgumentException("tree is empty.");
        }
        Node node = getNode(root, k);
        return node == null ? null : node.value;
    }

    @Override
    public void set(K k, V v) {
        Node node = getNode(root, k);
        if (node == null) {
            throw new IllegalArgumentException(k + " does not exists.");
        }
        node.value = v;
    }

    @Override
    public void add(K key, V value) {
        root = add(root, key, value);
    }

    private Node add(Node node, K key, V value) {
        if (node == null) {
            size++;
            return new Node(key, value);
        }
        if (node.key.compareTo(key) > 0) {
            node.left = add(node.left, key, value);
        } else if (node.key.compareTo(key) < 0) {
            node.right = add(node.right, key, value);
        } else {
            node.value = value;
        }
        return node;
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
        return getNode(root, k) != null;
    }

    @Override
    public V remove(K k) {
        Node node = getNode(root, k);
        if (node == null) {
            throw new IllegalArgumentException(k + " does not exists.");
        }
        root = remove(node, k);
        return node.value;
    }

    private Node remove(Node node, K e) {
        if (node == null) {
            return null;
        }

        if (node.key.compareTo(e) > 0) {
            node.left = remove(node.left, e);
        } else if (node.key.compareTo(e) < 0) {
            node.right = remove(node.right, e);
        } else {
            //左子树为空
            if (node.left == null) {
                Node right = node.right;
                node.right = null;
                size--;
                return right;
            }
            //右子树为空
            if (node.right == null) {
                Node left = node.left;
                node.left = null;
                size--;
                return left;
            }
            //左右子树都不为空
            if (node.left != null && node.right != null) {
                //比node节点大的最小值
                Node successor = min(node.right);
                Node newRoot = removeMin(node.right);
                successor.left = node.left;
                successor.right = newRoot;
                node.left = node.right = null;
                return successor;
            }
        }
        return node;
    }

    private Node min(Node node) {
        if (node.left == null) {
            return node;
        }
        return min(node.left);
    }

    private Node removeMin(Node node) {

        if (node == null) {
            return null;
        }

        if (node.left == null) {
            Node right = node.right;
            node.right = null;
            size--;
            return right;
        }

        node.left = removeMin(node.left);
        return node;
    }

    private Node getNode(Node node, K key) {
        Node cur = node;
        while (cur != null) {
            if (cur.key.compareTo(key) > 0) {
                cur = cur.left;
            } else if (cur.key.compareTo(key) < 0) {
                cur = cur.right;
            } else {
                break;
            }
        }
        return cur;
    }


    @Override
    public String toString() {
        return new StringJoiner(", ", BSTMap.class.getSimpleName() + "[", "]")
                .add("root=" + root)
                .add("size=" + size)
                .toString();
    }
}
