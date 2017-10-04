import java.util.Arrays;
import java.util.HashMap;

/*
 * Kelsey Cameron
 * July 22, 2015
 *72
 */
public class ReducingFractions {

	public static void main(String[] args) {
		int max = 1000000;
		int temp = max;
		int main = 0;
		int[] storage = new int[3];
		double temp2 = 0.0;
		HashMap<Integer, int[]> fractions = new HashMap<Integer, int[]>();
		HashMap<Integer, Double> decimals = new HashMap<Integer, Double>();
		for(int count = 1; count <= temp; count++){
			for(int count2 = count+1; count2 <= temp; count2++){
				// count is top, count2 is bot
				//System.out.println(count2 + " " + count);
				temp2 = (double)count/count2;
				if(!decimals.containsValue(temp2)){
					storage = reduce(count, count2);
					decimals.put(main, temp2);
					fractions.put(main, storage);
					main++;
				}
			}
			
			
			max--;
		}
		
		System.out.println(main);
		
		//reduce(2, 8);
	}
	public static int[] reduce(int top, int bot){
		int[] fraction = new int[3];
		fraction[0] = top;
		fraction[1] = bot;
		boolean[] list = getList(1000000);
		if(bot%top == 0){
			bot/=top;
			top/=top;
		}
		while(bot%2 == 0 && top%2==0){
			bot/=2;
			top/=2;
		}
		while(!isPrime(top, list) && !isPrime(bot, list) && top != 1 && top+1!=bot){
		
			if(bot%top == 0){
				bot/=top;
				top/=top;
			}
			System.out.println("Root" + (int)Math.pow(bot, 0.5));
		for(int count = 1; count <= bot/2 && top+1!= bot && (!isPrime(top, list) && !isPrime(bot, list)); count++){
			
			if(top%count == 0 && bot% count == 0){
				top/=count;
				bot/=count;
				System.out.println(top + "/" + bot);
				
			}
			
		
		}
	
		
		
		}
		
		fraction[0] = top;
		fraction[1] = bot;
		System.out.println(fraction[0] + "/" + fraction[1]);
		
		
		return fraction;
	}
	
	
	
	public static boolean[] new_list(int limit) {

		boolean[] my_list = new boolean[limit + 1];
		Arrays.fill(my_list, false);
		return my_list;

	}
	public static boolean[] getList(int limit){
		
		boolean[] list = new_list(limit);
		int limitRoot = (int) Math.sqrt(limit);
		for (int count = 2; count < limitRoot; count++) {

			if (!list[count]) {
				// System.out.print(count + " ");
				for (int k = count * count; k <= limit; k += count) {
					list[k] = true;

				}

			}	
		
	}
		return list;
	}
	public static boolean isPrime(int num, boolean[] list) {
		
			if (list[num] == false) {
				return true;
			}
			return false;
}
}
