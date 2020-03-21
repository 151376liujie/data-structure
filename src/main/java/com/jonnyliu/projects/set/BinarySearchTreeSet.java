package com.jonnyliu.projects.set;

import com.jonnyliu.projects.tree.BST;

/**
 * Author: jonny
 * Time: 2020-03-21 15:05.
 */
public class BinarySearchTreeSet<E extends Comparable<E>> implements Set<E> {

    private BST<E> tree;

    public BinarySearchTreeSet() {
        tree = new BST<>();
    }

    @Override
    public void add(E e) {
        tree.add(e);
    }

    @Override
    public void remove(E e) {
        tree.remove(e);
    }

    @Override
    public boolean contains(E e) {
        return tree.contains(e);
    }

    @Override
    public int getSize() {
        return tree.getSize();
    }

    @Override
    public boolean isEmpty() {
        return tree.isEmpty();
    }
}
