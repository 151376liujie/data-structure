package com.jonnyliu.projects.heap;

import com.jonnyliu.projects.array.Array;

import java.util.StringJoiner;

/**
 * 最大堆
 * 堆：① 完全二叉树
 * ② 父节点的值比左右子节点的值大
 * Author: jonny
 * Time: 2020-03-21 23:49.
 */
public class MaxHeap<E extends Comparable<E>> {

    private Array<E> data;

    public MaxHeap() {
        data = new Array<>();
    }

    public MaxHeap(int capacity) {
        data = new Array<>(capacity);
    }

    public int getSize() {
        return data.getSize();
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }

    /**
     * 向堆中添加一个元素
     *
     * @param e
     */
    public void add(E e) {
        data.addLast(e);
        shiftUp(data.getSize() - 1);
    }

    /**
     * 元素上浮
     *
     * @param index
     */
    private void shiftUp(int index) {
        while (index != 0 && data.get(parent(index)).compareTo(data.get(index)) < 0) {
            data.swap(index, parent(index));
            index = parent(index);
        }
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

    public E remove() {
        data.swap(0, data.getSize() - 1);
        E max = data.removeLast();
        shiftDown(0);
        return max;
    }


    /**
     * 元素下沉
     *
     * @param index 需要下沉的元素索引
     */
    private void shiftDown(int index) {

        while (leftChild(index) < data.getSize()) {
            //res 存放index下左右子树最大的索引位置
            int res = leftChild(index);
            if (rightChild(index) < data.getSize() && data.get(rightChild(index)).compareTo(data.get(res)) > 0) {
                res = rightChild(index);
            }
            //如果index位置的元素比最大的子节点还要大，说明已经遵守堆的性质
            if (data.get(index).compareTo(data.get(res)) > 0) {
                break;
            }
            data.swap(index, res);
            index = res;
        }
    }

    /**
     * 将最大堆中的根节点替换为e
     */
    public E replace(E e) {
        E max = findMax();
        data.set(0, e);
        shiftDown(0);
        return max;
    }

    /**
     * 将指定数组转换成最大堆
     *
     * @param arr
     */
    public void heapify(E[] arr) {
        data = new Array<>(arr);
        //最后一个非叶子节点
        int index = parent(arr.length - 1);
        for (int i = index; i >= 0; i--) {
            shiftDown(i);
        }

    }


    private int leftChild(int i) {
        return 2 * i + 1;
    }

    private int rightChild(int i) {
        return 2 * i + 2;
    }

    private int parent(int i) {
        if (i == 0) {
            throw new IllegalArgumentException("root has no parent.");
        }
        return (i - 1) / 2;
    }


    @Override
    public String toString() {
        return new StringJoiner(", ", MaxHeap.class.getSimpleName() + "[", "]")
                .add("data=" + data)
                .toString();
    }
}
