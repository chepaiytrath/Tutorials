package com.jatin.code.practice.tree;

public class BinarySearchTreeDemo{
	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();
		bst.insert(15);
		bst.insert(8);
		bst.insert(10);
		bst.insert(-1);
		bst.insert(12);
		bst.insert(17);
		bst.insert(20);
		bst.insert(25);
		
		bst.viewInOrder();
		
		System.out.println("Lowest number in BST is : "+bst.findMin());
		
		System.out.println("Highest number in BST is : "+bst.findMax());
		
		System.out.println("Height of BST is : "+bst.findHeight());
		
		
		
	}
}