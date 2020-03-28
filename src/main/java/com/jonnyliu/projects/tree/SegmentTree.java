package com.jonnyliu.projects.tree;

/**
 * 线段🌲
 * Time: 2020-03-26 20:48.
 *
 * @author jonny
 */
public class SegmentTree<E> {

    /**
     * 对左右子节点结果的合并器
     */
    private Merger<E> merger;
    /**
     * 原始数据
     */
    private E[] data;
    /**
     * 线段树数据，数据都在叶子节点，非叶子节点存放索引
     */
    private E[] tree;

    public SegmentTree(E[] data, Merger<E> merger) {
        this.data = (E[]) new Object[data.length];
        System.arraycopy(data, 0, this.data, 0, data.length);
        tree = (E[]) new Object[4 * data.length];
        this.merger = merger;
        build(0, 0, data.length - 1);
    }

    /**
     * 在treeIndex位置处创建表示区间[l...r]的线段树
     *
     * @param treeIndex
     * @param left
     * @param right
     */
    private void build(int treeIndex, int left, int right) {

        if (left == right) {
            tree[treeIndex] = data[left];
            return;
        }
        int mid = left + (right - left) / 2;
        int leftChild = leftChild(treeIndex);
        int rightChild = rightChild(treeIndex);

        build(leftChild, left, mid);
        build(rightChild, mid + 1, right);
        tree[treeIndex] = merger.merge(tree[leftChild], tree[rightChild]);
    }

    /**
     * 在线段树中查询[queryLeft,queryRight]区间内的数据
     *
     * @param queryLeft
     * @param queryRight
     * @return
     */
    public E query(int queryLeft, int queryRight) {

        if (queryLeft < 0 || queryLeft >= data.length || queryRight < 0 || queryRight >= data.length || queryLeft > queryRight) {
            throw new IllegalArgumentException("query left and query right is not illegal.");
        }

        return query(0, 0, data.length - 1, queryLeft, queryRight);

    }

    /**
     * 在以treeIndex位置为根，在[left,right]区间范围内查找在范围[queryLeft，queryRight]内的数据
     *
     * @param treeIndex
     * @param left
     * @param right
     * @param queryLeft
     * @param queryRight
     * @return
     */
    private E query(int treeIndex, int left, int right, int queryLeft, int queryRight) {

        if (left == queryLeft && right == queryRight) {
            return tree[treeIndex];
        }
        int leftChild = leftChild(treeIndex);
        int rightChild = rightChild(treeIndex);
        int mid = left + (right - left) / 2;
        //查询的右边界比mid还小，说明查询范围完全在左子树中，只需要在左子树中查找即可
        if (queryRight <= mid) {
            return query(leftChild, left, mid, queryLeft, queryRight);
        } else if (queryLeft >= mid + 1) {
            //查询的左边界比mid + 1还大，说明查询范围完全在右子树中，只需要在右子树中查找即可
            return query(rightChild, mid + 1, right, queryLeft, queryRight);
        }
        //查询的范围在左右子树中都有
        E leftResult = query(leftChild, left, mid, queryLeft, mid);
        E rightResult = query(rightChild, mid + 1, right, mid + 1, queryRight);
        return merger.merge(leftResult, rightResult);
    }

    /**
     * 更新指定index位置的数据为e
     *
     * @param index
     * @param e
     */
    public void update(int index, E e) {
        if (index < 0 || index >= data.length) {
            throw new IllegalArgumentException("index is illegal.");
        }

        data[index] = e;
        update(0, 0, data.length - 1, index, e);
    }

    /**
     * 在以treeIndex为根，在区间[left,right]区间内更新index位置上的数据
     *
     * @param treeIndex
     * @param left
     * @param right
     * @param index
     * @param e
     */
    private void update(int treeIndex, int left, int right, int index, E e) {

        //相当于left == right == index
        if (index == left && left == right) {
            tree[treeIndex] = e;
            return;
        }
        int leftChild = leftChild(treeIndex);
        int rightChild = rightChild(treeIndex);
        int mid = left + (right - left) / 2;

        //说明跟右子树没关系，需要在左子树中更新值
        if (index <= mid) {
            update(leftChild, left, mid, index, e);
        } else {
            update(rightChild, mid + 1, right, index, e);
        }
        //改变任何一个子节点的数据后，需要重新更新（合并）父节点的值
        tree[treeIndex] = merger.merge(tree[leftChild], tree[rightChild]);
    }

    public int getSize() {
        return data.length;
    }

    public E get(int index) {
        if (index < 0 || index >= data.length) {
            throw new IllegalArgumentException("index is illegal.");
        }
        return data[index];
    }

    private int leftChild(int index) {
        return 2 * index + 1;
    }

    private int rightChild(int index) {
        return 2 * index + 2;
    }


    @Override
    public String toString() {

        StringBuilder builder = new StringBuilder();
        builder.append("segment tree [");
        for (int i = 0; i < tree.length; i++) {
            builder.append(tree[i] == null ? "NULL" : tree[i]);
            if (i != tree.length - 1) {
                builder.append(", ");
            }
        }
        builder.append("], size = ").append(tree.length);

        return builder.toString();
    }
}
