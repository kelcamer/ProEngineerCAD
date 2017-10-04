/*
 * Kelsey Cameron
 * July 23, 2015
 * Completed in thirty minutes
 */
public class DigitFifthPowers_30 {

	public static void main(String[] args) {
		int  total = 0;
		int sum = 0;
		for(int infinite = 10000000; infinite>1; infinite--){
			total = 0;
			String digits = infinite + "";
			for(int c = 0; c < digits.length(); c++){
				total+= Math.pow(digits.charAt(c) - 48, 5);
			}
			if(total == infinite){
				sum+= infinite;
			System.out.println(infinite);
			}
		
		}
		System.out.println("Sum of all perfect 5: " + sum);
	}

}
