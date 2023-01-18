import java.awt.event.KeyAdapter;
import java.util.Random;
import java.util.Scanner;
import java.awt.event.KeyEvent;
public class RandomDice {
    public static void play(){
        //start new game
        Scanner in=new Scanner(System.in);
        boolean out = true;
        //while loop for inputs on how many players
        while(out){
            System.out.println("Would you like to play (1) player or (2)");
            String input =in.nextLine();
            //accept input to be tested if not 1 or 2 ask for another input
            if(input.equals("1")){
                OnePlayer(in);
                out = false;
            }
            if(input.equals("2")){
                TwoPlayer();
                out = false;
            }
            else{
                System.out.println("Please enter 1 or 2");
            }
        }
    }
    public static void OnePlayer(Scanner in){
        //intitialize health
        int playerOneHealth = 10;
        int playerTwoHealth = 10;
        int i = 1;
        //while both players have not zero health keep playing
        while(playerOneHealth != 0 && playerTwoHealth != 0){
            //if counting variable is odd then player ones turn
            if(i%2 == 1){
                //let player know what to do
                System.out.println("player one's turn");
                System.out.println("Press enter to roll");
                //get input
                String input = in.nextLine();
                //get random number from between 1-6
                Random rand = new Random();
                int upperbound = 7;
                int lowerbound = 0;
                int intrandom = rand.nextInt(upperbound);
                //tell playing how much damage they did
                System.out.println("You rolled a " + String.valueOf(intrandom));
                //check if player health is exactly zero if it is game ends and player 1 wins else tell player they missed
                if((playerOneHealth=playerOneHealth-intrandom) > 0){

                }
                else{
                    System.out.println("You over-swung and missed");
                }
                //end of turn tell player health of both players
                System.out.println("Player One Health: " + playerOneHealth);
                System.out.println("Player Two Health: " + playerTwoHealth);
            }
            //if counting variable is even it is players twos turn
            if(i%2 == 2){
                System.out.println("player two's turn");
                Random rand = new Random();
                int upperbound = 6;
                //creates a random number from 1 to 6
                int intrandom = rand.nextInt(upperbound);
                System.out.println("You rolled a " + String.valueOf(intrandom));
                if((playerTwoHealth=playerTwoHealth-intrandom) > 0){

                }
                else{
                    System.out.printf("You over-swung and missed");
                }
                System.out.println("Player One Health: " + playerOneHealth);
                System.out.println("Player Two Health: " + playerTwoHealth);
            }
            i++;
        }

    }
    public static void TwoPlayer(){

    }
}
