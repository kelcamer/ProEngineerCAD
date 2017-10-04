import java.math.BigInteger;

/*
 * Kelsey Cameron
 * July 21, 2015
 * Completed in four hours
 */
public class FactorialDigitSum_20 {

	public static void main(String[] args) {
		BigInteger t = new BigInteger("1");
		BigInteger tempo = generateFact(100, t, 0);

		System.out.println(addDigits(tempo));
		
	}
	public static BigInteger generateFact(int num, BigInteger total, int count){
		
		if(num>=2){
			BigInteger temp2 = new BigInteger(num + "");
			BigInteger temp = generateFact(num-1, total, count++).multiply(temp2);
		total = total.multiply(temp);
		System.out.println(num + " " + total);
		return total;
		}
		
		if(num <= 0){
			return total;
		}
		return total;
		
		
	}
	public static int addDigits(BigInteger num){
		String numstr = num.toString();
		int totalchar = 0;
		for(int index = 0; index < numstr.length(); index++){
			totalchar+=(numstr.charAt(index)-48);
			
			
			
		}
		
		return totalchar;
	}

}
