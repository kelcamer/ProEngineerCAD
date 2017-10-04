import java.util.HashMap;

/*
 * Kelsey Cameron
 * July 27, 2015
 * Add square of digits until number is seen.
 * This literally takes thirty minutes to run.
 * It took about two hours to make.
 * Answer: 8581146
 * TODO: optimize
 */
public class bruteforcebackup {

	public static void main(String[] args){
		int max = 10000000;
	//	int max = 10;
		// maybe this should be an int[] not sure
		HashMap<Integer, Integer> hashtag = new HashMap<Integer, Integer>();
		int chain = 0;
		int total89 = 0;
		for(int count = 2; count < max; count++){
			System.out.println("Count: " + count);
			chain = count;
			
				
			while(chain != 1){
				hashtag.put(chain, next(chain));
				chain = next(chain);
				System.out.print("Chain " + chain + " - ");
				if(chain == 89){
					total89++;
					break;
				}
			}
			
	
			
			System.out.println("///////////////////////");
			
		}
		System.out.println("Total89 " + total89);
		
		//System.out.println(next(4));

	}
	public static int next(int num){
		int nextone = 0;
		String num1 = num + "";
		
		
		for(int ind = 0; ind < num1.length(); ind++){
			int digit = num1.charAt(ind) - 48;
		//	System.out.println("Digit "  + digit);
			nextone+= Math.pow(digit, 2);
			
		}
		return nextone;
		
	}

}
