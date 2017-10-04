import java.util.HashMap;


public class NumberLetterCounts_17 {

	public static void main(String[] args) {
		int totalchar = 0;
		int max = 1000;
		HashMap<Integer, String> hash = getMap();
		
		
		for(int count = 1; count < 14 && count <= max; count++){
			totalchar+= hash.get(count).length();
		} // stops at 13
		
		
		if(max > 14){
			for(int c = 14; c < 20; c++){
				hash.put(c, hash.get(c-10) + "teen");
				totalchar+= hash.get(c).length();
			}
		}
		
		for(int start = 20; start <= max; start+=10){
			System.out.println(start);
			totalchar+=addMore(start, totalchar, hash);
			
		}

		
		System.out.println(totalchar);
		

	}
	// 20
	public static int addMore(int startval, int total, HashMap<Integer, String> map){
		total+= map.get(startval).length();
		if(startval >= 100){
			total += 3;
			
		}
		for(int c = startval+1; c < startval+10; c++){
			//map.put(c, map.get(startval) + "-" + map.get(c));
			total+= 1 + map.get(c-startval).length() + map.get(startval).length();
		}
		return total;
	}
	public static HashMap<Integer, String> getMap(){
		HashMap<Integer, String> hash = new HashMap<Integer, String>();
		hash.put(1, "one");
		hash.put(2, "two");
		hash.put(3, "three");
		hash.put(4, "four");
		hash.put(5, "five");
		hash.put(6, "six");
		hash.put(7, "seven");
		hash.put(8, "eight");
		hash.put(9, "nine");
		hash.put(10, "ten");
		hash.put(11, "eleven");
		hash.put(12, "twelve");
		hash.put(13, "thirteen");
		hash.put(20, "twenty");
		hash.put(30,"thirty");
		hash.put(40, "forty");
		hash.put(50, "fifty");
		hash.put(60, "sixty");
		hash.put(70, "seventy");
		hash.put(80, "eighty");
		hash.put(90, "ninety");
		hash.put(100, "hundred");
		
		return hash;
	}
	
}
