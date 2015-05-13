/**
 *	Merge two sorted linked lists and return it as a new list.
 *  The new list should be made by splicing together the nodes of the first two lists.
 *
 *	Author: matao
 */

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
}


public class MergeTwoSortedLists {
	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode dummy = new ListNode(0);
		ListNode p = dummy;
		while(l1 != null && l2 != null) {
			if(l1.val < l2.val) {
				p.next = l1;
				l1 = l1.next;
				p = p.next;
			} else {
				p.next = l2;
				l2 = l2.next;
				p = p.next;
			}
		}
		if(l1 != null) {
			p.next = l1;
		}
		if(l2 != null) {
			p.next = l2;
		}
		return dummy.next;
	}

	public static void main(String[] args) {
		ListNode head1 = new ListNode(0);
		ListNode tail1 = head1;
		for (int i = 0; i < 5; i++) {
			ListNode newNode = new ListNode(i);
			tail1.next = newNode;
			tail1 = tail1.next;
		}

		ListNode head2 = new ListNode(0);
		ListNode tail2 = head2;
		for (int i = 3; i < 6; i++) {
			ListNode newNode = new ListNode(i);
			tail2.next = newNode;
			tail2 = tail2.next;
		}
		ListNode result = mergeTwoLists(head1.next, head2.next);
		while(result != null) {
			System.out.print(result.val + " ");
			result = result.next;
		}
		System.out.println();
	}
}