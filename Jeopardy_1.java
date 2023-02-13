package jeopardy;
import java.util.Random;
import java.util.Scanner;

public class jeopardy{
    
    int player1points = 0;
    int player2points = 0;
        
    public static void play(){
        //ask user for multiPlayer() or singlePlayer() @TODO test
        Scanner scnr = new Scanner(System.in);
        
        int userGameSelection = 0;
        
        while (userGameSelection != 1 || userGameSelection != 2){
            
            System.out.println("would you like to play single (1) or multi (2)");
             userGameSelection = scnr.nextInt();
             
             if (userGameSelection == 1){
                 
                 singlePlayer();
                 
             }
             else if (userGameSelection == 2){
                 
                 multiPlayer();
                 
             }
             
             else {
                 
                 System.out.println("Not a vaild input only enter '1' or '2'.");
                 
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
                    playGeoGuesser();
                case 2:
                    playITT();
                case 3:    
                    playNTP();
                 
            }
            
        }
        else{
            //player 2
            //ask dice roll winner which board to play
        }

        
    }
    public static void singlePlayer(){
        //ask which board to play @TODO
        playGeoGuesser();
        playNTP();
        playITT();
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
    public static void playGeoGuesser(){
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
    public static void playNTP(){
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
    public static void playITT(){
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
    public static void finalQuestion(){

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
