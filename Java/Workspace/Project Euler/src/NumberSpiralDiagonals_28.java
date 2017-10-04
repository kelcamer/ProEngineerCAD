/*
 * Kelsey Cameron
 * July 28, 2015
 * Took about an hour - 1.5 to complete
 * Holy cow it compiles fast.  Yay!
 */
public class NumberSpiralDiagonals_28 {

	public static void main(String[] args) {

		// sum for 3 X 3 = 25
		// dim is one more than it should be
		int dim = 1000, numtoskip = 2, total = 0, prev = 1, count = 0;

		for(int loop = 3; loop < dim+2; loop+=2){
		
		for(count = prev; count <= Math.pow(loop, 2); count+=numtoskip){
			total+=count;
			System.out.println(count);
			prev = count + numtoskip+2;
			if(count == 25){
				break;
			}
		}

		numtoskip+=2;
		}
		System.out.println("Total: " + total);
	}
	

}
