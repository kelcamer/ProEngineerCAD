// Arup Guha
// 2/6/07
// Class written for Spring 2007 COP 3330 Assignment #2
// This class maintains an "event" object.

public class Event implements Comparable<Event> {
	
	// Components of an event. Times are supposed to be integers ranging from
	// 0 to 24, inclusive, representing the hours in a day.
	private String name;
	private int start;
	private int end;
	
	// Constructs a new Event object with the given name, start and
    // end times. The start and end times are integers in between 0
    // and 24, inclusive, representing the starting and ending hour
    // of the event. end must be greater than start.
	public Event(String name, int start, int end) {
		this.name = name;
		this.start = start;
		this.end = end;
	}
	
	// Returns a String representation of the current object.
	public String toString() {
		String temp = "";
		
		// First put in the name of the event.
		temp = temp + name;
		
		// Add some padding - assuming that all event names are shorter than
		// 20 letters.
		int pad = 20 - name.length();
		for (int i=0; i<pad; i++)
			temp = temp + " ";
			
		// Add the start and end times.
		temp = temp + start + ":00 to " + end + ":00";
		return temp;
	}
	
	// Returns true iff e conflicts with the current object.
	public boolean conflict(Event e) {
		return ( (this.start <= e.start && this.end > e.start) ||
		         (e.start <= this.start && e.end > this.start) );
	}
	
	// Returns the name of the current object.
	public String getName() {
		return name;
	}
	
	// Returns the duration of the current object.
	public int duration() {
		return end - start;
	}
	
	// Returns a negative integer if the current object finishes before
    // e, 0 if they finish at the same time, and a positive integer if it
    // finishes after e.
	public int compareTo(Event e) {
		return this.end - e.end;
	}
}