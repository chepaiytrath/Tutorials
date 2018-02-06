package com.jatin.code.practice.linkedlist;

public class Node {
	private int data;
	private Node next = null;

	public Node(int data) {
		this.data = data;
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

	public void appendToTail(int data){
		Node n = this;
		Node end = new Node(data);
		while(n.next != null) {
			n = n.next;
		}
		n.next = end;
	}
	
	void printAllNext() {
		Node x = this;
		while(x != null) {
			System.out.print(x.data + "\t");
			x = x.next;
		}
	}

	@Override
	public String toString() {
		return "Node [data=" + data +"]";
	}
	
}
