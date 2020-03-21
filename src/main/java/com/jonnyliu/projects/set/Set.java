package com.jonnyliu.projects.set;

/**
 * Author: jonny
 * Time: 2020-03-21 15:04.
 */
public interface Set<E> {

    void add(E e);

    void remove(E e);

    boolean contains(E e);

    int getSize();

    boolean isEmpty();

}
