/*Programmer: Christine McIntee
  July 11th 2023
  Card*/
  
import java.util.*;

public class Card {
   //Fields
   private String face;
   private String suit;
   private int value;
   
   //Construct Card 
   public Card(String cardFace, String cardSuit) {
      this.face = cardFace;
      this.suit = cardSuit;
   } //end Card constructor 
   
   //Return face of Card
   public String getFace() {
      return face;
   } //end getFace method
   
   //Return suit of Card
   public String getSuit() {
      return suit;
   } //end getSuit method
   
   //Return String representation of Card
   public String toString() {
       return face + " of " + suit; 
   } //end toString method
   
   //Return integer value of Card
   public int getValue() {
      int cardValue = 0;
      switch(face) {
         case "Deuce":
            cardValue += 2;
            break;
         case "Three":
            cardValue += 3;
            break;
         case "Four":
            cardValue += 4;
            break;
         case "Five":
            cardValue += 5;
            break;
         case "Six":
            cardValue += 6;
            break;
         case "Seven":
            cardValue += 7;
            break;
         case "Eight":
            cardValue += 8;
            break;
         case "Nine":
            cardValue += 9;
            break;
         case "Ten":
            cardValue += 10;
            break;
         case "Jack":
            cardValue += 10;
            break;
         case "Queen":
            cardValue += 10;
         break;
            case "King":
            cardValue += 10;
         break;
            case "Ace":
            cardValue += 11;
         break;
      }
      return cardValue;
   } //end getValue method

} //end Card class