import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/*
 * Kelsey Cameron
 * July 17, 2015
 * Goal:  Learn how to use MemoIzation
 * Goal:  Figure out what pattern these numbers have:
 *
 * 			n to n/2 (n is even)
 *			n to 3n + 1 (n is odd)
 *
 *Using the rule above and starting with 13, we generate the following sequence:
 *
 *		13 - 40 - 20 - 10 - 5 - 16 - 8 - 4 - 2 - 1
 * 
 */

public class Largest_Collatz_Sequence_13 {

	public static void main(String[] args) {
		int max_val = 999999;
		int reference = max_val;
		HashMap<Integer, ArrayList<Integer>> cache = new HashMap<Integer, ArrayList<Integer>>();
		int max_numbers_in_chain = 0,  temp = 0;
		// For all values 0 to 999,999
		// start from largest to get maximum amount of numbers
		for (int a = 0; a < max_val; a++) {
			for (int index = (max_val - a); index >= 0 && reference > 0; reference--) {
				System.out.println(reference);
				
				
			
				index = reference;
			//	System.out.println("Index: " + index);
				ArrayList<Integer> chain = new ArrayList<Integer>();

			

					chain.add(index);
				

						while (index != 1) {
							if (index % 2 != 0) {
								// odd
								index = 3 * index + 1;
							} else {
								// even
								index /= 2;
							}
							
							if(!doesContain(cache, index, max_val) || index == 1){
								chain.add(index);
								temp++;
							}
							else if(doesContain(cache, index, max_val)){
							//	System.out.println("Before Chain " + chain.toString() + " Index: " + index);
								ArrayList<Integer> tail = getRest(cache, index, max_val);
							//	System.out.println("Tail " + tail.toString());
								for(int loop = 0; loop < tail.size() && tail.get(loop)!=1; loop++){
									chain.add(tail.get(loop));
									temp++;
								}
								chain.add(1);
								temp++;
							//	System.out.println("After Chain " + chain.toString());
								cache.put(reference, chain);
								break;
							}
					
							cache.put(reference, chain);
				}

				//	System.out.println("Reference " + reference);
				//	System.out.println("Max num: " + temp + " Max " + max_numbers_in_chain);
					temp = getBig(max_numbers_in_chain, temp);
				//	System.out.println("Max num: " + temp);
					max_numbers_in_chain = temp;
					temp = 0;
			}

			
		//	System.out.println("Max num: " + max_numbers_in_chain);
			
			System.out.println("Cache " + cache.toString());
		}
		System.out.println("Max num: " + max_numbers_in_chain+1);
	
		
	}
	public static int getBig(int num1, int num2){
		if(num1 > num2){
			return num1;
			
		}
		else{
			return num2;
		}
		
	}
	public static boolean doesContain(HashMap<Integer, ArrayList<Integer>> map,
			int magic_num, int max) {

		for (int a = max; a > 0; a--) {
			if (map.get(a) != null) {
				ArrayList<Integer> temp = map.get(a);

				if (temp.contains(magic_num) && magic_num!=1) {
					return true;
				}

			}
		}

		return false;
	}
	public static ArrayList<Integer> getRest(HashMap<Integer, ArrayList<Integer>> map,
			int magic_num, int max) {
			ArrayList<Integer> restOfChain = new ArrayList<Integer>();
			int secondind = 0;
		for (int a = max; a > 0; a--) {
			if (map.get(a) != null) {
			
				ArrayList<Integer> temp = map.get(a);
				if (temp.contains(magic_num) && magic_num!=1) {
					secondind = temp.indexOf(magic_num);
					while(secondind < map.get(a).size()){
					restOfChain.add(map.get(a).get(secondind));
					secondind++;
					}
				}

			}
		}
	//	System.out.println("Rest of chain " + restOfChain.toString());
		return restOfChain;
		
		
		
	}

}
