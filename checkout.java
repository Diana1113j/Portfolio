package Arrays;

import java.util.Scanner;

public class checkout {

	public static void main(String[] args) {

		//scanner class
		Scanner myInput = new Scanner ( System.in );

		/*This code asks the user to enter the total amount and prints out the total cost including taxes.
		 * The user inputs the amount of cash they will use to pay the items, and the most efficient change is 
		 * given to the user. 
		 */

		// state variables
		int itemAmount, cash;
		double tax, totalCost, totalBill, Cost, change, need;


		//tell the amount of items user is buying
		System.out.println("How many items are you buying?");
		itemAmount = myInput.nextInt();

		//create an array in the memory of item Amount
		String [] itemName = new String [itemAmount];
		double [] itemCost = new double [itemAmount];

		//for loop to ask user to scan item for the amount of item amount
		for(int i = 0; i < itemAmount ;i++)
		{
			//ask user to scan each item
			System.out.println("Scan each item.");
			//ask user to input cost of item 
			System.out.println("Enter the cost of item.");

			//user input the cost of item 
			itemCost[i] = myInput.nextInt();

			//ask user to input name of item 
			System.out.println("Enter the name of item.");
			//user input name of item 
			itemName[i] = myInput.next();

			myInput.nextLine();

		}//end for loop 

		//call method to calculate the total cost of item
		totalCost = calculateCost(itemAmount, itemCost);

		//declare variables 
		tax = 0.13 * totalCost;
		totalBill = totalCost + tax;
		Cost = Math.round( totalBill * 100.0) / 100.0;
		//print out the total bill
		System.out.println("RECEIPT");
		System.out.println("------------");

		//for loop 
		for (int i = 0; i < itemAmount; i++)
		{
			System.out.println( itemName[i] + " = $" + itemCost[i]);
		}
		System.out.println("tax = $" + tax);
		System.out.println("------------");
		System.out.println("Total bill = $" + Cost);

		//ask user how much cash you are paying with 
		System.out.println("How much cash are you paying with?");
		cash = myInput.nextInt();
		change = cash - Cost;

		//if you pay less cash than the cost state the amount you need to pay 
		if (totalBill > cash) 
		{
			need = totalBill - cash;
			System.out.println("Sorry. You need $" + need + " more to purchase.");
		}

		//state variables for each bill
		int hundred = (int)change / 100;
		int fifty = (int)(change - hundred*100) / 50;
		int twentyFive = (int)(change - hundred*100-fifty*50) / 25;
		int ten = (int)(change - hundred*100 - fifty*50 - twentyFive * 25) / 10;
		int five = (int)(change - hundred*100 - fifty*50 - twentyFive *25 - ten*10) / 5;
		int twoonie = (int)(change - hundred*100 - fifty*50 - twentyFive *25 - ten*10 - five*5) / 2;
		int loonie = (int)(change - hundred*100 - fifty*50 - twentyFive *25 - ten*10 - five*5 - twoonie*2) / 1;
		double quarter =(int)(change - hundred*100 - fifty*50 - twentyFive *25 - ten*10 - five*5 - twoonie*2 - loonie) / 0.25;
		int realQuarter = (int)quarter;
		double dime = (int)(change - hundred*100 - fifty*50 - twentyFive *25 - ten*10 - five*5 - twoonie*2 - loonie - realQuarter*0.25) / 0.10;
		int realDime = (int)dime;
		double nickel =(int)(change - hundred*100 - fifty*50 - twentyFive *25 - ten*10 - five*5 - twoonie*2 - loonie - realQuarter*0.25 -realDime*0.10) / 0.05;
		int realNickel = (int)nickel;

		//output amount of change depending on the amount of change
		if (change >= 100 )
		{
			System.out.println("You will have " + hundred + " hundred dollar bills " + fifty + " fifty dollar bills" + twentyFive + " twenty five dollar bills " + ten + " ten dollar bills " + five + " five dollar bills " + twoonie + " twoonies " + loonie + " loonies " + realQuarter + " quarter coins " + realDime + " dime coins " + realNickel + " nickel coins. ");
		}
		else if (change >= 50)
		{ 
			System.out.println("You will have " + fifty + " fifty dollar bills" + twentyFive + " twenty five dollar bills " + ten + " ten dollar bills " + five + " five dollar bills " + twoonie + " twoonies " + loonie + " loonies " + realQuarter + " quarter coins " + realDime + " dime coins " + realNickel + " nickel coins. ");
		}
		else if (change >= 25 )
		{
			System.out.println("You will have " + twentyFive + " twenty five dollar bills " + ten + " ten dollar bills " + five + " five dollar bills " + twoonie + " twoonies " + loonie + " loonies " + realQuarter + " quarter coins " + realDime + " dime coins " + realNickel + " nickel coins. ");
		}
		else if (change >= 10)
		{
			System.out.println("You will have " + ten + " ten dollar bills " + five + " five dollar bills " + twoonie + " twoonies " + loonie + " loonies " + realQuarter + " quarter coins " + realDime + " dime coins " + realNickel + " nickel coins. ");
		}
		else if (change >= 5)
		{
			System.out.println("You will have "+ five + " five dollar bills " + twoonie + " twoonies " + loonie + " loonies " + realQuarter + " quarter coins " + realDime + " dime coins " + realNickel + " nickel coins. ");
		}
		else if (change >= 2)
		{
			System.out.println("You will have " + twoonie + " twoonies " + loonie + " loonies " + realQuarter + " quarter coins " + realDime + " dime coins " + realNickel + " nickel coins. ");
		}
		else if (change >= 1)
		{
			System.out.println("You will have " + loonie + " loonies " + realQuarter + " quarter coins " + realDime + " dime coins " + realNickel + " nickel coins. ");
		}
		else if (change >= 0.25)
		{
			System.out.println("You will have " + realQuarter + " quarter coins " + realDime + " dime coins " + realNickel + " nickel coins. ");
		}
		else if (change >= 0.10)
		{
			System.out.println("You will have " + realDime + " dime coins " + realNickel + " nickel coins. ");
		}
		else if (change >= 0.05)
		{
			System.out.println("You will have " + realNickel + " nickel coins. ");
		}

		//close the coding with the following statement 
		System.out.println("Thank you for shopping. Have a great rest of your day :)");

		myInput.close();
	}//end main

	public static double calculateCost(int itemAmount, double[] itemCost) 
	{
		int sum = 0;

		for (int i = 0; i < itemCost.length; i++)
			sum += itemCost[i];

		return sum;
	}//end calculateCost 

}//end class
