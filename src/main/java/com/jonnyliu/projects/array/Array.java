package com.jonnyliu.projects.array;

import java.util.Arrays;

/**
 * Time: 2018-11-04 22:20.
 *
 * @author jonny
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
        data = (E[]) new Object[capacity];
        size = 0;
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
        return size;
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
        return data.length;
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
            data[i + 1] = data[i];
        }
        data[index] = e;
        size++;
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
        System.arraycopy(data, 0, newData, 0, getSize());
        data = newData;
    }

    /**
     * 数组中是否包含指定元素
     *
     * @param e
     * @return
     */
    public boolean contains(E e) {
        for (int i = 0; i < data.length; i++) {
            if (e.equals(data[i])) {
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
        return data[index];
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
        E ss = data[index];
        data[index] = e;
        return ss;
    }

    /**
     * 查找指定元素所在索引(第一次)
     *
     * @param e
     * @return
     */
    public int find(E e) {
        for (int i = 0; i < data.length; i++) {
            if (e.equals(data[i])) {
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
        E datum = data[index];
        for (int j = index + 1; j < getSize(); j++) {
            data[j - 1] = data[j];
        }
        size--;
        //这个操作其实也可以不做，因为用户永远不会看到index == size的位置的元素，只不过执行这个可以帮助GC
        data[size] = null;

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
                .append(", data: " + Arrays.toString(data))
                .append("}");
        return sb.toString();
    }
}
