package algorithms;

public class Q0061RotateList {
	public static void main(String[] args) {
		ListNode a = new ListNode(1);
		ListNode b = new ListNode(2);
		ListNode c = new ListNode(3);
		ListNode d = new ListNode(4);
		ListNode e = new ListNode(5);
		ListNode f = new ListNode(6);
		ListNode g = new ListNode(7);
		ListNode h = new ListNode(8);
		ListNode i = new ListNode(9);
		ListNode j = new ListNode(10);
		a.next = b;
		b.next = c;
		c.next = d;
		d.next = e;
		e.next = f;
		f.next = g;
		g.next = h;
		h.next = i;
		i.next = j;
		
		int n = 10;
		System.out.println(rotateRight(a, n));
	}

	public static ListNode rotateRight(ListNode head, int k) {
		ListNode dummy = new ListNode(-1);
		dummy.next = head;
		ListNode slow = dummy;
		ListNode fast = dummy;
		int count = 0;
		while(count < k) {
			fast = fast.next;
			count++;
		}
		
		while(fast.next != null) {
			fast = fast.next;
			slow = slow.next;
		}
		ListNode newHead = slow.next;
		slow.next = null;
		fast.next = head;
		return newHead;
	}
}
