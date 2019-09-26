package com.btree;

public class DistanceOfBinaryTree {

	public static void main(String[] args) { 
        
        // Let us create binary tree given in the above example 
        Node  root = new Node(1); 
        root.left = new Node(2); 
        root.right = new Node(3); 
        root.left.left = new Node(4); 
        root.left.right = new Node(5); 
        root.right.left = new Node(6); 
        root.right.right = new Node(7); 
        root.right.left.right = new Node(8); 
         
        System.out.println("Dist(4, 5) = "+findDistance(root, 4, 5)); 
        System.out.println("Dist(4, 6) = "+findDistance(root, 4, 6)); 
        //System.out.println("LCA(4, 6) = "+FindLCA.findLCA(4, 6,root).value); 
        System.out.println("Dist(3, 4) = "+findDistance(root, 3, 4)); 
        System.out.println("Dist(2, 4) = "+findDistance(root, 2, 4)); 
        System.out.println("Dist(8, 5) = " +findDistance(root, 8, 5)); 
          
    } 
	
	public static Integer findDistance(Node node,int value1,int value2) {
		Node nodeLCA=FindLCA.findLCA(value1, value2,node);
		
		int dist1=distanceFromLCA(nodeLCA, value1, 0);
		int dist2=distanceFromLCA(nodeLCA, value2, 0);
		return dist1+dist2;
		
	}
	
	public static Integer distanceFromLCA(Node node,int value,int level) {
		if(node==null)
			return -1;
		if( node.value==value)
			return level;
		
		
		int left=distanceFromLCA(node.left, value, level+1);
		
		if(left==-1)
			left=distanceFromLCA(node.right, value, level+1);
		return left;
			
		
		
	}
}
