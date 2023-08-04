/*Programmer: Christine McIntee
  July 11th 2023
  Card deck*/
  
import java.util.*;
import java.util.Random;

public class Deck {
   //Fields
   private static final Random randomNumbers = new Random(); 
   private static final int NUMBER_OF_CARDS = 52;   
   private Card[] deck = new Card[NUMBER_OF_CARDS];
   private int currentCard = 0; // index of next Card to be dealt (0 - 51) 
    
   //Fills Deck with Cards
   public Deck() {
      String[] faces = {"Ace", "Deuce", "Three", "Four", "Five", "Six",
              "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King"};
      String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};  
      for (int count = 0; count < deck.length; count++) {
         deck[count] = new Card(faces[count % 13], suits[count / 13]); 
      } 
   } //end DeckOfCards Constructor 
    
   //Shuffle Deck
   public void shuffle() {
      currentCard = 0;  
      for (int first = 0; first < deck.length; first++) {
         int second = randomNumbers.nextInt(NUMBER_OF_CARDS);  
         Card temp = deck[first]; 
         deck[first] = deck[second];
         deck[second] = temp;  
       }
   } //end shuffle method 
    
   //Deal one Card 
   public Card dealCard() {
      if (currentCard < deck.length) {
         return deck[currentCard++]; 
      } else {
         return null;
      } 
   } //end dealCard method
      
} //end Deck class