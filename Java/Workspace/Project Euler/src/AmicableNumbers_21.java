/*
 * Kelsey Cameron
 * July 23, 2015
 * Completed in about thirty minutes :)
 */
public class AmicableNumbers_21 {

	public static void main(String[] args) {
		int total = 0;
		for(int count = 0; count < 10000; count++){
		int sum = getFactors(count);
		int sum2 = getFactors(sum);
		if(count == sum2 && sum != sum2){
			total+= sum;
		System.out.println("Amicable Numbers: \nSum " + sum);
		System.out.println("Sum2 " + sum2 + "\nCount " + count);
		}
		}
		System.out.println("Total " + total);
		
		//System.out.println(getFactors(496));
	}
	public static int getFactors(int number){
		int total = 0;
		for(int count = 1; count <= number/2; count++){
			if(number%count == 0){
				total+=count;
				//System.out.println(count);
			}
			
		}
		
		return total;
	}
}
