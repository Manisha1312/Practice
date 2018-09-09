package com.practice.java.array;

import java.util.Scanner;

public class SplitArray {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = in.nextInt();
		}
		//findMax(arr);
		findMax1(arr);
		in.close();
	}

	private static void findMax(int[] arr) {
		int maxDiff = Integer.MIN_VALUE;
		for(int i =0 ;i < arr.length - 1 ;i++){
			int maxLeft = Integer.MIN_VALUE;
			int maxRight = Integer.MIN_VALUE;
			int k =0;
			int j = i+1;
			while(k<=i){
				if(arr[k]>maxLeft)
				{
					maxLeft=arr[k];
				}
				k++;
			}
			while(j<arr.length){
				if(arr[j]>maxRight)
				{
					maxRight = arr[j];
				}
				j++;
			}
			if(maxDiff < Math.abs(maxLeft-maxRight))
			maxDiff = Math.abs(maxLeft-maxRight);
		}
		System.out.println("maxDifference :- " + maxDiff);
	}
	
	private static void findMax1(int[] A) {
        int[] maxLeft = new int[A.length];
    	maxLeft[0] = A[0];
    	int len = A.length-1;
    	int currentMaxLeft = Integer.MIN_VALUE;
    	
    	for(int i = 1; i <= len; i++) {
    		currentMaxLeft = A[i];
    		if(currentMaxLeft > maxLeft[i-1]){
    			maxLeft[i] = currentMaxLeft;
    		}else{
    			maxLeft[i] = maxLeft[i-1];
    		}
    	}
    	
    	int[] maxRight = new int[A.length];
    	maxRight[len] = A[len];
    	currentMaxLeft = Integer.MIN_VALUE;
    	
    	for(int i = len-1; i >= 0; i--) {
    		currentMaxLeft = A[i];
    		if(currentMaxLeft > maxRight[i+1]) {
    			maxRight[i] = currentMaxLeft;
    		} else {
    			maxRight[i] = maxRight[i+1];
    		}
    	}

    	int maxDiff = Integer.MIN_VALUE;
    	for(int i = 0; i <= len; i++) {
    		int currMax = Math.abs(maxLeft[i]-maxRight[i]);
    		if(currMax > maxDiff) {
    			maxDiff = currMax;
    		}
    	}
    	System.out.println("Ans :- " + maxDiff);
    }

	static void printArray(int arr[]) {
		for (int i = 0; i < arr.length; i++) {
			System.out.println("" + arr[i]);
		}
	}
}
