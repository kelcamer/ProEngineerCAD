/*
 * Kelsey Cameron
 * July 16, 2015
 * Took approximately 4 hours
 * 
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class sum_13 {

	public static void main(String[] args) throws FileNotFoundException {
		File input = new File("input.in");

		// can modify large sum variables
		int totalrow = 100;
		int lengthofnum = 50;

		Scanner scanny_f = new Scanner(input);
		int[][] all = new int[lengthofnum][totalrow];
		String ending = "";
		int charcount = 0;

		String buffer = "";
		while (scanny_f.hasNext()) {
			buffer = buffer + scanny_f.next();
		}

		for (int col = 0; col < totalrow; col++) {
			for (int row = 0; row < lengthofnum; row++) {
				if (buffer.charAt(charcount) != '\n')
					;
				{
					all[row][col] = (buffer.charAt(charcount) - 48);
					charcount++;
				}

			}
		}

		int sum_of_last_ones = 0;
		int carry = 0;

		for (int row = 0; row < lengthofnum; row++) {

			for (int col = 0; col < totalrow; col++) {
				sum_of_last_ones += all[49 - row][col];

			}
			// System.out.println(sum_of_last_ones);
			carry = sum_of_last_ones / 10;
			ending = (sum_of_last_ones - carry * 10) + ending;
			// System.out.println(sum_of_last_ones + " Carry: " + carry);
			sum_of_last_ones = carry;

		}
		ending = carry + ending;
		System.out.println("Digit of final num: " + ending);
		scanny_f.close();
	}

}
// / work with digits
/*
 * first check if both last digits are greater than 10 if greater than 10,
 * subtract ten and add rest to second digit then remove last digit and move on
 * to second to last until only 10 remain
 */

