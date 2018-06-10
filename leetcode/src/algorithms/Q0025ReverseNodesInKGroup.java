package algorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Q0025ReverseNodesInKGroup {
	public static void main(String[] args) {
		ListNode a = new ListNode(8);
		ListNode b = new ListNode(3);
		ListNode c = new ListNode(9);
		ListNode d = new ListNode(7);
		ListNode e = new ListNode(4);
		ListNode f = new ListNode(8);
		ListNode g = new ListNode(1);
		ListNode h = new ListNode(6);
		ListNode i = new ListNode(5);
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
		
		int n = 3;
		System.out.println(reverseKGroup2(a, n));
	}

	
	public static ListNode reverseKGroup(ListNode head, int n) {
		if(head == null || head.next == null || n == 1) {
			return head;
		}
		ListNode dummy = new ListNode(-1);
		dummy.next = head;
		
		ListNode slow = dummy;
		ListNode fast = dummy;
		
		int count = n;
		List<Integer> list = new ArrayList<>();
		Stack<ListNode> stack = new Stack<>();
		while(fast.next != null) {
			fast = fast.next;
			--count;
			stack.push(fast);
			if(count == 0) {
				while(!stack.isEmpty()) {
					list.add(stack.pop().val);
				}
				slow = fast;
				count = n;
			}
		}
		slow = slow.next;
		while(slow != null) {
			list.add(slow.val);
			slow = slow.next;
		}
		
		dummy = new ListNode(-1);
		fast = dummy;
		for(Integer x : list) {
			fast.next = new ListNode(x);
			fast = fast.next;
		}
		
		return dummy.next;
	}
	
	public static ListNode reverseKGroup2(ListNode head, int k) {
		if(head == null || head.next == null || k == 1) {
			return head;
		}
		
		ListNode dummy = new ListNode(-1);
		dummy.next = head;
		ListNode begin = dummy;
		ListNode end = head;
		
		int count = 0;
		while(end != null) {
			count++;
			if(count % k == 0) {
				begin = reverse(begin, end.next);
				end = begin.next;
			}else {
				end = end.next;
			}
		}
		return dummy.next;
	}

	public static ListNode reverse(ListNode begin, ListNode end){
		ListNode curr = begin.next;
		ListNode first = curr;
		ListNode prev = begin;
		while(curr != end) {
			ListNode next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		begin.next = prev;
		first.next = curr;
		return first;
	}
	
	public static ListNode reverseKGroupRecursion(ListNode head, int k) {
		if (head == null || head.next == null || k == 1) {
			return head;
		}
		ListNode curr = head;
		int count = 0;
		while (count < k) {
			count++;
			curr = curr.next;
		}

		if (count == k) {
			curr = reverseKGroupRecursion(curr, k);
			while (count-- > 0) {
				ListNode next = head.next;
				head.next = curr;
				curr = head;
				head = next;
			}
		}
		return head;
	}
}


