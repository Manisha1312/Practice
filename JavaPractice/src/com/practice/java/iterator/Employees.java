package com.practice.java.iterator;

import java.util.ArrayList;
import java.util.List;

public class Employees {

	private List<Employee> emps = null;

	public Employees(){
		emps = new ArrayList<Employee>();
		emps.add(new Employee(1001,"Rams","Lead", 250000L));
		emps.add(new Employee(1002,"Posa","Dev", 150000L));
		emps.add(new Employee(1003,"Chinni","QA", 150000L));
	}

	public List<Employee> getEmps() {
		return emps;
	}

	public void setEmps(List<Employee> emps) {
		this.emps = emps;
	}

}
