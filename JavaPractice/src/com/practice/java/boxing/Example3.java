package com.practice.java.boxing;

import java.util.ArrayList;
import java.util.List;

public class Example3 {
	public static void main (String[] args)
    {
        /* Here we are creating a list
          of elements of Integer type.
          adding the int primitives type values */
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < 10; i++)
            list.add(i);
    }  
}
