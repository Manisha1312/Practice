package com.practice.java.iterator;

import java.util.Iterator;

public class Example4 {
	public static void main(String args[]) {
		Employees emps = new Employees();

		Iterator itr = emps.getEmps().iterator();

		while (itr.hasNext()) {
			System.out.println("Employee detail : " + itr.next());
		}
	}
}
