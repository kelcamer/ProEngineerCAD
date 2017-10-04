import java.util.Arrays;


public class PrimeFactorization {

	public static void main(String[] args) {
		
		getDivisors(28);
		
		}
	public static int getDivisors(int testnum ){
	
		int[] howmany = new int[testnum];
		Arrays.fill(howmany, 0);
		for(int count = 2; count < 10; count++){
			if(isPrime(16, count)){
				while(testnum%count == 0){
				// yes 2 is prime
				testnum /=count;
				howmany[count]++;
				}
				
			}
			
			
		}
		int divisors = 1;
		for(int count = 0; count < howmany.length; count++){
			// logic goes here
			if(howmany[count] != 0){
				
				divisors *= (1+howmany[count]);
				
				System.out.println(count + " " + howmany[count]);
			}
			
		}
		System.out.println(divisors);
		return divisors;
	}
	public static boolean[] new_list(int limit) {

		boolean[] my_list = new boolean[limit + 1];
		Arrays.fill(my_list, false);
		return my_list;

	}
	public static boolean isPrime(int limit, int num) {
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
		return getFlag(list, limit, num);

	}

	public static boolean getFlag(boolean[] list, int max, int num) {
			if (list[num] == false) {
				return true;
			}
			return false;
}
}