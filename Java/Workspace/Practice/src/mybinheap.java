/*
 * Well that's a whole lot easier than I thought it would be... 
 * I like Java better than C.
 * 
 * Kelsey Cameron
 * Completed in roughly 1.5 hours
 * July 30, 2015
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class mybinheap {

	public static void main(String args[]){
		ArrayList<doubleVal> mylist = new ArrayList<doubleVal>();
		Scanner scanny = new Scanner(System.in);

		int choice = 0, which = 0;
		
		System.out.println("Do you want a min-heap (1) or a max-heap? (2)");
		which = scanny.nextInt();
		
		
		while(choice != 2){
			System.out.println("Please enter a number to add to the heap.");
			int value = scanny.nextInt();
			insert(value, mylist, which);
			System.out.println("Continue = 1, End = 2");
			choice = scanny.nextInt();
		}

		print(mylist);
		scanny.close();
}
	public static ArrayList<doubleVal> insert(int val, ArrayList<doubleVal> list, int choice){
		
		doubleVal temp = new doubleVal(val);
		if(list.isEmpty()){
			list.add(temp);			
		}
		else{
			list.add(temp);
		
			for(int ind = 0; ind < list.size()-2; ind++){
				int bigger = 0;
				switch(choice){
				case 1:
					bigger = getGreatest(list.get(ind).val, val);
					break;
				case 2:
					bigger = getSmallest(list.get(ind).val, val);
				}
				
				
				if(bigger != val){
				Collections.swap(list, ind, list.size()-1);
				}

			}
			
		}
	
		return list;
		
	}

		
	public static void print(ArrayList<doubleVal> list){
		for(int a =0; a < list.size(); a++){
			System.out.print(list.get(a).val + " ");
		}
	
	}
public static int getGreatest(int num, int num2){
	if(num > num2){
		return num;
	}
	return num2;
	
}
public static int getSmallest(int num, int num2){
	if(num < num2){
		return num;
	}
	return num2;
	
}
static class doubleVal{
	
	private int val;
	
	doubleVal(int val1){
		this.val = val1;
	}
	
	
	
}
}
