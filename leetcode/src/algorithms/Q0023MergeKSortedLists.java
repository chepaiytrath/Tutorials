package algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Q0023MergeKSortedLists {
	public static void main(String[] args) {
		ListNode a = new ListNode(1);
		ListNode b = new ListNode(4);
		ListNode c = new ListNode(5);
		a.next = b;
		b.next = c;

		ListNode d = new ListNode(1);
		ListNode e = new ListNode(3);
		ListNode f = new ListNode(4);
		d.next = e;
		e.next = f;

		ListNode g = new ListNode(2);
		ListNode h = new ListNode(6);
		g.next = h;

		ListNode[] listNodes = { a, d, g };
		System.out.println(mergeKListsMergeSort(listNodes));
	}

	public static ListNode mergeKListsBruteForce(ListNode[] listNodes) {
		List<Integer> list = new ArrayList<>();
		for (ListNode listNode : listNodes) {
			while (listNode != null) {
				list.add(listNode.val);
				listNode = listNode.next;
			}
		}

		Collections.sort(list);
		ListNode node = new ListNode(-1), temp = node;
		for (int i = 0; i < list.size(); i++) {
			while (null != temp.next) {
				temp = temp.next;
			}
			temp.next = new ListNode(list.get(i));
		}
		return node.next;
	}

	public static ListNode mergeKListsPriorityQueue(ListNode[] listNodes) {
		List<ListNode> lists = Arrays.asList(listNodes);
		Queue<ListNode> queue = new PriorityQueue<>(new Comparator<ListNode>() {
			@Override
			public int compare(ListNode o1, ListNode o2) {
				return o1.val - o2.val;
			}
		});

		for (ListNode node : lists) {
			queue.add(node);
		}

		ListNode node = new ListNode(-1);
		ListNode temp = node;
		while (!queue.isEmpty()) {
			temp.next = queue.poll();
			temp = temp.next;
			if (temp.next != null) {
				queue.add(temp.next);
			}
		}
		return node.next;
	}
	
	public static ListNode mergeKListsMergeSort(ListNode[] listNodes) {
		return mergeSort(listNodes, 0, listNodes.length - 1);
	}

	private static ListNode mergeSort(ListNode[] listNodes, int i, int j) {
		if(i == j) {
			return listNodes[i];
		}else if(i < j) {
			int mid = (i + j) / 2;
			ListNode l1 = mergeSort(listNodes, i, mid);
			ListNode l2 = mergeSort(listNodes, mid + 1, j);
			return mergeTwoListNodes(l1,l2);
		}else {
			return null;
		}
	}

	private static ListNode mergeTwoListNodes(ListNode l1, ListNode l2) {
		if(l1 == null) {
			return l2;
		}
		if(l2 == null) {
			return l1;
		}
		if(l1.val < l2.val) {
			l1.next = mergeTwoListNodes(l2, l1.next);
			return l1;
		}else {
			l2.next = mergeTwoListNodes(l1, l2.next);
			return l2;
		}
	}
}