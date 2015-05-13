/**
 *	Given a list, rotate the list to the right by k places, where k is non-negative.
 *
 *	For example:
 *
 *	Given 1->2->3->4->5->NULL and k = 2,
 *
 *	return 4->5->1->2->3->NULL.
 *
 *	Author: matao
 *
 *	注意k 大于 链表长度时的处理
 */

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
}

public class RotateList {
	public static ListNode rotateRight(ListNode head, int k) {
		if (head == null) {
			return null;
		}
		if(k == 0) {
			return head;
		}
		k = k % getLength(head);
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		head = dummy;
		ListNode tail = dummy;
		while(k-- > 0) {
			tail = tail.next;
		}
		while(tail.next != null) {
			head = head.next;
			tail = tail.next;
		}
		tail.next = dummy.next;
		dummy.next = head.next;
		head.next = null;
		return dummy.next;
    }

    public static int getLength(ListNode head) {
        int length = 0;
        while (head != null) {
            length ++;
            head = head.next;
        }
        return length;
    }

    public static void main(String[] args) {
    	ListNode head = new ListNode(0);
		ListNode tail = head;
		for (int i = 1; i <= 5; i++) {
			ListNode newNode = new ListNode(i);
			tail.next = newNode;
			tail = tail.next;
		}
		// ListNode node2 = new ListNode(2);
		// ListNode node1 = new ListNode(1);
		// tail.next = node2;
		// node2.next = node1;

		ListNode p = head.next;
		while(p != null) {
			System.out.print(p.val + " ");
			p = p.next;
		}
		System.out.println();

		ListNode result = rotateRight(head.next, 2);
		while(result != null) {
			System.out.print(result.val + " ");
			result = result.next;
		}
		System.out.println();
    }
}