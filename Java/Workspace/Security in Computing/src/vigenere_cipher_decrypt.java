import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class vigenere_cipher_decrypt {

	public static void main(String[] args) throws FileNotFoundException {
		System.out.println("What file contains the keyword?");
		Scanner scanny = new Scanner(System.in);
		String keyword = scanny.next();
		File key = new File(keyword);
		Scanner scanny_f = new Scanner(key);
		keyword = scanny_f.next();
		// char[] letters = keyword.toCharArray();
		System.out.println("What file contains the text you would like to decrypt?");
		String input = scanny.next();
		File in = new File(input);
		Scanner scanny_data = new Scanner(in);
		String text = "";
		while (scanny_data.hasNext()) {
			text = text + scanny_data.next();
		}

		

		String oldString = decrypt_each_letter(text, keyword);
		System.out.println(oldString);
		
	
		scanny.close();
		scanny_f.close();
		scanny_data.close();
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
}
