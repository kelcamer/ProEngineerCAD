import java.util.ArrayList;
import java.util.HashMap;


public class printing_10 {
	public static void prompt1(){
		System.out.println("Which of the following choices do you want?\n"
				+"1) Make a reservation\n"
				+"2) Print out a listing of all flights\n"
				+"3) Quit");
		
	}
	public static void reservations(HashMap<Integer, ArrayList<airline>> list){
		for(int c = 0; c < 10; c++){
			System.out.println("Day " + c);
		for(int x = 0; x < 6; x++){
			System.out.println("To: " + list.get(c).get(x).from + " From: " + list.get(c).get(x).to + " Available Seats:  " + list.get(c).get(x).seats);			
		}
		System.out.println();
		}
		
	}
	public static HashMap<Integer, ArrayList<airline>> setSeats(HashMap<Integer, ArrayList<airline>> list, int day, int number){
		
		
		for(int x = 0; x < 6; x++){
		  list.get(day).get(x).seats = number;	
		}
		System.out.println();
	
		return list;
	}
}
