///////////////////////////////////////////////////////////
//
// Alex Brewer
// CSC 160 Computer Science 1
// Nov 18, 2020
// 30 or Bust!
//
///////////////////////////////////////////////////////////

// import my scanner
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        // set up the 2 players
        Player player1 = new Player();
        Player player2 = new Player();
        // Display the Welcoming
        displayWelcome();
        // Allow players to enter their names
        setUpNames(player1, player2);
        runGame(player1, player2);
    }
    public static void runGame(Player player1, Player player2 ){
        Scanner input = new Scanner(System.in);
        // Set up the integers for the dice and their sum
        int dice1, dice2, diceSum, playerTurn = 1;
        // check if a player has wont the game.
        boolean winner = false;
        while (!winner){
            switch (playerTurn) {
                case 1:
                    dice1 = rollDice();
                    dice2 = rollDice();
                    diceSum = dice1 + dice2;
                    System.out.println("");
                    System.out.println(player1.getName() + "'s turn.");
                    System.out.println("Dice one rolled a " + dice1);
                    System.out.println("Dice two rolled a " + dice2);
                    System.out.println("For a total of " + diceSum);
                    player1.displayScore();
                    System.out.println("Would you like to (1) add the first roll of " + dice1 + ", (2) add the second roll of " + dice2 + ", or (3) add the total of " + diceSum + " to your score? ");
                    System.out.print("Please enter either \"1\", \"2\", or \"3\". ");
                    int option = input.nextInt();
                    while (option != 1 && option != 2 && option != 3){
                        System.out.println("");
                        System.out.print(option + " was not a valid input. please enter either \"1\", \"2\", or \"3\". ");
                        option = input.nextInt();
                    }
                    if(option == 1){
                        player1.updateScore(dice1);
                    }
                    else if (option == 2){
                        player1.updateScore(dice2);
                    }
                    else{
                        player1.updateScore(diceSum);
                    }
                    if(player1.checkScore()){
                        winner = true;
                        break;
                    }
                    else {
                        playerTurn = 2;
                    }
                case 2:
                    dice1 = rollDice();
                    dice2 = rollDice();
                    diceSum = dice1 + dice2;
                    System.out.println("");
                    System.out.println(player2.getName() + "'s turn.");
                    System.out.println("Dice one rolled a " + dice1);
                    System.out.println("Dice two rolled a " + dice2);
                    System.out.println("For a total of " + diceSum);
                    player2.displayScore();
                    System.out.println("Would you like to (1) add the first roll of " + dice1 + ", (2) add the second roll of " + dice2 + ", or (3) add the total of " + diceSum + " to your score? ");
                    System.out.print("Please enter either \"1\", \"2\", or \"3\". ");
                    option = input.nextInt();
                    while (option != 1 && option != 2 && option != 3){
                        System.out.println("");
                        System.out.print( option + " was not a valid input. please enter either \"1\", \"2\", or \"3\". ");
                        option = input.nextInt();
                    }
                    if(option == 1){
                        player2.updateScore(dice1);
                    }
                    else if (option == 2){
                        player2.updateScore(dice2);
                    }
                    else{
                        player2.updateScore(diceSum);
                    }
                    if(player2.checkScore()){
                        winner = true;
                        break;
                    }
                    else {
                        playerTurn = 1;
                    }

            }
        }
    }

    public static int rollDice(){
        // get a random number between 1 and 6
        return (int) (Math.random() * (7 - 1)) + 1;
    }

    public static void displayWelcome(){
        // Display the Game and it's rules
        System.out.println("");
        System.out.println("Welcome to 30 or Bust");
        System.out.println("");
        System.out.println("The goal of this game is to accrue a total score of 30. The first player to reach that score is declared the winner.");
        System.out.println("If a player's score exceeds the total of 30, you will \"Bust\" and the score will reset back to zero");
        System.out.println("The first of two players will roll a pair of six sided dice. That player must then choose to take the sum of those dice or any of the face values to add to their total.");
        System.out.println("Then, the other player will roll.");
        System.out.println("The first player to reach a score of exactly 30 wins.");
        System.out.println("Good luck!");
        System.out.println("");
    }

    public static void setUpNames(Player player1, Player player2){
        // set up scanner for player input
        Scanner input = new Scanner(System.in);
        // prompt player 1 to enter their name
        System.out.println("Before we begin, you must tell me your names.");
        System.out.print("Player one, please enter your name: ");
        player1.setName(input.next());
        // print player 1's name and allow them to review it
        System.out.print("Is you name " + player1.getName() + "? (Enter \"y\" for yes or \"n\" for no.) " );
        String YorN = input.next();
        // grab their entry as a character
        char choice = YorN.charAt(0);

        // Check if the player did not like their name
        while(choice != 'y'){
            // if they did not like the name allow them to change it.
            if (choice == 'n') {
                System.out.print("Please enter you name: ");
                player1.setName(input.next());
                System.out.print("Is you name " + player1.getName() + "? (Enter \"y\" for yes or \"n\" for no.) " );
            }
            // if the input was not a y or an n have the user reenter it
            else{
                System.out.print("That was not a valid input (enter \"y\" for yes or \"n\" for no). ");
            }
            YorN = input.next();
            choice = YorN.charAt(0);
        }
        // Prompt player 2 to pick a name and proceed through the same steps as player 1
        System.out.println("");
        System.out.print("Player two, please enter you name: ");
        player2.setName(input.next());
        System.out.print("Is you name " + player2.getName() + "? (Enter \"y\" for yes or \"n\" for no.) " );
        YorN = input.next();
        choice = YorN.charAt(0);

        while(choice != 'y'){
            if (choice == 'n') {
                System.out.print("Please enter you name: ");
                player2.setName(input.next());
                System.out.print("Is you name " + player2.getName() + "? (Enter \"y\" for yes or \"n\" for no.) " );
            }
            else{
                System.out.print("That was not a valid input (enter \"y\" for yes or \"n\" for no). ");
            }
            YorN = input.next();
            choice = YorN.charAt(0);
        }
        // Display both players' names and proceed with the game
        System.out.println("");
        System.out.println("Thank you " + player1.getName() + " and " + player2.getName() + " For playing.");
        System.out.println("let's begin!");
    }
}