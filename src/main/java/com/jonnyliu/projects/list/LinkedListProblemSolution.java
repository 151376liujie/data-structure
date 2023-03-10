package com.jonnyliu.projects.list;


import java.util.Arrays;
import java.util.List;
import java.util.Random;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.ImmutableTriple;
import org.apache.commons.lang3.tuple.Pair;
import org.apache.commons.lang3.tuple.Triple;

/**
 * LinkedList的18个问题的算法实现
 */
public class LinkedListProblemSolution {


    public static void main(String[] args) {
        LinkedListProblemSolution problemSolution = new LinkedListProblemSolution();
        List<Integer> list = Arrays.asList(1, 2, 3, 4);
        Node head = problemSolution.buildSimpleList(list);
        System.out.println("list is " + head);
        System.out.println("list length: " + problemSolution.length(head));
        System.out.println("================================================================");
        System.out.println("3 occurs in list: " + problemSolution.count(head, 3) + " times.");
        System.out.println("================================================================");

        System.out.println("position 3 is " + problemSolution.getNth(head, 3));
        System.out.println("position 0 is " + problemSolution.getNth(head, 0));
        System.out.println("================================================================");
        try {
            System.out.println("position 5 is " + problemSolution.getNth(head, 5));
        } catch (Exception e) {
            System.out.println("error expected. ☺");
        }
        System.out.println("================================================================");
        head = problemSolution.deleteList(head);
        System.out.println("after delete list: is " + head);
        System.out.println("================================================================");

        head = problemSolution.buildSimpleList(list);
        System.out.println("list is " + head);
        System.out.println("pop head node: " + problemSolution.pop(head) + ", after pop,list: " + head);
        System.out.println("================================================================");

        head = problemSolution.deleteList(head);
        head = problemSolution.insertNth(head, 0, 1);
        System.out.println("add 1 at index 0, list is " + head);
        head = problemSolution.insertNth(head, 1, 2);
        System.out.println("add 2 at index 1, list is " + head);
        head = problemSolution.insertNth(head, 2, 3);
        System.out.println("add 3 at index 2, list is " + head);
        head = problemSolution.insertNth(head, 3, 4);
        System.out.println("add 4 at index 3, list is " + head);
        head = problemSolution.insertNth(head, 4, 7);
        System.out.println("add 5 at index 4, list is " + head);
        System.out.println("================================================================");

        head = problemSolution.deleteList(head);
        for (int i = 0; i < 20; i++) {
            int data = new Random().nextInt(200);
            System.out.println("add element: " + data + "  to list");
            head = problemSolution.sortedInsert(head, new Node(data));
        }
        System.out.println("after sortedInsert, list is " + head);

        Node cur = head;
        while (cur != null && cur.next != null) {
            if (cur.data > cur.next.data) {
                throw new IllegalArgumentException("sorted insert algorithm error");
            }
            cur = cur.next;
        }
        System.out.println("================================================================");

        LinkedListProblemSolution solution = new LinkedListProblemSolution();
        Node newList = solution.buildSimpleList(list);
        System.out.println("================================================================");

        head = problemSolution.append(head, newList);
        System.out.println("after append, list is " + head);
        System.out.println("================================================================");

        Pair<Node, Node> nodeNodePair = problemSolution.frontBackSplit(head);
        System.out.println("after front back split, left list is " + nodeNodePair.getLeft() + ", right list is "
                + nodeNodePair.getRight());
        System.out.println("================================================================");

        head = problemSolution.buildSimpleList(list);
        head = problemSolution.insertNth(head, 3, 6);
        System.out.println("list is " + head);
        Pair<Node, Node> pair = problemSolution.frontBackSplit(head);
        System.out.println(
                "after front back split, left list is " + pair.getLeft() + ", right list is " + pair.getRight());
        System.out.println("================================================================");

        head = problemSolution.buildSimpleList(Arrays.asList(1, 2, 3, 3, 5));
        System.out.println("list is " + head);
        head = problemSolution.removeDuplicates(head);
        System.out.println("after remove duplicate, list is " + head);
        System.out.println("================================================================");

        head = problemSolution.buildSimpleList(Arrays.asList(1, 1, 3, 3, 5));
        System.out.println("list is " + head);
        head = problemSolution.removeDuplicates(head);
        System.out.println("after remove duplicate, list is " + head);
        System.out.println("================================================================");

        head = problemSolution.buildSimpleList(Arrays.asList(1, 1, 1, 1, 1));
        System.out.println("list is " + head);
        head = problemSolution.removeDuplicates(head);
        System.out.println("after remove duplicate, list is " + head);
        System.out.println("================================================================");

        head = problemSolution.buildSimpleList(Arrays.asList(1, 2, 2, 2, 2));
        System.out.println("list is " + head);
        head = problemSolution.removeDuplicates(head);
        System.out.println("after remove duplicate, list is " + head);
        System.out.println("================================================================");

        head = problemSolution.buildSimpleList(Arrays.asList(1, 2, 3));
        Node target = problemSolution.buildSimpleList(Arrays.asList(1, 2, 3));
        Pair<Node, Node> nodePair = problemSolution.moveNode(head, target);
        System.out.println("after move node, source list is " + nodePair.getLeft());
        System.out.println("after move node, target list is " + nodePair.getRight());
        System.out.println("================================================================");

        head = problemSolution.buildSimpleList(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
        System.out.println("before alternative split, source list is " + head);
        Triple<Node, Node, Node> triple = problemSolution.alternatingSplit(head, null, null);
        System.out.println("after alternative split, source list is " + triple.getLeft());
        System.out.println("after alternative split, left list is " + triple.getMiddle());
        System.out.println("after alternative split, right list is " + triple.getRight());
        System.out.println("================================================================");

        head = problemSolution.buildSimpleList(Arrays.asList(1, 2, 3, 4));
        Node head1 = problemSolution.buildSimpleList(Arrays.asList(1, 2, 3, 4));
        //Node node = problemSolution.shuffleMerge(head, head1);
        System.out.println("================================================================");

        head = problemSolution.buildSimpleList(Arrays.asList(1, 2, 3, 4, 5));
        System.out.println("list1 is " + head);
        Node head2 = problemSolution.buildSimpleList(Arrays.asList(3, 5, 6));
        System.out.println("list2 is " + head2);
        Node node = problemSolution.sortedIntersect(head, head2);
        System.out.println("after intersection is " + node);
        System.out.println("================================================================");

        head = problemSolution.buildSimpleList(Arrays.asList(1, 2, 3, 4, 5));
        System.out.println("before reverse, list is " + head);
        //Node newHead = problemSolution.reverse(head);
        Node newHead = problemSolution.reverseUsingPointers(head);
        System.out.println("after reverse, list is " + newHead);

        head = problemSolution.buildSimpleList(Arrays.asList(1));
        System.out.println(problemSolution.reverseUsingPointers(head));

    }

    /**
     * 计算链表长度
     *
     * @param head 链表头结点
     * @return 链表长度
     */
    public int length(Node head) {
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
    public int count(Node head, int ele) {
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
    public int getNth(Node head, int index) {
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
     *
     * @return
     */
    public Node deleteList(Node head) {
        if (head == null) {
            return head;
        }
        Node next;
        while (head != null) {
            next = head.next;
            head = null;
            head = next;
        }
        return head;
    }

    /**
     * 删除以head为头的链表头结点,并返回删除的节点元素
     *
     * @param head 待删除头结点的链表头结点
     * @return 删除节点的元素
     */
    public Pair<Node, Integer> pop(Node head) {
        if (head == null) {
            throw new IllegalArgumentException("head cannot be null");
        }
        int data = head.data;
        head = head.next;
        return new ImmutablePair<>(head, data);
    }

    /**
     * 在链表的指定位置添加元素data
     *
     * @param head  链表头结点
     * @param index 添加的位置
     * @param data  待添加的元素
     * @return 链表头结点
     */
    public Node insertNth(Node head, int index, int data) {
        if (head == null) {
            return new Node(data);
        }
        if (index == 0) {
            return new Node(data, head);
        }

        Node cur = head;
        for (int i = 0; i < index - 1; i++) {
            cur = cur.next;
        }
        Node newNode = new Node(data);
        newNode.next = cur.next;
        cur.next = newNode;
        return head;
    }

    /**
     * 将节点添加到顺序(元素从小到大排列)链表的合适位置
     *
     * @param head 待插入节点的链表头结点
     * @param node 待添加的节点
     * @return 添加后的链表的头结点
     */
    public Node sortedInsert(Node head, Node node) {
        // 如果链表中一个节点都没有,或者要插入的节点比头结点还小,说明要插到头结点前.
        if (head == null || head.data >= node.data) {
            node.next = head;
            head = node;
            return head;
        }

        Node cur = head;
        // prev就是要插入的位置的前一个节点
        Node prev = null;
        while (cur != null && cur.data < node.data) {
            prev = cur;
            cur = cur.next;
        }
        node.next = cur;
        prev.next = node;
        return head;
    }


    /**
     * 将指定的链表追加到源链表中,并返回追加后的新链表的头结点
     *
     * @param head     源链表
     * @param listNode 待追加的链表
     * @return 追加后的新链表的头结点
     */
    public Node append(Node head, Node listNode) {
        if (head == null) {
            head = listNode;
            return head;
        }
        Node cur = head;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = listNode;
        return head;
    }

    /**
     * 将一个以head为头结点的单链表拆分成两个单独的链表
     *
     * @param head 待拆分的链表头结点
     * @return 拆分后的两个子链表
     */
    public Pair<Node, Node> frontBackSplit(Node head) {
        // 一个节点都没有或者只有一个节点的情况
        if (head == null || head.next == null) {
            return new ImmutablePair<>(head, null);
        }
        Node slow = head;
        Node fast = head.next;
        while (fast != null) {
            fast = fast.next;
            if (fast != null) {
                slow = slow.next;
                fast = fast.next;
            }
        }

        Node halfRight = slow.next;
        slow.next = null;

        return new ImmutablePair<>(head, halfRight);
    }

    /**
     * 在升序的链表中移除重复元素, 并返回删除后的链表头结点
     *
     * @param head 链表头结点
     * @return 删除后的链表头结点
     */
    public Node removeDuplicates(Node head) {
        // 一个节点都没有或者只有一个节点的情况
        if (head == null || head.next == null) {
            return head;
        }
        Node cur = head;
        Node next = head.next;
        while (cur != null && next != null) {
            if (cur.data != next.data) {
                cur = cur.next;
                next = cur.next;
            } else {
                cur.next = next.next;
                next.next = null;
                next = cur.next;
            }
        }
        return head;
    }

    /**
     * 将指定链表的头结点移动到目标链表的头结点
     *
     * @param sourceNode 源链表头结点
     * @param targetNode 目标链表头节点
     * @return 返回移动节点后的链表头结点
     */
    public Pair<Node, Node> moveNode(Node sourceNode, Node targetNode) {
        if (sourceNode == null) {
            throw new IllegalArgumentException("source linked-list is empty");
        }
        Node temp = sourceNode;
        sourceNode = sourceNode.next;

        temp.next = targetNode;
        targetNode = temp;

        return new ImmutablePair<>(sourceNode, targetNode);
    }

    public Triple<Node, Node, Node> alternatingSplit(Node source, Node aRef, Node bRef) {
        if (source == null) {
            return null;
        }
        if (source.next == null) {
            aRef = source;
            return new ImmutableTriple<>(source, aRef, bRef);
        }
        Node cur = source;
        while (cur != null) {
            Pair<Node, Node> nodePair = moveNode(cur, aRef);
            cur = nodePair.getLeft();
            aRef = nodePair.getRight();
            if (cur != null) {
                Pair<Node, Node> nodePair2 = moveNode(cur, bRef);
                cur = nodePair2.getLeft();
                bRef = nodePair2.getRight();
            }
        }
        return new ImmutableTriple<>(cur, aRef, bRef);
    }

    public Node shuffleMerge(Node a, Node b) {
        // TODO
        return null;
    }

    /**
     * 计算给定的两个有序链表的交集并返回由交集组成的新链表
     *
     * @param a 有序链表1
     * @param b 有序链表2
     * @return 交集组成的新链表头结点(新链表也是有序的)
     */
    public Node sortedIntersect(Node a, Node b) {
        Node dummyHead = new Node(-1);
        Node cur = dummyHead;
        while (a != null && b != null) {
            if (a.data == b.data) {
                cur.next = new Node(a.data);
                cur = cur.next;

                a = a.next;
                b = b.next;
            } else if (a.data > b.data) {
                b = b.next;
            } else {
                a = a.next;
            }
        }
        return dummyHead.next;
    }

    /**
     * 反转单链表
     *
     * @param head 待反转单链表的头结点
     * @return 反转后的单链表头结点
     */
    public Node reverse(Node head) {
        Node dummyHead = new Node();

        while (head != null) {
            dummyHead.next = new Node(head.data, dummyHead.next);
            head = head.next;
        }
        return dummyHead.next;
    }

    public Node reverseUsingPointers(Node head) {

        Node front = null;
        Node cur = head;
        Node back = null;

        while (cur != null) {
            back = cur.next;

            cur.next = front;

            front = cur;
            cur = back;
        }

        return front;
    }

    /**
     * 将指定的list转变为单链表
     *
     * @param list 待转换的列表
     * @return 单链表
     */
    private Node buildSimpleList(List<Integer> list) {
        Node head = null;
        for (int i = 0; i < list.size(); i++) {
            head = this.insertNth(head, i, list.get(i));
        }
        return head;
    }

}