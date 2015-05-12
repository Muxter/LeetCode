/**
 *	Given a linked list, determine if it has a cycle in it.
 *	
 *	Author: matao
 */

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) {
		val = x;
		next = null;
	}
}

public class LinkedListCycle {
	public static boolean hasCycle(ListNode head) {
        if(head == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast)
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
    	// null
		ListNode head1 = null;
		System.out.println(hasCycle(head1) + "");

		// 1->null
		ListNode head2 = new ListNode(1);
		System.out.println(hasCycle(head2) + "");

		// 1->2->null
		ListNode head3 = new ListNode(1);
		ListNode node1 = new ListNode(2);
		head3.next = node1;
		System.out.println(hasCycle(head3) + "");

		// 1->2->3->null
		ListNode head4 = new ListNode(1);
		ListNode node2 = new ListNode(3);
		head4.next = node1;
		node1.next = node2;
		System.out.println(hasCycle(head4) + "");

		// 1->2->3->2
		ListNode head5 = new ListNode(1);
		head5.next = node1;
		node1.next = node2;
		node2.next = node1;
		System.out.println(hasCycle(head5) + "");
	}
}