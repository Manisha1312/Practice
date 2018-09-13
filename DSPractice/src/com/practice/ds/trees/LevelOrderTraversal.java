package com.practice.ds.trees;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversal {

	public static void main(String args[]) {
		TreeNode root = new TreeNode(2);
		root.left = new TreeNode(3);
		root.right = new TreeNode(4);
		root.left.left = new TreeNode(8);
		root.left.right = new TreeNode(89);
		root.left.left.left = new TreeNode(23);
		root.right.left = new TreeNode(43);

//		System.out.println("In Order Traversal :");
//		TreeNode.inOrder(root);
//		
//		System.out.println("pre Order Traversal :");
//		TreeNode.preOrder(root);
		
		
		
		System.out.println("Level Order Traversal :");
		levelOrderTraversal(root);
		

		int h = TreeNode.height(root);

		max_level = h + 1;
		rightViewUtil(root, 1);
		System.out.println("");
		max_level = h + 1;
		leftViewUtil(root, 1);

		printLeftLevelNode(root, 1, h);
		System.out.println("");
		printRightLevelNode(root, 1, h);
		System.out.println("");
	}

	private static void levelOrderTraversal(TreeNode root) {
	//UsingQueue(root);
		Recursively(root);
	}
	
	private static void Recursively(TreeNode root) {
		int h = TreeNode.height(root);
//		for (int i = h; i >= 1; i--) {
//			printlevelnodes(root, i);
//			System.out.println("");
//		}
		
		for (int i = 1; i <= h ; i++) {
			printlevelnodes(root, i);
			System.out.println("");
		}
		
	}

	private static void UsingQueue(TreeNode root) {
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		while (!q.isEmpty()) {
			TreeNode temp = q.remove();
			if (temp != null) {
				System.out.println("" + temp.data);
				q.add(temp.left);
				q.add(temp.right);
			}
		}
	}

	static int max_level = 0;

	private static void rightViewUtil(TreeNode root, int level) {
		// Base Case
		if (root == null)
			return;

		// If this is the last Node of its level

		// Recur for right subtree first, then left subtree
		rightViewUtil(root.right, level + 1);
		rightViewUtil(root.left, level + 1);
		if (max_level > level) {
			System.out.print(" " + root.data);
			max_level = level;
		}
	}

	private static void leftViewUtil(TreeNode root, int level) {
		// Base Case
		if (root == null)
			return;

		// Recur for right subtree first, then left subtree
		leftViewUtil(root.left, level + 1);
		leftViewUtil(root.right, level + 1);

		// If this is the last Node of its level
		if (max_level > level) {
			System.out.print(" " + root.data);
			max_level = level;
		}
	}

	private static void printLeftLevelNode(TreeNode root, int level, int height) {
		if (root != null) {
			System.out.print(" " + root.data);
			if (root.left != null) {
				printLeftLevelNode(root.left, level + 1, height);
			} else if (root.right != null) {
				printLeftLevelNode(root.right, level + 1, height);
			}
		}
	}

	private static void printRightLevelNode(TreeNode root, int level, int height) {
		if (root != null) {
			System.out.print(" " + root.data);
			if (root.right != null) {
				printLeftLevelNode(root.right, level + 1, height);
			} else if (root.left != null) {
				printLeftLevelNode(root.left, level + 1, height);
			}
		}
	}

//	private static void printlevelnodes(TreeNode root, int level) {
//		if (root == null)
//			return;
//		if (level == 1)
//			System.out.print(" " + root.data);
//		else {
//			level--;
//			printlevelnodes(root.left, level);
//			printlevelnodes(root.right, level);
//		}
//	}
	
	private static void printlevelnodes(TreeNode root, int level) {
		if (root == null)
			return;
		if (level == 1)
			System.out.print(" " + root.data);
		else {
			level--;
			printlevelnodes(root.right, level);
			printlevelnodes(root.left, level);
		}
	}
}
