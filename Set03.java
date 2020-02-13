import java.io.*;
import java.util.Random;
import java.util.Scanner;
import java.util.InputMismatchException;


public class Set03 {
    private static int playerScore = 0;
    private static int computerScore = 0;

    public static void main(String[] args) {
        home();
    }

        public static void home(){
        prelimFileCheck();
        System.out.println("Rock, Paper, Sccissors, Lizard, Spock!");
        System.out.println("1.) Play Game.");
        System.out.println("2.) Show Scores.");
        System.out.println("3.) Exit.");
        System.out.println("4.) Reset scores");
            System.out.print(": ");


            Scanner in = new Scanner(System.in);
        int choice = in.nextInt();

        if (choice == 1){
            gameMenu();
        }
        else if (choice==2){
            gameScore();

        }
        else if(choice==3){
            System.exit(0);
        }
        else if(choice==4){
            fileWipe();
            System.out.println("And so it is done.");
            home();
        }

        else {
            System.out.println("You entered an invalid choice. Please choose again");
            home();
            }

    }

    public static void gameMenu() { //remake method for roll
        System.out.println("_ _ _ _ _ _ _ _ _ _ _");
        System.out.println("What is your weapon of choice ?");
        System.out.println("0: Rock");
        System.out.println("1: Paper");
        System.out.println("2: Scissors");
        System.out.println("3: Lizard");
        System.out.println("4: Spock");
        System.out.println("6: Save and Quit");
        System.out.print(": ");


        Scanner in = new Scanner(System.in);
        int userWeapon = in.nextInt();

        if (userWeapon == 6){
            saveGame();
        System.exit(0);
         }

        else if (userWeapon > 6){
            System.out.println("Please choose a valid option from the menu.");
            gameMenu();
        }

        else
            battle(userWeapon);
    }

    static String intToString(int x) {
        switch (x) {
            case 0:
                return "Rock";
            case 1:
                return "Paper";
            case 2:
                return "Scissors";
            case 3:
                return "Spock";
            case 4:
                return "Lizard";
            default:
                return "Not def.";
        }
    }


    public static void battle( int userWeapon) {
        int computerWeapon = compRoll();
        String userString = intToString(userWeapon);
        String compString = intToString(computerWeapon);

        if (userWeapon == computerWeapon) {
            System.out.println("Tie! You had " + userWeapon + " and the Pc had " + compString);
            System.out.println("Your score is " + playerScore + " and the computers' score is " + computerScore);
            gameMenu();

        } else if (userWeapon == 0 && (computerWeapon == 2 || computerWeapon == 4)) {
            System.out.println("You won! You Had "  + userString + " and the Pc had " + compString);
            playerScore++;
            System.out.println("Your score is " + playerScore + " and the computers' score is " + computerScore);
            gameMenu();
        } else if (userWeapon == 1 && (computerWeapon == 0 || computerWeapon == 3)) {
            System.out.println("You won! You had " + userString + " and the Pc had " + compString);
            playerScore++;
            System.out.println("Your score is " + playerScore + " and the computers' score is " + computerScore);
            gameMenu();
        } else if (userWeapon == 2 && (computerWeapon == 1 || computerWeapon == 4)) {
            System.out.println("You won! You had " + userString + " and the Pc had " + compString);
            playerScore++;
            System.out.println("Your score is " + playerScore + " and the computers' score is " + computerScore);
            gameMenu();
        } else if (userWeapon == 3 && (computerWeapon == 0 || computerWeapon == 2)) {
            System.out.println("You won! You had " + userString + " and the Pc had " + compString );
            playerScore++;
            System.out.println("Your score is " + playerScore + " and the computers' score is " + computerScore);
            gameMenu();
        } else if (userWeapon == 4 && (computerWeapon == 1 || computerWeapon == 3)) {
            System.out.println("You won! You had " + userString + " and the Pc had " + compString);
            playerScore++;
            System.out.println("Your score is " + playerScore + " and the computers' score is " + computerScore);
            gameMenu();

        } else {
            System.out.println ("You lost. You had " + userString + " and the Pc had " + compString);
            computerScore++;
            System.out.println("Your score is " + playerScore + " and the computers' score is " + computerScore);
            gameMenu();
        }
    }

    public static int compRoll (){ //method for computers choice
        Random compRoll = new Random();
        return (compRoll.nextInt(6-1)+0);

    }

    public static void saveGame() {
        try {
            PrintWriter saveWriter = new PrintWriter(new FileWriter("save.txt"));

            saveWriter.println(playerScore);
            saveWriter.println(computerScore);
            saveWriter.close();
            System.exit(0);

        } catch (IOException e) {
            System.out.println("Something went wrong.");
            e.printStackTrace();
        }
    }

    public static void gameScore(){
        System.out.println ("Your score is "+ playerScore);
        System.out.println("The computers' score is "  + computerScore);
        System.exit(0);

    }

    public static void prelimFileCheck(){
        File saveFile = new File("save.txt");
        boolean exists = saveFile.exists();

        if (!exists) {
            int userScore = 0;
            int computerScore = 0;
            try {
                PrintWriter saveWriter = new PrintWriter(new FileWriter("save.txt"));
                saveWriter.println(userScore);
                saveWriter.println(computerScore);
                saveWriter.close();
            }
            catch (IOException e) {
                System.out.println("An input output error occured");
                e.printStackTrace();
            }
        }
        // if exists
        else {
            String[] storage = new String[2];
            try {
                File file = new File("save.txt");

                Scanner saveReader = new Scanner(file);
                for (int i = 0; i <= 1; ) {
                    storage[i] = saveReader.next();
                    i++;
                }
                playerScore = Integer.parseInt(storage[0]);
                computerScore = Integer.parseInt(storage[1]);
                System.out.println();
            } catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
        }
    }

    private static void fileWipe(){
        int userScore = 0;
        int computerScore = 0;

        try {
            PrintWriter saveWriter = new PrintWriter(new FileWriter("save.txt"));
            saveWriter.println(userScore);
            saveWriter.println(computerScore);
            saveWriter.close();
        }
        catch (IOException e) {
            System.out.println("An input output error occured");
            e.printStackTrace();
        }

    }


}
