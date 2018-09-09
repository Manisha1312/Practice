package com.practice.java.array;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class sortFrequencyArray {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		// int n = in.nextInt();
		int[] arr = { 5, 2, 5, 8, 2, 6, 8, 8 };
		/*
		 * for(int i=0;i<n;i++){ arr[i]=in.nextInt(); }
		 */
		sortFrequency(arr);
	}

	private static void sortFrequency(int[] arr) {
		HashMap<Integer, Integer> h = new HashMap<Integer, Integer>();
		// data[] d = new data[arr.length];
		for (int i = 0; i < arr.length; i++) {
			if (h.containsKey(arr[i])) {
				h.put(arr[i], (h.get(arr[i]) + 1));
			} else {
				h.put(arr[i], 1);
			}
		}
		h = sortByValues(h);
		// Get the iterator for key set of the map
		Iterator<Integer> iterator = h.keySet().iterator();
		while (iterator.hasNext()) {
			Integer key = (Integer) iterator.next();
			System.out.println(key + " ->" + h.get(key));
		}

	}

	private static HashMap sortByValues(HashMap map) {
		List list = new LinkedList(map.entrySet());
		// Defined Custom Comparator here
		Collections.sort(list, new Comparator() {
			public int compare(Object o1, Object o2) {
				return ((Comparable) ((Map.Entry) (o1)).getValue())
						.compareTo(((Map.Entry) (o2)).getValue());
			}
		});
		// Here I am copying the sorted list in HashMap
		// using LinkedHashMap to preserve the insertion order
		HashMap sortedHashMap = new LinkedHashMap();
		for (Iterator it = list.iterator(); it.hasNext();) {
			Map.Entry entry = (Map.Entry) it.next();
			sortedHashMap.put(entry.getKey(), entry.getValue());
		}
		return sortedHashMap;
	}

	public class data implements Comparable<data> {
		int val;
		int frequency;

		data(int val, int freq) {
			this.val = val;
			this.frequency = freq;
		}

		int getVal() {
			return this.val;
		}

		int getFrequency() {
			return this.frequency;
		}

		@Override
		public int compareTo(data o) {

			// ascending order
			return frequency - o.getFrequency();
		}

	}
}
