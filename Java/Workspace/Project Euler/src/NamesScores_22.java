import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/*
 * Kelsey Cameron
 * July 23, 2015
 * Completed in about four hours
 */
public class NamesScores_22 {

	public static void main(String[] args) throws FileNotFoundException {
		File input = new File("names.txt");
		Scanner scanny = new Scanner(input);
		String buffer = "", sample = "";
		while (scanny.hasNext()) {
			buffer = scanny.next();
		}
		System.out.println(buffer);
		buffer = buffer.replaceAll("\"", "");
		int begin = 0, temp = 0;
		int numofnum = 0;
		ArrayList<String> list = new ArrayList<String>();
		// lookup how substring works
		for (int ind = 0; ind < buffer.length(); ind++) {
			if (buffer.charAt(ind) == ',') {
			//	System.out.println(" " + ind);
				sample.replace(",", "");
				sample = buffer.substring(begin, ind);

				if (!list.contains(sample)) {
					list.add(sample);
					numofnum++;
				}

				System.out.println("Sample " + sample + " ");
				temp = ind + 1;
			//	System.out.println(temp);
				begin = temp;
			}
		}
		sample = buffer.substring(begin, buffer.length());
		//System.out.println("Sample " + sample + " ");
		if (!list.contains(sample)) {
			list.add(sample);
		}

		 Collections.sort(list, String.CASE_INSENSITIVE_ORDER);
		// 	System.out.println(list.toString());
		 int temp2 = 0;
		 int total_of_all = 0;
		 for(int index = 1; index < numofnum+2; index++){
			
			 System.out.print(index + " " + getNameScore(list.get(index-1)) + " " + list.get(index-1) + " ");
			 total_of_all += ((index) * getNameScore(list.get(index-1)));
			 System.out.println(total_of_all);
		}
		 
		 
		 System.out.println(total_of_all);
		 // final name at 5162
		 //System.out.println(list.get(5162));
		// System.out.println(numofnum);
		 
		 
		 
		 
	}

	public static int getNameScore(String name) {
		int score = 0;

		for (int count = 0; count < name.length(); count++) {
			score += (name.charAt(count) - 'A')+1;
		//	System.out.println("Score " + (int)(name.charAt(count) - 'A')+1);
		}

		return score;
	}
	
/*
	public static ArrayList<String> sortAlpha(ArrayList<String> mylist) {
		ArrayList<String> temp = new ArrayList<String>();

		for (int count = 1; count < mylist.size(); count++) {
			if (mylist.get(count - 1).charAt(0) < mylist.get(count).charAt(0)) {
				temp.add(mylist.get(count - 1));
				temp.add(mylist.get(count));
				System.out.println(mylist.get(count));
			} else if (mylist.get(count - 1).charAt(0) > mylist.get(count)
					.charAt(0)) {
				temp.add(mylist.get(count));
				temp.add(mylist.get(count - 1));
				System.out.println(mylist.get(count));
			} else {
				System.out.println(mylist.get(count));
				for (int ind = 1; ind < mylist.get(count).length()
						&& ind < mylist.get(count - 1).length(); ind++) {
					if (mylist.get(count - 1).charAt(ind) < mylist.get(count)
							.charAt(ind)) {
						temp.add(mylist.get(count - 1));
						temp.add(mylist.get(count));
					} else if (mylist.get(count - 1).charAt(ind) > mylist.get(
							count).charAt(ind)) {
						temp.add(mylist.get(count));
						temp.add(mylist.get(count - 1));
					}

				}
			}

		}

		return temp;
	}
*/
}
