package topic.linked_list;

import learning.base.ReverseList_206;
import module.ListNode;

/**
 * 92. ReverseLinkedList II
 * Given the head of a singly linked list and two integers left and right where left <= right, reverse the nodes of the list from position left to position right, and return the reversed list.
 */
public class ReverseBetween_92 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right) {
            return head;
        }

        int i = 1;
        ListNode leftPrev = null;
        ListNode leftNode = null;
        ListNode rightNext = null;
        ListNode rightNode = null;
        ListNode newOrderList = head;
        ListNode result = newOrderList;
        for (ListNode cur = head; cur != null; cur = cur.next) {
            if (i < left) {
                newOrderList = cur;
                newOrderList = newOrderList.next;
            }
            if (i == left - 1) {
                newOrderList = cur;
                leftPrev = newOrderList;
                newOrderList.next = null;
            } else if (i == left) {
                leftNode = cur;
            } else if (i == right) {
                rightNode = cur;
            } else if (i == right + 1) {
                rightNext = cur;
                rightNode.next = null;
            }

            i++;
        }

        ListNode pre = rightNext;
        ListNode cur = leftNode;
        if (cur != null) {
            ListNode tmp = leftNode.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }

        if (leftPrev != null) {
            leftPrev.next = pre;
        } else {
            return pre;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println("test");
    }
}
