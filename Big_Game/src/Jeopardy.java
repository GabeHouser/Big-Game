import java.util.Random;
import java.util.Scanner;

public class Jeopardy{

    static int player1points = 0;
    static int player2points = 0;
    static boolean isSinglePlayer;

    public static void play(){
        //ask user for multiPlayer() or singlePlayer() @TODO test
        Scanner scnr = new Scanner(System.in);

        int userGameSelection = 0;

        while (userGameSelection != 1 || userGameSelection != 2){

            System.out.println("would you like to play single (1) or multi (2)");
            userGameSelection = scnr.nextInt();

            if (userGameSelection == 1){
                isSinglePlayer = true;
                singlePlayer();
            }
            else if (userGameSelection == 2){
                isSinglePlayer = false;
                multiPlayer();
            }

            else {

                System.out.println("Not a valid input only enter '1' or '2'.");

            }
        }
    }



    public static void multiPlayer(){
        //roll to see who goes first
        if(diceRoll()==1){ //Returns 1 or 2 for which player goes first
            //player 1
            //ask dice roll winner which board to play


            switch (askGame()){

                case 1:
                    playGeoGuesser(1);
                case 2:
                    playITT(1);
                case 3:
                    playNTP(1);

            }

        }
        else{
            //player 2
            //ask dice roll winner which board to play
            switch (askGame()){

                case 1:
                    playGeoGuesser(2);
                case 2:
                    playITT(2);
                case 3:
                    playNTP(2);

            }
        }


    }
    public static void singlePlayer(){
        //ask which board to play @TODO
        switch (askGame()){

            case 1:
                playGeoGuesser(-1);
            case 2:
                playITT(-1);
            case 3:
                playNTP(-1);

        }
    }

    public static int askGame(){
        Scanner scnr = new Scanner(System.in);
        int userGameSelection = 0;
        boolean isVaild = false;

        while(!isVaild){

            System.out.println("Enter 1 for Geoguesser \nEnter 2 for IT Triva \nEnter 3 for Name That person \n");
            userGameSelection = scnr.nextInt();

            if (userGameSelection == 1 || userGameSelection == 2 || userGameSelection == 3){
                isVaild = true;
            }
            else {
                System.out.println("Not a vaild input only enter '1' , '2' or '3'.");
            }
        }
        return userGameSelection;
    }

