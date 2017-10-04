import java.math.BigInteger; 

/*
 * Kelsey Cameron
 * July 20, 2015
 * 
 * Get number 2^1000
 * Add digits
 * Completed one hour
 */
public class Power_Digit_Sum_16 {

	public static void main(String[] args) {
		int total = 0;
		BigInteger sum = new BigInteger("2");
		BigInteger two = new BigInteger("2");
		for(int index = 1; index < 1000; index++){
			sum = sum.multiply(two);
			System.out.println(sum);
		}
		
		String strsum = sum.toString();
	
		for(int count = 0; count < strsum.length(); count++){
			if(strsum.charAt(count)-48 > 0){
			total+= (double)(strsum.charAt(count)-48);
			}
			
			System.out.println(total);
		}

	}

}
