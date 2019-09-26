package com.btree;

import java.util.concurrent.atomic.AtomicInteger;

public class DiameterOfTree {
	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.right = new Node(4);
		root.right.left = new Node(5);
		root.right.right = new Node(6);
		root.right.left.left = new Node(7);
		root.right.left.right = new Node(8);
		
	/*	  Constructed tree is 
        1 
       / \ 
       2    3 
      / \ 
     4   5 
		getDiameter(1)==> getDiameter(2) ==>getDiameter(4) 
		getDiameter(4) return 1
		getDiameter(2) is back 
		getDiameter(5) is called        distance =1
		getDiameter(5) returns 1        distance =1
		getDiameter(2) returns 2        distance =3 
	    getDiameter(1) is called 
	    getDiameter(3) is called
	    getDiameter(3) returns 1        distance =3 
	    getDiameter(1) is called
	    getDiameter(1) returns 3        distance =4 //getDiameter(2)+getDiameter(3)+1
*/
		

		System.out.print("The diameter of the tree is " + getDiameter(root));
	}

	public static int getDiameter(Node node) {
		AtomicInteger diameter = new AtomicInteger();
		getDiameter(node, diameter);
		return diameter.get();
	}

	public static int getDiameter(Node node, AtomicInteger distance) {
		if(node==null) {
			return 0;
		}
		int lDiameter=getDiameter(node.left,distance);
		int rDiameter=getDiameter(node.right,distance);
		distance.set(Math.max(lDiameter+rDiameter+1, distance.get()));
		return Math.max(lDiameter, rDiameter)+1;

	}

}
