/*
File Name: Deck.java
Author: Francis O'Hara
Date: 2/27/2024
Description: A class for representing the deck in a game of Blackjack.
How to Run: N/A
*/
package project_1;

import java.util.ArrayList;
import java.util.Random;

public class Deck {
    /** The underlying ArrayList of Cards backing the Deck class. */
    private ArrayList<Card> deck;

    /**
     * Creates the underlying deck as an ArrayList of Card objects. 
     * Calls build() as a subroutine to build the deck itself.
     */
    public Deck() {
        build();
    }

    /**
     * Builds the underlying deck as a standard 52 card deck. 
     * Replaces any current deck stored. 
     */
    public void build() {
        // create empty deck
        deck = new ArrayList<>();

        // do the following 4 times ...
        for (int i = 0; i < 4; i ++){
            // add one each of card with value 2-9
            for (int j = 2; j <= 9; j ++){
                Card card2To9 = new Card(j);
                deck.add(card2To9);
            }

            // add one card with value 11
            Card card11 = new Card(11);
            deck.add(card11);

            // add four cards with value 10
            for(int k = 0; k < 4; k ++){
                Card card10 = new Card(10);
                deck.add(card10);
            }
        }
    }

    /**
     * Returns the number of cards left in the deck. 
     * @return the number of cards left in the deck
     */
    public int size() {
        return deck.size();
    }

    /**
     * Returns and removes the first card of the deck.
     * @return the first card of the deck
     */
    public Card deal() {
        Card topCard = deck.getFirst();
        deck.removeFirst();
        return topCard;
    }

    /**
     * Shuffles the cards currently in the deck. 
     */
    public void shuffle() {
        ArrayList<Card> shuffledDeck = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < 52; i++){
            int randomIndex = random.nextInt(deck.size());
            Card randomCard = deck.get(randomIndex);
            shuffledDeck.add(randomCard);
            deck.remove(randomIndex);
        }

        deck = shuffledDeck;
    }

    /**
     * Returns a string representation of the deck.
     * @return a string representation of the deck
     */
    public String toString() {
        return "" + deck;
    }

    // define additional getter for testing purposes.
    /**
     * Returns an ArrayList of Integers representing the value of the cards in the deck.
     * @return An ArrayList of the values of the cards in the deck.
     */
    public ArrayList<Integer> getCardValues(){
        ArrayList<Integer> deckValues = new ArrayList<>();

        for (Card card: deck)
            deckValues.add(card.getValue());

        return deckValues;
    }
}
