package com.jonnyliu.projects.map;

/**
 * Author: jonny
 * Time: 2020-03-21 19:42.
 */
public interface Map<K, V> {

    V get(K k);

    void set(K key, V newValue);

    void add(K key, V value);

    int getSize();

    boolean isEmpty();

    boolean contains(K key);

    V remove(K key);

}
