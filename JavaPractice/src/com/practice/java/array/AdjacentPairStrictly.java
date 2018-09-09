package com.practice.java.array;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class AdjacentPairStrictly {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = in.nextInt();
		}
		findMax1(arr);
		in.close();
	}
	
	private static void findMax1(int[] A) {
		HashMap<Integer, LinkedList<Integer>> h = new HashMap<Integer, LinkedList<Integer>>();
		// data[] d = new data[arr.length];
		LinkedList<Integer> index = new LinkedList<Integer>();
		for (int i = 0; i < A.length; i++) {
			if (h.containsKey(A[i])) {
				h.get(A[i]).add(i);
				h.put(A[i], (h.get(A[i])));
			} else {
				index = new LinkedList<Integer>();
				index.add(i);
				h.put(A[i], index);
			}
		}
		Map<Integer, LinkedList<Integer>> t = new TreeMap<Integer, LinkedList<Integer>>(h);
				
		Iterator<Map.Entry<Integer, LinkedList<Integer> >> iterator2 = t.entrySet().iterator();
		Map.Entry<Integer, LinkedList<Integer> > previousEntry = null,currentEntry;
		if(iterator2.hasNext()){
			previousEntry = iterator2.next();
		}
		int m1,m2,currentMax,max=0;
		while(iterator2.hasNext()){
			currentEntry = iterator2.next();
			m1 = Math.abs(Collections.max(previousEntry.getValue()) - Collections.min(currentEntry.getValue()));
			m2 = Math.abs(Collections.max(currentEntry.getValue()) - Collections.min(previousEntry.getValue()));
			currentMax = m1<m2?m2:m1;
			max = currentMax<max?max:currentMax;
			previousEntry = currentEntry;
			
		}
		System.out.println(max);

		
	}

	private static void printMap(Map<Integer, LinkedList<Integer>> t) {
		Iterator<Integer> iterator = t.keySet().iterator();
		while (iterator.hasNext()) {
			Integer key = (Integer) iterator.next();
			System.out.println(key + " ->" + t.get(key));
		}
		
	}

	static void printArray(int arr[]) {
		for (int i = 0; i < arr.length; i++) {
			System.out.println("" + arr[i]);
		}
	}


}