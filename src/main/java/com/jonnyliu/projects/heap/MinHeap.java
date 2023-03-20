package com.jonnyliu.projects.heap;

import com.jonnyliu.projects.array.Array;
import java.util.StringJoiner;

/**
 * 最小堆
 * 堆：① 完全二叉树
 * ② 父节点的值比左右子节点的值小
 * Author: jonny
 * Time: 2020-03-21 23:49.
 */
public class MinHeap<E extends Comparable<E>> {

    private Array<E> data;

    public MinHeap() {
        data = new Array<>();
    }

    public MinHeap(int capacity) {
        data = new Array<>(capacity);
    }

    public MinHeap(E[] arr) {
        this.heapify(arr);
    }

    public int getSize() {
        return data.getSize();
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }

    /**
     * 向堆中添加一个元素
     * 采取的策略是先将待添加的元素放置到数据的最后,
     * 但由于添加完元素后堆的性质可能会被破坏,
     * 所以需要不断的将待添加的元素和其父节点的元素比较,
     * 如果其父节点的元素比该节点的值小,则兑换两者的位置的元素,
     * 直到该元素=0
     *
     * @param e 待添加的元素
     */
    public void add(E e) {
        data.addLast(e);
        shiftUp(data.getSize() - 1);
    }

    /**
     * 返回堆中的根节点（最大节点）
     *
     * @return
     */
    public E findMax() {
        if (data.isEmpty()) {
            throw new IllegalArgumentException("heap is empty.");
        }
        return data.getFirst();
    }

    /**
     * 从最大堆中移除最大的元素
     *
     * @return 堆中的最大元素
     */
    public E remove() {
        data.swap(0, data.getSize() - 1);
        E max = data.removeLast();
        shiftDown(0);
        return max;
    }

    /**
     * 将最大堆中的根节点替换为e
     *
     * @param e 待替换的元素
     */
    public E replace(E e) {
        E max = findMax();
        data.set(0, e);
        shiftDown(0);
        return max;
    }

    /**
     * 元素上浮
     *
     * @param index 开始上浮的索引位置
     */
    private void shiftUp(int index) {
        while (index > 0) {
            // index索引位置的父节点所在的索引位置
            int parent = parent(index);
            // 如果index索引所在的元素 小于其父节点的元素
            if (data.get(parent).compareTo(data.get(index)) <= 0) {
                break;
            }
            // 交换index索引和其父节点索引所在的元素
            data.swap(index, parent);
            index = parent;
        }
    }

    /**
     * 元素下沉
     *
     * @param index 需要下沉的元素索引
     */
    private void shiftDown(int index) {

        while (leftChild(index) < data.getSize()) {
            //res 存放index下左右子树最小的索引位置
            int left = leftChild(index);
            int right = rightChild(index);
            int res = left;
            // 如果它有右孩子,并且它的右孩子比左孩子小
            if (right < data.getSize() && data.get(right).compareTo(data.get(res)) <= 0) {
                res = right;
            }
            //如果index位置的元素比最小的子节点还要小，说明已经遵守堆的性质
            if (data.get(index).compareTo(data.get(res)) <= 0) {
                break;
            }
            data.swap(index, res);
            index = res;
        }
    }

    /**
     * 将指定数组转换成最大堆
     *
     * @param arr 待转换的数组
     */
    private void heapify(E[] arr) {
        this.data = new Array<>(arr);
        //从最后一个非叶子节点开始，一直到索引为0的位置，挨个进行下沉操作。
        int index = parent(arr.length - 1);
        for (int i = index; i >= 0; i--) {
            shiftDown(i);
        }
    }

    /**
     * 获取指定索引的左孩子的索引
     *
     * @param i 索引位置
     * @return 左孩子的索引
     */
    private int leftChild(int i) {
        return 2 * i + 1;
    }

    /**
     * 获取指定索引的右孩子索引
     *
     * @param i 索引位置
     * @return 右孩子索引
     */
    private int rightChild(int i) {
        return 2 * i + 2;
    }

    /**
     * 获取指定索引的父节点的索引
     *
     * @param i 索引位置
     * @return 父节点的索引
     */
    private int parent(int i) {
        if (i == 0) {
            throw new IllegalArgumentException("root has no parent.");
        }
        return (i - 1) / 2;
    }


    @Override
    public String toString() {
        return new StringJoiner(", ", MinHeap.class.getSimpleName() + "[", "]")
                .add("data=" + data)
                .toString();
    }
}