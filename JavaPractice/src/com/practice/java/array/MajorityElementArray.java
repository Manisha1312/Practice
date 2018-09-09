package com.practice.java.array;
import java.util.HashMap;
import java.util.Map;

/*A majority element in an array A[] of 
 size n is an element that appears more than n/2 times
 */

public class MajorityElementArray {
	public static void main(String args[]) {
		int[] arr = { 2, 5, 25, 2, 2, 3, 2, 1, 2, 2, 2, 1, 9, 24 };
		majorityElement(arr);
	}

	private static void majorityElement(int[] arr) {
		Map<Integer, Integer> h = new HashMap<Integer, Integer>();
		for (int i = 0; i < arr.length; i++) {
			if (h.containsKey(arr[i])) {
				h.put(arr[i], (h.get(arr[i])) + 1);
			} else {
				h.put(arr[i], 1);
			}

			if (h.containsValue((arr.length / 2) + 1)) {
				System.out.println("" + arr[i]);
				return;
			}
		}
		System.out.println("No Majority Element");
	}
}
