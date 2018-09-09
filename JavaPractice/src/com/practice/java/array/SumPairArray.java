package com.practice.java.array;
/*
 * Given an array and a number, check for pair in sum a*/

import java.util.HashSet;
import java.util.Scanner;

public class SumPairArray {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter sum");
		int sum = in.nextInt();
		System.out.println("Enter number of elements in array");
		int n = in.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = in.nextInt();
		}
		printpairs(arr,sum);
	}

	private static void printpairs(int[] arr,int sum) {
		HashSet<Integer> h = new HashSet<Integer>();
		for(int i=0;i<arr.length;i++){
			if(h.contains(sum-arr[i])){
				System.out.println(""+arr[i]+"  "+(sum-arr[i]));
			}
			h.add(arr[i]);
		}
		
	}
}
