/*
File Name:   DeckTests.java
Author:      Francis O'Hara
Date:        2/24/2024
Description: Contains tests for the Deck class.
How to Run:  java -ea DeckTests
*/
package project_1;

import java.util.HashMap;
import java.util.ArrayList;

public class DeckTests {
    /**
     * Executes tests for the Deck class.
     */
    public static void deckTests() {
        // case 1: testing Deck() and size()
        {
            // set up
            System.out.println("--CASE 1: TESTING DECK() AND SIZE()--");
            Deck d1 = new Deck();

            // verify
            System.out.println(d1);

            // test
            assert d1 != null : "Error in Deck::Deck()";
            assert d1.size() == 52 : "Error in Deck::Deck()";
        }

        // case 2: testing deal()
        {
            // set up
            System.out.println("\n--CASE 2: TESTING DEAL()--");
            Deck d1 = new Deck();
            Card c1 = d1.deal();

            // verify
            System.out.println("d1: " + d1);
            System.out.println("c1: " + c1);

            // test
            assert d1 != null : "Error in Deck::deal()";
            assert c1 != null : "Error in Deck::deal()";
            assert d1.size() == 51 : "Error in Deck::deal()";
        }

        // case 3: testing build()
        {
            // set up
            System.out.println("\n--CASE 3: TESTING BUILD()--");
            Deck d1 = new Deck();
            Card c1 = d1.deal();
            Card c2 = d1.deal();
            Card c3 = d1.deal();

            // verify
            System.out.println("DECK BEFORE BUILD(): " + d1);
            d1.build();
            System.out.println("DECK AFTER BUILD(): " + d1);

            // test
            assert d1 != null : "Error in Deck::build()";
            assert c1 != null : "Error in Deck::deal()";
            assert c2 != null : "Error in Deck::deal()";
            assert c3 != null : "Error in Deck::deal()";
            assert d1.size() == 52 : "Error in Deck::build()";
        }

        // case 4: testing shuffle()
        {
            // set up
            System.out.println("\n--CASE 4: TESTING SHUFFLE()--");
            Deck d1 = new Deck();

            // verify
            String before = d1.toString();
            System.out.println("BEFORE SHUFFLE(): " + before);
            d1.shuffle();
            String after = d1.toString();
            System.out.println("AFTER SHUFFLE(): " + after);

            // test
            assert !before.equals(after) : "Error in Deck::shuffle()";
            assert d1.size() == 52 : "Error in Deck::shuffle()";
        }

        // case 5: check correct number of each card
        {
            // set up
            System.out.println("\n--CASE 5: CHECK CORRECT NUMBER OF EACH CARD TYPE IN DECK--");
            Deck d1 = new Deck();

            // use hash map to count number of each distinct card type
            HashMap<Integer, Integer> counter = new HashMap<>();

            for (int cardValue: d1.getCardValues()){
                if (!counter.containsKey(cardValue))
                    counter.put(cardValue, 1);
                else
                    counter.put(cardValue, counter.get(cardValue) + 1);
            }

            // verify
            System.out.println("FREQUENCY COUNT FOR EACH CARD TYPE:\n" + counter);

            // test
            for (int i = 2; i <= 9; i ++)
                assert counter.get(i) == 4 : "Error in Deck: Incorrect number of cards with value " + i;

            assert counter.get(10) == 16: "Error in Deck: Incorrect number of cards with value 10.";
            assert counter.get(11) == 4: "Error in Deck: Incorrect number of cards with value 11";
        }

        // case 6: check reshuffle randomness
        {
            // set up
            System.out.println("\n--CASE 6: CHECK RESHUFFLE RANDOMNESS--");
            // calculate probability that shuffle implementation is random
            double probabilityOfRandomness = getProbabilityOfRandomness();

            // verify
            System.out.printf("The probability that the current implementation of the shuffle method is random is %.2f %%.", probabilityOfRandomness);

            // test
            // assuming a truly random shuffle produces different outcomes at least 95% of the time in 1000 simulations with sequence length 52;
            assert probabilityOfRandomness > 95: "Error in Deck::shuffle(); Shuffle is not random.";

        }
        System.out.println("\n\n*** Done testing Deck! ***\n");
    }

    // define helper function for checking shuffle randomness
    /**
     * Returns the probability that the current implementation of the shuffle method of the Deck class is random as a percentage.
     * This probability is obtained by calling the shuffle method an arbitrary number of times (currently 1000) with the same input
     * and calculating the number of times it produces a different output divided by the total number of shuffles.
     * This is based on the fact that a truly random shuffle algorithm would produce different outputs given the same
     * input most of the time.
     * @return A percentage representing the probability that the shuffle method is random.
     */
    private static double getProbabilityOfRandomness() {
        Deck d1 = new Deck();

        // calculate probability that shuffle method is random by counting number of times it produces different output given same input.
        int totalNumberOfShuffles = 1000;
        ArrayList<String> shuffleOutcomes = new ArrayList<>(totalNumberOfShuffles);  // string representations of state of deck after each shuffle
        int numberOfShufflesWithSameOutcome = 0;

        for (int i = 0; i < totalNumberOfShuffles; i ++) {
            String currentOutcome = d1.toString();

            // compare current outcome with previously seen outcomes
            for (String outcome: shuffleOutcomes){
                if (outcome.equals(currentOutcome)) {
                    numberOfShufflesWithSameOutcome++;
                    break;
                }
            }

            // add current outcome to previously seen outcomes
            shuffleOutcomes.add(currentOutcome);

            // rebuild deck and shuffle
            d1.build();
            d1.shuffle();
        }

        // compute and return probability of shuffle randomness as percentage
        double probabilityOfRandomness = ( (double) (totalNumberOfShuffles - numberOfShufflesWithSameOutcome) / totalNumberOfShuffles) * 100.0;
        return probabilityOfRandomness;
    }

    /**
     * The main entry point into the program.
     * @param args Array of Strings representing command-line arguments passed to the program.
     */
    public static void main(String[] args) {
        deckTests();
    }
}