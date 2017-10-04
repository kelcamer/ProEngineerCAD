import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
 * Kelsey Cameron
 * July 14, 2015
 * It took about seven hours to complete but I finally did it!!!!!
 */
public class closest_numbers_grid_11 {

	public static void main(String[] args) throws FileNotFoundException {
		int dim = 20;
		
		int[][] grid = new int[dim + 1][dim + 1];
		File input = new File("grid.in");
		Scanner scanny_f = new Scanner(input);

		int x1 = 0, y1 = 0, start = 0;
		while (scanny_f.hasNextLine()) {
			if (start < start + 20 && x1 < 20 && y1 < 20) {
				grid[x1][y1] = scanny_f.nextInt();
				x1++;
			} else {
				x1 = 0;
				y1++;
				start += 20;
			}
		}
		start = 0;
	
	
		long biggest = 0, temp = 0;
	
		x1 = 0;
		y1 = 0;
		
		
			
			//put inside master loop for each row
		for(int count = 0; count < 17; count++){
			//temp = biggest;
			biggest = getBig(getLargestHorizontal(grid, count), biggest);
		//	System.out.println("BIG: " + biggest);
			biggest = getBig(getLargestVertical(grid, count), biggest);
		//	System.out.println("BIG: " + biggest);
			biggest = getBig(getLargestDiagonalLeft(grid, count), biggest);
		//	System.out.println("BIG: " + biggest);
		   biggest = getBig(getLargestDiagonalRight(grid, count), biggest);
		 //  System.out.println("BIG: " + biggest);
			biggest = getBig(getLargestDiagonalStraightLeft(grid, count, dim), biggest);
		//	System.out.println("BIG: " + biggest);
			biggest = getBig(getLargestDiagonalStraightRight(grid, count, dim), biggest);
		//	biggest = temp, biggest);
		}
		System.out.println("BIGGEST: " + biggest);

		
		
		start = 0;
		scanny_f.close();

	}
	
