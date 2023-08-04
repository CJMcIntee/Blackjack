/*Programmer: Christine McIntee
  July 11th 2023
  Blackjack game rules, assumes the player 
  will want to hit if their cards value below 18. 
  Bugs: The winOrLose message sometimes displays twice.*/
  
import java.util.*;

public class Blackjack {
   //Fields
   private Deck DeckOfCards;
   
   //Constructor
   public Blackjack() {
      this.DeckOfCards = new Deck();
   } //end Blackjack constructor
   
   /*Defines the rules of the game, shuffles and deals cards 
   to the player*/
   public void playBlackjack(Scanner input) {
      //shuffle deck
      DeckOfCards.shuffle();
      int playerValue = 0;
      int dealerValue = 0;
      System.out.println("The dealer smiles while they shuffle the deck,");
      System.out.println("then deals two cards to each player.");
      //deal initial cards to player
      Stack<Card> playersHand = new Stack<Card>();
      Card cardOneP = DeckOfCards.dealCard();
      playersHand.push(cardOneP);
      Card cardTwoP = DeckOfCards.dealCard();
      playersHand.push(cardTwoP);
      System.out.println("Your hand: " + cardOneP + " || " + cardTwoP);
      playerValue += cardOneP.getValue();
      playerValue += cardTwoP.getValue();         
      System.out.println("The value of cards in your hand is now " + playerValue);
      //deal initial cards to dealer
      Stack<Card> dealersHand = new Stack<Card>();
      Card cardOneD = DeckOfCards.dealCard();
      dealersHand.push(cardOneD);
      Card cardTwoD = DeckOfCards.dealCard();
      dealersHand.push(cardTwoD);
      System.out.println("Dealer's hand: " + cardOneD + " || " + "Face-down card");
      dealerValue += cardOneD.getValue();
      dealerValue += cardTwoD.getValue();
      boolean winOrLoseB = winOrLose(playerValue, dealerValue);
      //while game is not over, hit or stand
      while (!winOrLoseB) {
         winOrLoseB = winOrLose(playerValue, dealerValue);
         System.out.println("Would you like to \"hit\" or \"stand\"? ");
         String hitOrStand = input.nextLine();
         //hit or stand
         if (hitOrStand.equals("hit")) {
            Card cardThreeP = DeckOfCards.dealCard();
            playersHand.push(cardThreeP);
            playerValue += cardThreeP.getValue();
            System.out.println("You were dealt the " + cardThreeP);
            System.out.println("The value of cards in your hand is now " + playerValue);
            winOrLoseB = winOrLose(playerValue, dealerValue);
            dealerValue = dealerAction(winOrLoseB, dealerValue, dealersHand, cardOneD, cardTwoD);
            winOrLoseB = winOrLose(playerValue, dealerValue);
         } else if (hitOrStand.equals("stand")) {
            dealerValue = dealerAction(winOrLoseB, dealerValue, dealersHand, cardOneD, cardTwoD);
            winOrLoseB = winOrLose(playerValue, dealerValue);
         }
      } //end loop
   } //end playBlackjack method
   
   //Dealer's actions
   private int dealerAction(boolean winOrLoseB, int dealerValue, Stack dealersHand, 
                                                      Card cardOneD, Card cardTwoD) {
      if (!winOrLoseB) {
         //Dealer reveals face-down card after first turn is over
         if (dealersHand.size() == 2) {
            System.out.println("The dealer flips over thier face-down card to reveal the " + cardTwoD);
            System.out.println("Dealer's hand: " + cardOneD + " || " + cardTwoD);
            System.out.println("The value of cards in the dealer's hand is now " + dealerValue);
         }
         //The dealer must "hit" until reaching 17 or more
         if (dealerValue <= 17) {
            Card cardThreeD = DeckOfCards.dealCard();
            dealersHand.push(cardThreeD);
            dealerValue += cardThreeD.getValue();
            System.out.println("The dealer drew the " + cardThreeD);
            System.out.println("The value of cards in the dealer's hand is now " + dealerValue);
         }
      }
      return dealerValue;
   } //end dealerAction method
      
   /*Determine if the user has won or lost by evaluating thier 
   hand and the dealer's hand*/
   private boolean winOrLose(int playerValue, int dealerValue) {
      if (playerValue == 21) {
         System.out.println("You win!");
         System.out.println("The dealer says \"You have extraordinary skill, congratulations!");
         return true;
      } else if (playerValue > 21) {
         System.out.println("You bust! The dealer wins!");
         System.out.println("The dealer says \"Sorry friend.\"");
         return true;
      } else if (dealerValue == 21) {
         System.out.println("Dealer wins!");
         System.out.println("The dealer says \"Don't feel bad friend,");
         System.out.println("I've been playing this game for years...\"");
         return true;
      } else if (dealerValue > 21) {
         System.out.println("The dealer busts! You win!");
         System.out.println("The dealer says \"Now that's what I call incredible luck!\"");
         return true;
      } else if ((playerValue == 21 && dealerValue == 21) || 
                 (playerValue == 20 && dealerValue == 20) ||
                 (playerValue == 19 && dealerValue == 19)) {
         System.out.println("You push! No one wins!");
         System.out.println("The dealer says \"Rotten luck...\"");
         return true;
      } else if ((dealerValue >= 17 && playerValue >= 17) && 
                   (dealerValue < 21 && playerValue < 21)) {
         if (dealerValue < playerValue) {
            System.out.println("The player's hand has a value of " + (playerValue - dealerValue) + 
                                                                " more than the dealer's hand.");
            System.out.println("You win!");
            System.out.println("The dealer says \"I can tell you're having a lucky day today...");
            System.out.println("Care to play again?\"");
            return true;
         } else if (dealerValue > playerValue) {
            System.out.println("The dealer's hand has a value of " + (dealerValue - playerValue) + 
                                                                " more than the player's hand.");
            System.out.println("Dealer wins!");
            System.out.println("The dealer says \"That was a close one! Luck is on your side today,");
            System.out.println("I think you'll do well to try again...\"");
            return true;
         }
      } return false;
   } //end winOrLose method
   
} //end Blackjack class
