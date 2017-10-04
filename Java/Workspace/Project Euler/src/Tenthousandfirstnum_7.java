/*
 * Kelsey Cameron
 * 
 * July 14, 2015
 * 
 */
import java.util.Arrays;
import java.util.Scanner;

public class Tenthousandfirstnum_7 {

	public static void main(String[] args) {

		System.out.println("What number is your max?");
		Scanner scanny = new Scanner(System.in);
		int max = scanny.nextInt();
	//	run(max);
		get_primes(max);
		

		scanny.close();
	}

	public static void get_primes(int limit) {
		boolean[] list = new_list(limit);
		int limitRoot = (int) Math.sqrt(limit);
		for (int count = 2; count < limitRoot; count++) {

			if (!list[count]) {
				// System.out.print(count + " ");
				for (int k = count * count; k <= limit; k += count) {
					list[k] = true;

				}

			}


		}
		display(list, limit);

	}


	public static void display(boolean[] list, int max) {
		int number = 1;
		for (int count = 1; count < max; count++) {
		
			if (list[count] == false) {
				
				System.out.println("For number " + number + " " + count + " is a prime number.");
				number++;
			}

		}

	}

	public static boolean[] new_list(int limit) {

		boolean[] my_list = new boolean[limit + 1];
		Arrays.fill(my_list, false);
		return my_list;

	}

}