    public static boolean checkIfDone(boolean[][] subgameBoolArray){
        for(int i = 0; subgameBoolArray.length > i; i++){
            for(int row = 0; row<3 ;row++){
                for(int column = 0; column<3 ;column++){
                    if (subgameBoolArray[row][column] == false){
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static boolean askQuestion(Scanner in, String question, String choice1, String choice2, String choice3, int answer, int points){
        boolean answered = false;
        //prompt -- can change syntax
        System.out.println(question + "\n" + "\n" + choice1 + "\n" + choice2 + "\n" + choice3);
        //basically while false
        while (!answered){
            //get input
            String input=in.nextLine();
            //if 1, 2 or 3 == proper input
            if(Integer.parseInt(input) == 1 || Integer.parseInt(input) == 2 || Integer.parseInt(input) == 3){
                //if user answer and correct answer are the same reward int points
                if(Integer.parseInt(input) == answer){
                    System.out.println(points);
                    System.out.println("correct");
                    //if return true should be added to bool array
                    return true;
                }
                else{
                    //else the question was answered wrong and return true to bool array to show question was answered
                    System.out.println("wrong");
                    return true;
                }
            }
            System.out.println("Enter number 1, 2 or 3");
        }
        return false;
    }

    public static void playGeoGuesser(int playerTurn){
        //INITIALIZE VARIABLES
        //GeoGuesser Qestions Array
        String[][] GGQA = new String[3][3];
        boolean[][] GGBA = new boolean[3][3];
        //go till array done
        if(checkIfDone(GGBA)){
            //go to final question
        }
        //FLAGS Questions @TODO
        GGQA[1][1] = "";
        GGQA[1][2] = "";
        GGQA[1][3] = "";
        //LANDMARKS Questions @TODO
        GGQA[2][1] = "";
        GGQA[2][2] = "";
        GGQA[2][3] = "";
        //MAP SILHOUETTE Questions @TODO
        GGQA[3][1] = "";
        GGQA[3][2] = "";
        GGQA[3][3] = "";


        //SINGLE PLAYER @TODO



        //MULTI PLAYER @TODO



    }
    public static void playNTP(int playerTurn){
        //INITIALIZE VARIABLES
        //ADD QUESTIONS @TODO
        //Name That Person Question Array
        String[][] NTPQA = new String[3][3];

        //ACTORS Questions @TODO
        NTPQA[1][1] = "";
        NTPQA[1][2] = "";
        NTPQA[1][3] = "";
        //MUSICIANS Questions @TODO
        NTPQA[2][1] = "";
        NTPQA[2][2] = "";
        NTPQA[2][3] = "";
        //ARTISTS Questions @TODO
        NTPQA[3][1] = "";
        NTPQA[3][2] = "";
        NTPQA[3][3] = "";

        //SINGLE PLAYER @TODO



        //MULTI PLAYER @TODO



    }
    public static void playITT(int playerTurn){
        //INITIALIZE VARIABLES
        //ADD QUESTIONS @TODO
        //IT Trivia Questions Array
        String[][] ITTQA = new String[3][3];

        //CYBER SECURITY Questions @TODO
        ITTQA[1][1] = "";
        ITTQA[1][2] = "";
        ITTQA[1][3] = "";
        //HARDWARE Questions @TODO
        ITTQA[2][1] = "";
        ITTQA[2][2] = "";
        ITTQA[2][3] = "";
        //SOFTWARE Questions @TODO
        ITTQA[3][1] = "";
        ITTQA[3][2] = "";
        ITTQA[3][3] = "";

        //SINGLE PLAYER @TODO



        //MULTI PLAYER @TODO



    }
    public static void finalQuestion(Scanner scnr, int gameNum){
        //geo guesser
        if(gameNum == 1){
            if(isSinglePlayer){
                //ask player for points wagered & if points wagered is greater than 0 and less than player points total accept value
                int pointsWagered1 = askPointsWagered(scnr, player1points, "player 1 ");
                if(askFinalQ(scnr, "What is the most visited country in the world", "France")){
                    player1points = pointsWagered1*2 + player1points;
                }
                else{
                    player1points = player1points - pointsWagered1;
                    System.out.println("you lost " + pointsWagered1);
                    System.out.println("you have " + player1points + " points");
                }
            }
            if(!isSinglePlayer){
                //get points wagered
                int pointsWagered1 = askPointsWagered(scnr, player1points, "player 1 ");
                int pointsWagered2 = askPointsWagered(scnr, player2points, "player 2 ");
                //ask final question
                if(askFinalQ(scnr, "What is the most visited country in the world", "France")){

                }
                else{

                }
                //get player one answer

                //get player two answer
                //check answer
            }
        }
        //Name that person
        else if(gameNum == 2){
            //ask final question
        }
        //IT trivia
        else if(gameNum == 3){
            //ask final question
        }
    }
    static public int askPointsWagered(Scanner scnr, int playerPoints, String player){
        boolean isWagerMade = false;
        while(!isWagerMade){
            System.out.println(player + "how many points would you like to wager?");
            int pointsWager = scnr.nextInt();
            if(pointsWager > 0 && pointsWager<=playerPoints){
                return pointsWager;
            }
            else{
                System.out.println("Please enter value greater than 0 and less or equal to your points total.");
            }
        }
        return -1;
    }
    static public boolean askFinalQ(Scanner scnr, String finalQuestion, String correctAnswer){
        System.out.println(finalQuestion);
        boolean isFinalAnswer = false;
        while(!isFinalAnswer){
            if(isSinglePlayer){
                String finalAnswer = scnr.nextLine();
                System.out.println("Is " + finalAnswer + " your final answer?");
                String in = scnr.nextLine();
                if(in.equalsIgnoreCase("yes")){
                    isFinalAnswer = true;
                    if(finalAnswer.equalsIgnoreCase(correctAnswer)){
                        //award double points wagered
                        System.out.println("Correct the answer is " + correctAnswer);
                        return true;
                    }
                    else{
                        System.out.println(finalAnswer + "was not correct. The answer is: " + correctAnswer);
                        return false;
                    }
                }
                else{
                    System.out.println("please re-enter your final answer");
                }
            }
        }
        return false;
    }
    public static int diceRoll(){
        //get random int
        Random rand = new Random();
        boolean goesFirst = true;
        //roll till winner
        while(goesFirst){
            int playerOneRoll = rand.nextInt(6)+1;
            int playerTwoRoll = rand.nextInt(6)+1;
            //player 1 wins
            if(playerOneRoll<playerTwoRoll && playerOneRoll!=playerTwoRoll){
                return 1;
            }
            //player 2 wins
            if(playerTwoRoll<playerOneRoll && playerOneRoll!=playerTwoRoll){
                return 2;
            }
        }
        return 0;
    }
}