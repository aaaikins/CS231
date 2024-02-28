/*
File Name:   CardTests.java
Author:      Francis O'Hara
Date:        2/24/2024
Description: Contains tests for the Card class.
How to Run:  java -ea CardTests
*/
package project_1;

public class CardTests {
    /**
     * Executes tests for the Card class.
     */
    public static void cardTests() {
        // case 1: testing Card(i)
        {
            // set up
            System.out.println("--CASE 1: TESTING CARD(I)--");
            Card c1 = new Card(5);
            Card c2 = new Card(10);

            // verify
            System.out.println(c1 + " == 5");
            System.out.println(c2 + " == 10");

            // test
            assert c1 != null : "Error in Card::Card()";
            assert c2 != null : "Error in Card::Card()";
        }

        // case 2: testing getValue()
        {
            // set up
            System.out.println("\n--CASE 2: TESTING GETVALUE()--");
            Card c1 = new Card(5);
            Card c2 = new Card(10);

            // verify
            System.out.println(c1.getValue() + " == 5");
            System.out.println(c2.getValue() + " == 10");

            // test
            assert c1.getValue() == 5 : "Error in Card::Card() or Card::getValue()";
            assert c2.getValue() == 10 : "Error in Card::Card() or Card::getValue()";
        }

        // case 3: testing toString()
        {
            // set up
            System.out.println("\n--CASE 3: TESTING TOSTRING()--");
            Card c1 = new Card(5);
            Card c2 = new Card(10);

            // verify
            System.out.println(c1 + " == 5");
            System.out.println(c2 + " == 10");

            // test
            assert c1.toString().equals("5") : "Error in Card::toString()";
            assert c2.toString().equals("10") : "Error in Card::toString()";
        }

        System.out.println("*** Done testing Card! ***\n");
    }

    /**
     * The main entry point into the program.
     * @param args Array of Strings containing command-line arguments passed to the program.
     */
    public static void main(String[] args) {
        cardTests();
    }
}