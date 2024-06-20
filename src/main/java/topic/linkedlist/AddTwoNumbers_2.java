package topic.linkedlist;

import module.ListNode;

/**
 * 2. Add Two Numbers
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order, and each of their nodes contains a single digit.
 * Add the two numbers and return the sum as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 */
public class AddTwoNumbers_2 {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode result = dummyHead;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            int num1 = 0 ;
            if (l1 != null) {
                num1 = l1.val;
                l1 = l1.next;
            }

            int num2 = 0 ;
            if (l2 != null) {
                num2 = l2.val;
                l2 = l2.next;
            }
            int sum = num1 + num2 + carry;
            carry = sum / 10;
            dummyHead.next = new ListNode(sum % 10);
            dummyHead = dummyHead.next;
        }

        return result.next;
    }

    public static void main(String[] args) {
        System.out.println("===============test 1===============");
        ListNode n0 = new ListNode(5);
        ListNode n1 = new ListNode(6);
        ListNode n2 = new ListNode(4);
        ListNode n3 = new ListNode(2);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(3);
        n0.next = n1;
        n1.next = n2;
        n3.next = n4;
        n4.next = n5;
        ListNode result = addTwoNumbers(n0, n3);
        while (result != null) {
            System.out.print(result.val);
            result = result.next;
        }

    }
}
