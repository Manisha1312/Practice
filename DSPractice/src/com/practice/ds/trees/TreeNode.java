package com.practice.ds.trees;

public class TreeNode {
	public int data;
	public TreeNode left;
	public TreeNode right;
	public TreeNode parent;

	public TreeNode(int data) {
		this.data = data;
	}

	public void setLeftChild(TreeNode left) {
		this.left = left;
		if (left != null) {
			left.parent = this;
		}
	}

	public void setRightChild(TreeNode right) {
		this.right = right;
		if (right != null) {
			right.parent = this;
		}
	}
	
	public static TreeNode insert(int arr[],int i,long size){
		TreeNode n = null;	
		if(i<=size){
			n = new TreeNode(arr[i]);
			n.setLeftChild(insert(arr,2*i,size));
			n.setRightChild(insert(arr,(2*i)+1,size));}
		return n;
	}
	
	public static void inOrder(TreeNode root){
		if(root==null) return;
		inOrder(root.left);
		System.out.println(""+root.data);
		inOrder(root.right);
	}
	
	public static int size(TreeNode root){
		if(root==null){
			return 0;
		}else{
			return(size(root.left)+size(root.right)+1);
		}
	}

	public static int height(TreeNode root){
		int leftHt = root.left!=null?height(root.left):0;
		int rightHt = root.right!=null?height(root.right):0;
		return(1+Math.max(leftHt, rightHt));
		
	}
	
}
