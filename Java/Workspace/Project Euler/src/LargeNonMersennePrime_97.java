import java.math.BigInteger;

/*
 * Kelsey Cameron
 * July 30, 2015
 * 28433×2^(7830457)+1 = get last ten digits
 */
public class LargeNonMersennePrime_97 {

	public static void main(String[] args) {
		BigInteger first = new BigInteger("28433");
		BigInteger two = new BigInteger("2");
		BigInteger powtwo = new BigInteger("7830457");
		
		BigInteger total = pow(two, powtwo).multiply(first).add(new BigInteger("1"));
		
		System.out.println(total);
		
		
		
		
	}
	public static BigInteger pow(BigInteger two, BigInteger power){
		 for(int count = 0; count < Integer.parseInt(power.toString()); count++){
			 two = two.multiply(two);			
			 System.out.println(two);
		 }
		return two;
		
	}

}
