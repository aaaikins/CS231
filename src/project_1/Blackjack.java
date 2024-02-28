/*
File Name:   Blackjack.java
Author:      Francis O'Hara
Date:        2/27/2024
Description: A class for simulating a simplified version of the card game Blackjack.
How to run:  java Blackjack
*/
package project_1;

public class Blackjack {
    /** The current deck from which the player and dealer are dealt their cards. */
    private Deck deck;

    /** The hand of the player containing all cards they have been dealt. */
    private Hand playerHand;

    /** The hand of the dealer containing all cards they have been dealt. */
    private Hand dealerHand;

    /** The number of cards left in the deck below which the deck will be refilled when the game resets. */
    private int reshuffleCutoff;

    /**
     * Creates a Blackjack object. This object contains all the methods and attributes required for simulating a game of Blackjack.
     * @param reshuffleCutoff The number of cards left in the deck below which the deck should be refilled.
     *                        The reset method will refill the deck if the number of cards in the deck is less than `reshuffleCutoff`.
     */
    public Blackjack(int reshuffleCutoff) {
        this.reshuffleCutoff = reshuffleCutoff;
        deck = new Deck();
        deck.shuffle();
        reset();
    }

    /**
     * Creates a Blackjack object with the default reshuffleCutoff value of 26 cards.
     */
    public Blackjack() {
        this(26);
    }

    /**
     * Resets the Blackjack object for a fresh game by clearing the dealer and player hands.
     * Will also refill the deck if the number of cards left in the deck is less than the reshuffle cutoff.
     */
    public void reset() {
        playerHand = new Hand();
        dealerHand = new Hand();

        if (deck.size() < reshuffleCutoff) {
            deck = new Deck();
            deck.shuffle();
        }
    }

    /**
     * Adds one card each to the player hand and the dealer hand from the deck.
     * Always called before player's turn.
     */
    public void deal() {
        playerHand.add(deck.deal());
        dealerHand.add(deck.deal());
    }

    /**
     * Simulates the player's turn in a game of Blackjack by removing cards from the deck until player's hand total meets
     * an arbitrary threshold of 16 or above.
     * @return `true` if the player's hand's total after meeting the threshold is less than or equal to 21. Otherwise, returns
     *          `false`.
     */
    public boolean playerTurn() {
        while (playerHand.getTotalValue() < 16) {
            playerHand.add(deck.deal());
        }
        return (playerHand.getTotalValue() <= 21);
    }

    /**
     * Simulates the dealer's turn in a game of Blackjack by removing cards from the deck until dealer's hand total
     * meets an arbitrary threshold of 17 or above.
     * @return `true` if the dealer's hand's total after meeting the threshold is less than or equal to 21. Otherwise,
     *          returns `false`.
     */
    public boolean dealerTurn() {
        while (dealerHand.getTotalValue() < 17) {
            dealerHand.add(deck.deal());
        }
        return (dealerHand.getTotalValue() <= 21);
    }

    /**
     * Sets the reshuffle cutoff point, which is the number of cards left in the deck below which the reset method will
     * refill the deck.
     * @param cutoff An integer representing new reshuffle cutoff point to be set.
     */
    public void setReshuffleCutoff(int cutoff) {
        if (cutoff <= 52)
            reshuffleCutoff = cutoff;
        else
            System.out.println("Invalid Reshuffle Cutoff point!");
    }

    /**
     * Returns the current reshuffle cutoff point.
     * @return An integer representing the current reshuffle cutoff point.
     */
    public int getReshuffleCutoff() {
        return reshuffleCutoff;
    }

    // define additional getters for testing purposes
    /**
     * Returns the current state of the deck.
     * @return A Deck object representing the current deck of the Blackjack object.
     */
    public Deck getDeck(){
        return deck;
    }

    /**
     * Returns the current state of the player's hand.
     * @return A Hand object representing the current player's hand of the Blackjack object.
     */
    public Hand getPlayerHand(){
        return playerHand;
    }

    /**
     * Returns the current state of the dealer's hand.
     * @return A Hand object representing the current dealer's hand of the Blackjack object.
     */
    public Hand getDealerHand(){
        return dealerHand;
    }

    /**
     * Returns a textual representation of the Blackjack object in its current state.
     * @return A String representing the current state of the Blackjack object.
     */
    public String toString() {
        return "Player Hand --> " + playerHand + "\nDealer Hand --> " + dealerHand + "\nDeck --> " + deck + "\nReshuffle Cutoff --> " + reshuffleCutoff;
    }

    /**
     * Simulates a single round of a game of blackjack between a player and a dealer and returns the outcome.
     * @param verbose A boolean that determines whether more information about the current simulation should be displayed
     *                through standard output.
     *                If `true`, the initial and final hands of the player and dealer, as well as the outcome of the game
     *                will be written to standard output. If `false`, no information about the game or its outcome will
     *                be displayed.
     * @return An integer representing the outcome of the game. -1 means the dealer won the game, 1 means the player won
     *         the game, and 0 represents a tie between the dealer and the player.
     */
    public int game(boolean verbose){
        int gameResult;  // for storing game result

        // clear player and dealer hands and refill deck if applicable
        reset();

        // deal the initial hand for the player and dealer
        deal();

        // print initial hands of game (only in verbose mode)
        if (verbose){
            System.out.println("--INITIAL HANDS--");
            System.out.println("Player Hand --> " + playerHand + "\nDealer Hand --> " + dealerHand);
        }

        // simulate player and dealer's turns
        boolean playerDidNotBust = playerTurn();
        boolean dealerDidNotBust = dealerTurn();


        // determine the result of the game
        if (playerDidNotBust){
            if (dealerDidNotBust){ // neither player nor dealer busted
                int playerTotal = playerHand.getTotalValue();
                int dealerTotal = dealerHand.getTotalValue();
                if (playerTotal > dealerTotal)
                    gameResult = 1;  // player scored higher
                else if (playerTotal < dealerTotal)
                    gameResult = -1;  // dealer scored higher
                else
                    gameResult = 0;  // equal score
            }
            else
                gameResult = 1;  // player didn't bust but dealer busted
        }
        else
            gameResult = -1;  // player busted before dealer's turn

        // print final hands and result of the game (only in verbose mode)
        if (verbose){
            System.out.println("--FINAL HANDS--");
            System.out.println("Player Hand --> " + playerHand + "\nDealer Hand --> " + dealerHand);
            System.out.println("--GAME RESULTS--");
            switch (gameResult){
                case 1:
                    System.out.println("Player has won!");
                    break;
                case -1:
                    System.out.println("Dealer has won!");
                    break;
                case 0:
                    System.out.println("Player and Dealer have tied!");
                    break;
            }
        }

        return gameResult;
    }

    /**
     * The main entry point into the program.
     * @param args A String array containing all command line arguments passed to the program.
     */
    public static void main(String[] args) {
        // test that the Blackjack class works as expected using game() method
        Blackjack blackjack = new Blackjack();
        blackjack.game(true);
    }
}