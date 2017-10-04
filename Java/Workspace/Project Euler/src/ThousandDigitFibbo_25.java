import java.io.FileNotFoundException;
import java.math.BigInteger;

/*
 * Kelsey Cameron
 * July 21, 2015
 * Completed 2-3 hours
 */
public class ThousandDigitFibbo_25 {

	public static void main(String[] args) throws FileNotFoundException {
	
		
		//AddingLargeNumbers.addFromFile(4,1,"adding.txt");
		BigInteger temp = new BigInteger("1");
		System.out.println(generateFib(temp,temp, 1000, 1) + 1);
	
	}
	public static int getDigits(BigInteger num){
		String temp = num.toString();
	
		return temp.length();
	}
	public static int generateFib(BigInteger num1, BigInteger num2, int loop, int count){
		BigInteger num3 = new BigInteger(num1.add(num2) + "");
		if(getDigits(num3) != loop){
	//	System.out.println(num3);
		// make num3 the new num2 and make num2 the new num1
		num1 = num2;
		num2 = num3;
	//	System.out.println(count);
		count = generateFib(num1, num2, loop, count);
		
		}
		count++;
		return count;
	}
}
