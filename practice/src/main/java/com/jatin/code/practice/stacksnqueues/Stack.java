package com.jatin.code.practice.stacksnqueues;

import com.jatin.code.practice.linkedlist.Node;

public class Stack {
	private Node top;

	public Stack() {
		top = null;
	}

	public void push(int data) {
		Node n = new Node(data);
		n.setNext(top);
		top = n;
	}

	public Node pop() {
		if (top != null) {
			Node x = top;
			top = top.getNext();
			return x;
		}
		return null;
	}
}
