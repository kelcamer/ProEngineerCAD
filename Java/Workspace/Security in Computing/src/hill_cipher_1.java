/*
 * Kelsey Cameron
 * Learning the basics of Security in Computing and Encryption
 * Hill Cipher Algorithm based on linear algebra and matrix multiplication
 * 7/1/15
 * 
 */
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Scanner;

public class hill_cipher_1 {

	public static void main(String[] args) throws IOException {
		System.out.println("What file is the input text stored in?");
		Scanner scanny = new Scanner(System.in);
		String input_text = scanny.next();
		File input = new File(input_text);
		
		System.out.println("What file is the encryption key stored in?");
		String enc_key = scanny.next();
		Scanner scanny_f = new Scanner(input);
		int dim = scanny_f.nextInt();
		int[][] matrix = new int[dim][dim];

		for (int row = 0; row < dim; row++) {
			for (int col = 0; col < dim; col++) {
				matrix[row][col] = scanny_f.nextInt();
			}
		}
		char unencrypted[] = get_data_from_file(enc_key);
		String encrypted = encrypt(unencrypted, matrix, dim);
		System.out.println("Which file would you like to print to?");
		String output = scanny.next();
		print_to_file(encrypted, output);
		scanny.close();
		scanny_f.close();
	}

	public static char[] get_data_from_file(String filename) throws IOException {
		File input = new File(filename);
		char[] list = new char[10000];
		Scanner scanner = new Scanner(input);

		String theString = "";

		while (scanner.hasNext()) {
			theString = theString + scanner.next();
		}
		theString = theString.replaceAll("[^a-zA-Z]", "").toLowerCase();
		list = theString.toCharArray();

		// System.out.println(list);

		scanner.close();
		return list;
	}

	public static String encrypt(char[] data, int[][] key, int dimen) {
		int letter_mod[] = new int[10000];
		int temp_key[] = { -1, -1, -1 };
		int temp_sum = 0;
		String enc_data = "";
		// change 3
		int count = 0;
		while (count < data.length) {
			// System.out.println("hi");
			letter_mod[count] = (int) (data[count] - 'a');
			count++;
		}
		count = 0;
		int index = 0;
		while (count < data.length) {
			temp_key[0] = letter_mod[count]; // 0 3 6
			temp_key[1] = letter_mod[count + 1]; // 1 4 7
			temp_key[2] = letter_mod[count + 2]; // 2 5 8
			if ((temp_key[0] != -1) && (temp_key[1] != -1)
					&& (temp_key[2] != -1)) {
			//	System.out.println(temp_key[0] + " " + temp_key[1] + " "
				//		+ temp_key[2] + " ");

				int a = 0;
				while (a < 3) {
					// System.out.println("hai");
					temp_sum += key[a][0] * temp_key[0];
				//System.out.println("Key:  " + key[a][0] + " " + key[a][1]
				//			+ " " + key[a][2]);
					temp_sum += key[a][1] * temp_key[1];
					temp_sum += key[a][2] * temp_key[2];
				//	System.out.println(temp_sum);
					enc_data = enc_data + Character.toString(convert_to_letter(temp_sum));
					temp_sum = 0;
					a++;
				}
				count += 1;
				index++;
			}

		}

	
		return enc_data;

	}

	public static char convert_to_letter(int temp) {
		char c = (char) (temp % 26 + 'a');
		return c;
	}
	public static void print_to_file(String enc, String filename) throws IOException{
		File fout = new File(filename);
		FileOutputStream fos = new FileOutputStream(fout);
	 
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
			bw.write(enc);
			
			bw.close();
		
		
	}
}