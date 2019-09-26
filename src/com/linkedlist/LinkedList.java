package com.linkedlist;

public class LinkedList {
	public LinkedNode head;

	/**
	 * Adds a node in the front
	 * @param new_data
	 */
	  public void push(int new_data) 
	    { 
	        /* 1 & 2: Allocate the Node & 
	                  Put in the data*/
	        LinkedNode newNode = new LinkedNode(new_data); 
	  
	        /* 3. Make next of new Node as head */
	        newNode.next = head; 
	  
	        /* 4. Move the head to point to new Node */
	        head = newNode; 
	    } 
}
