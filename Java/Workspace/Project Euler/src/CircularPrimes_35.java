import java.util.ArrayList;
import java.util.Arrays;

/*
 * Kelsey Cameron
 * July 28, 2015
 * 
 * The number, 197, is called a circular prime because all rotations of the digits: 197, 971, and 719, are themselves prime.
 * There are thirteen such primes below 100: 2, 3, 5, 7, 11, 13, 17, 31, 37, 71, 73, 79, and 97.
 * How many circular primes are there below one million?
 * Took about 2 hours
 * Answer: 55
 */
public class CircularPrimes_35 {

	public static void main(String[] args) {
			final long startTime = System.currentTimeMillis();
			int limit = 1000000;
			ArrayList<Integer> primes = getPrimeList(limit);
			int counter = 0;
			System.out.println(2);
			for(int count = 3; count < limit; count+=2){
				String c = count + "";
				if(!c.contains("2") && !c.contains("4") &&!c.contains("6") &&!c.contains("8"));
				if(rotIsPrime(count, primes)){
					System.out.println(count);
					counter++;
				}
				
			}
			System.out.println("Count is " + (counter+=1));

		//	System.out.println(primes.toString());
			final long endTime = System.currentTimeMillis();
			System.out.println("Total execution time: " + (endTime - startTime) );
	}
	public static boolean rotIsPrime(int num, ArrayList<Integer> listofprimes){
		
		ArrayList<Integer> rotations = getAllRotations(num);
		for(int loop = 0; loop < rotations.size(); loop++){
			if(!listofprimes.contains(rotations.get(loop))){
				return false;
			}
		}
		return true;
		
	}
	public static ArrayList<Integer> getAllRotations(int num){
		ArrayList<Integer> list = new ArrayList<Integer>();
		String number = num + "";
		// do for number.length of times
	
		for(int ind = 0; ind < number.length(); ind++){
			number = rotate(number);
			list.add(Integer.parseInt(number));
		}
		
		return list;
	}
	public static String rotate(String number){
		String first = number.substring(0,1);
		String second = number.substring(1, number.length());
		return second + first;
	}
	public static ArrayList<Integer> getPrimeList(int limit){
		int sqlim = (int) Math.pow(limit, 0.5);
		boolean[] list = new boolean[limit+1];
		ArrayList<Integer> primes = new ArrayList<Integer>();
		Arrays.fill(list, false);
		for(int count = 2; count < sqlim; count++){
		
			if(!list[count]){
			for(int k = count * count; k <= limit; k+=count){
				list[k] = true;
			}
			}
		}
		
		for(int a = 2; a < list.length; a++){
			if(list[a] == false){
			primes.add(a);
			//System.out.println(a);
			}
			
		}
		return primes;
	}

}
