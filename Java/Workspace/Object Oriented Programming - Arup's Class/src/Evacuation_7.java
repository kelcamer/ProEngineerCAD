/*
 * 
 * Kelsey Cameron
 * Arup Guha's OOP Practice
 * 6/26/15
 * 
 * 
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Evacuation_7 {

	public static void main(String[] args) throws FileNotFoundException {

		File in = new File("people.in");
		Scanner scanny = new Scanner(System.in);
		Scanner scanny2 = new Scanner(in);
		String lname, fname = "";
		int gend, age = 0;
		String gender = "";
		int ann_inc, prior = 0;
		int max_size = 0;
		int people_added = 0;
		ArrayList<Evacuee_7> waiting_list = new ArrayList<Evacuee_7>();
		ArrayList<Evacuee_7> order_of_priority = new ArrayList<Evacuee_7>();
		p("Welcome to the evacuation assistant");
		int choice = 2;
		while (choice != 0) {
			p("\n1) Add an evacuee to the waiting list");
			p("2) Release a lifeboat");
			p("0) Exit");
			choice = scanny2.nextInt();

			if (choice == 1) {
				people_added++;
				p("What is the evacuee’s last name?");
				lname = scanny2.next();
				p("What is the evacuee’s first name?");
				fname = scanny2.next();
				p("Is the evacuee 1)male or 2)female?");
				gend = scanny2.nextInt();
				if (gend == 1) {
					gender = "Male";
				} else {
					gender = "Female";
				}
				p("How old is the evacuee?");
				age = scanny2.nextInt();
				p("What is the evacuee’s annual income(US$)? (Enter 0 for children)");
				ann_inc = scanny2.nextInt();
				p("The evacuee: " + fname + " " + lname + " (" + gender
						+ ", age " + age + ", income $" + ann_inc
						+ ")\nHas been added to the waiting list");

				Evacuee_7 new_person = new Evacuee_7(lname, fname, gend, age,
						ann_inc, prior);
				waiting_list.add(new_person);

				for (int x = 0; x < waiting_list.size(); x++) // bubble sort
																// outer loop
				{
					for (int i = 0; i < waiting_list.size(); i++) {
						if (waiting_list.get(x).compareTo(waiting_list.get(i)) < 0) {
							Evacuee_7 temp = waiting_list.get(x);
							waiting_list.set(x, waiting_list.get(i));
							waiting_list.set(i, temp);
						}

					}

				}

			}

			else if (choice == 2) {
				p("How many people can fit on the lifeboat?");
				max_size = scanny2.nextInt();
				int count = 0;
				for (count = 0; count < max_size; count++) {
				
					// method
					System.out.println(waiting_list.get(count).toString()); // Will invoke
				}
				
				
				p("Thanks for using the evacuation assistant."
				+ "\nLet’s hope the following people are strong swimmers:");
				for (int count2 = max_size; count2 < waiting_list.size(); count2++) {
					
					// method
					System.out.println(waiting_list.get(count2).toString()); // Will invoke
				}
				

			}
		}
	}


	public static int same_age(Evacuee_7 per1, Evacuee_7 per2) {

		return per1.compareTo(per2);
	}

	public static void p(String message) {
		System.out.println(message);
	}

}
