/* Name: Diana Jung
 *  Course: ICS 3U/C
 *  Teacher: Mrs.Keller
 *  Date: December 19 2022
 *  Description: This code is Hangman game, generating a random word based on their 
 *  category and difficulty choice, asking the user to guess the alphabet in the random
 *  Word and giving 5 chances for them to guess the final word. 
 */
package Arrays;

import java.util.*;

public class finalProject {

	public static void main(String[] args) {

		//declare and state variables 
		String menuChoice, categoryChoice, difficultyChoice, randomWord = null;
		int position, numWord;

		//introduce the game to the user 
		intro();

		//do while loop to continue the game until user quits the game 
		do 
		{
			//call method to select menu
			menuChoice = PrintAndSelectMenu();

			//if statement for different menu Options
			if (menuChoice.equalsIgnoreCase("R"))
				//call method to display rules
				rules();

			if (menuChoice.equalsIgnoreCase("Q"))
				System.out.println("Thank you for playing. Have a great day :)");

			if (menuChoice.equalsIgnoreCase("P"))
			{
				//call method to choose category 
				categoryChoice = selectCategory();
				//call method to choose difficulty mode 
				difficultyChoice = selectDifficulty(); 
				//call method to generate random number to choose position of word in array 
				position = randomPosition();

				//if statement for choice of word
				if (categoryChoice.equalsIgnoreCase("A"))
					//call method to make a random word in the animal category 
					randomWord = randomAnimal(difficultyChoice, position);

				else if (categoryChoice.equalsIgnoreCase("B"))
					//call method to make a random word in the emotion category 
					randomWord = randomEmotion(difficultyChoice, position);

				else if (categoryChoice.equalsIgnoreCase("C"))
					//call method to make a random word in the country category 
					randomWord = randomCountry(difficultyChoice, position);

				//count number of alphabet in the word
				numWord = numOfAlphabet(randomWord);

				//call playGame method
				playGame(randomWord, numWord);

			}//end if for P
		}//end do while
		while(!menuChoice.equalsIgnoreCase("Q"));


	}//end main 

	/*
	 * Method : playGame 
	 * Description : play Hangman and determine whether the player wins
	 * parameters : String randomWord, int numWord 
	 * Returns : 
	 */
	public static void playGame(String randomWord, int numWord) 
	{

		//declare variables
		String guessWord, answer;

		//create an array in the memory of length of the randomWord
		String [] hangmanWord = new String [numWord];


		//scanner class
		Scanner myInput = new Scanner(System.in);


		//call method to print the word on screen 
		print(hangmanWord);

		//for loop for the 8 chances the user gets 
		for (int i = 10; i > 0; i--)
		{

			//tell user how many chances they have left
			System.out.println("\nYou have " + i + " chances");

			//ask user to enter an alphabet
			System.out.println("Enter an alphabet");
			String alphabetChoice = myInput.next();

			//call method to find the position of the word 
			int position = indexOf(randomWord, alphabetChoice);

			if(position > -1) 
			{
				//call method to replace word 
				hangmanWord = replaceElement(hangmanWord, alphabetChoice, position);

				//call method to print word on screen
				print(hangmanWord);

				//ask the user to guess the word 
				System.out.println("\nWould you like to guess the word? Enter y/n.");
				guessWord = myInput.next();

				//error trap for user input other than y or n
				while(!guessWord.equalsIgnoreCase("y") && !guessWord.equalsIgnoreCase("n"))
				{

					System.out.println("Invalid input. Could you enter either y or n?");
					guessWord = myInput.next();

				}//end while

				//if the user inputs y for guess the word 
				if (guessWord.equalsIgnoreCase("y"))
				{
					//ask user to enter the word they guess
					System.out.println("Enter the word");
					answer = myInput.next();

					if (answer.equalsIgnoreCase(randomWord))
					{
						System.out.println("Congratulations! You are correct!");


						break;
					}
					else 
						System.out.println("I'm sorry, you are incorrect. Try again.");

				}//end if for y

				//if the user inputs n to guess word 
				if (guessWord.equalsIgnoreCase("n"))
					continue;

			}//end if 


			else{ 	
				System.out.println("I am sorry, the alphabet " + alphabetChoice + " is not present in the word.");

			}
		}//end for 

		//tell the user what the code is 
		System.out.println("Thank you for playing.");
		System.out.println("The word is " + randomWord);
	}//end play game 

	/*
	 * Method : replaceElement
	 * Description : replace the array with the alphabet choice 
	 * parameters : String array, alphabetChoice, int position 
	 * Returns : array 
	 */
	public static String [] replaceElement(String [] array, String alphabetChoice , int position)
	{

		array[position] = alphabetChoice;

		return array;

	}

	/*
	 * Method : indexOf
	 * Description : check if the answer matches with the randomWord
	 * parameters : String randomWord
	 * Returns : position 
	 */
	public static int indexOf(String randomWord, String alphabetChoice)
	{
		//find if the alphabetChoice is present in the randomWord using case insensitive method 
		int position = randomWord.toLowerCase().indexOf(alphabetChoice.toLowerCase());

		//System.out.println("position is " + position + "for " + randomWord);

		return position;
	}


