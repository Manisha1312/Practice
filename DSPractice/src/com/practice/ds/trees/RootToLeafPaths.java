package com.practice.ds.trees;


public class RootToLeafPaths {

	public static void main(String args[]) {
		TreeNode root = new TreeNode(2);
		root.left = new TreeNode(3);
		root.right = new TreeNode(4);
		root.left.left = new TreeNode(8);
		root.left.right = new TreeNode(89);
		root.left.left.left = new TreeNode(23);
		root.right.left = new TreeNode(43);
		int[] array = new int[8];
		rootToLeaf(root, array, 0);
	}

	private static void rootToLeaf(TreeNode root, int[] array, int i) {

		if (root == null)
			return;
		if (root.left == null && root.right == null) {
			array[i] = root.data;
			printArray(array, i);
			return;
		}
		array[i] = root.data;
		rootToLeaf(root.left, array, i + 1);
		rootToLeaf(root.right, array, i + 1);
	}

	private static void printArray(int[] array, int i) {
		for (int j = 0; j <= i; j++) {
			System.out.print(array[j]);
			System.out.print(" ");
		}
		System.out.println("\n");
	}
}
