package com.jatin.code.practice.stacksnqueues;

import com.jatin.code.practice.linkedlist.Node;

public class Queue {
	private Node front;
	private Node rear;
	private int size;
	
	public Queue() {
		front = null;
		rear = null;
		size = 0;
	}

	public boolean isEmpty(){
		return size==0;
	}
	
	public void insert(int data) {
		Node n = new Node(data);
		if(isEmpty()) {
			front = n;
			rear = n;
		}else {
			rear.setNext(n);
			rear = rear.getNext();
		}
		size++;
	}

	public Node remove() {
		if(isEmpty()) {
			return null;
		}
		Node n = front;
		front = front.getNext();
		if(front == null) {
			rear = null;
		}
		size--;		
		return n;
	}
	
	public Node peek() {
		return new Node(front.getData());
	}
	
	public void printQueueElements() {
		Node curr = front;
		while(curr != null) {
			System.out.print(curr.getData() + " ");
			curr = curr.getNext();
		}
	}
}
