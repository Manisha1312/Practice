package com.practice.java.array;
/*Find the first repeating element in an array of integers*/

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ArrayFirstRepeating {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = in.nextInt();
		}
		printFirstRepeating(arr);
		//printArray(arr);
		in.close();
	}

	private static void printFirstRepeating(int[] arr) {
		Set<Integer> h = new HashSet<Integer>();
		for (int i = 0; i < arr.length; i++) {
			if (h.contains(arr[i])) {
				System.out.println("Repeated Character :" + arr[i]);
				return;
			}
			h.add(arr[i]);
		}
		System.out.println("No Repeating Characters");
	}

	static void printArray(int arr[]) {
		for (int i = 0; i < arr.length; i++) {
			System.out.println("" + arr[i]);
		}
	}
}