	private static long getLargestDiagonalRight(int[][] grid,int row) {
	//	System.out.println("getLargestDiagonalRight:");
		int start = 0;
		int e =row;
		int x = 0;
		long largest = 1;
		long temp = 1;
		for (int d = row; d < row+17; d++) {
			temp = largest;
			largest = 1;
			for (x = start; x < start + 4; x++,e++) {

				// System.out.println("Diagonal:   " + p1 + " (" + x + ", "
				// + (d+e) + ")");
				if (x == 20) {
					x -= 20;
				//	d -= 3;
				}
				if(e ==row+4){
					e=row;
				}

			//	System.out.println("(x, e) = (" + (x) + ", " + (e) + ")");
				//System.out.println("Start: " + start);

				largest *= grid[x][e];
			//	System.out.println("Number: " + grid[x][e]);
				//p1 = 1;
			}
		//	System.out.println("Largest: " + largest 
		//				   + "\nTemp:    " + temp);
			largest = getBig(temp, largest);
			
		//	System.out.println("Largest: " + largest);
			start++;
			x -= 2;
		}
	//	System.out.println("Largest: " + largest);
	//	System.out.println("////////////////////////");
		return largest;
	}
	private static long getLargestDiagonalStraightRight(int[][] grid, int row, int max){
	//	System.out.println("getLargestDiagonalStraightRight:");
		int start = row, x=0;
		long larg = 0, temp = 0;
		
		for (int d = start; d < 17; d++) {
			temp = larg;
			larg = 1;
		
		for ( x = start; x < start+4; x++) {
			larg *= grid[x][x]; 
	//		System.out.println("(x, x) = (" + (x) + ", " + (x) + ")");
		//	System.out.println("Number: "+ grid[x][x]);
		//	System.out.println("Larg: " + larg);
		
			}
		//System.out.println("Largest: " + larg 
		//		+ "\nTemp:    " + temp);
		larg = getBig(temp, larg);
		
	//	System.out.println("Largest: " + larg);
	//	System.out.println("////////////////////////");
		
			start++;
			
		}
		
		return larg;
	}
	private static long getLargestDiagonalStraightLeft(int[][] grid, int row, int max){
	//	System.out.println("getLargestDiagonalStraightLeft:");

		int start = row, x=0;
		long larg = 0, temp = 0;
		max--;
		for (int d = start; d < 17; d++) {
			temp = larg;
			larg = 1;
		
			for ( x = start; x < start+4; x++) {
			larg *= grid[max][x]; 
		//	System.out.println("(x, x) = (" + (max) + ", " + (x) + ")");
		//	System.out.println("Number: "+ grid[max][x]);
		//	System.out.println("Larg: " + larg);
			max--;
			}
			max+=3;
		//System.out.println("Largest: " + larg 
	//			+ "\nTemp:    " + temp);
		larg = getBig(temp, larg);
		
	//	System.out.println("Largest: " + larg);
		//System.out.println("////////////////////////");
		
			start++;
			
		}
		
		return larg;
	}
	private static long getLargestDiagonalLeft(int[][] grid,int row) {
		//System.out.println("getLargestDiagonalLeft:");

		int start = 0;
		// DO NOT CHANGE E
		int e =row;
		int x = 0;
		long largest = 1;
		long temp = 1;
		for (int d = row; d < row+17; d++) {
			temp = largest;
			largest = 1;
			for (x = start + 3; x >= start; x--,e++) {

				// System.out.println("Diagonal:   " + p1 + " (" + x + ", "
				// + (d+e) + ")");
				if (x == 20) {
					x -= 20;
				//	d -= 3;
				}
				if(e ==row+4){
					e=row;
				}

			//	System.out.println("(x, e) = (" + (x) + ", " + (e) + ")");
			//	System.out.println("Start: " + start);

				largest *= grid[x][e];
			//	System.out.println("Number: " + grid[x][e]);
				//p1 = 1;
			}
			//System.out.println("Largest: " + largest 
			//			   + "\nTemp:    " + temp);
			largest = getBig(temp, largest);
			
			//System.out.println("Largest: " + largest);
			start++;
			x -= 2;
			//System.out.println("Largest: " + largest);
			//System.out.println("////////////////////////");
		}
		return largest;
	}
	public static long getLargestHorizontal(int[][] grid, int row){
		//System.out.println("getLargestHorizontal:");

		long temp = 0, larg = 0;
		int start = 0, x=0;
		
		start = row;
		for (int d = start; d < 17; d++) {
			temp = larg;
			larg = 1;
		
		for ( x = start; x < start+4; x++) {
			larg *= grid[x][row]; 
		//	System.out.println("(" + x + ", " + row + ")");
		
			}
	//	System.out.println("Largest: " + larg 
	//			+ "\nTemp:    " + temp);
		larg = getBig(temp, larg);
		
	//	System.out.println("Largest: " + larg);
			x-=2;
			start++;
			
		}
	//	System.out.println("////////////////////////");
		//System.out.println("Largest: " + larg);
		return larg;
	}
	public static long getLargestVertical(int[][] grid, int row){
	//	System.out.println("getLargestVertical:");

		long temp = 0, larg = 0;
		int start = 0, x=0;
		start = row;
		for (int d = start; d < 17; d++) {
			temp = larg;
			larg = 1;
		
		for ( x = start; x < start+4; x++) {
			larg *= grid[row][x]; 
			//System.out.println(" (" + row + ", " + x + ")");
		
			}
	//	System.out.println("Largest: " + larg 
	//			+ "\nTemp:    " + temp);
		larg = getBig(temp, larg);
		
	//	System.out.println("Largest: " + larg);
		//System.out.println("////////////////////////");
			x-=2;
			start++;
			
		}
		
		return larg;
	}
	
	public static long getBig(long num1, long num2){
		if(num1 > num2){
			return num1;
			
		}
		else{
			return num2;
		}
		
	}

}
