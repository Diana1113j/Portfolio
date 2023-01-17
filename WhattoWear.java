package Arrays;

import java.util.*;

public class WhattoWear {

	public static void main(String[] args) {
		
		/*This code asks the user for the temperature, precipitation, and the type of day.
		 * Based on the temperature, precipitation, and the type of day, the output is 
		 * shown. 
		 */

		//scanner class
		Scanner myInput = new Scanner ( System.in );

		//Declare and initialize variables
		int lowestTemp, highestTemp, averageTemp, chanceOfRain;
		String sunny, cloudy, windy;

		//start the code by introducing the system to the user
		System.out.println("Welcome to \"What to Wear\",\nTo help you decide, I need to know some information...");

		//ask user to input lowest temperature
		System.out.println("\nDuring the time you intend to be out,\n\t What will the lowest temperature be? (°C)");
		lowestTemp = myInput.nextInt();
		myInput.nextLine();

		//error check for lowest Temperature for too high and too low values
		if (lowestTemp <= -40 || lowestTemp >= 40)
		{
			System.out.println("I'm sorry, your input for the lowest temperature is an invalid temperature value. Please double check your entry.");
			System.exit(0);
		}

		//highest temperature 
		System.out.println("\tWhat will the highest temperature be? (°C)");
		highestTemp = myInput.nextInt();
		myInput.nextLine();

		//error check for highest temperature for too high and too low values
		if ( highestTemp <= -40 || highestTemp >= 40 )
		{
			System.out.println("I'm sorry, your input for the highest temperature is an invalid temperature value. Please double check your entry.");
			System.exit(0);
		}

		//error check for temperature if lowest temperature value is higher than highest temperature value
		if (lowestTemp > highestTemp)
		{
			System.out.println("Please double check your entry. \nYou have the lowest temperature higher than the highest temperature.");
			System.exit(0);
		}

		//calculate averageTemp
		averageTemp = (lowestTemp + highestTemp)/2;

		//ask user to input precipitation percentage value 
		System.out.println("\tWhat is the chance of precipitation? Enter the percentage value.");
		chanceOfRain = myInput.nextInt();
		myInput.nextLine();

		//error check for percentage lower than 0 or higher than 100
		if (chanceOfRain < 0 || chanceOfRain > 100)
		{
			System.out.println("Please double check your entry. It is an invalid percentage value. Input between 0 to 100.");
			System.exit(0);
		}

		//ask user to input Y or No for if it will be sunny
		System.out.println("For the following questions, please answer Y for yes or N for no:");
		System.out.println("\tWill it be sunny?");
		sunny = myInput.nextLine();

		//if N on sunny question ask next question if Y, move on
		if (sunny.equalsIgnoreCase("N"))
		{
			//ask user if the day will be cloudy 
			System.out.println("\tWill it be cloudy?");
			cloudy = myInput.nextLine();

			//if N on cloudy question ask next question if Y, move on 
			if (cloudy.equalsIgnoreCase("N"))
			{
				//ask user if the day will be windy 
				System.out.println("\tWill it be windy?");
				windy = myInput.nextLine();

				//error trap for putting N on all three
				if (windy.equalsIgnoreCase("N"))
				{
					System.out.println("I'm sorry. You have inputed N for all three questions.\nPut Y on either sunny, cloudy, or windy.\nTry again.");
					System.exit(0);
				}

				//error trap for putting neither Y or N in windy
				else if (!windy.equalsIgnoreCase("Y") && !windy.equalsIgnoreCase("N"))
				{
					System.out.println("I'm Sorry, could you type either Y or N for the value?");
					System.exit(0);
				}

				//output clothing for cloudy day user
				else if (windy.equalsIgnoreCase("Y"))
				{
					System.out.println("I think you should wear:");
					System.out.println("\t - Underwear (Obviously!)\n\t - hat(windy)");

					//add scarf if temperature is below -10
					if (lowestTemp <= -10)
					{
						System.out.println("\t - scarf (windy & very cold)");
					}
				}

			}//add if statement for input of N in cloudy question

			//error trap for putting neither Y or N in cloudy
			else if (!cloudy.equalsIgnoreCase("Y") && !cloudy.equalsIgnoreCase("N"))
			{
				System.out.println("I'm Sorry, could you type either Y or N for the value?");
				System.exit(0);
			}

			//output clothing for cloudy day user
			else if (cloudy.equalsIgnoreCase("Y"))
			{
				System.out.println("I think you should wear:");
				System.out.println("\t - Underwear (Obviously!)");
			}
		}//end if statement for input N on sunny question

		//error trap for putting different alphabet not Y or N
		else if (!sunny.equalsIgnoreCase("Y") && !sunny.equalsIgnoreCase("N"))
		{
			System.out.println("I'm Sorry, could you type either Y or N for the value?");
			System.exit(0);
		}

		//output clothing for sunny day user 
		else if (sunny.equalsIgnoreCase("Y"))
		{
			System.out.println("I think you should wear:");
			System.out.println("\t - Underwear (Obviously!)\n\t - sunglasses(sunny)");
			if (highestTemp >= 25)
			{
				System.out.println("\t - ball cap(sunny)");
			}

		}//end if statement for input Y of sunny question 

		//outer wear & accessories based on average temperature
		if (averageTemp <= -20 )
		{
			System.out.println("\t - Winter coat(ESSENTIAL)\n\t - Long pants\n\t - Sweater\n\t - Mitts/gloves\n\t - Toque");

		}

		else if (averageTemp <= -10)
		{
			System.out.println("\t - Winter coat(RECOMMENDED)\n\t - Long pants\n\t - Long sleeve\n\t - Mitts/gloves\n");
		}

		else if (averageTemp <= 0)
		{
			System.out.println("\t - Winter coat(OPTIONAL)\n\t - Long pants\n\t - Long sleeve\n\t - Mitts/gloves\n");
		}

		else if (averageTemp <= 10)
		{
			System.out.println("\t - Jacket\n\t - Long pants\n\t - Long sleeve");
		}

		else if (averageTemp <= 20)
		{
			System.out.println("\t - Short sleeved shirt\n\t - long pants\n\t - long sleeve");
		}

		else if (averageTemp <= 30)
		{
			System.out.println("\t - Short sleeved shirt\n\t - Shorts\n\t - Sandals");
		}

		//Based on precipitation input value from user, output whether umbrella is needed
		if (chanceOfRain >= 100)
		{
			System.out.println("\t - rain boots\n\t - umbrella (STRONGLY RECOMMENDED, high chance it will rain)");
		}

		else if (chanceOfRain >= 50)
		{
			System.out.println("\t - umbrella (recommended) ");
		}

		else if (chanceOfRain >= 20)
		{
			System.out.println("\t - umbrella (optional since chance of raining is low)");
		}

		//end coding with following statement
		System.out.println("\n\tHave a wonderful day!");

		//closes the scanner
		myInput.close();
	}//end main

}//end class

