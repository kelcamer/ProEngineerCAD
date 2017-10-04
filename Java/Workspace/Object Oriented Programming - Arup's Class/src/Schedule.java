// Arup Guha
// 2/6/07
// Class written for Spring 2007 COP 3330 Assignment #2
// This class maintains an a schedule for a whole day.
// A schedule is basically a collection of event objects that don't conflict.

import java.util.*;

public class Schedule {
	
	// Stores the day and the events for that day.
	String day;
	private ArrayList<Event> listOfEvents;
	
	
	// Creates an empty Schedule object for the day day.
	public Schedule(String day) {
		this.day = day;
		listOfEvents = new ArrayList<Event>();
	}
	
	// Adds e to the current object if it does not conflict with
    // a previously scheduled event in the current object. In this
    // case, null is returned. If a conflict arises, the Event with
    // with the conflict occurs is returned, but e is NOT added to
    // the current object.
	public Event addEvent(Event e) {
		
		// Check for conflicts with e.
		Event temp = conflict(e);
		
		// If there is none, add the event.
		if (temp == null)
			listOfEvents.add(e);	
			
		// Sort the events if there's at least one in the list.
		if (!listOfEvents.isEmpty()) sort();
			
		// Return temp, which indicates the status of the add.
		return temp;
	}
	
	// Sorts all of the events in the current object based on the end time of
	// each event.
	private void sort() {
		
		// Can't sort an ArrayList, but we can Sort an array...lol
		Event[] a = new Event[1];
		Event[] temp = listOfEvents.toArray(a);
		Arrays.sort(temp);
		
		// Empty the list.
		listOfEvents.clear();
		
		// Add each event back into the list in the sorted order.
		for (int i=0; i<temp.length; i++)
			listOfEvents.add(temp[i]);
		
	}
	
	// Returns true if and only if the current object has an event with
    // the name name.
	public boolean hasEvent(String name) {
		
		// Iterate through the whole list of events.
		for (Event curevent: listOfEvents)
		
			// We found an event with the desired name.
			if ((curevent.getName()).equals(name))
				return true;
				
		// Never found an event with the desired name.
		return false;
	}
	
	// If an event with the name name is in the current object, it is
    // canceled and true is returned. Otherwise, false is returned.
	public boolean cancel(String name) {
		
		// Iterate through all of the events.
		for (Event curevent: listOfEvents)  {
			
			// Found an event with a matching name!
			if ((curevent.getName()).equals(name)) {
				
				// Find where this event is in the list.
				int index = listOfEvents.indexOf(curevent);
				
				// Remove it.
				listOfEvents.remove(index);
				
				// This is redundant, but sort everything again.
				if (!listOfEvents.isEmpty()) sort();
				
				return true;
			}
		
		}
		
		// The event wasn't canceled because it didn't exist in the current
		// object.
		return false; 
	}
	
	// The method assumes that an event with the name name is scheduled
    // in the current object. If moving that event to the newly indicated
    // times by start and end doesn't cause a conflict, the move is done
    // and null is returned. If this creates a conflict, the Event which
    // causes the conflict is returned and no change is made to the current
    // object.
	public Event moveEvent(String name, int start, int end) {
		
		// Iterate through the events.
		for (Event curevent : listOfEvents) {
			
			// Find the event with the correct name.
			if ((curevent.getName()).equals(name)) {
				
				// Create an event object for the "moved" event.
				Event temp = new Event(name, start, end);
				
				// Store the old event.
				Event old = curevent;
				int index = listOfEvents.indexOf(curevent);
				
				// Remove it from the list of events.
				listOfEvents.remove(index);
			
				// See if a conflict arises if we add the "moved" event to the
				// schedule.
				Event ifconflict = conflict(temp);
				
				// If there's no conflict, we just add the moved event to the
				// schedule.
				if (ifconflict == null)
					listOfEvents.add(temp);
				
				// Since we can't move the old event, we must add it back in
				// because we shouldn't cancel it.
				else
					listOfEvents.add(old);
					
				// Just in case we need to sort...
				if (!listOfEvents.isEmpty()) sort();
					
				// Returns the status of the move.
				return ifconflict;
						
			}
		}
		
		// This is to make the compiler happy.
		return null;		
	}
	
	// Returns the event in the current object that conflicts with e if there
	// is a conflict. If there is none, null is returned.
	private Event conflict(Event e) {
		
		// Iterate through all of the events and return the first one that
		// conflicts with e.
		for (Event curevent : listOfEvents) {
			if (curevent.conflict(e))
				return curevent;
		}
		
		// No conflicting event found.
		return null;
	}
	
	// Returns the total number of scheduled hours in the current object.
	public int numHoursScheduled() {
		int hours = 0;
		
		// Iterate through all events and add the total hours they take up.
		for (Event curevent: listOfEvents)
			hours += curevent.duration();
			
		return hours;
	}
	
	// Returns a String representation of the current object.
	public String toString() {
		
		// Return a string that represents the whole schedule object.
		
		String temp = "";
		temp = temp + day +":\n\n";
		
		for (Event curevent: listOfEvents) {
			temp = temp + curevent + "\n";
		}
		
		return temp;
	}
}