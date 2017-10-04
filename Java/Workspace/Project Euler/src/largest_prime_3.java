import java.util.Scanner;
/*
 * 
Problem 3


The prime factors of 13195 are 5, 7, 13 and 29.

What is the largest prime factor of the number 600,851,475,143 ?

Kelsey Cameron
 */
public class largest_prime_3 {

	public static void main(String[] args) {
		Scanner scanny = new Scanner(System.in);
		p("Please enter a number.");
		long l = scanny.nextLong();
		get_primes(l);
		scanny.close();
	}
	public static void p(String message){
		System.out.println(message);
	}
	public static void get_primes(long num){

		for(int count = 2; count < Math.pow(num, 0.5); count++){
			
			while(num % count == 0 && num/count != 1){
				num = num/count;
			}
				

		}
		System.out.println(num);
	
		
		
		
	}
	
}
