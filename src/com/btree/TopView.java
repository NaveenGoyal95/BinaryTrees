package com.btree;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class TopView {

	public static void main(String args[]) {
		/*
		 * Create following Binary Tree 1 
		 * / \ 2 3 \ 4 \ 5 \ 6
		 */
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.right = new Node(4);
		root.right.left = new Node(5);
		root.right.right = new Node(6);
		root.right.left.left = new Node(7);
		root.right.left.right = new Node(8);

		System.out.println("Following are nodes in top view of Binary Tree\n");
		topView(root);
		System.out.println("\nFollowing are nodes in top view of Binary Tree by queue\n");
		topViewByQueuetopView(root);
	}
	
	
	public static void topView(Node node) {
		
		Map<Integer,Pair> map=new TreeMap<Integer,Pair>();
		
		topView(node,0,0,map);
		for(Pair data:map.values()){ 
			System.out.print( data.node.value + " "); 
			}
		
		
		
	}
	
	
	public static void topView(Node node, int distance,int level, Map<Integer, Pair> map) {

		if (node == null) {
			return;
		}
		
		if(!map.containsKey(distance) || map.get(distance).level>level) {
			map.put(distance, new Pair(node,level));
		}
		
		topView(node.left,distance-1,level+1,map);
		
		topView(node.right,distance+1,level+1,map);

	}
	
	public static void topViewByQueuetopView(Node node) {

		Map<Integer, Pair> map = new TreeMap<Integer, Pair>();
		Queue<Pair> q= new LinkedList<>();
		
		if(node==null)
			return;
		q.add(new Pair(node,0));
		
		while(!q.isEmpty()) {
			
			Pair current=q.peek();
			if(map.get(current.level)==null) 
					map.put(current.level, current);
			
			q.remove();
			if(current.node.left!=null) {
				q.add(new Pair(current.node.left,current.level-1));
			}
			
			if(current.node.right!=null) {
				q.add(new Pair(current.node.right,current.level+1));
			}
			
		}

		for (Pair data : map.values()) {
			System.out.print(data.node.value + " ");
		}
	}
}
