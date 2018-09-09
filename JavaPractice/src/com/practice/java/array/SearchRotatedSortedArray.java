package com.practice.java.array;
/*Search an element in a rotated sorted array
 */

public class SearchRotatedSortedArray {
	public static void main(String args[]) {
		int[] arr = { 3, 3, 3, 3, 3, 3, 2, 3, 3 };
		int key = 2;
		bsearchRotatedArray(arr, key, 0, arr.length - 1);
	}

	private static void bsearchRotatedArray(int[] arr, int key, int low,
			int high) {
		if (low > high) {
			System.out.println("Element not found");
			return;
		}
		int mid = (low + high) / 2;
		if (arr[mid] == key) {
			System.out.println("Element " + arr[mid] + " found at index "
					+ (mid + 1));
			return;
		} else if (arr[low] < arr[high]) {
			if (arr[mid] < key) {
				bsearchRotatedArray(arr, key, mid + 1, high);
			} else {
				bsearchRotatedArray(arr, key, low, mid - 1);
			}
		} else {
			if (arr[mid] > arr[low]) {
				if (key >= arr[low] && key <= arr[mid - 1]) {
					bsearchRotatedArray(arr, key, low, mid - 1);
				} else {
					bsearchRotatedArray(arr, key, mid + 1, high);
				}
			} else {
				if (key >= arr[mid + 1] && key <= arr[high]) {
					bsearchRotatedArray(arr, key, mid + 1, high);
				} else {
					bsearchRotatedArray(arr, key, low, mid - 1);
				}
			}
		}
		
	}
}