	/*
	 * Method : compareAnswer
	 * Description : check if the answer matches with the randomWord
	 * parameters : String answer, randomWord
	 * Returns : 1 or -1
	 */
	public static void compareAnswer(String answer, String randomWord) 
	{
		if (answer.equalsIgnoreCase(randomWord))
			System.out.println("Congratulations! You are correct!");

		else 
			System.out.println("I'm sorry, you are incorrect. Try again.");
	}//end compareAnswer

	/*
	 * Method : numOfAlphabet
	 * Description : count the number of alphabet in the random Word
	 * parameters : String randomWord
	 * Returns : numberOfAlphabet 
	 */
	public static int numOfAlphabet(String randomWord) {

		//declare and state variables
		int numOfAlphabet = 0;

		//for loop to count the num of alphabet 
		for (int i = 0; i < randomWord.length(); i++)
			//if statement 
			if (Character.isLetter(randomWord.charAt(i)))
				numOfAlphabet++;

		return numOfAlphabet;

	}//end numOfAlphabet 

	/*
	 * Method : randomCountry 
	 * Description : choose randomWord from the random number generated before 
	 * as the position in the particular array based on the difficulty
	 * parameters : String difficultyChoice, int position 
	 * Returns : randomWord
	 */
	public static String randomCountry(String difficultyChoice, int position) 
	{
		//state and declare variables
		int i = position;

		//if statement for different difficulty choices 
		if (difficultyChoice.equalsIgnoreCase("E"))
		{
			String newArray[] = {"Brazil", "Cuba", "China", "Egypt", "France", "Germany",  "Italy", "Korea", "Laos", "Nepal", "Poland", "Vietnam" };
			return newArray[i];
		}
		if (difficultyChoice.equalsIgnoreCase("M"))
		{
			String newArray[] = {"Belgium",  "Denmark",  "Hungary", "Ireland", "Israel", "Portugal", "Ukraine" };
			return newArray[i];
		}
		if (difficultyChoice.equalsIgnoreCase("H"))
		{
			String newArray[] = { "Honduras",  "Kyrgyzstan",  "Uzbekistan",  "Luxembourg",  "Belarus" , "Portugal", "Switzerland"};
			return newArray[i];
		}
		return null;
	}//end randomCountry 

	/*
	 * Method : randomPosition 
	 * Description : choose randomWord from the random number generated before 
	 * as the position in the particular array based on the difficulty
	 * parameters : String difficultyChoice, int position 
	 * Returns : randomWord
	 */
	public static String randomEmotion(String difficultyChoice, int position) 
	{
		//state and declare variables
		int i = position;

		//if statement for different difficulty choices 
		if (difficultyChoice.equalsIgnoreCase("E"))
		{
			String newArray[] =  { "sad", "bored", "crazy", "confident", "bad", "mad",  "fear"};
			return newArray[i];

		}
		if (difficultyChoice.equalsIgnoreCase("M"))
		{
			String newArray[] = {  "hopeful", "confused", "nervous" , "jealous", "tired" , "excited", "scared"};
			return newArray[i];
		}
		if (difficultyChoice.equalsIgnoreCase("H"))
		{
			String newArray[] =  { "outraged", "wrathful", "skeptical",  "panicked", "insulted", "guilty", "anxious"};
			return newArray[i];
		}


		return null;
	}//end randomEmtoion 

	/*
	 * Method : randomPosition 
	 * Description : choose randomWord from the random number generated before 
	 * as the position in the particular array based on the difficulty
	 * parameters : String difficultyChoice, int position 
	 * Returns : randomWord
	 */
	public static String randomAnimal(String difficultyChoice, int position) 
	{
		//state and declare variables
		int i = position;

		//if statement for different difficulty choices 
		if (difficultyChoice.equalsIgnoreCase("E"))
		{
			String newArray[]= { "cat", "shark", "bear", "whale" , "bat" , "cobra" , "cow" , "fox", "frog", "goat", "dog" };
			return newArray[i];
		}
		if (difficultyChoice.equalsIgnoreCase("M"))
		{
			String newArray[]  = { "hamster",  "lobster",  "squid", "pelican", "python", "camel", "penguin", "donkey"};
			return newArray[i];
		}
		if (difficultyChoice.equalsIgnoreCase("H"))
		{
			String newArray [] = { "angelfish", "dolphin", "dragonfly" , "rhinoceros", "hedgehog", "tadpole", "panther" };
			return newArray[i];
		}

		return null;
	}//end randomAnimal 

	/*
	 * Method : randomPosition 
	 * Description : generate random number to choose the word in the array list 
	 * parameters : n/a
	 * Returns : randomPosition 
	 */
	public static int randomPosition() {
		//declare variables
		int position;
		//generate random number between 0-20
		position = (int) (Math.random()* 7);
		return position;
	}//end randomPosition 

