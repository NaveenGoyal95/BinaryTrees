package com.btree;

public class CheckBinarySearchTree {
	
	
	
	public static void main(String args[]) 
    { 
        BinaryTree tree = new BinaryTree(); 
        tree.root = new Node(4); 
        tree.root.left = new Node(2); 
        tree.root.right = new Node(5); 
        tree.root.left.left = new Node(1); 
        tree.root.left.right = new Node(3); 
  
        if (isBST(tree.root)) 
            System.out.println("IS BST"); 
        else
            System.out.println("Not a BST"); 
    } 
	
	
	public static boolean isBST(Node node) {
		boolean a=false;
		boolean b=false;

		if(node==null)
			return true;
		if(node.left!=null && node.left.value<node.value) {
			a= isBST(node.left);
		}
		if(node.right!=null && node.right.value>node.value) {
			b=isBST(node.right);
		}
		
		
		return a&&b;

	}

}
