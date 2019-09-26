package com.linkedlist;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class RemoveZeroSumConsecutive {

   
    private static void removeNonZeroElements(LinkedNode head) {
     LinkedNode currentNode = head;
     Stack<LinkedNode> stack = new Stack<>();
     boolean flag = false;
     List<LinkedNode> list = new ArrayList<>();
     while (currentNode != null) {
        if (currentNode.value > 0)
            stack.push(currentNode);
        else {
            int sum = currentNode.value;
            flag = false;
            while (!stack.isEmpty()) {
                LinkedNode temp = stack.pop();
                sum += temp.value;
                if (sum == 0) {
                    flag = true;
                    list.clear();
                    break;
                }
                list.add(temp);
            }
            if (!flag) {
                list.forEach(i -> stack.add(i));
                stack.add(currentNode);
            }
        }
        currentNode = currentNode.next;
     }
     stack.forEach(i -> System.out.print(i.value +" -> "));
     System.out.println("NULL");
   }

    // Driver program to test above functions
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.head = new LinkedNode(6);
        list.head.next = new LinkedNode(6);
        list.head.next.next = new LinkedNode(8);
        list.head.next.next.next = new LinkedNode(4);
        list.head.next.next.next.next = new LinkedNode(-12);
        list.head.next.next.next.next.next = new LinkedNode(9);
        list.head.next.next.next.next.next.next = new LinkedNode(8);
        list.head.next.next.next.next.next.next.next = new LinkedNode(-8);

        removeNonZeroElements(list.head);
    }
}