package learning.base;

/**
 * 25 逢k翻转
 */
public class ReverseKGroup_25 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) {
            this.val = val;
        }
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode reverseKGroup(ListNode head, int k) {

        // 异常入参兼容
        if (head == null || head.next == null || k == 0) {
            return head;
        }

        // 逢k翻转
        // 1. 遍历到k
        ListNode pre = head;
        int i = 1;
        while(pre != null && pre.next != null && i < k) {
            pre = pre.next;
            i++;
        }

        // 若不足k,保留不翻转
        if(i < k) {
            return head;
        }

        // 局部翻转链表
        ListNode hd = head;
        ListNode prev = null;
        ListNode next = pre.next;
        while(hd != next) {
            ListNode tmp = hd.next;
            hd.next = prev;
            prev = hd;
            hd = tmp;
        }

        // 递归
        head.next = reverseKGroup(next, k);
        return pre;

    }

    public static void main(String[] args) {
        System.out.println("testing");
    }
}
