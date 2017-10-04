import java.util.Scanner;


public class binaryTrees {

	public static void main(String[] args) {
		int choice = 1;
		Scanner scanny = new Scanner(System.in);
		System.out.println("----------------Binary Tree Program Activated----------------");
		Tree mytree = new Tree();
		
		while(choice == 1){
		System.out.println("Please enter a number.");
		int num = scanny.nextInt();
		
		mytree.add(num);
	
		System.out.println("Continue = 1\nExit = 0");
		choice = scanny.nextInt();
		}
		
		
		mytree.swap(0, 1);
		// print tree
		printTreeRecurse(Tree.root);
		scanny.close();
	}
	public static void printTreeRecurse(Node root){
		if(root != null){
			System.out.print(root.data + " ");
		}
		if(root.getLeft() != null){
		//5
			System.out.println();
			printTreeRecurse(root.getLeft());
		}
		if(root.getRight() != null){
			printTreeRecurse(root.getRight());
		}
		
	}
	public static class Node{
		int data;
		Node left;
		Node right;
		Node(int num){
			data = num;
			left = null;
			right = null;
		}
		Node(){
			left = right = null;
		}
		public Node getLeft(){
			return left;
		}
		public Node getRight(){
			return right;
		}
		public void setLeft(Node node){
			left = node;
		}
		public void setRight(Node node){
			right = node;
		}
		public void setData(int num){
			data = num;
		}
		
	}
	public static class Tree{
		static Node root;
		static int count;
		
		Tree(){
			root = new Node();
			count = 0;
		}
		Tree(int r){
			root.data = r;
			count = 0;
		}
		
		public static void add(int numb){
			
			if(root.data == 0){
				root.data = numb;
			}
			else{
			Node next = new Node(numb);
			Node cur = root;
			
			if(numb > cur.data){
				// put on right side
				while(cur.getRight() != null){
					cur = cur.getRight();
				}
				cur.setRight(next);
			}
			else{
				// put on left side
				while(cur.getLeft() != null){
					cur = cur.getLeft();
				}
				cur.setLeft(next);
			}
			System.out.println(root.data);
			count++;
			}
		}
		public static void swap(int ind1, int ind2){
			Node temp2 = null;
			Node one = null, two = null;
			for(int i = 1; i < count; i++){
				if(root.left != null && count == ind1){
					one = root.left;
				}
				else if(root.left != null && count == ind2){
					two = root.left;
				}
				else{
					if(root.right!=null && count == ind1){
						one = root.right;
					}
					else if(root.right!=null && count == ind2){
						one = root.right;
					}
				}
				
				
			}
	
			temp2 = one;
			one = two;
			two = temp2;
			
			
			
		}
		
		
		
	}
	
	

}
