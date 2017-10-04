/*
 * 
 * Kelsey Cameron
 * July 14, 2015
 * Yay I finished in 20 min
 */
public class pythag_triplet_9 {

	public static void main(String[] args) {
		double c = 0;
		for(int a = 1; a < 5000; a++){
			for(int b = 1; b < 5000; b++){
				c = Math.pow(Math.pow(a,2) + Math.pow(b,2), .5);
				if(Math.pow(a, 2) + Math.pow(b, 2) == Math.pow(1000-a-b, 2) && ((a+b + c) == 1000)){
					System.out.println(a + " " + b + " " + c);
					System.out.println(a * b * Math.pow(Math.pow(a,2) + Math.pow(b,2), .5));
				}
				
			}
		}

	}

}
