package com.jatin.code.practice.linkedlist;

public class SumOfNumbersInLinkedList {
	public static void main(String[] args) {
		Node head1 = new Node(3);
		head1.appendToTail(9);
		head1.appendToTail(1);

		Node head2 = new Node(8);
		head2.appendToTail(1);
		head2.appendToTail(9);

		Node result = usingRecursion(head1, head2, 0);

		result.printAllNext();
	}

	private static Node usingRecursion(Node head1, Node head2, int carry) { // fails if last digit has sum more than 10
		Node result = new Node(carry);
		if (head1 == null && head2 == null && !(carry > 0)) {
			return null;
		}
		int sum = carry;

		if (head1 != null) {
			sum += head1.getData();
		}
		if (head2 != null) {
			sum += head2.getData();
		}
		result.setData(sum % 10);
		result.setNext(usingRecursion(head1 == null ? null : head1.getNext(), head2 == null ? null : head2.getNext(),
				sum > 9 ? 1 : 0));
		return result;
	}
}
