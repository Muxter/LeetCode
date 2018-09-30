package com.matao.medium;

import com.matao.ListNode;

/**
 * Created by matao on 2018/9/30.
 * <p>
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 * <p>
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * <p><br>
 * Example:
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 */
public class AddTwoNumbers {

    private static ListNode addTwoNumbersList(ListNode l1, ListNode l2) {
        ListNode h1 = l1;
        ListNode h2 = l2;
        ListNode dummyHead = new ListNode(0);
        ListNode currentNode = dummyHead;
        int sum = 0;
        int carry = 0;
        while (h1 != null || h2 != null) {
            int val1 = h1 == null ? 0 : h1.val;
            int val2 = h2 == null ? 0 : h2.val;
            sum = val1 + val2 + carry;
            carry = sum / 10;
            ListNode node = new ListNode(sum % 10);
            currentNode.next = node;
            currentNode = currentNode.next;
            sum = 0;

            if (h1 != null) h1 = h1.next;
            if (h2 != null) h2 = h2.next;
        }
        if (carry != 0) {
            currentNode.next = new ListNode(carry);
            currentNode = currentNode.next;
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        ListNode result = addTwoNumbersList(l1, l2);
        ListNode p = result;
        while (p != null) {
            System.out.println(p.val);
            p = p.next;
        }
    }
}
