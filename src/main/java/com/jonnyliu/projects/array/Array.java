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
        this.data = data;
        this.size = data.length;
    }

    public int getSize() {
        return this.size;
    }

    public boolean isEmpty() {
        return getSize() == 0;
    }

    public int getCapacity() {
        return this.data.length;
    }

    public void addLast(E e) {
        add(getSize(), e);
    }

    public void addFirst(E e) {
        add(0, e);
    }

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

    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity];
        System.arraycopy(this.data, 0, newData, 0, getSize());
        this.data = newData;
    }

    public boolean contains(E e) {
        for (int i = 0; i < this.data.length; i++) {
            if (e.equals(this.data[i])) {
                return true;
            }
        }
        return false;
    }

    public E get(int index) {
        if (index < 0 || index >= getSize()) {
            throw new IllegalArgumentException("index must be >= 0 and < size");
        }
        return this.data[index];
    }

    public E set(int index, E e) {
        if (index < 0 || index >= getSize()) {
            throw new IllegalArgumentException("index must be >= 0 and < size");
        }
        E ss = this.data[index];
        this.data[index] = e;
        return ss;
    }

    public int find(E e) {
        for (int i = 0; i < this.data.length; i++) {
            if (e.equals(this.data[i])) {
                return i;
            }
        }
        return -1;
    }

    public E removeFirst() {
        return remove(0);
    }

    public E removeLast() {
        return remove(getSize() - 1);
    }

    public void removeElement(E e) {
        int index = find(e);
        if (index >= 0) {
            remove(index);
        }
    }

    public E remove(int index) {
        if (index < 0 || index >= getSize()) {
            throw new IllegalArgumentException("index must be >= 0 and < size");
        }
        E datum = this.data[index];
        for (int j = index; j < getSize(); j++) {
            this.data[j] = this.data[j + 1];
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
