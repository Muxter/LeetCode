/**
 *	Given a sorted linked list, delete all nodes that have duplicate numbers, 
 *	leaving only distinct numbers from the original list.
 *
 *	For example,
 *	Given 1->2->3->3->4->4->5, return 1->2->5.
 *	Given 1->1->1->2->3, return 2->3.
 *
 *	Author: matao
 *
 */

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
}

public class RemoveDuplicatesfromSortedListII {
	public static ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) {
        	return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        while(head.next != null && head.next.next != null) {
        	if (head.next.val == head.next.next.val) {
        		int val = head.next.val;
        		while(head.next != null && head.next.val == val) {
        			head.next = head.next.next;
        		}
        	} else {
        		head = head.next;
        	}
        }
        return dummy.next;
    }

    public static void main(String[] args) {
    	ListNode node1 = new ListNode(1);
    	ListNode node2 = new ListNode(2);
    	ListNode node3 = new ListNode(3);
    	ListNode node3_ = new ListNode(3);
    	ListNode node4 = new ListNode(4);
    	ListNode node4_ = new ListNode(4);
    	ListNode node5 = new ListNode(5);

    	node1.next = node2;
    	node2.next = node3;
    	node3.next = node3_;
    	node3_.next = node4;
    	node4.next = node4_;
    	node4_.next = node5;

    	ListNode node = deleteDuplicates(node1);
    	while(node != null) {
    		System.out.print(node.val + " ");
    		node = node.next;
    	}
    	System.out.println();
    }
}