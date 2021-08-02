package com.leet;

public class AddTwoNumber {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        if (l1 == null && l2 == null) return new ListNode(0);
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode result = new ListNode(-1);
        ListNode head = result;
        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {

            if (l2 != null) {
                carry += l2.val;
                l2 = l2.next;
            }

            if (l1 != null) {
                carry += l1.val;
                l1 = l1.next;
            }

            head.next = new ListNode(carry % 10);
            head = head.next;
            carry /= 10;
        }

        return result.next;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }
}

