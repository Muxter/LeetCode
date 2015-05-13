/**
 *	Remove all elements from a linked list of integers that have value val.
 *
 *	Example
 *	Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
 *	Return: 1 --> 2 --> 3 --> 4 --> 5
 *
 *	Author: matao
 *	
 *	Hint: 处理头结点时，创建哑元结点，可进行统一处理，避免讨论特殊情况。
 *	
 */

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
}

public class RemoveLinkedListElements {

	public static ListNode removeElements(ListNode head, int val) {
		ListNode dummy = new ListNode(Integer.MAX_VALUE);
		dummy.next = head;
		ListNode p = dummy;
		ListNode tmp = p.next;
		while(tmp != null) {
			if(tmp.val == val) {
				p.next = tmp.next;
				tmp = p.next;
			} else {
				p = tmp;
				tmp = p.next;
			}
		}
		return dummy.next;
    }

	public static void main(String[] args) {
		ListNode node1 = new ListNode(1);
		ListNode node1_ = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);
		ListNode node6 = new ListNode(6);
		ListNode node6_ = new ListNode(6);
		node1.next = node2;
		node2.next = node6;
		node6.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6_;
		//	1->2->6->3->4->5->6
		ListNode p = node1;
		while(p != null) {
			System.out.print(p.val + " ");
			p = p.next;
		}
		System.out.println();

		removeElements(node1, 6);
		p = node1;
		while(p != null) {
			System.out.print(p.val + " ");
			p = p.next;
		}
		System.out.println();
	}
}