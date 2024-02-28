/*
File Name:   Card.java
Author:      Francis O'Hara
Date:        2/27/2024
Description: Helper class for the Blackjack.java
How to Run:  N/A
*/
package project_1;

public class Card {
    /** The value of the card. */
    private int value;

    /**
     * Constructs a card with the specified value.
     * @param val The value of the card.
     */
    public Card(int val) {
        if (val >= 2 && val <= 11)
            value = val;
        else
            System.out.println("Invalid card value!");
    }

    /**
     * Returns the value of the card.
     * @return the value of the card
     */
    public int getValue() {
        return this.value;
    }
    
    /**
     * Returns a string representation of the card.
     * @return a string representation of the card
     */
    public String toString() {
        return "" + value;
    }
}
