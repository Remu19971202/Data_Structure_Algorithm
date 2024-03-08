package LeetCode_Solution;

/*
   LeetCode_83.删除有序链表重复节点
 */
public class LeetCode83 {
    public static void main(String[] args) {
        ListNode head = ListNode.of(1, 1, 2, 2, 3, 4, 5);
            System.out.println(head);
        System.out.println("========去重后的链表========");
        System.out.println(new LeetCode83().deleteDuplicates(head));
    }

    public ListNode deleteDuplicates(ListNode head) {
        //节点数＜2
        if (head == null || head.next == null) {
            return head;
        }
        //节点数≥2
        ListNode p1 = head;
        ListNode p2;
        while ((p2 = p1.next) != null) {
            if (p1.val == p2.val) {
                p1.next = p2.next;

            } else {
                p1 = p1.next;
            }
        }
        return head;
    }
}
