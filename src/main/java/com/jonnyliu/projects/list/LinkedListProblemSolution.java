package com.jonnyliu.projects.list;


import java.util.Random;

/**
 * LinkedList的18个问题的算法实现
 */
public class LinkedListProblemSolution {

    private Node head;

    public static void main(String[] args) {
        LinkedListProblemSolution problemSolution = new LinkedListProblemSolution();
        problemSolution.buildSimpleList();
        System.out.println("list is " + problemSolution.head);
        System.out.println("list length: " + problemSolution.length());

        System.out.println("3 occurs in list: " + problemSolution.count(3) + " times.");

        System.out.println("position 3 is " + problemSolution.getNth(3));
        System.out.println("position 0 is " + problemSolution.getNth(0));
        try {
            System.out.println("position 5 is " + problemSolution.getNth(5));
        } catch (Exception e) {
            System.out.println("error expected. ☺");
        }
        problemSolution.deleteList();
        System.out.println("after delete list: is " + problemSolution.head);

        problemSolution.buildSimpleList();
        System.out.println("list is " + problemSolution.head);
        System.out.println("pop head node: " + problemSolution.pop() + ", after pop,list: " + problemSolution.head);

        problemSolution.deleteList();
        problemSolution.insertNth(0, 1);
        System.out.println("add 1 at index 0, list is " + problemSolution.head);
        problemSolution.insertNth(1, 2);
        System.out.println("add 2 at index 1, list is " + problemSolution.head);
        problemSolution.insertNth(2, 3);
        System.out.println("add 3 at index 2, list is " + problemSolution.head);
        problemSolution.insertNth(3, 4);
        System.out.println("add 4 at index 3, list is " + problemSolution.head);
        problemSolution.insertNth(4, 7);
        System.out.println("add 5 at index 4, list is " + problemSolution.head);

        problemSolution.deleteList();
        for (int i = 0; i < 20; i++) {
            int data = new Random().nextInt(200);
            System.out.println("add element: " + data + "  to list");
            problemSolution.sortedInsert(new Node(data));
        }
        System.out.println("after sortedInsert, list is " + problemSolution.head);

        Node cur = problemSolution.head;
        while (cur != null && cur.next != null) {
            if (cur.data > cur.next.data) {
                throw new IllegalArgumentException("sorted insert algorithm error");
            }
            cur = cur.next;
        }

    }

    /**
     * 计算链表长度
     *
     * @return 链表长度
     */
    public int length() {
        int count = 0;
        Node cur = head;
        while (cur != null) {
            count++;
            cur = cur.next;
        }
        return count;
    }

    /**
     * 查找ele在链表中出现的次数
     *
     * @param ele 待查找的元素
     * @return ele 在链表中出现的次数
     */
    public int count(int ele) {
        int count = 0;
        Node cur = head;
        while (cur != null) {
            if (cur.data == ele) {
                count++;
            }
            cur = cur.next;
        }
        return count;
    }

    /**
     * 返回指定索引的元素
     *
     * @param index 索引位置,从0开始
     * @return 指定索引的元素
     */
    public int getNth(int index) {
        if (head == null) {
            throw new IllegalArgumentException("head cannot be null");
        }
        Node cur = head;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        if (cur == null) {
            throw new IllegalArgumentException("index out of range");
        }
        return cur.data;
    }

    /**
     * 删除整个链表
     */
    public void deleteList() {
        if (head == null) {
            return;
        }
        Node next;
        while (head != null) {
            next = head.next;
            head = null;
            head = next;
        }
    }

    /**
     * 删除以head为头的链表头结点,并返回删除的节点元素
     *
     * @return 删除节点的元素
     */
    public int pop() {
        if (head == null) {
            throw new IllegalArgumentException("head cannot be null");
        }
        int data = head.data;
        head = head.next;
        return data;
    }

    /**
     * 在链表的指定位置添加元素data
     *
     * @param index 添加的位置
     * @param data  待添加的元素
     */
    public void insertNth(int index, int data) {
        if (head == null) {
            head = new Node(data);
            return;
        }
        if (index == 0) {
            head = new Node(data, head);
            return;
        }

        Node cur = head;
        for (int i = 0; i < index - 1; i++) {
            cur = cur.next;
        }
        Node newNode = new Node(data);
        newNode.next = cur.next;
        cur.next = newNode;
    }

    /**
     * 将节点添加到顺序(元素从小到大排列)链表的合适位置
     *
     * @param node 待添加的节点
     */
    public void sortedInsert(Node node) {
        // 如果链表中一个节点都没有,或者要插入的节点比头结点还小,说明要插到头结点前.
        if (head == null || head.data >= node.data) {
            node.next = head;
            head = node;
            return;
        }

        Node cur = head;
        Node prev = null;
        while (cur != null && cur.data < node.data) {
            prev = cur;
            cur = cur.next;
        }
        node.next = cur;
        prev.next = node;
    }

    private void buildSimpleList() {
        Node head = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);
        Node fourth = new Node(4, null);

        head.next = second;
        second.next = third;
        third.next = fourth;
        this.head = head;
    }

}