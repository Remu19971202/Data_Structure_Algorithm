package LinkedList_II;

import java.util.Iterator;
import java.util.Objects;

public class DoublyLinkedList implements Iterable<Integer> {
    static class Node {
        Node prev;
        int value;
        Node next;

        public Node(Node prev, int value, Node next) {
            this.prev = prev;
            this.value = value;
            this.next = next;
        }
    }

    private final Node head;
    private final Node tail;

    public DoublyLinkedList() {
        head = new Node(null, 6313, null);
        tail = new Node(null, 5189, null);
        head.next = tail;
        tail.prev = head;
    }

    private Node findNode(int index) {
        int i = -1;
        for (Node p = head; p != tail; p = p.next, i++) {
            if (i == index) {
                return p;
            }
        }
        return null;
    }

    //从头加入节点
    public void addFirst(int value) {
        insert(0, value);
    }

    public void removeFirst() {
        remove(0);
    }

    public void addLast(int value) {
        Node last = tail.prev;
        Node added = new Node(last, value, tail);
        last.next = added;
        tail.prev = added;
    }

    public void removeLast(int value) {
        Node removed = tail.prev;
        if (removed == head) throw illegalIndex(0);
        Node prev = removed.prev;
        prev.next = tail;
        tail.prev = prev;
    }

    //根据索引插入节点
    public void insert(int index, int value) {
        Node prev = findNode(index - 1);
        if (prev == null) {
            throw illegalIndex(index);
        }
        Node next = prev.next;
        Node inserted = new Node(prev, value, next);
        prev.next = inserted;
        next.prev = inserted;

    }

    //按索引删除元素
    public void remove(int index) {
        Node prev = findNode(index - 1);
        if (prev == null) {
            throw illegalIndex(index);
        }
        Node removed = prev.next;
        if (removed == tail) {
            throw illegalIndex(index);
        }
        Node next = prev.next.next;
        prev.next = next;
        next.prev = prev;

    }

    private IllegalArgumentException illegalIndex(int index) {
        return new IllegalArgumentException(
                String.format("index [%d] 不合法%n", index)
        );
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            Node p = head.next;

            @Override
            public boolean hasNext() {
                return p != tail;
            }

            @Override
            public Integer next() {
                int value = p.value;
                p = p.next;
                return value;
            }
        };
    }
}


