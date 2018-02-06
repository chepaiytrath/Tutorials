package com.jatin.code.practice.misc;

public class LinkedList {
	class Node {
		private int data;
		private Node next;

		public Node(int i) {
			this.data = i;
			this.next = null;
		}

		public int getData() {
			return data;
		}

		public void setData(int data) {
			this.data = data;
		}

		public Node getNext() {
			return next;
		}

		public void setNext(Node next) {
			this.next = next;
		}

		@Override
		public String toString() {
			return "[" + data + "->" + next + "]";
		}

	}

	Node head = null;

	public LinkedList() {
		super();
	}

	public Node getHead() {
		return head;
	}

	public void setHead(Node head) {
		this.head = head;
	}

	public void printLinkedList() {
		Node n = head;
		while (n != null) {
			System.out.print(n.getData() + "   ");
			n = n.getNext();
		}
	}
	Node newNode(int data){
		return new Node(data);
	}
	
	private static void addInSortedLinkedList(Node node, LinkedList list) {
		Node head = list.getHead();
		Node curr = head;

		if (null == curr || node.getData() <= curr.getData()) {
			node.setNext(curr);
			list.setHead(node);
			return;
		}
		while (curr.getNext() != null && curr.getNext().getData() < node.getData()) {
			curr = curr.getNext();
		}
		node.setNext(curr.getNext());
		curr.setNext(node);
	}

	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		addInSortedLinkedList(list.newNode(5), list);
		list.printLinkedList();
		System.out.println();
		addInSortedLinkedList(list.newNode(4), list);
		list.printLinkedList();
		System.out.println();
		addInSortedLinkedList(list.newNode(7), list);
		list.printLinkedList();
		System.out.println();
		addInSortedLinkedList(list.newNode(6), list);
		list.printLinkedList();
		System.out.println();
		addInSortedLinkedList(list.newNode(10), list);
		list.printLinkedList();
		System.out.println();
	}

}
