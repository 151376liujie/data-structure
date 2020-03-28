package com.jonnyliu.projects.tree;

import org.junit.Before;
import org.junit.Test;

/**
 * Author: jonny
 * Time: 2020-03-26 22:17.
 */
public class SegmentTreeTest {

    private SegmentTree<Integer> segmentTree;

    @Before
    public void setUp() throws Exception {
        segmentTree = new SegmentTree<>(new Integer[]{1, 2, 3, 4, 5, 6}, Integer::sum);
        System.out.println(segmentTree);
    }


    @Test
    public void setSegmentTree() {
        System.out.println(segmentTree.getSize());
    }


    @Test
    public void query() {

        System.out.println(segmentTree.query(1, 4));

    }

    @Test
    public void update() {
        segmentTree.update(0, 0);
        System.out.println(segmentTree);
    }
}