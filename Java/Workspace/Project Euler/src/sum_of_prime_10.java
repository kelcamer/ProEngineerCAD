import java.util.Arrays;


public class sum_of_prime_10 {

	public static void main(String[] args) {

		getPrimeSumUnder(2000000);
		
		
		
		
		
		
	}

	public static void getPrimeSumUnder(int max){
		boolean[] isNotPrime = new boolean[max+1];  // false for prime, true for not
		Arrays.fill(isNotPrime, false);
		for(int count = 2; count < Math.pow(max, 0.5); count++){  // do until square root
			
			if(!isNotPrime[count]){
			for(int cross = count*count; cross < max; cross+=count){ // cross out all multiples of 2, 3, 4 (through adding from count)
					isNotPrime[cross] = true;
				}
				
				
			}
			
		}
		double sum = 0;
		for(int c = 2; c < max; c++){
			
			if(isNotPrime[c] == false){
				System.out.println(c);
				sum += c;
			}
			
		}
	System.out.println("Sum " + sum);
		
		
	}

		
		
	
}
