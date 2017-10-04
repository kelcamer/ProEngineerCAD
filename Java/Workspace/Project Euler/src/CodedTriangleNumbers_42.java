import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * Kelsey Cameron
 * July 24, 2015
 * Completed in about an hour
 * THE MEANING OF LIFE!
 * 
 */
public class CodedTriangleNumbers_42 {

	public static void main(String[] args) throws FileNotFoundException {
		ArrayList<Integer> mainlist = generateTri();
		File input = new File("words.txt");
		int begin = 0, temp = 0, numofnum = 0;
		
		Scanner scanny = new Scanner(input);
		String buffer = "", sample = "";
		while (scanny.hasNext()) {
			buffer = scanny.next();
		}
//		System.out.println(buffer);
		buffer = buffer.replaceAll("\"", "");
		ArrayList<String> list = new ArrayList<String>();

		for (int ind = 0; ind < buffer.length(); ind++) {
			if (buffer.charAt(ind) == ',') {
				sample.replace(",", "");
				sample = buffer.substring(begin, ind);

				if (!list.contains(sample)) {
					list.add(sample);
					numofnum++;
				}

				
				System.out.println(sample + " " + getASCIItotal(sample));
				
				
				temp = ind + 1;
			
				begin = temp;
			}
		
		}
		numofnum = 0;
		for(int a = 0; a < list.size(); a++){
			if(mainlist.contains(getASCIItotal(list.get(a)))){
				System.out.println(list.get(a) +  " is a triangle word " + getASCIItotal(list.get(a)) + " " + numofnum);
			numofnum++;
			}
		}
		System.out.println(numofnum);
		//System.out.println(getASCIItotal("AAA"));
	}
	public static ArrayList<Integer> generateTri(){
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		int ref = 1;
		for(int count = 1; count < 100000; count+=ref){
			//System.out.println(count);
			list.add(count);
			ref++;
		}
	
		
		return list;
	}
	public static int getASCIItotal(String word){
		int total = 0;
		for(int count = 0; count < word.length(); count++){
			total += (int)(word.charAt(count) - 'A') + 1;
		}
		return total;
		
	}

}
