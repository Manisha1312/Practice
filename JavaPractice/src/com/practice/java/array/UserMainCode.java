package com.practice.java.array;

import java.util.Scanner;

public class UserMainCode {

	private static int output1;
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int input1 = in.nextInt();
		int[] input2 = new int[input1];
		for (int i = 0; i < input1; i++) {
			input2[i] = in.nextInt();
		}
		findSeriesNext(input2);
		//printArray(arr);
		in.close();
	}

	private static void findSeriesNext(int[] a) {

	    if(CheckAP(a) == 1)
	    {
	    }else if(CheckGP(a) == 1){}
	    else {
	    	// CheckFib(a);
	    }
	}

	public static int CheckAP(int[] a)
	{
	    int iDiff=a[1]-a[0];
	    for(int i=0;i<a.length-1;i++)
	    {
	        if((a[i+1]-a[i])!=iDiff)
	            return -1;
	    }
	    output1 = a[a.length-1]+iDiff;
	    return 1;
	}

	public static int CheckGP(int[] a)
	{
	    int iRatio=a[1]/a[0];
	    for(int i=0;i<a.length-1;i++)
	    {
	        if((a[i+1]/a[i])!=iRatio)
	            return -1;
	    }
	    output1=a[a.length-1]*iRatio;
	    return 1;
	}
}
