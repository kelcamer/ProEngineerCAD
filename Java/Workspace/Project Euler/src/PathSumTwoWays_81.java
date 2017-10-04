import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * Kelsey Cameron
 * July 29, 2015
 * 
 * 
 */
public class PathSumTwoWays_81 {

	public static void main(String[] args) throws FileNotFoundException {
		
		
		getArrayFromFile("path81.txt", 5);
		
		
		
	}
	public static int[][] getArrayFromFile(String filename, int dim) throws FileNotFoundException{
		int[][] list = new int[dim+1][dim+1];
		File input = new File(filename);
		Scanner scanny = new Scanner(input);
		String buffer = "", sample = "";
		while (scanny.hasNext()) {
			buffer = scanny.next();
		}
		System.out.println(buffer);

		int begin = 0, temp = 0, ind = 0, x = 0, y = 0;
		int numofnum = 0;
	
		// lookup how substring works
		for (ind = 0; ind < buffer.length(); ind++) {
			
			if (buffer.charAt(ind) == ',' || buffer.charAt(ind) == '\n') {
			
				temp = ind;
				sample.replace(",", "");
				sample.replace(" ", "");
				sample = buffer.substring(begin, temp);
				System.out.println(x + " " + y);
				list[x][y] = Integer.parseInt(sample);
				
			  //  System.out.println(sample);
				begin = temp+1;
			}
			x++;
			//begin = ind;
		}
		sample = buffer.substring(begin, buffer.length());
		//System.out.println(sample);
		
		
		scanny.close();
		return list;
	}

}
