import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
 * Kelsey Cameron
 * Learning the basics of Security in Computing and Encryption
 * Vigenere Cipher
 * 7/2/15
 * 
 */
public class vigenere_cipher {

	public static void main(String[] args) throws FileNotFoundException {
		p("What file contains the keyword?");
		Scanner scanny = new Scanner(System.in);
		String keyword = scanny.next();
		File key = new File(keyword);
		Scanner scanny_f = new Scanner(key);
		keyword = scanny_f.next();
		// char[] letters = keyword.toCharArray();
		p("What file contains the text you would like to encrypt?");
		String input = scanny.next();
		File in = new File(input);
		Scanner scanny_data = new Scanner(in);
		String text = "";
		while (scanny_data.hasNext()) {
			text = text + scanny_data.next();
		}
		String newString = "", oldString = "";
		p("Encrypt file? 1 = Yes");
		int choice = scanny.nextInt();
		if(choice == 1){
		newString = offset_each_letter(text, keyword);
		p(newString);
		}
		p("Decrypt file? 1 = Yes");
		int choice2 = scanny.nextInt();
		if(choice2 == 1){
		oldString = decrypt_each_letter(newString, keyword);
		p(oldString);
		}
	
		scanny.close();
		scanny_f.close();
		scanny_data.close();
	}

	public static String offset_each_letter(String main, String key) {
		int temp = 0;
		String new_text = "";
		main = main.replaceAll("[^a-zA-Z]", "").toLowerCase();
		for (int count = 0; count < main.length(); count++) {
			
			if (key.length() != 0) {
				int ind = (int) (count % key.length());
				temp = key.charAt(ind) - 'a';

				int temp_amount = main.charAt(count) - 'a'; // if temp_amount >
															// 25, reset to 0

				temp_amount += temp;
				if (temp_amount >= 26) { // lets say 33
					temp_amount -= 26;
				}
				new_text = new_text + (char) (temp_amount + 'a');
				temp_amount=0;
			}
			
		}

		return new_text;
	}
	public static String decrypt_each_letter(String main, String key){
		
		String old_text = "";
		int temp = 0;
		for (int count = 0; count < main.length(); count++) {

			if (key.length() != 0) {
				int ind = (int) (count % key.length());
				temp = key.charAt(ind) - 'a';
				int temp_amount = main.charAt(count) - 'a'; // if temp_amount >
															// 25, reset to 0

				temp_amount -= temp;
				if (temp_amount < 0) { // lets say 33
					temp_amount += 26;
				}
				old_text = old_text + (char) (temp_amount + 'a');
				temp_amount=0;
			}
		
		
	
	}
		return old_text;
	}

	public static void p(String message) {
		System.out.println(message);
	}
}