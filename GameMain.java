/*Programmer: Christine McIntee
  July 11th 2023
  Play Blackjack card game and view rules*/

import java.util.*;

public class GameMain {
   
   //Main method
   public static void main(String[] args) {
      Scanner input = new Scanner(System.in);
      System.out.println("Welcome to Blackjack!");
      menuOptions();
      gameMenu(input);
   } //end main method
   
   //Game menu
   public static void gameMenu(Scanner input) {
      String option = input.nextLine();
      do {
         if (option.equals("p")) {
            //Play Blackjack
            Blackjack newGame = new Blackjack();
            newGame.playBlackjack(input);
            //Back to menu
            menuOptions();
            option = input.nextLine();
         } else if (option.equals("r")) {
            viewRules();
            menuOptions();
            option = input.nextLine();
         } else if (option.equals("q")) {
            System.out.print("Thank you for playing!");
         } else {
            System.out.println("Invalid input.");
            menuOptions();
            option = input.nextLine();
         }
      } while (!option.equals("q"));
         System.out.print("Thank you for playing!");
   } //end gameMenu method

   //Display menu command options
   public static void menuOptions() {
      System.out.println("Please enter a command: ");
      System.out.println("  \"p\" to play game");
      System.out.println("  \"r\" to view rules");
      System.out.println("  \"q\" to quit");
   } //end menuOptions method
      
   //Explains Blackjack rules to user
   public static void viewRules() {
      System.out.println("                        ~Rules~ ");
      System.out.println("In Blackjack, everyone plays against the dealer (house).");
      System.out.println("The goal is to draw cards with a value as close to 21 as");
      System.out.println("possible without going over. Your options are to either");
      System.out.println("\"stand\" or \"hit\". \"Stand\" means that you don't want any");
      System.out.println("more cards. \"Hit\" means that you want to draw additional");
      System.out.println("cards. The game ends when either you or the dealer \"bust\" or");
      System.out.println("\"push\". \"Bust\" is when the combined total value of your hand");
      System.out.println("exceeds 21. And \"push\" is when you and the dealer have the same");
      System.out.println("total value of cards in your hand. For additional information");
      System.out.println("and strategies visit (vegashowto.com/blackjack).");
      System.out.println("---------------------------------------------------------------");
   } //end viewRules method
      
} //end GameMain class