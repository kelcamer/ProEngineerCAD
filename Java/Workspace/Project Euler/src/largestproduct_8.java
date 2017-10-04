import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class largestproduct_8 {

	
	public static void main(String[] args) throws FileNotFoundException {
		File input = new File("input.txt");
		Scanner scanny_f = new Scanner(input);
		long temp = 1, total = 1;
		String buffer = "";
		int count = 0;
		int start = 0;
		while (scanny_f.hasNext()) {
			buffer = buffer + scanny_f.next();
		}
		
		while(count < buffer.length()){
			temp = 1;
			for(count = start; count < start+13; count++){
				temp *= Long.parseLong((buffer.charAt(count) + ""));
				
			
				
			}
			start++;
		//	System.out.println(temp);
			if(temp > total){
				total = temp;
				
			}
		}
		System.out.println("Answer " +total);
			// Answer is not 2091059712
			
			
		//System.out.print(total);
		}
		
		

	}

	
	

