package com.practice.ds.trees;

import java.util.ArrayList;
import java.util.Scanner;

public class MirrorTree {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for (int j = 0; j < t; j++) {
			long n = in.nextLong();
			int[] arrival = new int[(int) (n + 1)];
			for (int i = 1; i <= n; i++) {
				arrival[i] = in.nextInt();
			}
			TreeNode root = TreeNode.insert(arrival, 1, n);
			mirror(root);
			TreeNode.inOrder(root);
			System.out.println("");
		}

	}

	private static void mirror(TreeNode root) {
		TreeNode m = null;
		if (root == null) {
			return;
		} else {
			mirror(root.left);
			mirror(root.right);
			m = root.left;
			root.left = root.right;
			root.right = m;
		}

	}

}