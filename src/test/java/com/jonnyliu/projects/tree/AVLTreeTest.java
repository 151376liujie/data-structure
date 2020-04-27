package com.jonnyliu.projects.tree;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Author: jonny
 * Time: 2020-04-25 19:23.
 */
public class AVLTreeTest {

    private AVLTree<String, String> tree;
    private List<String> content;

    @Before
    public void setUp() throws Exception {
        tree = new AVLTree<>();
        URL url = tree.getClass().getClassLoader().getResource("Pride_and_Prejudice.txt");
        assert url != null;
        List<String> lines = Files.readAllLines(Paths.get(url.toURI()));
        content = lines.stream().flatMap(line -> Arrays.stream(line.split("\\s+"))).collect(Collectors.toList());
        System.out.println("pride and prejudice words size: " + content.size());
    }

    @Test
    public void remove() {
    }

    @Test
    public void min() {
    }

    @Test
    public void contains() {
        AVLTree<Integer, Integer> avlTree = new AVLTree<>();
        IntStream.range(1, 10000000).forEach(idx -> avlTree.add(idx, idx));
        System.out.println("tree node size: " + avlTree.getSize());
        System.out.println("tree is balanced: " + avlTree.isBalanced());
        System.out.println("tree is BST: " + avlTree.isBST());
        IntStream.range(1, 10000000).forEach(idx -> Assert.assertTrue(avlTree.contains(idx)));
    }

    @Test
    public void add() {
        content.forEach(word -> tree.add(word, word));
        System.out.println("tree node size: " + tree.getSize());
        System.out.println("tree is balanced: " + tree.isBalanced());
        System.out.println("tree is BST: " + tree.isBST());
    }

    @Test
    public void add2() {
        AVLTree<Integer, Integer> avlTree = new AVLTree<>();
        IntStream.range(1, 10000000).forEach(idx -> avlTree.add(idx, idx));
        System.out.println("tree node size: " + avlTree.getSize());
        System.out.println("tree is balanced: " + avlTree.isBalanced());
        System.out.println("tree is BST: " + avlTree.isBST());
    }
}