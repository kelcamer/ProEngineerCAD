
public class square_of_sums_6 {

	public static void main(String[] args) {
		int sq_of_sum = 0, sum_of_sq = 0;
		for(int count = 1; count < 101; count++){
			sq_of_sum += count;
			sum_of_sq += Math.pow(count,  2);
			
		}
	
		double difference = Math.pow(sq_of_sum, 2) - sum_of_sq ;
		System.out.println(difference);

	}

}
