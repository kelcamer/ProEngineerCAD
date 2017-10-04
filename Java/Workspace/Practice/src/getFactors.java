
import java.util.ArrayList;
import java.util.Arrays;


public class getFactors {

	public static void main(String[] args) {
		
		ArrayList<Integer> list = primeFactorization(20);
		for(int a = 0; a < list.size(); a++){
			System.out.println(list.get(a));
		}

	}
	public static ArrayList<Integer> primeFactorization(int num){
		ArrayList<Integer> factors = new ArrayList<Integer>();
	
		int count = 2;
		int times = 0;
		int divisors = 1;
		int temp = 0;
	
		while(num!=1 && count < num/2){
			while(num%count== 0){
				num/=count;
				factors.add(count);
				//System.out.println("Times " + times + " count " + count);
			}
			
			count++;
		}
		
		
		int div = getDivisor(factors);
		System.out.println("div " + div );
		
		
	return factors;
	}
	public static boolean[] new_list(int limit) {

		boolean[] my_list = new boolean[limit + 1];
		Arrays.fill(my_list, false);
		return my_list;

	}
	public static int getDivisor(ArrayList<Integer> list){
		int powers = 0;
		int div = 1;
		int c = 0;
		for(int count = 2; count < list.size(); count++){
		//	System.out.println("List.size() = " + list.size());
		//	System.out.println("C " + c + " Count: " + count);
			while((list.get(c) == count) && (c < list.size())){
			//	System.out.println("List.get() = " + list.get(c));
				c++;
				powers++;
				if(c == list.size()){
					break;
				}
				}
			//	System.out.println("Powers " + powers);
			
			if(powers != 0){
				div*=(1+powers);
			}
			powers = 0;
		
		}
		
		return div;
		
	}
	
	public static ArrayList<Integer> getFactorsOfNum(int num){
		ArrayList<Integer> factors = new ArrayList<Integer>();
		for(int count = 2; count < num/2; count++){
			
			while(num%count == 0){
				if(!factors.contains(num)){
					factors.add(num);
				}
				if(!factors.contains(count)){
					factors.add(count);
				}
				num/=count;
				if(!factors.contains(num)){
					factors.add(num);
				}
			}
			
		}
		factors.add(1);
	return factors;
	}
}
