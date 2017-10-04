/*
 * Kelsey Cameron
 * July 13, 2015
 * 
 * 
 */
public class largest_palindrome_4 {

	public static void main(String[] args) {
		int num1 = 999, num2 = 999;
		int result = 0;
		result = num1*num2;		
		int count = 0;
		  int max = 0;

		    for ( int i = 999 ; i >= 100 ; i--) {
		        for (int j = 999 ; j >= 100 ; j-- ) {
		            int p = i * j;
		            if ( max < p && isPalindrome(p) ) {
		                max = p;
		                System.out.println(i + " * " + j + " = " + max);
		            }
		        }
		    }

		/*
		while(!isPalindrome(result)){
		//	System.out.println(num1 + " * " + num2 + " = " + result);
			
		
			
			
			
			result = num1*num2; 
			
			
				
			
				if(!isPalindrome(result) && count <= 899){
					
					result = num1 * (num1-count);
					System.out.println(num1 + " * " + (num1-count) + " = " + result);
					if(isPalindrome(result)){
						System.out.println("PALINDROME");
						break;
					}
					if(!isPalindrome(result)){
						result = (num1 - count) * (num1-count);
						System.out.println((num1-count) + " * " + (num1-count) + " = " + result);
					}
					if(isPalindrome(result)){
						System.out.println("PALINDROME");
						break;
					}
					if(!isPalindrome(result)){
						result = (num1 - count) * (num1-count-1);
						System.out.println((num1-count) + " * " + (num1-count-1) + " = " + result);
					}
					count++;
				
					if(isPalindrome(result)){
						System.out.println("PALINDROME");
						break;
					}
				}
				
				
				
			
			
			
			
		}*/
		//System.out.println(num1 + " * " + num2 + " = " + result);
		
	}
	public static boolean isPalindrome(int num){
		
		String number = Integer.toString(num);
		
		int count = 0, max = number.length()-1;
		boolean flag = false;
		for(count = 0; count < number.length(); count++){
			if(number.charAt(count) == number.charAt(max)){
				flag = true;
			}
			else{
				return false;
			}
			
			max--;
		}
		return flag;
		
		}

}
