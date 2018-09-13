package com.practice.ds.trees;

import java.util.LinkedList;

public class BinarySearchTree {

	private class QueueNode {
		BinarySearchTreeNode treeNode;
		int level;

		QueueNode(BinarySearchTreeNode treeNode, int level) {
			this.treeNode = treeNode;
			this.level = level;
		}
	}

	private class BinarySearchTreeNode {
		int data;
		BinarySearchTreeNode left;
		BinarySearchTreeNode right;

		BinarySearchTreeNode(int data) {
			this.data = data;
		}
	}

	BinarySearchTreeNode root;

	// default value for root node is 9
	BinarySearchTree() {
		this.root = new BinarySearchTreeNode(9);
	}

	BinarySearchTree(int rootValue) {
		this.root = new BinarySearchTreeNode(rootValue);
	}

	private BinarySearchTreeNode search(BinarySearchTreeNode node, int key) {
		if (node == null) // base case
		{
			return null;
		}

		BinarySearchTreeNode searchedNode = null;

		if (key == node.data) // key found!
		{
			searchedNode = node;
		} else if (key < node.data) // search key into left sub-tree
		{
			searchedNode = search(node.left, key);
		} else if (key > node.data) // search key into right sub-tree
		{
			searchedNode = search(node.right, key);
		}

		return searchedNode;
	}

	public BinarySearchTreeNode search(int key) {
		BinarySearchTreeNode searchedNode = search(this.root, key);

		if (searchedNode == null) {
			System.out.println("\n\nKey not found!");
		} else {
			System.out.println("\n\nKey found!");
		}
		return searchedNode;
	}

	private BinarySearchTreeNode insert(BinarySearchTreeNode node, int key) {
		if (node == null) // base case
		{
			node = new BinarySearchTreeNode(key);
		}

		if (key < node.data) // insert key into left sub-tree
		{
			node.left = insert(node.left, key);
		} else if (key > node.data) // insert key into right sub-tree
		{
			node.right = insert(node.right, key);
		}

		return node;
	}

	public void insert(int key) {
		root = insert(this.root, key);
		return;
	}

	public void printTreeLevelOrder() {
		if (root == null)
			return;

		LinkedList queue = new LinkedList();
		queue.add(new QueueNode(root, 0));

		int maxLevelVisited = -1;

		while (!queue.isEmpty()) {
			QueueNode currentNode = (QueueNode) queue.remove();

			if (currentNode.level > maxLevelVisited) {
				maxLevelVisited = currentNode.level;
				System.out.print("\nlevel-" + currentNode.level + " nodes: ");
			}
			System.out.print(" " + currentNode.treeNode.data);

			if (currentNode.treeNode.left != null) {
				queue.add(new QueueNode(currentNode.treeNode.left, currentNode.level + 1));
			}

			if (currentNode.treeNode.right != null) {
				queue.add(new QueueNode(currentNode.treeNode.right, currentNode.level + 1));
			}
		}
	}

	public static void main(String[] args) {
		BinarySearchTree tree = new BinarySearchTree(3);

		tree.insert(1);
		tree.insert(5);
		tree.insert(0);
		tree.insert(2);
		tree.insert(4);

		/*
		 * 3 1 5 0 2 4
		 * 
		 */

		System.out.print("BinarySearch tree level order traversal:");
		tree.printTreeLevelOrder();

		tree.search(3);
	}

}
