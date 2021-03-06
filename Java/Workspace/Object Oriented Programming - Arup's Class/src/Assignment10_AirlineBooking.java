/*
 * Kelsey Cameron
 * July 31, 2015
 * I am almost done! I just gotta update the seats...
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

// subtract seats from hash table from days specified
public class Assignment10_AirlineBooking {

	public static void main(String[] args) throws FileNotFoundException{
		
		ArrayList<airline> flights = getFlightData("airline.txt");
		ArrayList<request> list = new ArrayList<request>();
		
		HashMap<Integer, ArrayList<airline>> flight_hash = new HashMap<Integer, ArrayList<airline>>();
		for(int x = 0; x < 10; x++){
			flight_hash.put(x, flights);
			
		}
		
		Scanner scanny = new Scanner(System.in);
		int choice = 1;
		while(choice != 3){
		
		printing_10.prompt1();
		
		choice = scanny.nextInt();
		
		switch(choice){
		case 1:
			request next = getReq(scanny);
			if(!request.flightexists(flights, next)){
				System.out.println("Sorry, no flight is going from those two places.");
				//break;
			}
			else if(!request.validnumbers()){
				System.out.println("Sorry, those numbers are invalid.  Please try again.");
			//	break;
			}
			else if(request.enoughSeats(flights, next)){
				System.out.println("Sorry, there are not enough seats on this flight.  Please try a different one.");
				//break;
			}
			else{
				int temp = 0;
				System.out.println(request.leave);
			/*	for(int x = 0; x < flights.size(); x++){
				if(flights.get(x).from.equals(request.from) && flights.get(x).to.equals(request.to)){
						System.out.println("TEST " + request.from + " " + flights.get(x).from);
						System.out.println("Before " + flights.get(x).seats);
						System.out.println("x " + x);
						flights.get(x).seats -= request.seats;
						System.out.println("After " +flights.get(x).seats);
						temp = flights.get(x).seats;
					}
					
				}*/
				
				
				// PROBLEM   ASK DAVE
				flight_hash.get(0).get(2).seats = -89;
				list.add(next);
				
				
				
				System.out.println("Thanks! Your reservation has been made.");
			}
			
			
			
			break;
		case 2:
			printing_10.reservations(flight_hash);
			break;

		case 3:
			
			break;
		
		}
		
		}
		scanny.close();
	}
		
	
	public static request getReq(Scanner scanny) {
		String buff = "0";	

		System.out.println("What is your name, first followed by last?");
		String first = scanny.next();
		String last  = scanny.next();
		String fullname = first + " " + last;
		
		System.out.println("From which city do you want to fly?");
		String from = scanny.next();
		System.out.println("What is your destination city?");
		String to = scanny.next();
		System.out.println( "Which day do you want to leave?");
		buff = scanny.next();
		while(!isInt(buff)){
			buff = scanny.next();
		}
		int dayleave = Integer.parseInt(buff);


		System.out.println("Which day do you want to come back?");
		buff = scanny.next();
		while(!isInt(buff)){
			buff = scanny.next();

		}
		int comeback = Integer.parseInt(buff);
	
		System.out.println("How many seats do you want?");
		buff = scanny.next();
		while(!isInt(buff)){
			buff = scanny.next();
		}
		int seats = Integer.parseInt(buff);
		// TODO Auto-generated method stub
		
		request next = new request(fullname, from, to, dayleave, comeback, seats);
		
		return next;
	}
	public static ArrayList<airline> getFlightData(String filename) throws FileNotFoundException{
		ArrayList<airline> list = new ArrayList<airline>();
		File input = new File(filename);
		Scanner scanny = new Scanner(input);

		int loop = scanny.nextInt();
		for(int line = 0; line < loop; line++){
			String from = scanny.next();
			String to = scanny.next();
			int seats = Integer.parseInt(scanny.next());
			airline temp = new airline(from, to, seats);
			list.add(temp);
			//System.out.println("From: " + from + " to " + to + "\nSeats: " + seats);	
		}
		scanny.close();
		return list;
	}
	public static boolean isInt(String test){
		if(!test.matches("\\d+")){
			System.out.println("That is an invalid option. Please try again.");
			return false;
		}
		return true;
		
	}
//	public static void

}
