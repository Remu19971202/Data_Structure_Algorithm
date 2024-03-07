package LinkedList_;

import static LinkedList_.SinglyLinkedList.reverseList;

public class LinkedList_Demo {
    public static void main(String[] args) {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        Node<Integer> node1 = new Node<>(1, 10);
        Node<Integer> node2 = new Node<>(2, 20);
        Node<Integer> node3 = new Node<>(3, 30);
        Node<Integer> node4 = new Node<>(4, 40);

        list.add(node1);
        list.add(node2);
        list.add(node3);

        list.add(node4);
//        list.delete(1);
        list.printList();
//
//        System.out.println(list.Length_II(list.getHead()));
//
//        Node<Integer> node = findLastIndexNode(list.getHead(), 2);
//        System.out.println("node = " + node);

        System.out.println("反转后的链表");
        reverseList(list.getHead());
        list.printList();

        // ori版链表
        SinglyLinkedList_ori listOri = new SinglyLinkedList_ori();
        listOri.addFirst(11);
        listOri.addFirst(23);
        listOri.addFirst(58);
        listOri.addFirst(13);

        listOri.loop2(value->{
            System.out.println(value);
        });

        // 增强for循环
        for (Integer value : listOri) {
            System.out.println(value);
        }
    }

}
