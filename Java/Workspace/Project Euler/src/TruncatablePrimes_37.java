import java.util.ArrayList;
import java.util.Arrays;

/*
 * Kelsey Cameron
 * July 27, 2015
 * Find the 11 primes that have each digit as a prime number.
 * Takes about five minutes to run
 * Took 3.5 hours to complete
 * make sure it includes 23
 */

// You can't reverse it, it doesn't work like that... :/
public class TruncatablePrimes_37 {

	public static void main(String[] args) {
		
		ArrayList<Integer> allprime = getListOfPrime(99999999);
		ArrayList<Integer> truncprime = new ArrayList<Integer>();
		//System.out.println(allprime.toString());
		int numbersseen = 0;
		int total = 0;
		for(int count = 740000; numbersseen != 11 && count > 10; count--){
			String test = count + "";
			if(!test.contains("4") && !test.contains("6") && !test.contains("8") && !test.contains("0") && !test.startsWith("1") && !test.endsWith("1") && !test.endsWith("5")){
			if(allprime.contains(count) && isTruncatableLeft(count, allprime) && isTruncatableRight(count, allprime)){
				truncprime.add(count);
				total+=count;
				System.out.println("FOUND ONE " + count);
			//	break;
				numbersseen++;
			}
			}
			
		}
		
	
	//	System.out.println(isTruncatableLeft(3797, allprime) + " " + isTruncatableRight(3797, allprime));
		System.out.println(truncprime.toString());
		System.out.println(total);

	
		
		
		
	}
	// 3797 returns 7973
	// dont reverse...just take away first digit and check if num is prime
	public static int revNum(int num){
		String number = num + "";
		String second = "";
		second = number.substring(1, number.length());
	
		return Integer.parseInt(second);
	}
	public static boolean isTruncatableLeft(int number, ArrayList<Integer> primes){
		// 3790 
		// 379
		// 37
		// 3
		System.out.println(number);

		if(!primes.contains(number)){
			return false;
		}
		while(primes.contains(number) && number/10 > 1){
			number/=10;
			System.out.println(number);
			if(!primes.contains(number)){
				System.out.println("///////////////////////////");
				return false;
			}
			
		}
		System.out.println("///////////////////////////");
		return true;
		
	}
	public static boolean isTruncatableRight(int number, ArrayList<Integer> primes){
		// 3797 
		// 797
		// 97
		// 7
		System.out.println(number);

		if(!primes.contains(number)){
			return false;
		}
		while(primes.contains(number) && number > 10 ){
		//	System.out.println("REV " + revNum(number));
			number = revNum(number);
			System.out.println(number);
			if(!primes.contains(number)){
				System.out.println("///////////////////////////");
				return false;
			}
			
		}
		System.out.println("///////////////////////////");
		return true;
		
	}
	public static boolean[] newList(int lim){
		boolean[] first = new boolean[lim+1];
		Arrays.fill(first, false);
		return first;
		
	}
	public static ArrayList<Integer> getListOfPrime(int limit){
		ArrayList<Integer> prime = new ArrayList<Integer>();
		boolean[] composites = newList(limit);
		int limroot = (int) Math.pow(limit, 0.5);
		
		
		for(int count = 2; count < limroot; count++){
			
			if(!composites[count]){
			for(int square = count*count; square <= limit; square+=count){
					composites[square] = true;	
			}
			}
			
		}
		for(int ind = 2; ind < composites.length; ind++){
			if(composites[ind] == false){
				prime.add(ind);
			}
			
		}
		
		
		
		return prime;
	}

}
