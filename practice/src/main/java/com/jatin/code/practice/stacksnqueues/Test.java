package com.jatin.code.practice.stacksnqueues;

import com.jatin.code.practice.linkedlist.Node;

public class Test {
	public static void main(String[] args) {
		Queue q = new Queue();
		q.insert(1);
		q.insert(2);
		q.insert(3);
		q.printQueueElements();
		System.out.println();
		
		Node x = q.remove();
		q.printQueueElements();
		System.out.println();
		
		x.setData(0);
		q.printQueueElements();
		System.out.println();
	}
}
