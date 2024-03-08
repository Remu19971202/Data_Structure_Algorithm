package LeetCode_Solution;

/*
   LeetCode_203.根据值删除节点
 */
public class LeetCode203 {
    public static void main(String[] args) {
        ListNode head = ListNode.of(1, 2, 3, 4, 5, 6);
        System.out.println(head);
        System.out.println("========删除后的链表========");
        System.out.println(new LeetCode203().removeElements_01(head, 6));
    }

    //方法1:
    public ListNode removeElements_01(ListNode head, int val) {
        ListNode s = new ListNode(0, head);
        ListNode p1 = s;
        ListNode p2 = p1.next;
        while (p2 != null) {
            if (p2.val == val) {
                p1.next = p2.next;
                p2 = p2.next;
            } else {
                p1 = p1.next;
                p2 = p2.next;
            }
        }
        return s.next;
    }
}
