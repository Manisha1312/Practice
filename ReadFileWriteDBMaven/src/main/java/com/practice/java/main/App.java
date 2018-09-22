package com.practice.java.main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//import com.practice.java.db.JdbcPersonDAO;
//import com.practice.java.db.Person;
//import com.practice.java.db.PersonDAO;
import com.practice.java.db.jpa.*;
import com.practice.java.file.FilesDemos;

public class App {
	public static void main(String[] args) throws IOException {

//	    PersonDAO dao = new JdbcPersonDAO();
	    PersonDAO dao = new JpaPersonDAO();
//		List<String> personsString = FilesDemos.getListFromFile();

		List<Person> personObject = new ArrayList<>();
//		for (String p : personsString) {
//			String[] s = p.split(":");
//			personObject.add(new Person(Integer.valueOf(s[0]),s[1]));
//		}
//		
//		for (Person person : personObject) {
//			dao.save(person);
//		}
		
		personObject = dao.findAll();
		for (Person person : personObject) {
			FilesDemos.writeIntoFile(person.toString()+"\n");
		}
	}
}

