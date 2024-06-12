package learning.base;

/**
 * 206 翻转链表
 */
public class ReverseList_206 {
    public class ListNode {
        int val;
        ReverseList_206.ListNode next;
        ListNode() {}
        ListNode(int val) {
            this.val = val;
        }
        ListNode(int val, ReverseList_206.ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode reverseList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode pre = null;
        ListNode cur = head;

        while (cur != null) {
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }

        return pre;
    }

    public static void main(String[] args) {
        System.out.println("testing reverseList");
    }

}
