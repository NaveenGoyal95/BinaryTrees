package com.btree;

public class MaximumSumInTree {

	public static void main(String[] args) {
		  BinaryTree tree = new BinaryTree(); 
	        tree.root = new Node(-15); 
	        tree.root.left = new Node(5); 
	        tree.root.right = new Node(6); 
	        tree.root.left.left = new Node(-8); 
	        tree.root.left.right = new Node(1); 
	        tree.root.left.left.left = new Node(2); 
	        tree.root.left.left.right = new Node(6); 
	        tree.root.right.left = new Node(3); 
	        tree.root.right.right = new Node(9); 
	        tree.root.right.right.right = new Node(0); 
	        tree.root.right.right.right.left = new Node(4); 
	        tree.root.right.right.right.right = new Node(-1); 
	        tree.root.right.right.right.right.left = new Node(10); 
	        System.out.println("Max pathSum of the given binary tree is "
	                +maxPathSum(tree.root));

	}
	
	public static Integer maxPathSum(Node root) {
		Integer max=Integer.MIN_VALUE;
		 maxPathSum( root,max);
		 return max;
	}
	
	public static Integer maxPathSum(Node node,Integer max) {
		if(node==null)
			return 0;
		
		if(node.left==null && node.right==null) {
			return node.value;
		}
		
		int leftSum=maxPathSum( node.left, max);
		int rightSum=maxPathSum( node.right, max);
		
		if(node.left!=null && node.right !=null) {
			max=Math.max(max, (leftSum+rightSum+node.value));
			return Math.max(leftSum, rightSum)+node.value;
		}
		
      return node.left==null ? rightSum+node.value:leftSum+node.value;
	}

}
