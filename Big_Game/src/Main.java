import java.util.Scanner;
import java.util.Random;

import static java.lang.Integer.parseInt;

public class Main {
    public static void main(String[] args) {
        //Make menu system where you can open menu at any point to pause, resume or quit out


        System.out.println("What game would you like to play? (1) Random Dice (2) Race for Riches (3) World Traveler (4) Who am I (5) IT Trivia (6) Who Done It" );
        Scanner in=new Scanner(System.in);
        String input = "";
        boolean out = true;
        while(out){
            input=in.nextLine();
            try{
                parseInt(input);
                out = false;
            }catch (Exception e){
                System.out.println("please enter game number you would like to play");
            }
        }
        switch (parseInt(input)){
            case 1:
                System.out.println("Now playing Random Dice");
                RandomDice.play();
            break;
            case 2:
                System.out.println("Now playing Race For Riches");
                RaceForRiches.play();
            break;
            case 3:
                System.out.println("Now playing World Traveler");
                WorldTraveler.play();
            break;
            case 4:
                System.out.println("Now playing Who Am I");
                WhoAmI.play();
            break;
            case 5:
                System.out.println("Now playing IT Trivia");
                ITTrivia.play();
            break;
            case 6:
                System.out.println("Now playing Who done it");
                WhoDoneIt.play();
            break;
            default: System.out.println("Invalid month");
            break;
        }
    }
}