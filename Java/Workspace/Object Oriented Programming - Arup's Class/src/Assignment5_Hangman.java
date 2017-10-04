import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/*
 * Kelsey Cameron
 * Arup Guha's OOP Practice
 * 6/25/15
 * 
 * 
 */
public class Assignment5_Hangman {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner scanny = new Scanner(System.in);
		p("Welcome to the Hangman Program!\n\nWhat is the name of the file with all of the words?");
		String filename = scanny.next();
		File input = new File(filename);
		Scanner scanny_f = new Scanner(input);
		char guess = ' ';
		int num_tries = 0;
		int correct_letters = 0;
		int word_number = 1;
		String guess_str = "";
		int num_words = scanny_f.nextInt();
		String secret_word = "";
		p("What number word, from 1 to " + num_words + ", do you want to use?");
		int choice = scanny.nextInt();
		for(int c = 0; c < choice; c++){
			secret_word = scanny_f.next();
		}
	
			StringBuilder user_word = new StringBuilder();
			for(int index = 0; index < secret_word.length(); index++){
				user_word.append("_ ");
			}
			while(user_word.toString().contains("_") || num_tries > 5){
			
				if(num_tries > 5){
					p("Sorry, you have not guessed the correct word in time. The correct word was " + secret_word.toUpperCase());
					break;
				}
			p("Here is the board: \n" + user_word + "\nWhat is your guess?");
			
			guess = scanny.next().charAt(0);
			guess_str = Character.toString(guess);
			/////////////////////////////////////
			if(secret_word.contains(guess_str)){
				p("Good job!");
			for(int ind = 0; ind < secret_word.length(); ind++){
				correct_letters++;
				if(guess == secret_word.charAt(ind)){
			
					user_word.replace(2*ind, 2*ind, guess_str.toUpperCase());
					
					user_word.deleteCharAt(2*ind +1);
			
					if(!user_word.toString().contains("_")){
					
						p("Congratulations, you win!\nHere is the final board: " + user_word);
						correct_letters = 0;
						

					}
				}
			}
			}
			else{
				p("Sorry, that letter is not in the word.");
			
				num_tries++;
			}
		}
		
		
		
		
		
		scanny.close();
		scanny_f.close();
	}
	public static void p(String message){
		System.out.println(message);
	}

}
























/*
	for(int count = 0; count < num_words; count++){
			
			String user_word = " ";
			
		
			secret_word = scanny.next();
			for(int loop = 0; loop < secret_word.length(); loop++){
				user_word.
				
			}
			
			while(user_word.toString().contains("_")){
			p("The current board is " + user_word.toString());
			p("Please enter your guess.");
			guess = scanny2.next();
			guess.toUpperCase();
			guess_char = guess.charAt(0);
			while(guess.length() > 1){
				p("Error, you can only enter one character.\nPlease enter another.");
				guess = scanny2.next();

			}
				if(secret_word.contains(guess)){
					for(int c = 0; c < secret_word.length(); c++){
						
						if(guess_char == secret_word.charAt(c)){
						user_word.deleteCharAt(c);
						user_word.append(c);
							p(user_word.toString());
						}
					}
				}
				else{
					p("The letter " + guess + " is not in this hangman word.");
				}
				
			}
		}

*/