package com.linkedlist;

public class DetectLoop {

	public static void main(String[] args) {
		LinkedList llist = new LinkedList();

		llist.push(20);
		llist.push(4);
		llist.push(15);
		llist.push(10);

		/* Create loop for testing */
		llist.head.next.next.next.next = llist.head;

		if (detectLoop(llist.head))
			System.out.println("Loop found");
		else
			System.out.println("No Loop");
	}
	
	
	public static void findLength(LinkedNode node) {
		LinkedNode pointer = node;
		int counnt=0;
		while(pointer.next!=node) {
			counnt++;
			pointer=pointer.next;
		}

		System.out.println("Count is ====>" +(counnt+1)) ;
		
	}


	public static boolean detectLoop(LinkedNode head) {
		if (head == null) {
			return false;
		}

		LinkedNode slowPointer = head;
		LinkedNode fastPointer = head;
		int count=0;
		while (slowPointer != null && fastPointer != null && fastPointer.next != null) {
			slowPointer = slowPointer.next;
			fastPointer = fastPointer.next.next;
			if (slowPointer == fastPointer) {
				findLength(slowPointer);
				return true;
			}

		}

		return false;

	}

}
