package com.practice.java.array;
/*program to find the sum of contiguous subarray within
a one-dimensional array of numbers which has the largest sum*/

import java.util.Scanner;

public class MaximumSubArraySum {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = in.nextInt();
		}
		maxSubArraySum(arr);
		in.close();
	}

	private static void maxSubArraySum(int[] arr) {
		int maxsum = 0;
		int currentsum = 0;
		for (int i = 0; i < arr.length; i++) {
			currentsum += arr[i];
			if (currentsum > 0) {
				if (maxsum < currentsum)
					maxsum = currentsum;
			} else {
				currentsum = 0;
			}
		}
		System.out.println("MaximumSum :- "+maxsum);
	}
}
