package com.jonnyliu.projects.tree;

/**
 * Author: jonny
 * Time: 2020-03-26 22:07.
 */
@FunctionalInterface
public interface Merger<E> {


    E merge(E a, E b);

}
