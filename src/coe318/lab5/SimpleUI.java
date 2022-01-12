package coe318.lab5;

import java.util.Scanner;

public class SimpleUI implements UserInterface {
    private BlackjackGame game;
    private Scanner user = new Scanner(System.in);

  @Override
    public void setGame(BlackjackGame game) {
        this.game = game;
    }

  @Override
    public void display() {
        System.out.println("House Cards:");
        System.out.println(game.getHouseCards().toString());
        System.out.println("You hold:");
        System.out.println(game.getYourCards().toString());    
    }

  @Override
    public boolean hitMe() {
        System.out.println("Another Card? (Y or N)");
        char ans = user.next().charAt(0);
        if (ans == 'Y' || ans == 'y'){
            return true;
        }
        else if (ans=='N' || ans=='n'){
            return false;
        }
        else{
            System.out.println("Only enter (Y or N)");
            return hitMe();
        }   
    }

  @Override
    public void gameOver() {
        System.out.println("Game Over\n\n");
        System.out.println("House Cards:");
        System.out.println(game.getHouseCards().toString());
        System.out.println("You hold:");
        System.out.println(game.getYourCards().toString());  
        System.out.println("Scores:\n\n");
        int houseScore = game.score(game.getHouseCards());
        System.out.println("House: "+houseScore);
        int yourScore = game.score(game.getYourCards());
        System.out.println("You: "+yourScore);
        if((yourScore<=21 && houseScore>21)||(yourScore==21 && houseScore==21)){
            System.out.println("You Won | House Lost!");
        }
        else if(yourScore<=21 && houseScore<=21){
            if(yourScore>houseScore){
                System.out.println("You Won | House Lost!");
            }
            else{
                System.out.println("You Lost | House Won!");
            }
        }
        else{
            System.out.println("You Lost | House Won!");
        }
    }

}