import java.util.HashMap;
import java.util.SortedSet;
import java.util.TreeSet;

/*
 * Kelsey Cameron
 * July 21, 2015 - 22
 * Finished in about five hours?
 */
public class DistinctPowers_29 {

	public static void main(String[] args) {
		
		
		HashMap<Integer, Double> hashtag = new HashMap<Integer, Double>();
		// 2 through 5
		int maincounter = 0;
		double val = 0;
		for(int count = 2; count < 101; count++){
			for(int num = 2; num < 101; num++){
				val = Math.pow(num, count);
			if(!hashtag.containsValue(val)){	
				
				hashtag.put(maincounter, val);		
				maincounter++;
			}
	
			
			}
		}

		
		// Sort hashmap
		SortedSet<Double> values = new TreeSet<Double>(hashtag.values());
		
		
		System.out.println(values.toString());
		System.out.println(maincounter + " values");
		
		
		
	}


}
