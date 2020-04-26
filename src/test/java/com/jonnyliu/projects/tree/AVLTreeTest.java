package com.jonnyliu.projects.tree;

import org.junit.Before;
import org.junit.Test;

import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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
        System.out.println(content.size());
    }

    @Test
    public void remove() {
    }

    @Test
    public void min() {
    }

    @Test
    public void contains() {
    }

    @Test
    public void add() {
        content.forEach(word -> tree.add(word, word));
        System.out.println("tree is balanced: " + tree.isBalanced());
        System.out.println("tree is BST: " + tree.isBST());
    }
}