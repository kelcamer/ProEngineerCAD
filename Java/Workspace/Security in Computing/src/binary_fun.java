import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class binary_fun {

	public static void main(String[] args) throws FileNotFoundException {
		File bin_file = new File("output.in");
		Scanner scanny_f = new Scanner(bin_file);
		Scanner scanny = new Scanner(System.in);
		String word = "";

		int orig = 0;
		System.out.println("Would you like to encode a message into binary (1)"
				+ "\n           Decode binary code into a message(2)\n"
				+ "           Convert between Decimal and Binary?(3)");
		String useript = scanny.nextLine();
		switch(useript) {
		case "1":

			String message = "";
			System.out.println("Please enter a message.");
			message = message + scanny.nextLine();
			convert_message_to_binary(message);
			System.out
					.println("Your encoded binary message is stored in file 'output.in.");

			break;
		case "2":
			while (scanny_f.hasNext()) {
				orig = scanny_f.nextInt();
				word = get_message(orig, word);
			}
			System.out.println("Your secret message: \n" + word);
			break;
		case "3":
			while (scanny_f.hasNext()) {
				orig = scanny_f.nextInt();
				choices(orig, scanny);
			}
			break;

		}

		scanny_f.close();
		scanny.close();

	}

	public static void choices(int orig, Scanner scanny) {
		System.out
				.println("1 = Convert from binary to Decimal\n2 = Convert from Decimal to Binary");
		int choice = scanny.nextInt();
		if (choice == 1) {
			int dec = convert_to_decimal(orig);
			System.out.println("Your number is " + orig
					+ " but in decimal, it is " + dec);

			// print_as_letter(dec);
		} else if (choice == 2) {
			int num = convert_to_binary(orig);
			System.out.println("Your number is " + orig
					+ " but in binary, it is " + num);
		}

	}

	public static String get_message(int orig, String final_word) {
		int dec = convert_to_decimal(orig);
	//	System.out.println("Your number is " + orig + " but in decimal, it is "
		//		+ dec);
		final_word = final_word + get_letter(dec);
		return final_word;
	}

	public static void convert_message_to_binary(String msg)
			throws FileNotFoundException {
		int[] num = new int[msg.length()];
		int temp = 0;
		for (int ind = 0; ind < msg.length(); ind++) {
		
			temp = (int) msg.charAt(ind);
			num[ind] = convert_to_binary(temp);

		}

		PrintWriter writer = new PrintWriter("output.in");
		for (int a = 0; a < num.length; a++) {
			writer.println(num[a] + "");
		}

		writer.close();

	}

	// 65 to 90 97 to 122
	public static int convert_to_decimal(int binum) {
		// error here
		int dec_num = 0;
		String bi = Integer.toString(binum);
		int max = bi.length() - 1;
		// System.out.println(bi);
		for (int count = 0; count < bi.length(); count++) {
			if (bi.charAt(count) == '1') {
				dec_num += Math.pow(2, max);
				// System.out.println(dec_num + " " + max + " " + count);
			}
			max--;

		}

		return dec_num;
	}

	public static char get_letter(int num) {
		char letter = (char) num;
		return letter;
	}

	public static int convert_to_binary(int num) {
		int bin[] = new int[8];
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

		int bin_int = Integer.parseInt(bin_number);

		return bin_int;
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

	public static int[] reverse(int[] a) {
		int[] b = new int[a.length];
		for (int i = 0; i < a.length; i++) {
			b[a.length - 1 - i] = a[i];
		}
		return b;
	}

}
