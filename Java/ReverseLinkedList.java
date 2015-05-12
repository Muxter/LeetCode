/**
 *	Reverse a singly linked list.
 *
 *	Author: matao
 */

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
}
 

public class ReverseLinkedList {
	public static ListNode reverseList(ListNode head) {
		ListNode pre = null;
        while(head != null) {
            ListNode temp = head.next;
            head.next = pre;
            pre = head;
            head = temp;
        }
        return pre;
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(0);
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		head.next = node1;
		node1.next = node2;
		node2.next = node3;
		while(head != null) {
			System.out.print(head.val + "->");
			head = head.next;
		}
		System.out.println();

		ListNode result = reverseList(head);
		while(result != null) {
			System.out.print(result.val + "->");
			result = result.next;
		}
		System.out.println();
	}
}