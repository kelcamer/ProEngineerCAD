/*
 * Kelsey Cameron
 * July 24, 2015
 * Took forever to complete, like two weeks but FINALLY IM DONE
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;


public class HighlyDivisibleTriangularNum_12 {

	public static void main(String[] args) {
		
		int limit = 100000;
		ArrayList<Integer> prime = get_primes(limit);
		ArrayList<Integer> list = generateTri(1000000000, 500, prime);
		System.out.println(list.toString());
	//	System.out.println(getDivisors(500, prime));
		
		for(int ind = 12350; ind < limit && ind < list.size(); ind++){
			System.out.println("ind " + ind);

			if(getDivisors(list.get(ind),limit, prime) >= 500){
				System.out.println(list.get(ind) + " " + ind);
				break;
			}
			
			
		}
		
		
	}
	
	public static ArrayList<Integer> generateTri(int limit, int indextolook, ArrayList<Integer> p){
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		int ref = 1;
		for(int count = 1; count < limit; count+=ref){
		
			list.add(count);
		
			ref++;
		}
	
		
		return list;
	}
	public static int getDivisors(int testnum, int limit, ArrayList<Integer> primes){
		int[] howmany = new int[limit+1];
		Arrays.fill(howmany, 0);
		for(int count = 2; count < limit; count++){
			if(primes.contains(count)){
				while(testnum%count == 0){
				// yes 2 is prime
				testnum /=count;
				howmany[count]++;
				}
				
			}
			
			
		}
		int count = 0;
		int divisors = 1;
		for(count = 0; count < howmany.length; count++){
			// logic goes here
			if(howmany[count] != 0){
				
				divisors *= (1+howmany[count]);
				
			//	System.out.println(count + " " + howmany[count]);
			}
			
		}
		System.out.println(divisors + " " + count);
		if(divisors >= 500){
			System.out.println(divisors + " " + count);
			
		}
	//	System.out.println("HI");
		return divisors;
	}
	public static boolean[] new_list(int limit) {

		boolean[] my_list = new boolean[limit + 1];
		Arrays.fill(my_list, false);
		return my_list;

	}

	
	public static ArrayList<Integer> get_primes(int limit) {
		boolean[] list = new_list(limit);
		ArrayList<Integer> primes = new ArrayList<Integer>();
		int limitRoot = (int) Math.sqrt(limit);
		for (int count = 2; count < limitRoot; count++) {

			if (!list[count]) {
				// System.out.print(count + " ");
				for (int k = count * count; k <= limit; k += count) {
					list[k] = true;

				}

			}


		}
		for(int c = 0; c < list.length; c++){
			if(!list[c]){
				primes.add(c);
			}
			
		}
		
		
		return primes;

	}

	public static boolean getFlag(boolean[] list, int max, int num) {
			if (list[num] == false) {
				return true;
			}
			return false;
}
}



