package com.jonnyliu.projects.array;

import java.util.Arrays;

/**
 * Author: jonny
 * Time: 2018-11-04 22:20.
 */
public class Array<E> {

    /**
     * 默认容量
     */
    private static final int DEFAULT_CAPACITY = 10;

    private E[] data;
    /**
     * 数组中实际存放元素的个数
     */
    private int size;

    public Array(int capacity) {
        this.data = (E[]) new Object[capacity];
        this.size = 0;
    }

    public Array() {
        this(DEFAULT_CAPACITY);
    }

    public Array(E[] data) {
        for (E datum : data) {
            addLast(datum);
        }
    }

    /**
     * 返回实际元素个数
     *
     * @return
     */
    public int getSize() {
        return this.size;
    }

    /**
     * 判断数组是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return getSize() == 0;
    }

    /**
     * 返回数组最大容量
     *
     * @return
     */
    public int getCapacity() {
        return this.data.length;
    }

    /**
     * 在数组最后添加元素
     *
     * @param e
     */
    public void addLast(E e) {
        add(getSize(), e);
    }

    /**
     * 在数组开头添加元素
     *
     * @param e
     */
    public void addFirst(E e) {
        add(0, e);
    }

    /**
     * 在指定索引位置添加元素
     *
     * @param index
     * @param e
     */
    public void add(int index, E e) {
        if (index > getSize() || index < 0) {
            throw new IllegalArgumentException("invalid index: " + index + " ,index must be greater than 0 and less than size");
        }
        //需要扩容
        if (getSize() >= getCapacity()) {
            resize(getCapacity() * 2);
        }
        for (int i = getSize() - 1; i >= index; i--) {
            this.data[i + 1] = this.data[i];
        }
        this.data[index] = e;
        this.size++;
    }

    /**
     * 数组扩容或缩容
     *
     * @param newCapacity 新的数组容量
     */
    private void resize(int newCapacity) {
        //如果需要设置的新容量小于数组默认容量，则不进行扩容
        if (newCapacity < DEFAULT_CAPACITY) {
            return;
        }
        E[] newData = (E[]) new Object[newCapacity];
        System.arraycopy(this.data, 0, newData, 0, getSize());
        this.data = newData;
    }

    /**
     * 数组中是否包含指定元素
     *
     * @param e
     * @return
     */
    public boolean contains(E e) {
        for (int i = 0; i < this.data.length; i++) {
            if (e.equals(this.data[i])) {
                return true;
            }
        }
        return false;
    }

    /**
     * 获取指定索引位置上的元素
     *
     * @param index
     * @return
     */
    public E get(int index) {
        if (index < 0 || index >= getSize()) {
            throw new IllegalArgumentException("index must be >= 0 and < size");
        }
        return this.data[index];
    }

    /**
     * 获取开头位置元素
     *
     * @return
     */
    public E getFirst() {
        return get(0);
    }

    /**
     * 获取最后位置元素
     *
     * @return
     */
    public E getLast() {
        return get(size - 1);
    }

    /**
     * 在指定索引位置上设置元素
     *
     * @param index
     * @param e
     * @return
     */
    public E set(int index, E e) {
        if (index < 0 || index >= getSize()) {
            throw new IllegalArgumentException("index must be >= 0 and < size");
        }
        E ss = this.data[index];
        this.data[index] = e;
        return ss;
    }

    /**
     * 查找指定元素所在索引(第一次)
     *
     * @param e
     * @return
     */
    public int find(E e) {
        for (int i = 0; i < this.data.length; i++) {
            if (e.equals(this.data[i])) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 删除开头位置元素
     *
     * @return
     */
    public E removeFirst() {
        return remove(0);
    }

    /**
     * 删除最后位置元素
     *
     * @return
     */
    public E removeLast() {
        return remove(getSize() - 1);
    }

    /**
     * 删除指定元素
     *
     * @param e
     */
    public void removeElement(E e) {
        int index = find(e);
        if (index >= 0) {
            remove(index);
        }
    }

    /**
     * 删除指定索引位置的元素
     *
     * @param index
     */
    public E remove(int index) {
        if (index < 0 || index >= getSize()) {
            throw new IllegalArgumentException("index must be >= 0 and < size");
        }
        E datum = this.data[index];
        for (int j = index + 1; j < getSize(); j++) {
            this.data[j - 1] = this.data[j];
        }
        this.size--;
        this.data[this.size] = null;

        //缩容
        if (getSize() <= getCapacity() / 4 && getCapacity() / 2 != 0) {
            resize(getCapacity() / 2);
        }
        return datum;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("Array")
                .append("{")
                .append("capacity : " + getCapacity())
                .append(", size: " + getSize())
                .append(", data: " + Arrays.toString(this.data))
                .append("}");
        return sb.toString();
    }

    public static void main(String[] args) {
        Array<Integer> array = new Array<>();
        for (int i = 0; i < 11; i++) {
            array.addLast(i);
        }
        System.out.println(array);
        array.add(2, 99);
        System.out.println(array);

        array.remove(2);
        System.out.println(array);
        array.remove(0);
        System.out.println(array);

        array.removeFirst();
        System.out.println(array);
    }
}
