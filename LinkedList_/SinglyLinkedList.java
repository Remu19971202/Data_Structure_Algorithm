package LinkedList_;

public class SinglyLinkedList<T> {
    private Node<T> head;

    public SinglyLinkedList() {
        this.head = null;
    }

    //打印链表
    public void printList() {
        if (head == null) {
            System.out.println("NaN");
        } else {
            Node<T> current = head;
            while (current != null) {
                System.out.println("Node_Num: " + current.Num +
                        "  Node_data: " + current.data + " ");
                current = current.next;
            }
            System.out.println();
        }
    }

    //计算链表长度
    public int Length_I() {
        int count = 0;
        Node<T> current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    //计算单链表有效节点个数，如果是带有头节点的链表，需求不统计头节点
    public static int Length_II(Node head) { //该方法参数接收一个头节点
        if (head.next == null) {
            return 0;
        }
        int length = 0;
        Node current = head.next;
        while (current != null) {
            length++;
            current = current.next;
        }
        return length;
    }

    public Node<T> getHead() {//
        return head;
    }

    //从链表末尾或头部加入节点
    public void add(Node<T> newNode) { //使用方法重载，令add()中的add_position参数默认为”tail“
        add(newNode, "tail");
    }

    public void add(Node<T> newNode, String add_position) {

        if (head == null) {
            head = newNode;
        } else {
            if (add_position.equalsIgnoreCase("tail")) {
                Node<T> current = head;
                while (current.next != null) {
                    current = current.next;
                }
                current.next = newNode;
            } else if (add_position.equalsIgnoreCase("head")) {
                newNode.next = head;
                head = newNode;
            }
        }
    }

    //指定位置插入节点(根据Num值)
    public void insert(Node<T> newNode) {
        Node<T> temp_node = head;
        boolean flag = false; //添加的编号是否存在，默认为false
        while (true) {
            if (temp_node.next == null) {
                break;
            }
            if (temp_node.next.Num > newNode.Num) {
                break;
            }
            if (temp_node.next.Num == newNode.Num) {
                flag = true;
                break;
            }
            temp_node = temp_node.next;
        }
        if (flag == true) {
            System.out.printf("编号为 %d 的Node已存在\n", newNode.Num);
        } else {
            newNode.next = temp_node.next;
            temp_node.next = newNode;
        }
    }

    //根据编号Num来修改Node中的data
    public void modify(Node<T> newNode) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        Node<T> temp_node = head.next;
        boolean flag = false;
        while (true) {
            if (temp_node == null) {
                break;
            }
            if (temp_node.Num == newNode.Num) {
                flag = true;
                break;
            }
            temp_node = temp_node.next;
        }
        if (flag) {
            temp_node.data = newNode.data;
        } else {
            System.out.printf("Node_num: %d not found\n", newNode.Num);
        }


    }

    //指定位置删除节点(根据Num值)
    public void delete(int Num) {
        if (head.Num == Num) {
            head = head.next;
            return;
        }
        Node<T> temp_node = head;
        boolean flag = false;
        while (true) {
            if (temp_node.next == null) {
                break;
            }
            if (temp_node.next.Num == Num) {
                flag = true;
                break;
            }
            temp_node = temp_node.next;
        }
        if (flag) {
            temp_node.next = temp_node.next.next;
        } else {
            System.out.printf("要删除的节点编号Node_Num: %d 未找到.\n", Num);
        }
    }

    //查找倒数第i个节点
    public static Node findLastIndexNode(Node head, int index) {
        if (head.next == null) {
            return null;
        }
        //第一次遍历得到链表长度(有效节点个数)
        int size = Length_II(head);
        //第二次遍历size-index的位置
        if (index <= 0 || index > size) {
            return null;
        }
        Node current = head.next;
        for (int i = 0; i < size - index; i++) {
            current = current.next;
        }
        return current;
    }

    //链表反转
    public static void reverseList(Node head) {
        //如果链表为空，或者只有一个节点，则无需反转，直接返回
        if (head.next == null || head.next.next == null) {
            return;
        }
        Node current = head.next; //辅助指针，遍历原来的链表
        Node next = null; //指向当前节点[current]的下一个节点
        Node reverseHead = new Node<>(0, "");
        //遍历原来的链表，每遍历一个节点，就将其取出，并放在新的链表的reverseHead的最前端
        while (current != null) {
            next = current.next; //先暂时保存当前节点的下一个节点，因为后面需要使用
            current.next = reverseHead.next;
            reverseHead = current;
            current = next;
        }
        head.next = reverseHead.next;
    }
}

class Node<T> {
    public int Num;
    T data;
    public Node<T> next;

    public Node(int num, T data) {
        this.Num = num;
        this.data = data;
        this.next = null;
    }

//    public int getNum() {
//        return Num;
//    }
//
//    public void setNum(int num) {
//        Num = num;
//    }

    @Override
    public String toString() {
        return "Node [ " +
                "Num=" + Num +
                ", data=" + data +
                " ]";
    }
}
