package LeetCode_Solution;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(64);
        sb.append("[");
        ListNode p = this;
        while(p!=null){
            sb.append(p.val);
            if(p.next != null){
                sb.append(",");
            }
            p = p.next;
        }
        sb.append("]");
        return sb.toString();
    }

    public static ListNode of(int... values) {
        if (values == null || values.length == 0) {
            return null;
        }

        ListNode dummy = new ListNode(0, null);
        ListNode current = dummy;

        for (int value : values) {
            current.next = new ListNode(value, null);
            current = current.next;
        }

        return dummy.next;
    }
}
