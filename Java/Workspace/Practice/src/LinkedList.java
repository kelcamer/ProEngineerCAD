/*
 * Kelsey Cameron
 * July 31, 2015
 * Took probably 3 hours total
 */

import java.util.Scanner;


public class LinkedList {

	public static void main(String[] args) {

		int choice = 1;
		Scanner scanny = new Scanner(System.in);
		System.out.println("----------------Linked List Program Activated----------------");

		list mylist = new list();


		while(choice == 1){
		System.out.println("Please enter a number.");
		int num = scanny.nextInt();
		list.add(num);
		
		System.out.println("Continue = 1\nExit = 0");
		choice = scanny.nextInt();
		}
		printList(list.head);
		scanny.close();
	}

	public static void printList(Node first){
		if(first.getData() != -999 && first!= null){
			System.out.print(first.getData() + " ");
		}
		if(first.getNext() != null){
			printList(first.getNext());
		}
		
		
	}
static class Node{
	private int data;
	private Node next;
	
	public Node(int val){
		this.data = val;
		next = null;

	}
	public Node(int dataval, Node nextone){
		this.data = dataval;
		next = nextone;
		
	}
	 public int getData() {
         return data;
     }

     public void setData(int dataValue) {
         data = dataValue;
     }

     public Node getNext() {
         return next;
     }

     public void setNext(Node nextValue) {
         next = nextValue;
     }

	
}
static class list{
	private static Node head;
	private static int count;
	list(){
		head = new Node(-999);
		count = 0;
	}
	
	public static void add(int number){
		Node temp = new Node(number);
		Node current = head;
		
		while(current.getNext() != null){
			current = current.getNext();	
		}

		current.setNext(temp);
		count++;

	}
	public static int getCount(){
		return count;
	}

	
}


}