package com.jonnyliu.projects.tree;

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
        BinarySearchTree<Integer>.Node root = tree.getRoot();

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
        /**
         *                 3
         *                /  \
         *               2    4
         *              / \
         *             0   1
         */

        BinarySearchTree<Integer>.Node root = tree.getRoot();

        assertEquals(Integer.valueOf(3), root.getData());
        assertEquals(Integer.valueOf(2), root.getLeft().getData());
        assertEquals(Integer.valueOf(4), root.getRight().getData());
        assertNull(root.getRight().getLeft());
        assertNull(root.getRight().getRight());
        assertEquals(Integer.valueOf(0), root.getLeft().getLeft().getData());
        assertEquals(Integer.valueOf(1), root.getLeft().getLeft().getRight().getData());
    }

    @Test
    public void contains() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        assertTrue(tree.isEmpty());
        assertNull(tree.getRoot());

        tree.add(4);
        tree.add(2);

        assertTrue(tree.contains(2));
        assertFalse(tree.contains(5));
    }

    @Test
    public void preOrder() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        assertTrue(tree.isEmpty());
        assertNull(tree.getRoot());

        tree.add(4);
        tree.add(7);
        tree.add(2);
        tree.add(9);
        tree.add(3);

        /**
         *        4
         *      /   \
         *    2      7
         *     \       \
         *      3       9
         */

        assertEquals("4,2,3,7,9", tree.preOrder());
    }

    @Test
    public void inOrder() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        assertTrue(tree.isEmpty());
        assertNull(tree.getRoot());

        tree.add(4);
        tree.add(7);
        tree.add(2);
        tree.add(9);
        tree.add(3);

        /**
         *        4
         *      /   \
         *    2      7
         *     \       \
         *      3       9
         */

        assertEquals("2,3,4,7,9", tree.inOrder());
    }

    @Test
    public void postOrder() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        assertTrue(tree.isEmpty());
        assertNull(tree.getRoot());

        tree.add(4);
        tree.add(7);
        tree.add(2);
        tree.add(9);
        tree.add(3);

        /**
         *        4
         *      /   \
         *    2      7
         *     \       \
         *      3       9
         */

        assertEquals("3,2,9,7,4", tree.postOrder());
    }
}