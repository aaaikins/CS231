/*
File Name:   Hand.java
Author:      Francis O'Hara
Date:        2/27/2024
Description: A class for representing a player or dealer's hand of cards in a game of Blackjack.
How to Run:  N/A
*/
package project_1;

import java.util.ArrayList;

public class Hand {
    /** The underlying ArrayList for storing cards in the hand. */
    private ArrayList<Card> hand;

    /**
     * Creates an empty hand as an ArrayList of Cards.
     */
    public Hand(){
        hand = new ArrayList<>();
    }

    /**
     * Removes any cards currently in the hand.
     */
    public void reset(){
        hand = new ArrayList<>();
    }

    /**
     * Adds the specified card to the hand.
     * @param card the card to be added to the hand
     */
    public void add(Card card){
        hand.add(card);
    }

    /**
     * Returns the number of cards in the hand.
     * @return the number of cards in the hand
     */
    public int size(){
        return hand.size();
    }

    /**
     * Returns the card in the hand specified by the given index. 
     * @param index the index of the card in the hand.
     * @return the card in the hand at the specified index.
     */
    public Card getCard(int index){
        return hand.get(index);
    }

    /**
     * Returns the summed value over all cards in the hand.
     * @return the summed value over all cards in the hand
     */
    public int getTotalValue(){
        int total = 0;
        for (Card card: hand)
            total += card.getValue();
        return total;
    }

    /**
     * Returns a string representation of the hand.
     * @return a string representation of the hand
     */
    public String toString(){
        return hand + " : " + getTotalValue();
    }
}
