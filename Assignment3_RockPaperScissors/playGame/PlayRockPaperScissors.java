package playGame;
import java.util.Scanner;
import java.util.Random;

public class PlayRockPaperScissors {
	/*CPSC 24500-001- Object-Oriented Programming
	 * Assignment 3-Rock, Paper, and Scissors
	 * This program plays the game of Rock, Paper and Scissors against the computer
	 */
	public static void main(String[] args) {
		//Welcome Banner & Rules of the game
		System.out.print(" *** Welcome to Rock, Paper & Scissors Game!***\n");
        System.out.println("Here are the rules for the game:");
        System.out.print("1.Rock vs Scissors --> Rock breaks the Scissors..\n2.Scissors vs Paper --> Scissors slices the Paper..");
        System.out.print("\n3.Paper vs Rock --> Paper Flods the Rock..\n");
        System.out.print("Same choice play again!!\nLet's start the Game!\n");
        
        Scanner sc = new Scanner(System.in);
        boolean playAgain = true;
        while (playAgain) {
            int userChoice = userChoice(sc);
            
            //Randomly generated Computers choice & display the choice that computer made;
            int computerChoice = generateComputerChoice();
            // select the winner
            selectWinner(userChoice, computerChoice);

            // Ask the user if he/she wants to play again
            System.out.print("\nDo you want to play another game? Then Enter Y: ");
            String response = sc.next();
            if (!response.equalsIgnoreCase("Y")) {
                playAgain = false;
            }
        }
        if (playAgain == false)
        	System.out.print("\nThanks for Playing..");
	}
	public static int userChoice(Scanner sc)
	{
		int choice = 0;
        while (choice < 1 || choice > 3) {
        System.out.print("\nEnter your choice: 1 for Rock, 2 for Paper and 3 for Scissors:");
        while (!sc.hasNextInt()) {
            System.out.print("Invalid input! Try again!!  Please number (1, 2 or 3):");
            sc.next();
        }
        choice = sc.nextInt();
        if (choice < 1 || choice > 3) {
            System.out.print("Invalid input! Try again!! \n");
        }
       }
      return choice;
    }
	public static int generateComputerChoice() {
        Random random = new Random();
        return random.nextInt(3) + 1;
    }
	public static void selectWinner(int userChoice, int computerChoice) {
		 System.out.println("Your choice: "+displayChoice(userChoice));
		 System.out.println("Computer has Choosen: "+displayChoice(computerChoice));
		 showTheRule(computerChoice,userChoice);
		 		
        if (userChoice == computerChoice) {
            System.out.print("\nSame Choice made..It's a tie! play again!!\n");
        } else if ((userChoice == 1 && computerChoice == 3) ||
                   (userChoice == 2 && computerChoice == 1) ||
                   (userChoice == 3 && computerChoice == 2)) {
            System.out.print("Congratulations... You win!!!!\n");
        } else {
            System.out.print("Computer wins! Better luck next time....\n");
        }
        System.out.println("-------------------------------------------");
    }
	
	//Shows the rule determined for the chosen option
	public static void showTheRule(int userChoice, int computerChoice) {
		
			
		if((userChoice == 1 && computerChoice == 3) ||(userChoice == 3 && computerChoice == 1))
		{
			System.out.println("\nRock breaks the Scissors");
		}
		else if ((userChoice == 2 && computerChoice == 1) || (userChoice == 1 && computerChoice == 2) )
		{
			System.out.println("\nPaper Flods the Rock..");
		}
		else if((userChoice == 3 && computerChoice == 2) || (userChoice == 2 && computerChoice == 3))
		{
			System.out.println("\nScissors slices the Paper..");
		}
		else
		{
			System.out.print("");
		}
     }
	  //Getting choice name from the selected number
	public static String displayChoice(int number)
	{
		String chosenOption = "";
        if( number == 1 ){
        	chosenOption = "Rock";
        }else if( number == 2 ){
        	chosenOption = "Paper";
        }else if( number == 3 ){
        	chosenOption = "Scissors";
        }
        return chosenOption;
 	}
}

