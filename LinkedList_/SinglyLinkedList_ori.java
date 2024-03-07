package LinkedList_;

import java.util.Iterator;
import java.util.function.Consumer;

public class SinglyLinkedList_ori implements Iterable<Integer>{
    private Node head = null; //头指针

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            Node p = head;
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
        //1.链表为空的情况
//        head = new Node(value, null);
        //2.链表非空的情况
        head = new Node(value, head);
    }

    public void loop1(Consumer<Integer> consumer) {
        Node p = head;
        while (p != null) {
//            System.out.println(p.value);
            consumer.accept(p.value);
            p = p.next;
        }
    }

    public void loop2(Consumer<Integer> consumer) {
        for (Node p = head; p != null; p = p.next) {
            consumer.accept(p.value);
        }
    }

    private Node findLast() {
        if (head == null) { //空链表
            return null;
        }
        Node p;
        for (p = head; p.next != null; p = p.next) {
        }
        return p;
    }

    public void addLast(int value) {
        Node last = findLast();
        if (last == null) { //如果是空链表直接调用addFirst()方法
            addFirst(value);
            return;
        }
        last.next = new Node(value, null);
    }

    // 根据节点索引返回节点对象
    private Node findNode(int index) {
        int i = 0;
        for (Node p = head; p != null; p = p.next, i++) {
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
        if (index == 0){
            addFirst(value);
            return;
        }
        Node prev = findNode(index - 1); // 找到上一个节点
        if (prev == null) illegalIndex(index);
        prev.next = new Node(value, prev.next);
    }

    // 删除节点
    public void removeFirst() {
        if (head == null) {
            throw illegalIndex(0);
        }
        head = head.next;
    }

    // 按索引删除
    public void remove(int index) {
        if (index == 0) {
            removeFirst();
            return;
        }
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