	/*
	 * Method : selectDifficulty
	 * Description : display difficulty choices and ask user to choose
	 * parameters : n/a
	 * Returns : difficultyChoice 
	 */
	public static String selectDifficulty() {
		//scanner class
		Scanner myInput = new Scanner(System.in);

		//declare variable
		String difficultyChoice; 

		//display difficulty mode
		System.out.println("----DIFFICULTY MODE----");
		System.out.println("\t E - Easy");
		System.out.println("\t M - Medium");
		System.out.println("\t H - Hard");
		System.out.println("Enter your choice.");
		//user input difficulty choice 
		difficultyChoice = myInput.next();

		//error trap 
		while (!difficultyChoice.equalsIgnoreCase("E")&&!difficultyChoice.equalsIgnoreCase("M")&&!difficultyChoice.equalsIgnoreCase("H"))
		{
			System.out.println("Invalid Input. Enter again.");
			difficultyChoice = myInput.next();
		}
		return difficultyChoice;
	}//end selectDifficulty 

	/*
	 * Method : selectCategory 
	 * Description : display category choices and ask user to choose
	 * parameters : n/a
	 * Returns : categoryChoice 
	 */
	public static String selectCategory() {

		//scanner class
		Scanner myInput = new Scanner(System.in);

		//declare variables 
		String categoryChoice;

		//display choice
		System.out.println("Please select 1 of the following categories.");
		System.out.println("\t A. Animals");
		System.out.println("\t B. Emotion");
		System.out.println("\t C. Country");
		System.out.println("\nYour choice?");
		//user input category choice 
		categoryChoice = myInput.next();

		//error trap 
		while(!categoryChoice.equalsIgnoreCase("A")&&!categoryChoice.equalsIgnoreCase("B")&&!categoryChoice.equalsIgnoreCase("C"))
		{
			System.out.println("Invalid input. Enter again");
			categoryChoice = myInput.next();
		}//end while 

		//display the user's choice 
		System.out.println("Thank you. Your category choice is ...");
		if (categoryChoice.equalsIgnoreCase("A"))
			System.out.println("\tAnimals");
		if (categoryChoice.equalsIgnoreCase("B"))
			System.out.println("\tEmotion");
		if (categoryChoice.equalsIgnoreCase("C"))
			System.out.println("\tCountry");

		return categoryChoice;
	}//end selectCategory 

	/*
	 * Method : rules
	 * Description : display rules
	 * parameters : n/a
	 * Returns : n/a
	 */
	public static void rules() 
	{
		//display rules 

		System.out.println("—---How to play Hangman—-----");
		System.out.println("\n * Select one of the following categories");
		System.out.println("\t - Animal, Emotion, Country");
		System.out.println("\n * Choose easy, medium hard mode");	
		System.out.println("\n * Guess the alphabet for displayed number of words");
		System.out.println("\n YOU ARE GIVEN TOTAL 10 TRIALS");
		System.out.println("\n * For every turn the player guesses an existing alphabet, player is given a chance to guess the word");
		System.out.println("\n * If the word is correct, the player wins!");

	}//end rules

	/*
	 * Method : intro
	 * Description : introduce the game to the user 
	 * parameters : n/a
	 * Returns : n/a
	 */
	public static void intro() 
	{
		//declare variables
		String name;

		//scanner class
		Scanner myInput = new Scanner (System.in);

		//welcome the user to the game and ask for the name
		System.out.println("Welcome to Hangman!");
		System.out.println("Enter your name.");
		name = myInput.next();
		System.out.println("Hi " + name + "! Nice to meet you ^*^");
	}//end intro

	/*
	 * Method : PrintAndSelectMenu
	 * Description : print menu and ask user to select menu 
	 * parameters : n/a
	 * Returns : menuChoice 
	 */
	public static String PrintAndSelectMenu() 
	{
		//scanner class
		Scanner myInput = new Scanner (System.in);

		//declare variables 
		String menuChoice;

		//display menu  
		System.out.println("\nPlease select one of the following options :");
		System.out.println("\tR - rules");
		System.out.println("\tP - play the Game");
		System.out.println("\tQ - quit the program");

		System.out.println("\nYour Choice?");
		//user input menu choice 
		menuChoice = myInput.next();

		//error trap 
		while (!menuChoice.equalsIgnoreCase("R")&& !menuChoice.equalsIgnoreCase("P")&& !menuChoice.equalsIgnoreCase("Q"))
		{
			System.out.println("Invalid input. Enter again");
			menuChoice = myInput.next();
		}//end while 

		return menuChoice;
	}//end PrintAndSelectMenu


	/*
	 * Method : print
	 * Description : print the random word array for the user 
	 * parameters : String array
	 * Returns : n/a
	 */
	public static void print(String [] array)
	{

		//for loop
		for(int a = 0; a <array.length; a++)
		{
			//if statement 
			if (array[a] != null)
				System.out.print( " [ " + array[a] + " ] ");

			else 
				System.out.print(" [ _ ] ");

		}//end for 

		System.out.println();
	}//end printString
}//end class
