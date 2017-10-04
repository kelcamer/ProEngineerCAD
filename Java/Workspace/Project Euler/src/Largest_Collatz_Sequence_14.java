
public class Largest_Collatz_Sequence_14 {
	public static void main(String args[]){
        long start = System.currentTimeMillis();
        // timing it
         
        
        // define variables
        int largest = 0;
        int longest_sequence = 0;
        
        // from 2 to 1 million
        for(int n = 2; n < 1000001; n++){
        	
        	// using the current number
            long Number = n;
            
            int counter = 1;
            // gets the sequence num of times
            while(Number > 1){
                if(Number % 2 == 0){
                    Number = Number / 2;
                } else{
                    Number = (Number * 3) + 1;
                }
                counter++;
            }
             
            if(counter > longest_sequence){
                longest_sequence = counter;
                System.out.println("Counter: " + counter);
                largest = n;
                System.out.println("Largest so far " + n);

            }
        }
     
        System.out.format("Answer = %d", largest);
        System.out.println();
        System.out.format("longest_sequence = %d ", longest_sequence);
        System.out.println();
        long stop = System.currentTimeMillis();
        System.out.println("Run time = " + (stop - start) + " milliseconds");
    }
 
}



