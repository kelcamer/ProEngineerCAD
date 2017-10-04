import java.util.ArrayList;


public class request {
	String name;
	static String to;
	static String from;
	static int leave;
	static int comeback;
	static int seats;
	
	
	 request(String nm, String t, String f, int leav, int come, int seat){
		 this.name = nm;
		 this.to = t;
		 this.from = f;
		 this.leave = leav;
		 this.comeback = come;
		 this.seats = seat;
		 
	 }
	 public static boolean flightexists(ArrayList<airline> info, request mine){
		 for(int ind = 0; ind < info.size(); ind++){
			// System.out.println(info.get(ind).from);
			 if(info.get(ind).from.equals(mine.from) && info.get(ind).to.equals(mine.to )){
				 return true;
			 }
			 
		 }
		 return false;
	 }
	 public static boolean validnumbers(){
		 if(leave >= comeback){
			 return false;
		 }
		 if(leave > 9 || leave < 0){
			 return false;
		 }
		 if(comeback > 9 || comeback < 0){
			 return false;
		 }
		 
		 return true;
	 }
	 public static boolean enoughSeats(ArrayList<airline> info, request mine){
		 for(int ind = 0; ind < info.size(); ind++){
			 
		
			 if(info.get(ind).from.equals(mine.from) && info.get(ind).to.equals(mine.to )){
				 
				 System.out.println(info.get(ind).seats);
				 if(info.get(ind).seats < mine.seats){
				 return true;
				 }
			 }
			 
		 }
		 return false;
	 }
	
}