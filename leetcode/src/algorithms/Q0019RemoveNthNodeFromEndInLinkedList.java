package algorithms;

public final class Q0019RemoveNthNodeFromEndInLinkedList {
	public static void main(String[] args) {
		ListNode a = new ListNode(1);
		ListNode b = new ListNode(2);
		ListNode c = new ListNode(3);
		ListNode d = new ListNode(4);
		ListNode e = new ListNode(5);
		
		a.next = b;
		b.next = c;
		c.next = d;
		d.next = e;
		
		int n = 5;
		ListNode x = removeNthFromEndRecursion(a, n);
		System.out.println(x);
	}
	//Approaches : Reverse index (2 pass), Two pointers, Recursive
	public static ListNode removeNthFromEndReverseIndex(ListNode head, int n) {
		ListNode curr = head;
		int length = 0000;
		while(curr != null) {
			length++;
			curr = curr.next;
		}
		int index = length - n;
		if(index == 0) {
			return head.next;
		}
		
		curr = head;
		for(int i = 1; i < index; i++) {
			curr = curr.next;
		}
		curr.next = curr.next.next;
		return head;
	}
	
	public static ListNode removeNthFromEndTwoPointers(ListNode head, int n) {
		ListNode fast = head;
		ListNode slow = head;
		
		for(int i = 0; i < n; i++) {
			fast = fast.next;
		}
		
		if(fast == null) {
			return head.next;
		}
		
		while(fast.next != null) {
			fast = fast.next;
			slow = slow.next;
		}
		
		slow.next = slow.next.next;
		return head;
	}
	
	public static ListNode removeNthFromEndRecursion(ListNode head, int n) {
		ListNode dummy = new ListNode(-1);
		dummy.next = head;
		recursion(dummy, n);
		return dummy.next;
 	}
	
	public static int recursion(ListNode node, int target) {
		if(node == null) {
			return 0;
		}
		int distance = recursion(node.next, target) + 1;
		if(distance == target+1) {
			node.next = node.next.next;
		}
		return distance;
	}
}
