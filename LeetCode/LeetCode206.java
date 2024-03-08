package LeetCode_Solution;

/*
   LeetCode_206.反转链表
 */
public class LeetCode206 {
    public static void main(String[] args) {
        ListNode o5 = new ListNode(5, null);
        ListNode o4 = new ListNode(4, o5);
        ListNode o3 = new ListNode(3, o4);
        ListNode o2 = new ListNode(2, o3);
        ListNode o1 = new ListNode(1, o2);
        System.out.println(o1);
        ListNode n1 = new LeetCode206().reverseList_04(o1);
        System.out.println("----------反转后的链表----------");
        System.out.println(n1);
    }

    //方法1:构造一个新链表,从旧链表依次拿到每个节点,创建新节点加至新链表头部，完成反转(头插法)
    public ListNode reverseList_01(ListNode o1) {
        ListNode n1 = null;
        ListNode p = o1;
        while(p!=null){
            // 在每次循环中，将当前节点 p 的值插入到新链表的头部，同时更新新链表的头节点n1
            // 每插入一个新节点，新插入的节点就会成为新的头结点
            n1 = new ListNode(p.val, n1);
            // 将原始链表的指针后移
            p = p.next;
        }
        return n1;
    }

    //方法2:构造一个新链表,从旧链表头部移除节点,添加到新链表头部，完成反转
    public ListNode reverseList_02(ListNode o1) {
        List list1 = new List(o1);
        List list2 = new List(null);
        while (true){
            ListNode first = list1.removeFirst();
            if (first == null){
                break;
            }
            list2.addFirst(first);
        }
        return list2.head;
    }
    //节点外层的容器类,实现了addFirst和removeFirst方法
    static class List{
        ListNode head;

        public List(ListNode head) {
            this.head = head;
        }

        public void addFirst(ListNode first){
            first.next = head;
            head = first;
        }

        public ListNode removeFirst(){
            ListNode first = head;
            if (first != null){
                head = first.next;
            }
            return first;
        }
    }

    //方法3:递归
    public ListNode reverseList_03(ListNode o1) {
        if (o1 == null || o1.next == null){
            return o1;
        }
        ListNode last = reverseList_03(o1.next);
        o1.next.next = o1;
        o1.next = null;
        return last;
    }

    //方法4:
    // o1(旧头)、n1(新头)、o2(旧老二)
    public ListNode reverseList_04(ListNode o1) {
        //如果链表是一个空链表或链表中只有一个元素
        if (o1 == null || o1.next == null) {
            return o1;
        }
        ListNode o2 = o1.next;
        ListNode n1 = o1;
        while (o2 == null) {
            o1.next = o2.next;
            o2.next = n1;
            n1 = o2;
            o2 = o1.next;
        }
        return n1;
    }
}
