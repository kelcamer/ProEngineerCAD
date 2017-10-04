
public class smallest_positive_factor_5 {
	public static void main(String[] args) {
		
		int smallest = 99999999;
		for(int num = 999999999; num > 0; num--){
	
			if(num%20 == 0 &&num%19 == 0 &&num%18 == 0 &&num%17 == 0 &&num%16 == 0 &&num%15 == 0 &&num%14 == 0 &&num%13 == 0 &&num%12 == 0 &&num%11 == 0 && num!=0){
			

					smallest = num;
				
			}
		}
		System.out.println(smallest);
		
		
		
		
	}
}
