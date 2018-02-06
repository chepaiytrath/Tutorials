package com.jatin.code.practice.linkedlist;

public class nthLastElement {
	public static void main(String[] args) {
		Node head = new Node(5);
		head.appendToTail(2);
		head.appendToTail(7);
		head.appendToTail(1);
		head.appendToTail(4);
		head.appendToTail(6);
		
		Node x = usingPointers(head, 3);
		System.out.println(x.getData());
	}

	private static Node usingPointers(Node head, int n) {
		Node p1 = head;
		Node p2 = p1;
		for(int i = 1; i < n; i++) {
			p2 = p2.getNext();
		}
		while(p2.getNext() != null) {
			p2 = p2.getNext();
			p1 = p1.getNext();
		}
		return p1;
	}
}
