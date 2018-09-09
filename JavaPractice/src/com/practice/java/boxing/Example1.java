package com.practice.java.boxing;

//Normal boxing and unboxing by assinging int to integer and charceter to char respectively.
public class Example1 {
	    public static void main (String[] args)
	    {
	        // creating an Integer Object
	        // with value 10.
	        Integer i = new Integer(10);
	 
	        // unboxing the Object
	        int i1 = i;
	 
	        System.out.println("Value of i: " + i);
	        System.out.println("Value of i1: " + i1);
	 
	        //Autoboxing of char
	        Character a = 'a';
	 
	        // Auto-unboxing of Character
	        char ch = a;
	        System.out.println("Value of ch: " + ch);
	        System.out.println("Value of a: " + a);
	 
	    }
}
