package LinkedList_;

import java.util.Iterator;
import java.util.function.Consumer;

// 带哨兵节点的单向链表(不用判断链表是否为空)
public class SinglyLinkedListSentinel implements Iterable<Integer>{
    private Node head = new Node(0, null); //头指针

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            Node p = head.next;
            @Override
            public boolean hasNext() { //是否有下一个元素
                return p != null;
            }

            @Override
            public Integer next() { //返回当前值，并指向下一个元素
                int v = p.value;
                p = p.next;
                return v;
            }
        };
    }

    private static class Node {
        int value; //值
        Node next; //下一个节点指针

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    // 向链表的头部添加值
    public void addFirst(int value) {
//        //1.链表为空的情况
////        head = new Node(value, null);
//        //2.链表非空的情况
//        head = new Node(value, head);
        // 简化:
        insert(0, value);
    }

    public void loop1(Consumer<Integer> consumer) {
//        Node p = head;
        Node p = head.next; // 增加了哨兵节点，所以从head.next开始遍历
        while (p != null) {
//            System.out.println(p.value);
            consumer.accept(p.value);
            p = p.next;
        }
    }

    public void loop2(Consumer<Integer> consumer) {
        for (Node p = head.next; p != null; p = p.next) { // 增加了哨兵节点，所以从head.next开始遍历
            consumer.accept(p.value);
        }
    }

    private Node findLast() {
//        if (head == null) { //空链表
//            return null;
//        }
        // 没有节点的情况下，最后一个节点就是哨兵节点
        Node p;
        for (p = head; p.next != null; p = p.next) {
        }
        return p;
    }

    public void addLast(int value) {
        Node last = findLast();
        // 最后一个节点就是哨兵节点，不为空
//        if (last == null) { //如果是空链表直接调用addFirst()方法
//            addFirst(value);
//            return;
//        }
        last.next = new Node(value, null); // 哨兵节点直接指向新节点
    }

    // 根据节点索引返回节点对象
    private Node findNode(int index) {
//        int i = 0;
        int i = -1; // 哨兵节点的索引为-1
        for (Node p = head.next; p != null; p = p.next, i++) { // 增加了哨兵节点，所以从head.next开始遍历
            if(i == index) {
                return p;
            }
        }
        return null;
    }

    // 根据节点索引返回节点值
    public int get(int index) {
        Node node = findNode(index);
        if (node == null) illegalIndex(index);
        return node.value;
    }

    // 向指定索引位置插入
    public void insert(int index, int value) {
        // 索引为0时，上一个节点是哨兵节点，不需要特殊处理
//        if (index == 0){
//            addFirst(value);
//            return;
//        }
        Node prev = findNode(index - 1); // 找到上一个节点
        if (prev == null) illegalIndex(index);
        prev.next = new Node(value, prev.next);
    }

    // 删除节点
    public void removeFirst() {
//        if (head == null) {
//            throw illegalIndex(0);
//        }
//        head = head.next;
        // 简化:
        remove(0);
    }

    // 按索引删除
    public void remove(int index) {
//        if (index == 0) {
//            removeFirst();
//            return;
//        }
        Node prev = findNode(index - 1); //找到上一个节点
        if (prev == null) {
            throw illegalIndex(index);
        }
        Node removed = prev.next;
        if (removed == null) {
            throw  illegalIndex(index);
        }
        prev.next = removed.next;
    }

    private IllegalArgumentException illegalIndex(int index) {
        throw new IllegalArgumentException(
                String.format("index [$d] 不合法%n", index));
    }
}
