package com.jonnyliu.projects.tree;

import org.apache.commons.lang3.RandomUtils;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Author: jonny
 * Time: 2019-04-13 11:09.
 */
public class BinarySearchTreeTest {

    @Test
    public void getSize() {

        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        assertEquals(0, tree.getSize());

        tree.add(2);
        assertEquals(1, tree.getSize());
    }

    @Test
    public void isEmpty() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        assertTrue(tree.isEmpty());

        tree.add(2);
        assertFalse(tree.isEmpty());
    }

    @Test
    public void add() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        assertTrue(tree.isEmpty());
        assertNull(tree.getRoot());

        int[] arr = new int[]{3, 2, 4, 0, 1};
        int count = 0;
        for (int i : arr) {
            tree.add(i);
            count++;
            assertEquals(count, tree.getSize());
        }
        BinarySearchTree<Integer>.Node<Integer> root = tree.getRoot();

        assertEquals(Integer.valueOf(3), root.getData());
        assertEquals(Integer.valueOf(2), root.getLeft().getData());
        assertEquals(Integer.valueOf(4), root.getRight().getData());
        assertNull(root.getRight().getLeft());
        assertNull(root.getRight().getRight());
        assertEquals(Integer.valueOf(0), root.getLeft().getLeft().getData());
        assertEquals(Integer.valueOf(1), root.getLeft().getLeft().getRight().getData());

    }

    @Test
    public void addRecursive() {
    }

    public static void main(String[] args) {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        for (int i = 0; i < 5; i++) {
            tree.add(RandomUtils.nextInt(10, 50));

        }
        System.out.println(tree);
    }

}