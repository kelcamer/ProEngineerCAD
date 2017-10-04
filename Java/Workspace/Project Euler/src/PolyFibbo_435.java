import java.math.BigInteger;
import java.util.ArrayList;

/*
 * Kelsey Cameron
 * July 29, 2015
 */
public class PolyFibbo_435 {

	public static void main(String[] args) {
		BigInteger temp = new BigInteger("1");
		generateFib(temp, temp, 10, 0);
		
		

	}
	public static int generateFib(BigInteger num1, BigInteger num2, int loop, int count){
		BigInteger num3 = new BigInteger(num1.add(num2) + "");
		ArrayList<BigInteger> list = new ArrayList<BigInteger>();
		if(count < loop){
		System.out.println(num3);
		// make num3 the new num2 and make num2 the new num1
		num1 = num2;
		num2 = num3;
	//	System.out.println(count);
		count++;
		count = generateFib(num1, num2, loop, count);
		
		}
		return count;
	}
}
