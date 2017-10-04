import java.math.BigInteger;

/*
 * Kelsey Cameron
 * July 24, 2015
 * Completed in about 30 minutes
 */
public class SelfPowers_48 {
	public static void main(String[] args) {
		
		BigInteger total = new BigInteger("0");
		
		int max = 1000;
		int count = 1;
		while(count <= max){
			BigInteger countInt = new BigInteger(count + "");
			total = total.add(getPowtoPow(countInt));
			//System.out.println(getPowtoPow(countInt));
			//System.out.println("Total " + total);
			count++;
			
		}
		
	System.out.println(total.toString());
		
		
	}
	public static BigInteger getPowtoPow(BigInteger num1){
		BigInteger pows = new BigInteger("1");
		int loop = Integer.parseInt(num1.toString());
	//	System.out.println("Loop " + loop);
		for(int count = 0; count < loop; count++){
		pows = pows.multiply(num1);
		//System.out.println(pows.toString());
		}

		return pows;
	}
}
