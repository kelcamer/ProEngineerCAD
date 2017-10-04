import java.util.Scanner;

public class Assignment_8_Schedule {
	public static void main(String[] args) {
		Schedule gods_plan = null;
		String event_name = "";
		int day = 0;
		String day_s = "";
		int user_choice = 0, start = 0, end = 0;
		Scanner scanny = new Scanner(System.in);
		while (user_choice != 7) {
			p("1) Schedule an event.\n"
					+ "2) Cancel an event.\n"
					+ "3) Move a scheduled event.\n"
					+ "4) Print the schedule for a day.\n"
					+ "5) Print out how much time (in hours) is already scheduled.\n"
					+ "6) Print out how much time (in hours) is free for scheduling.\n"
					+ "7) Quit");
			user_choice = scanny.nextInt();
			p("What day would you like to modify?"
					+ "\nMonday = 1\nTuesday = 2\nWednesday = 3\nThursday=4\nFriday=5\nSaturday=6\nSunday=7");
			day = scanny.nextInt();
			day_s = convert_day_to_string(day);
			switch (user_choice) {

			case 1:
				p("Please enter the name of the event, and the starting and ending time the event will occur(represented with two integers from 1 to 24)."
						+ "Name: ");
				 event_name = scanny.next();
				p("Starting Time: ");
				start = scanny.nextInt();
				p("Ending Time: ");

				end = scanny.nextInt();
				
				gods_plan = new Schedule(day_s);
				Event event = new Event(event_name, start, end);
				Event worked = gods_plan.addEvent(event);
				if (worked != null) {
					p("Sorry, this event conflicts with another event on your schedule.");
				}
				break;
			case 2:
				p("What is the name of the event you wish to cancel?");
				boolean success = true;
				String cancel_event = scanny.next();
				if (gods_plan != null) {
					success = gods_plan.hasEvent(cancel_event);
				}
				if (success == false) {
					p("Sorry, this event does not exist"
							+ ", therefore I cannot cancel it.");
				}
				break;
			case 3:
				/*
				 * Ask the user for the name of the event, and the new starting
				 * and ending time of the event. Then, move this event in the
				 * appropriate schedule. If moving the event causes a conflict,
				 * print out an appropriate error message and do nothing. If the
				 * event isn't in the schedule do begin with, print out an error
				 * message stating so.
				 */
				p("What is the name of the event and the new starting and ending time?");
				p("Name: ");
				event_name = scanny.next();
				p("Starting Time: ");
				start = scanny.nextInt();
				p("Ending Time: ");
				end = scanny.nextInt();
				Event ifconflict = gods_plan.moveEvent(event_name, start, end);
				if(ifconflict != null){
					p("Sorry, I cannot move the event.");
				}
				break;
			case 4:
				/*
				 * 4) Ask the user for the day and print the corresponding schedule.
				 * 
				 */
				
				gods_plan.toString();
				break;
			case 5:
				break;
			case 6:
				break;
			case 7:
				break;
			}

		}
		scanny.close();
	}
	public static String convert_day_to_string(int day){
		String day_string = "";
		
		switch(day){
		case 1:
			day_string = "Monday";
			break;
		case 2:
			day_string = "Tuesday";
			break;
		case 3:
			day_string = "Wednesday";
			break;
		case 4:
			day_string = "Thursday";
			break;
		case 5:
			day_string = "Friday";
			break;
		case 6:
			day_string = "Saturday";
			break;
		case 7:
			day_string = "Sunday";
			break;
		
		}
		return day_string;
	}
	public static void p(String message) {
		System.out.println(message);
	}
}