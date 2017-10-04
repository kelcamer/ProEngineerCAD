import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/*
 * Kelsey Cameron
 * July 23, 2015
 *  5537376230390876637302048746832985971773659831892672
 */
public class AddingLargeNumbers {
		
	public static void main(String[] args) throws FileNotFoundException {
	
		
		int totalrow = 100;
		int lengthofnum = 50;
		
		System.out.println("Digit of final num: " + addFromFile(100,50,"input.in"));
	}
		public static String addFromFile(int totalrow, int lengthofnum, String filename) throws FileNotFoundException {
			File input = new File(filename);
			
			PrintWriter writer = new PrintWriter("output.txt");
		
			// can modify large sum variables
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
					if (buffer.charAt(charcount) != '\n');
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
			writer.println(ending);
			scanny_f.close();
			writer.close();
			return ending;
		}

}

