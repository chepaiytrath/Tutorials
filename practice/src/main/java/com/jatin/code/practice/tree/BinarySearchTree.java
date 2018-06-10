package com.jatin.code.practice.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinarySearchTree {
	private Node root;

	public Node getRoot() {
		return root;
	}

	public void setRoot(Node root) {
		this.root = root;
	}

	public void insert(int x) {
		this.root = putNode(this.root, x);
	}

	private Node putNode(Node node, int x) {
		if (null == node) {
			return new Node(x);
		}
		if (x < node.getData()) {
			node.setLeft(putNode(node.getLeft(), x));
		} else if (x > node.getData()) {
			node.setRight(putNode(node.getRight(), x));
		}
		return node;
	}

	public void viewInOrder() {
		showInOrder(this.root);
	}

	private void showInOrder(Node node) {
		if (null != node) {
			showInOrder(node.getLeft());
			System.out.println(node.getData());
			showInOrder(node.getRight());
		}
	}

	public void viewPreOrder() {
		showPreOrder(this.root);
	}

	private void showPreOrder(Node node) {
		if (null != node) {
			System.out.println(node.getData());
			showPreOrder(node.getLeft());
			showPreOrder(node.getRight());
		}
	}

	public void viewPostOrder() {
		showPostOrder(this.root);
	}

	private void showPostOrder(Node node) {
		if (null != node) {
			showPostOrder(node.getLeft());
			showPostOrder(node.getRight());
			System.out.println(node.getData());
		}
	}

	public void viewBFS() {
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);

		while (!queue.isEmpty()) {
			Node node = queue.poll();
			if (node != null) {
				System.out.println(node.getData());
				queue.add(node.getLeft());
				queue.add(node.getRight());
			}

		}
	}

	public int findMin() {
		Node node = root;
		while (null != node && null != node.getLeft()) {
			node = node.getLeft();
		}
		return node.getData();
	}

	public int findMax() {
		Node node = root;
		while (null != node && null != node.getRight()) {
			node = node.getRight();
		}
		return node.getData();
	}

	public int findHeight() {
		return height(this.root);
	}

	private int height(Node node) {
		if (null == node) {
			return 0;
		}
		return 1 + Math.max(height(node.getLeft()), height(node.getLeft()));
	}

	public boolean checkIfBST() {
		return checkBST(this.root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	private boolean checkBST(Node node, int minValue, int maxValue) {
		if(null == node) {
			return true;
		}
		
		if(minValue < node.getData() && node.getData() > maxValue) {
			return false;
		}
		
		return(checkBST(node.getLeft(), minValue, node.getData())
				&& checkBST(node.getRight(), node.getData(), maxValue));
	}
	

}