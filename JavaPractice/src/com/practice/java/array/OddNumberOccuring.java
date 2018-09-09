package com.practice.java.array;
import java.util.Scanner;

/*Find the Number Occurring Odd Number of Times*/
public class OddNumberOccuring {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = in.nextInt();
		}
		oddOccurence(arr);
	}

	private static void oddOccurence(int[] arr) {
		int res=0;
		for (int i = 0; i < arr.length; i++) {
			res = res ^ arr[i];
		}
		System.out.println(""+res);
	}
}
