/**
 *	Given a sorted linked list, 
 *	delete all duplicates such that each element appear only once.
 *	
 *	For example,
 *	Given 1->1->2, return 1->2.
 * 	Given 1_>1->2->3->3, return 1->2->3.
 *
 *	Author: matao
 */

class ListNode {
	int val;
	ListNode next;
	ListNode(int val) {
		this.val = val;
	}
}

public class RemoveDuplicatesFromSortedList {
	public static ListNode deleteDuplicates(ListNode head) {
		if(head == null)
			return null;
		ListNode curr = head;
		while(curr.next != null) {
			if(curr.next.val == curr.val)
				curr.next = curr.next.next;
			else
				curr = curr.next;
		}
		return head;
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(1);
		head.next.next = new ListNode(2);
		//  1->1->2
		ListNode curr = head;
		while(curr != null) {
			System.out.print(curr.val + "->");
			curr = curr.next;
		}
		System.out.println("after delete:");
		deleteDuplicates(head);
		curr = head;
		while(curr != null) {
			System.out.print(curr.val + "->");
			curr = curr.next;
		}
		System.out.println();
	}
}
