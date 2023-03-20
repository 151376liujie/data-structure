package com.jonnyliu.projects.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Author: jonny
 * Time: 2020-03-19 17:59.
 */
public class BSTTest {

    private BST<Integer> tree;

    @Before
    public void init() {
        tree = new BST<>();
    }

    @Test
    public void addByNonRecursive() {

        tree.addByNonRecursive(5);
        tree.addByNonRecursive(8);
        tree.addByNonRecursive(3);
        tree.addByNonRecursive(1);
        tree.addByNonRecursive(9);
        tree.addByNonRecursive(4);
        System.out.println(tree);
    }

    @Test
    public void add() {
        tree.add(5);
        tree.add(8);
        tree.add(3);
        tree.add(1);
        tree.add(9);
        tree.add(4);

        System.out.println(tree);
    }

    @Test
    public void contains() {

        tree.add(5);
        tree.add(8);
        tree.add(3);
        tree.add(1);
        tree.add(9);
        tree.add(4);
        tree.add(7);

        System.out.println(tree);

        Assert.assertTrue(tree.contains(9));
        Assert.assertFalse(tree.contains(90));

        tree.levelOrder();
    }

    @Test
    public void preorder() {
        tree.add(5);
        tree.add(8);
        tree.add(3);
        tree.add(1);
        tree.add(9);
        tree.add(4);

        tree.preOrder();
    }

    @Test
    public void min() {
        tree.add(5);
        tree.add(8);
        tree.add(3);
        tree.add(1);
        tree.add(9);
        tree.add(4);
        tree.add(7);

        System.out.println(tree);
        System.out.println(tree.min());
        System.out.println(tree.minByNR());
    }

    @Test
    public void max() {
        tree.add(5);
        tree.add(8);
        tree.add(3);
        tree.add(1);
        tree.add(9);
        tree.add(4);
        tree.add(7);

        System.out.println(tree);
        System.out.println(tree.max());
        System.out.println(tree.maxByNR());
    }

    @Test
    public void removeMax() {

        IntStream.range(1, 10000).forEach(idx -> tree.addByNonRecursive(new Random().nextInt(10000)));

        List<Integer> list = new ArrayList<>(tree.getSize());

        for (int i = 0; i < tree.getSize(); i++) {
            list.add(tree.removeMax());
        }

        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) < list.get(i + 1)) {
                throw new IllegalArgumentException();
            }
        }

        System.out.println(Arrays.toString(list.toArray()));
    }

    @Test
    public void removeMin() {
        IntStream.range(1, 10000).forEach(idx -> tree.addByNonRecursive(new Random().nextInt(10000)));

        List<Integer> list = new ArrayList<>(tree.getSize());

        for (int i = 0; i < tree.getSize(); i++) {
            list.add(tree.removeMin());
        }

        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) > list.get(i + 1)) {
                throw new IllegalArgumentException();
            }
        }

        System.out.println(Arrays.toString(list.toArray()));

    }

    @Test
    public void removeMaxNR() {
//        IntStream.range(1, 10000).forEach(idx -> tree.addByNonRecursive(new Random().nextInt(10000)));
//
//        System.out.println("after add, size: " + tree.getSize());
//
//        List<Integer> list = new ArrayList<>(tree.getSize());
//
//        for (int i = 0; i < tree.getSize(); i++) {
//            list.add(tree.removeMaxNR());
//        }
//
//        System.out.println("after remove max, size: " + tree.getSize());
//
//        for (int i = 0; i < list.size() - 1; i++) {
//            if (list.get(i) < list.get(i + 1)) {
//                throw new IllegalArgumentException();
//            }
//        }
//
//        System.out.println(Arrays.toString(list.toArray()));

        tree = new BST<>();

        tree.add(5);
        tree.add(3);
        tree.add(9);
        System.out.println("after add node, tree: " + tree);
        Integer max = tree.removeMaxNR();
        System.out.println("after remove max, tree: " + tree);
        System.out.println(max);
        System.out.println(tree.removeMaxNR());
        System.out.println(tree);

        System.out.println(tree.removeMaxNR());
        System.out.println(tree);
    }

    @Test
    public void floor() {
        tree.add(5);
        tree.add(3);
        tree.add(9);
        tree.add(8);

        System.out.println(tree.floor(4) == 3);
    }

    @Test
    public void ceil() {

        tree.add(5);
        tree.add(3);
        tree.add(9);
        tree.add(8);

        System.out.println(tree.ceil(4) == 5);
    }


    @Test
    public void remove() {
        tree.add(5);
        tree.add(3);
        tree.add(9);
        tree.add(8);
        tree.add(17);
        tree.remove(9);

        System.out.println(tree);
    }
}