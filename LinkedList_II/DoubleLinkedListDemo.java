package LinkedList_II;

public class DoubleLinkedListDemo {
    public static void main(String[] args) {
        DoublyLinkedList dll_ = new DoublyLinkedList();
        dll_.addLast(1);
        dll_.addLast(2);
        dll_.addLast(3);
        dll_.addLast(4);
        dll_.addLast(5);

        dll_.remove(1);
        dll_.insert(1,99);
        for (Integer i : dll_) {
            System.out.println(i);
        }


    }
}
