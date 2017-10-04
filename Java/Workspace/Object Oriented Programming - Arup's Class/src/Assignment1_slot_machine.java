import java.util.Random;
import java.util.Scanner;

public class Assignment1_slot_machine {

	public static void main(String[] args) {

		double total_money = 10.0;
		int ipt = 0;
		Scanner scanny = new Scanner(System.in);
		
		

			while (total_money > 0.25) {
				print_message("Choose one of the following menu options:\n1) Play the slot machine.\n2) Cash out.");
				print_message("You have " + total_money + " dollars.");
				total_money -= 0.25;
				ipt = scanny.nextInt();
				if (ipt == 1) {
				Random rand1 = new Random();
				Random rand2 = new Random();
				Random rand3 = new Random();
				int digit1 = rand1.nextInt(9);
				int digit2 = rand2.nextInt(9);
				int digit3 = rand3.nextInt(9);
				print_message("Digit 1: " + digit1 + "\nDigit2: " + digit2 + "\nDigit3: " + digit3);
				if (digit1 == digit2) {
					if (digit2 == digit3) {
						total_money+= 10;
						print_message("Congrats, you won 10$!!!");
					}
					else{
						total_money+=0.5;
						print_message("Congrats, you won 50 cents!!!");
					}
				}
				else if(digit1 == digit3){
					total_money+=0.5;
					print_message("Congrats, you won 50 cents!!!");
				}
				else if(digit2 == digit3){
					total_money+=0.5;
					print_message("Congrats, you won 50 cents!!!");
				}
				else{
					print_message("Sorry, you didn't win anything. :(");
				}

			}
				else if(ipt == 2){
					print_message("You have made a total of " + total_money + "dollars!!!");
					break;
				}

		}
		
		scanny.close();
	}

public static void print_message(String message){
	System.out.println(message);
}
}