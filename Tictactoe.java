package Arrays;

import java.util.*;

public class TicTacToe {

	public static void main(String[] args) {

		//defining variables
		int playerChoice;
		int turnNumber;
		int playAgain;
		int numPlayers;

		//tracking what is in each space
		int a1;
		int a2;
		int a3;
		int b1;
		int b2;
		int b3;
		int c1;
		int c2;
		int c3;
		//board variables
		String topLeft;
		String topCentre;
		String topRight;
		String centreLeft;
		String centre;
		String centreRight;
		String bottomLeft;
		String bottomCentre;
		String bottomRight;

		//error catch variable
		boolean validInput;

		//setting variables
		a1 = 0;
		a2 = 0;
		a3 = 0;
		b1 = 0;
		b2 = 0;
		b3 = 0;
		c1 = 0;
		c2 = 0;
		c3 = 0;
		playAgain = 0;
		topLeft = "[ ]";
		topCentre = "[ ]";
		topRight = "[ ]";
		centreLeft = "[ ]";
		centre = "[ ]";
		centreRight = "[ ]";
		bottomLeft = "[ ]";
		bottomCentre = "[ ]";
		bottomRight = "[ ]";
		turnNumber = 0;
		validInput = false;
		numPlayers = 0;

		//setting Scanner
		Scanner myInput = new Scanner(System.in);

		//checking number of players
		while (validInput == false) {
			System.out.println("How many people are playing?");
			try {
				numPlayers = myInput.nextInt();
				if (numPlayers < 1 || numPlayers > 2) {
					System.out.println("There can be only one or two players.");
				}//end if

				else {
					validInput = true;
				}//end else

			}//end try

			catch (Exception e) {
				System.out.println("Not a valid choice.");

				//stopping infinite loop
				myInput.nextLine();

			}//end catch

			finally {

			}//end finally

		}//end while

		//explaining input options
		System.out.println("top left is 1, top centre is 2, top right is 3,");
		System.out.println("centre left is 4,centre is 5, centre right is 6,");
		System.out.println("bottom left is 7, bottom centre is 8, bottom right is 9.");

		while (turnNumber < 11) {

			//checking if input is allowed
			validInput = false;
			while (validInput == false) {

				//asks for and collects choice
				System.out.println("What is your choice, player 1?");

				//catching input error
				try {
					playerChoice = myInput.nextInt();
				}//end try

				catch (Exception e) {
					System.out.println("Not a valid choice.");

					//stopping infinite loop
					myInput.nextLine();

					//allowing player to retry
					continue;
				}//end catch

				finally {

				}//end finally

				//finding board spot
				if (playerChoice == 1) {
					if (a1 == 0) {
						topLeft = "[x]";
						turnNumber = turnNumber + 1;
						a1 = 1;
						validInput = true;
					}//end if

					else {
						System.out.println("That spot is already taken. Please try again.");
					}//end else

				}//end if

				else if (playerChoice == 2) {
					if (a2 == 0) {
						topCentre = "[x]";
						turnNumber = turnNumber + 1;
						a2 = 1;
						validInput = true;
					}//end if

					else {
						System.out.println("That spot is already taken. Please try again.");
					}//end else

				}//end else if

				else if (playerChoice == 3) {
					if (a3 == 0) {
						topRight = "[x]";
						turnNumber = turnNumber + 1;
						a3 = 1;
						validInput = true;
					}//end if

					else {
						System.out.println("That spot is already taken. Please try again.");
					}//end else

				}//end else if

				else if (playerChoice == 4) {
					if (b1 == 0) {
						centreLeft = "[x]";
						turnNumber = turnNumber + 1;
						b1 = 1;
						validInput = true;
					}//end if

					else {
						System.out.println("That spot is already taken. Please try again.");
					}//end else

				}//end else if

				else if (playerChoice == 5) {
					if (b2 == 0) {
						centre = "[x]";
						turnNumber = turnNumber + 1;
						b2 = 1;
						validInput = true;
					}//end if

					else {
						System.out.println("That spot is already taken. Please try again.");
					}//end else

				}//end else if

				else if (playerChoice == 6) {
					if (b3 == 0) {
						centreRight = "[x]";
						turnNumber = turnNumber + 1;
						b3 = 1;
						validInput = true;
					}//end if

					else {
						System.out.println("That spot is already taken. Please try again.");
					}//end else

				}//end else if

				else if (playerChoice == 7) {
					if (c1 == 0) {
						bottomLeft = "[x]";
						turnNumber = turnNumber + 1;
						c1 = 1;
						validInput = true;
					}//end if

					else {
						System.out.println("That spot is already taken. Please try again.");
					}//end else

				}//end else if

				else if (playerChoice == 8) {
					if (c2 == 0) {
						bottomCentre = "[x]";
						turnNumber = turnNumber + 1;
						c2 = 1;
						validInput = true;
					}//end if

					else {
						System.out.println("That spot is already taken. Please try again.");
					}//end else

				}//end else if

				else if (playerChoice == 9) {
					if (c3 == 0) {
						bottomRight = "[x]";
						turnNumber = turnNumber + 1;
						c3 = 1;
						validInput = true;
					}//end if

					else {
						System.out.println("That spot is already taken. Please try again.");
					}//end else

				}//end else if

				else {
					System.out.println("That spot is not on the board. Please try again.");
				}//end else

				//ending game
				if (turnNumber == 9) {
					turnNumber = 10;
				}//end if

			}//end while

			//printing board
			board(topLeft, topCentre, topRight, centreLeft, centre, centreRight, bottomLeft, bottomCentre, bottomRight);

			//checking if game has been won
			turnNumber = whoWon(a1, a2, a3, b1, b2, b3, c1, c2, c3, turnNumber);
			if (turnNumber < 9 && numPlayers == 2) {

				//checking if input is allowed
				validInput = false;
				while (validInput == false) {

					//asks for and collects choice
					System.out.println("What is your choice, player 2?");

					//catching input error
					try {
						playerChoice = myInput.nextInt();
					}//end try

					catch (Exception e) {
						System.out.println("Not a valid choice.");

						//stopping infinite loop
						myInput.nextLine();

						//stopping error
						playerChoice = 0;
					}//end catch

					finally {

					}//end finally

					//finding board
					if (playerChoice == 1) {
						if (a1 == 0) {
							topLeft = "[o]";
							turnNumber = turnNumber + 1;
							a1 = 2;
							validInput = true;
						}//end if

						else {
							System.out.println("That spot is already taken. Please try again.");
						}//end else

					}//end if

					else if (playerChoice == 2) {
						if (a2 == 0) {
							topCentre = "[o]";
							turnNumber = turnNumber + 1;
							a2 = 2;
							validInput = true;
						}//end if

						else {
							System.out.println("That spot is already taken. Please try again.");
						}//end else

					}//end if

					else if (playerChoice == 3) {
						if (a3 == 0) {
							topRight = "[o]";
							turnNumber = turnNumber + 1;
							a3 = 2;
							validInput = true;
						}//end if

						else {
							System.out.println("That spot is already taken. Please try again.");
						}//end else

					}//end if

					else if (playerChoice == 4) {
						if (b1 == 0) {
							centreLeft = "[o]";
							turnNumber = turnNumber + 1;
							b1 = 2;
							validInput = true;
						}//end if

						else {
							System.out.println("That spot is already taken. Please try again.");
						}//end else

					}//end if

					else if (playerChoice == 5) {
						if (b2 == 0) {
							centre = "[o]";
							turnNumber = turnNumber + 1;
							b2 = 2;
							validInput = true;
						}//end if

						else {
							System.out.println("That spot is already taken. Please try again.");
						}//end else

					}//end if

					else if (playerChoice == 6) {
						if (b3 == 0) {
							centreRight = "[o]";
							turnNumber = turnNumber + 1;
							b3 = 2;
							validInput = true;
						}//end if

						else {
							System.out.println("That spot is already taken. Please try again.");
						}//end else

					}//end if

					else if (playerChoice == 7) {
						if (c1 == 0) {
							bottomLeft = "[o]";
							turnNumber = turnNumber + 1;
							c1 = 2;
							validInput = true;
						}//end if

						else {
							System.out.println("That spot is already taken. Please try again.");
						}//end else

					}//end if

					else if (playerChoice == 8) {
						if (c2 == 0) {
							bottomCentre = "[o]";
							turnNumber = turnNumber + 1;
							c2 = 2;
							validInput = true;
						}//end if

						else {
							System.out.println("That spot is already taken. Please try again.");
						}//end else

					}//end if

					else if (playerChoice == 9) {
						if (c3 == 0) {
							bottomRight = "[o]";
							turnNumber = turnNumber + 1;
							c3 = 2;
							validInput = true;
						}//end if

						else {
							System.out.println("That spot is already taken. Please try again.");
						}//end else

					}//end if

					else {
						System.out.println("That spot is not on the board. Please try again.");
					}//end else

				}//end while

				//printing board
				board(topLeft, topCentre, topRight, centreLeft, centre, centreRight, bottomLeft, bottomCentre, bottomRight);

				//checking if game has been won
				turnNumber = whoWon(a1, a2, a3, b1, b2, b3, c1, c2, c3, turnNumber);

			}//end if

			else if (turnNumber < 9 && numPlayers == 1) {
				validInput = false;
				while (validInput == false) {

					//creating random choice
					playerChoice = (int) (Math.random( )*9)+1;

					//finding board
					if (playerChoice == 1) {
						if (a1 == 0) {
							System.out.println("Computer chose top left");
							topLeft = "[o]";
							turnNumber = turnNumber + 1;
							a1 = 2;
							validInput = true;
						}//end if

					}//end if

					if (playerChoice == 2) {
						if (a2 == 0) {
							System.out.println("Computer chose top centre");
							topCentre = "[o]";
							turnNumber = turnNumber + 1;
							a2 = 2;
							validInput = true;
						}//end if

					}//end if

					if (playerChoice == 3) {
						if (a3 == 0) {
							System.out.println("Computer chose top right");
							topRight = "[o]";
							turnNumber = turnNumber + 1;
							a3 = 2;
							validInput = true;
						}//end if

					}//end if

					if (playerChoice == 4) {
						if (b1 == 0) {
							System.out.println("Computer chose centre left");
							centreLeft = "[o]";
							turnNumber = turnNumber + 1;
							b1 = 2;
							validInput = true;
						}//end if

					}//end if

					if (playerChoice == 5) {
						if (b2 == 0) {
							System.out.println("Computer chose centre");
							centre = "[o]";
							turnNumber = turnNumber + 1;
							b2 = 2;
							validInput = true;
						}//end if

					}//end if

					if (playerChoice == 6) {
						if (b3 == 0) {
							System.out.println("Computer chose centre right");
							centreRight = "[o]";
							turnNumber = turnNumber + 1;
							b3 = 2;
							validInput = true;
						}//end if

					}//end if

					if (playerChoice == 7) {
						if (c1 == 0) {
							System.out.println("Computer chose bottom left");
							bottomLeft = "[o]";
							turnNumber = turnNumber + 1;
							c1 = 2;
							validInput = true;
						}//end if

					}//end if

					if (playerChoice == 8) {
						if (c2 == 0) {
							System.out.println("Computer chose bottom centre");
							bottomCentre = "[o]";
							turnNumber = turnNumber + 1;
							c2 = 2;
							validInput = true;
						}//end if

					}//end if

					if (playerChoice == 9) {
						if (c3 == 0) {
							System.out.println("Computer chose bottom right");
							bottomRight = "[o]";
							turnNumber = turnNumber + 1;
							c3 = 2;
							validInput = true;
						}//end if

					}//end if

				}//end while

				//printing board
				board(topLeft, topCentre, topRight, centreLeft, centre, centreRight, bottomLeft, bottomCentre, bottomRight);

				//checking if game has been won
				turnNumber = whoWon(a1, a2, a3, b1, b2, b3, c1, c2, c3, turnNumber);

			}//end else if

			if (turnNumber > 9) {
				validInput = false;
				while (validInput == false) {
					System.out.println("Press 1 to play again, press 2 to exit the program.");
					try {
						playAgain = myInput.nextInt();
						if (playAgain < 1 || playAgain > 2) {
							validInput = false;
						}//end if

					}//end try

					catch (Exception e) {
						System.out.println("Not a valid input.");

						//stopping infinite loop
						myInput.nextLine();

						//retrying
						validInput = false;
					}//end catch

					finally {

					}//end finally

					//playing again
					if (playAgain == 1) {
						System.out.println("Restarting game.");

						//resetting variables
						turnNumber = 1;
						a1 = 0;
						a2 = 0;
						a3 = 0;
						b1 = 0;
						b2 = 0;
						b3 = 0;
						c1 = 0;
						c2 = 0;
						c3 = 0;
						topLeft = "[ ]";
						topCentre = "[ ]";
						topRight = "[ ]";
						centreLeft = "[ ]";
						centre = "[ ]";
						centreRight = "[ ]";
						bottomLeft = "[ ]";
						bottomCentre = "[ ]";
						bottomRight = "[ ]";
						validInput = true;
					}//end if

					else if (playAgain == 2) {
						System.out.println("Thank you for playing.");
						validInput = true;
						turnNumber = 11;
					}//end else if

				}//end while

			}//end if

		}//end while

		//announcing game end
		System.out.println("Game Over.");

		//closing scanner
		myInput.close();

	}//end main method

