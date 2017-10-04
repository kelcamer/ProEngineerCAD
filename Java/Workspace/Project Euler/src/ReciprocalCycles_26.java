import java.math.BigDecimal;

/*
 * Kelsey Cameron
 * July 30, 2015
 * Day 2, Hour 6
 * Wow...such simple code got the answer...after all I did yesterday. x)
 * But yay, I'm finally done!
 * 
 */
public class ReciprocalCycles_26 {

	public static void main(String[] args) {
		int loop = 0;
		int start = 5;
	
		String numStr = "";
		String pattern = "";
	
		for(int count = 999; count > 0; count--){

			BigDecimal num = new BigDecimal("1.0");
			BigDecimal temp = new BigDecimal(count + "");
			
			System.out.println(num + "/" + temp + " = ");
			num = num.divide(temp,2000,1);

			numStr = num.toPlainString();
		
			numStr = getRidTrailZero(numStr);
	
			// gets pattern
			while(getPattern(numStr, start) == "" && loop < numStr.length()){
				numStr = numStr.substring(1, numStr.length());			
			}
			pattern = getPattern(numStr, start);

			if(pattern.length() == count-1){
				System.out.println("Count ends at " + count);
				break;
			}
	
			}
		
	}
	public static String getRidTrailZero(String dec){
		char temp = 0;
		if(dec.charAt(0) == '0' && dec.charAt(1) == '.'){
		dec = dec.substring(2, dec.length());
		}
			int ind = dec.length()-1;
			if((dec.charAt(ind) == dec.charAt(ind-1)) && (dec.charAt(ind-1) == dec.charAt(ind-2)) && dec.charAt(ind-2) == dec.charAt(ind-3)){
				temp = dec.charAt(ind);
				dec = dec.replace(dec.charAt(ind) + "", "");
				ind--;
				return dec;
			}

		if(temp != 0){
		return dec + temp;
		}
		else{
		}
		return dec;
		
	} // 698
	public static String getPattern(String test, int startingind){
		String pattern = "";
		String firstthree = "";
	
		if(test.length() >= startingind){
		firstthree = test.substring(0, startingind);
	
		for(int ind = 1; ind < test.length()-startingind; ind++){
			
			if(test.charAt(ind) == firstthree.charAt(0) && test.charAt(ind+1) == firstthree.charAt(1) && test.charAt(ind+2) == firstthree.charAt(2)&& test.charAt(ind+3) == firstthree.charAt(3)&& test.charAt(ind+4) == firstthree.charAt(4)){	
				pattern = test.substring(0, ind);
			//	System.out.println(result);
				System.out.println("Pattern " + pattern);
				
				System.out.println(pattern.length());
				return pattern;
			}
			
		}
		}
		
		return "";
		
	}

	
	
	
}
