package com.practice.ds.linkedlist;

public class MainClass {
	public static void main(String args[]){
		SinglyLinkedList<Integer> sl = new SinglyLinkedList<Integer>();
		
		//Add to the end of the list
		sl.addEnd(10);
		sl.addEnd(3);
        sl.addEnd(32);
        sl.addEnd(54);
        sl.addEnd(29);
        sl.addEnd(13);
        
        sl.traverse();
        
        //Add after an element in the list
        sl.addAfter(76, 54); 

        sl.traverse();
        
        sl.addAfter(76, 5); //See if element does not exists
        
        //Add at an index in the list
        sl.addAtIndex(21, 4); 
        
        sl.traverse();
       
       //Remove from the front of the list
        sl.deleteFront();
        
        sl.traverse();
        
       //Remove at the given index in the list
        sl.deleteAfter(76);
        
        sl.traverse();
        
        //Remove at an index in the list
        sl.deleteAtIndex(2); 
        
        sl.traverse();
	}
}
