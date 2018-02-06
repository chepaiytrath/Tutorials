package com.jatin.code.practice.tree;

public class Node {

	private int data;
	private Node left;
	private Node right;

	public Node(int d) {
		this.data = d;
		left = right = null;
	}

	public Node(Node n) {
		this.data = n.getData();
		this.left = (null != n.getLeft()) ? new Node(n.getLeft().getData()) : null;
		this.right = (null != n.getRight()) ? new Node(n.getRight().getData()) : null;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public Node getLeft() {
		return left;
	}

	public void setLeft(Node left) {
		this.left = left;
	}

	public Node getRight() {
		return right;
	}

	public void setRight(Node right) {
		this.right = right;
	}
}
