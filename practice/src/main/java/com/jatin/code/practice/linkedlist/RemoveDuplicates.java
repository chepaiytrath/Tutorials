package com.jatin.code.practice.linkedlist;

import java.util.HashMap;
import java.util.Map;

public class RemoveDuplicates {
	public static void main(String[] args) {
		Node head = new Node(5);
		head.appendToTail(5);
		head.appendToTail(5);
		head.appendToTail(2);
		head.appendToTail(7);
		head.appendToTail(5);
		head.appendToTail(2);
		head.appendToTail(1);
		head.appendToTail(9);

		Node n = head;
		// usingHashMap(n);

		withoutUsingHashMap(n);

		head.printAllNext();

	}

	private static void withoutUsingHashMap(Node head) {
		if(head == null) { return; }
		
		Node previous = head;
		Node current = head.getNext();
		
		while(current != null) {
			Node runner = head;
			while(runner != current) {
				if(runner.getData() == current.getData()) {
					previous.setNext(current.getNext());
					current = current.getNext();
					break;
				}
				runner = runner.getNext();
			}
			
			if(runner == current) {
				previous = current;
				current = current.getNext();
			}
			
		}
		
	}

	private static void usingHashMap(Node n) {
		Map<Integer, Boolean> map = new HashMap<Integer, Boolean>();
		Node prev = null;
		while (n != null) {
			if (map.containsKey(n.getData())) {
				prev.setNext(n.getNext());
			} else {
				map.put(n.getData(), true);
				prev = n;
			}
			n = n.getNext();
		}
	}
}
