package com.btree;

public class FindLCA {

	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		tree.root.right.left = new Node(6);
		tree.root.right.right = new Node(7);
		System.out.println("LCA(4, 5) = " + findLCA(4, 5, tree.root).value);
		System.out.println("LCA(4, 6) = " + findLCA(4, 6, tree.root).value);
		System.out.println("LCA(3, 4) = " + findLCA(3, 4, tree.root).value);
		System.out.println("LCA(2, 4) = " + findLCA(2, 4, tree.root).value);
	}

	public static Node findLCA(int value1, int value2, Node node) {
		if (node == null) {
			return null;
		}
		if (node.value == value1 || node.value == value2) {
			return node;
		}
		if (node.left.value==value1||node.left.value==value2) {
			return node;
		}
		Node left = findLCA(value1, value2, node.left);
		Node right = findLCA(value1, value2, node.right);
		if (left == null && right == null) {
			return null;
		}
		if (left == null)
			return right;
		else
			return left;


	}

}
