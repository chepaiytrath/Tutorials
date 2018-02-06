package com.jatin.code.practice.linkedlist;

public class BeginningNodeOfCircularLinkedList {
	public static void main(String[] args) {
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		Node node5 = new Node(5);
		Node node6 = new Node(6);
		Node node7 = new Node(7);
		Node node8 = new Node(8);
		Node node9 = new Node(9);
		Node node10 = new Node(10);
		Node node11 = new Node(11);
		
		node11.setNext(node4);
		node10.setNext(node11);
		node9.setNext(node10);
		node8.setNext(node9);
		node7.setNext(node8);
		node6.setNext(node7);
		node5.setNext(node6);
		node4.setNext(node5);
		node3.setNext(node4);
		node2.setNext(node3);
		node1.setNext(node2);

		Node x = findBeginning(node1);
		System.out.println(x);
	}

	private static Node findBeginning(Node head) {
		Node n1 = head;
		Node n2 = head;

		// Find meeting point
		while (n2.getNext() != null) {
			n1 = n1.getNext();
			n2 = n2.getNext().getNext();
			if (n1 == n2) {
				break;
			}
		}

		// Error check - there is no meeting point, and therefore no loop
		if (n2.getNext() == null) {
			return null;
		}

		/*
		 * Move n1 to Head. Keep n2 at Meeting Point. Each are k steps /* from the Loop
		 * Start. If they move at the same pace, they must meet at Loop Start.
		 */
		n1 = head;
		while (n1 != n2) {
			n1 = n1.getNext();
			n2 = n2.getNext();
		}
		// Now n2 points to the start of the loop.
		return n2;
	}
}