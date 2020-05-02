package com.jonnyliu.projects.tree;

import org.apache.commons.lang3.RandomUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.stream.IntStream;

/**
 * Author: jonny
 * Time: 2020-04-25 19:23.
 */
public class AVLTreeTest {

    private AVLTree<Integer, Integer> tree;

    @Before
    public void setUp() throws Exception {
        tree = new AVLTree<>();
    }

    @Test
    public void remove() {
        HashSet<Integer> set = new HashSet<>();
        IntStream.range(1, 10000).forEach(idx -> set.add(RandomUtils.nextInt(1, 10000)));
        set.forEach(element -> {
            tree.add(element, element);
            Assert.assertTrue(tree.isBalanced());
            Assert.assertTrue(tree.isBST());
        });

        set.forEach(element -> {
            tree.remove(element);
            Assert.assertTrue(tree.isBalanced());
            Assert.assertTrue(tree.isBST());
        });
    }

    @Test
    public void min() {
        IntStream.range(1, 10000).forEach(idx -> {
            tree.add(idx, idx);
            Assert.assertTrue(tree.isBalanced());
            Assert.assertTrue(tree.isBST());
            Assert.assertEquals((Integer) 1, tree.min());
        });
    }

    @Test
    public void contains() {
        IntStream.range(1, 100000).forEach(idx -> tree.add(idx, idx));
        Assert.assertTrue(tree.isBalanced());
        Assert.assertTrue(tree.isBST());
        IntStream.range(1, 100000).forEach(idx -> Assert.assertTrue(tree.contains(idx)));
    }

    @Test
    public void add() {
        IntStream.range(1, 10000).forEach(idx -> {
            tree.add(idx, idx);
            Assert.assertTrue(tree.isBalanced());
            Assert.assertTrue(tree.isBST());
        });

    }

}