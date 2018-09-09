package com.practice.ds.graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class BFSConnectedGraph {
	public static void main(String args[]) throws Exception {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = in.nextInt();
		}
		BFS(arr);
		in.close();
	}

	private static void BFS(int[] arr) {
		for(int i:solution(arr))
			System.out.print(i+",");
		//levelOrderTraversal(root);
	}
	
	private static int[] solution(int[] T) {
		int number_of_edges,number_of_vertices;
        number_of_vertices = T.length;
        number_of_edges = T.length-1;
        int[] output = new int[number_of_edges];
        Map<Integer, List<Integer>> Adjacency_List = new HashMap<Integer, List<Integer>>();
        int root =0;
        for (int i = 0 ; i <number_of_vertices ; i++)
        {
        	if(T[i]==i){
        		root =i;

        	} else {
        		if(Adjacency_List.containsKey(T[i])){
        			List temp = Adjacency_List.get(T[i]);
        			temp.add(i);
        			Adjacency_List.put(T[i], temp);
        		}else{
        			List temp = new LinkedList<Integer>();
        			temp.add(i);
        			Adjacency_List.put(T[i], temp);
        		}
        	}
        	T[i]=0;
        }
       List<Integer> queue = new LinkedList<Integer>();
       queue.add(root);
    // int level =0;int nxtLcChange =0;
       while(queue.size()>0)
       {
    	   int parent = queue.remove(0);
    	   List<Integer> temp = Adjacency_List.get(parent);
    	//   if(nxtLcChange)
    	   if(temp!=null)
    	   for(Integer a:temp)
    	   {
    		   
    		   queue.add(a);
    		   T[a] = T[parent]+1;
    		   output[T[a]-1] = output[T[a]-1]+1;
    		  
    		
    	   }
       }
		return output;
	}

}