	/* Method Name: board
	 * Description: Prints the board to the console
	 * Parameters: each section of board (String topLeft, String topCentre, String topRight, String centreLeft, String centre, String centreRight, String bottomLeft, String bottomCentre, String bottomRight)
	 * Returns: n/a
	 */
	public static void board(String topLeft, String topCentre, String topRight, String centreLeft, String centre, String centreRight, String bottomLeft, String bottomCentre, String bottomRight) {
		System.out.println(topLeft + topCentre + topRight);
		System.out.println(centreLeft + centre + centreRight);
		System.out.println(bottomLeft + bottomCentre + bottomRight);
	}//end board method

	/* Method Name: whoWon
	 * Description: checks if a player won
	 * Parameters: each section of board (String topLeft, String topCentre, String topRight, String centreLeft, String centre, String centreRight, String bottomLeft, String bottomCentre, String bottomRight)
	 * Returns: n/a
	 */
	public static int whoWon(int a1, int a2, int a3, int b1, int b2, int b3, int c1, int c2, int c3, int turnNumber) {
		if (a1 == 1 && a2 == 1 && a3 == 1 || b1 == 1 && b2 == 1 && b3 == 1 || c1 == 1 && c2 == 1 && c3 == 1 || a1 == 1 && b1 == 1 && c1 == 1 || a2 == 1 && b2 == 1 && c2 == 1 || a3 == 1 && b3 == 1 && c3 == 1 || a1 == 1 && b2 == 1 && c3 == 1 || a3 == 1 && b2 == 1 && c1 == 1) {
			System.out.println("Player 1 Wins!");
			turnNumber = 10;
		}//end if

		else if (a1 == 2 && a2 == 2 && a3 == 2 || b1 == 2 && b2 == 2 && b3 == 2 || c1 == 2 && c2 == 2 && c3 == 2 || a1 == 2 && b1 == 2 && c1 == 2 || a2 == 2 && b2 == 2 && c2 == 2 || a3 == 2 && b3 == 2 && c3 == 2 || a1 == 2 && b2 == 2 && c3 == 2 || a3 == 2 && b2 == 2 && c1 == 2) {
			System.out.println("Player 2 Wins!");
			turnNumber = 10;
		}//end else if

		return turnNumber;

	}//end whoWon method

}//end TicTacToe class

