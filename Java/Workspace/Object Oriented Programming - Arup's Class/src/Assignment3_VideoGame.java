import java.util.Scanner;

/*
 * 	Kelsey Cameron
 * 	Arup Guha's Practice Assignments for OOP
 * 
 */
public class Assignment3_VideoGame {

	public static void main(String[] args) {
		double allow = 0.0, cost = 0.0;
		double total_m = 0.0;
		int games = 0;
		int weeks = 0;
		Scanner scanny = new Scanner(System.in);
		System.out.println("Please enter Billy's weekly allowance in dollars.");
		allow = scanny.nextDouble();
		total_m = allow;
		System.out.println("Please enter the cost of a video game in dollars.");
		cost = scanny.nextDouble();
		System.out.println("Please enter the number of weeks to follow Billy's spending habits.");
		weeks = scanny.nextInt();
		boolean flag;
		for(int count = 1; count < weeks+1; count++){
			if(total_m >= cost){
				System.out.println("After week " + count + ", Billy has " + total_m +  " dollars and then buys a video game!");
				total_m-=cost;
				games++;
			}
			else{
				System.out.println("After week " + count + ", Billy has " + total_m +  " dollars and does not buy a video game.");
				total_m+= allow;
			}
			
			
			
			
		}
		total_m+=allow;
		System.out.println("At the end of the " + weeks + " weeks, Billy has " + total_m +  " dollars and " + games + " video games.");
		
	}

}
