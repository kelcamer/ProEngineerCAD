import java.util.Scanner;

/*
 * Kelsey Cameron
 * Arup Guha Practice for OOP
 * 
 * 6/24/15
 * 
 */
public class Assignment4_FunWithStrings {

	public static void main(String[] args) {
		
		System.out.println("Please enter two strings.");
		Scanner scanny = new Scanner(System.in);
		String str1 = scanny.next();
		String str2 = scanny.next();
		int useript = 0;
		
		while(useript != 6){
		System.out
				.println("1) Print out which of the two strings comes first, alphabetically. (Or, if they are equal, print this out.) In making the comparison, ignore the case of the letters.");

		System.out
				.println("2) Print out whether or not the second String entered is a substring/ is contained within the first String entered.");

		System.out
				.println("3) Print out the lowercase version of the second String entered.");

		System.out
				.println("4) Print out the number of times the first letter in the String appears in the String. ");

		System.out
				.println("5) Print out the result when you replace all occurrences of 'e' in the second String with 'o'.");

		System.out.println("6) Quit");
		useript = scanny.nextInt();
		
		switch(useript){
		
		case 1:
			if(str1.compareToIgnoreCase(str2) > 0){
				System.out.println(str1 + " comes first.");
			}
			else if(str1.compareToIgnoreCase(str2) < 0){
				System.out.println(str2 + " comes first.");
			}
			else{
				System.out.println(str2 + " and " + str1 + " go in the same place in alphabetical order.");
			}
			break;
		case 2:
			if(str1.contains(str2)){
				p(str2 + " is a substring of " + str1 + ".  ");
			}
			else{
				p(str2 + " is not a substring of " + str1 + ".  ");
			}
			
			break;
		case 3:
			p("The lowercase version of the second String is " + str2.toLowerCase() + ".");
			break;
		case 4:
			char first = str1.charAt(0);
			int times = 0;
			for(int count = 0; count < str1.length(); count++){
				if(str1.charAt(count) == first){
					times++;
				}
				
				
			}
			p("'" + first + "'" + " appears " + times + " times.");
			break;
		case 5:
			p(str2.replace('e', 'o'));
			break;
		
		}
		
		
		
	}

}
	
	static void p(String message){
		System.out.println(message);
	}
}
