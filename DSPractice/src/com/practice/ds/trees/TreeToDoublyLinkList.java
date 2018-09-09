package com.practice.ds.trees;

public class TreeToDoublyLinkList {
	public static void main(String args[]) {
		TreeNode root = new TreeNode(2);
		root.left = new TreeNode(3);
		root.right = new TreeNode(4);
		root.left.left = new TreeNode(8);
		root.left.right = new TreeNode(89);
		root.left.left.left = new TreeNode(23);
		root.right.left = new TreeNode(43);

		System.out.println("tree:");
		TreeNode.inOrder(root); // 1 2 3 4 5
		System.out.println();

		System.out.println("list:");
		TreeNode head = treeToList(root);
		printList(head);
	}

	/*
	 * helper function -- given two listTreeNodes, join them together so the
	 * second immediately follow the first. Sets the .next of the first and the
	 * .previous of the second.
	 */
	public static void join(TreeNode a, TreeNode b) {
		a.right = b;
		b.left = a;
	}

	/*
	 * helper function -- given two circular doubly linked lists, append them
	 * and return the new list.
	 */
	public static TreeNode append(TreeNode a, TreeNode b) {
		// if either is null, return the other
		if (a == null)
			return (b);
		if (b == null)
			return (a);

		// find the lastTreeNode in each using the .previous pointer
		TreeNode aLast = a.left;
		TreeNode bLast = b.left;

		// join the two together to make it connected and circular
		join(aLast, b);
		join(bLast, a);

		return (a);
	}

	/*
	 * --Recursion-- Given an ordered binary tree, recursively change it into a
	 * circular doubly linked list which is returned.
	 */
	public static TreeNode treeToList(TreeNode root) {
		// base case: empty tree -> empty list
		if (root == null)
			return (null);

		// Recursively do the subtrees (leap of faith!)
		TreeNode aList = treeToList(root.left);
		TreeNode bList = treeToList(root.right);

		// Make the single rootTreeNode into a list length-1
		// in preparation for the appending
		root.left = root;
		root.right = root;

		// At this point we have three lists, and it's
		// just a matter of appending them together
		// in the right order (aList, root, bList)
		aList = append(aList, root);
		aList = append(aList, bList);

		return (aList);
	}

	/*
	 * Given a non-empty tree, insert a newTreeNode in the proper place. The
	 * tree must be non-empty because Java's lack of reference variables makes
	 * that case and this method messier than they should be.
	 */
	public static void treeInsert(TreeNode root, int newData) {
		if (newData <= root.data) {
			if (root.left != null)
				treeInsert(root.left, newData);
			else
				root.left = new TreeNode(newData);
		} else {
			if (root.right != null)
				treeInsert(root.right, newData);
			else
				root.right = new TreeNode(newData);
		}
	}

	// Do a traversal of the list and print it out
	public static void printList(TreeNode head) {
		TreeNode current = head;

		while (current != null) {
			System.out.print(Integer.toString(current.data) + " ");
			current = current.right;
			if (current == head)
				break;
		}

		System.out.println();
	}

}
