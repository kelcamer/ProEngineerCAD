/*
 * Kelsey Cameron
 * Took about 6 hours to complete
 * July 21, 2015
 */


import java.util.Arrays;


public class Double_Base_Palindromes_36 {

	public static void main(String[] args) {
		int total = 0;
	//	System.out.println(Long.MAX_VALUE);
		for(int count = 1; count < 1000000; count++){
	
			//System.out.println("Count: " + count + " Total" + total);
			String temp = convert_to_binary(count);
			temp = removeZeros(temp);
			if(isPalindrome(count + "") && isPalindrome(temp + "")){
				total+= count;
				System.out.println("Conversion " + temp + " " + count);
			}
			
		}
		System.out.println("Total: " + total);
	}
	public static String convert_to_binary(int num) {
		int bin[] = new int[20];
		int pow = 2;
		String bin_number = "";
		Arrays.fill(bin, 0);
		while (num > 0) {
			pow = highest_power_of_2(num);

			// Place a 1 in the position of pow
			bin[pow] = 1;

			num -= Math.pow(2, pow);

		}
		bin = reverse(bin);
		for (int i = 0; i < bin.length; i++) {
			bin_number = bin_number + bin[i];
		}

	//	long bin_int = Long.parseLong(bin_number);

		return bin_number;
	}
	public static int highest_power_of_2(int num) {
		int power = 1;
		int count = 0;
		do {
			power *= 2;
			count++;
		} while (power <= num);

		return count - 1;
	}

	// change to string
	// help
	public static int[] reverse(int[] a) {
		int[] b = new int[a.length];
		for (int i = 0; i < a.length; i++) {
			b[a.length - 1 - i] = a[i];
		}
		return b;
	}
	public static boolean isPalindrome(String num){
	
		
		int count = 0, max = num.length()-1;
		boolean flag = false;
		for(count = 0; count < num.length(); count++){
			if(num.charAt(count) == num.charAt(max)){
				flag = true;
			}
			else{
				return false;
			}
			
			max--;
		}
		return flag;
		
		}
	public static String removeZeros(String source){
		
		
		    for (int i = 0; i < source.length(); ++i)
		    {
		        char c = source.charAt(i);
		        if (c != '0' && !Character.isSpaceChar(c))
		            return source.substring(i);
		    }
			return source;
		
	

}
	
}
