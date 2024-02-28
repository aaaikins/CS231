/*
File Name:   BlackjackTests.java
Author:      Francis O'Hara
Date:        2/24/2024
Description: Contains tests for the methods defined within the Blackjack class.
How to Run:  java -ea BlackjackTests
*/
package project_1;

public class BlackjackTests {
    /**
     * Executes tests for the Blackjack class.
     */
    public static void blackjackTests() {
        // case 1: testing Blackjack()
        {
            // set up
            System.out.println("--CASE 1: TESTING BLACKJACK()--");
            Blackjack blackjack1 = new Blackjack();

            // verify
            System.out.println("BLACKJACK1:\n" + blackjack1);

            // test
            assert blackjack1 != null : "Error in Blackjack::Blackjack()";
        }

        // case 2: testing Blackjack(int reshuffleCutoff)
        {
            // set up
            System.out.println("\n--CASE 2: TESTING BLACKJACK(INT RESHUFFLECUTOFF)--");
            Blackjack blackjack2 = new Blackjack(20);

            // verify
            System.out.println("BLACKJACK2:\n" + blackjack2);

            // test
            assert blackjack2 != null : "Error in Blackjack::Blackjack(int reshuffleCutoff)";
            assert blackjack2.getReshuffleCutoff() == 20 : "Error in Blackjack::Blackjack(int reshuffleCutoff)";
        }

        // case 3: testing deal()
        {
            // set up
            System.out.println("\n--CASE 3: TESTING DEAL()--");
            Blackjack blackjack = new Blackjack();
            System.out.println("GAME STATE BEFORE DEAL:\n" + blackjack);
            blackjack.deal();

            // verify
            System.out.println("GAME STATE AFTER DEAL:\n" + blackjack);

            // test
            assert blackjack.getDeck().size() == 50: "Error in Blackjack::deal()";
            assert blackjack.getPlayerHand().size() == 1: "Error in Blackjack::deal()";
            assert blackjack.getDealerHand().size() == 1: "Error in Blackjack::deal()";
        }

        // case 4: testing playerTurn()
        {
            // set up
            System.out.println("\n--CASE 4: TESTING PLAYERTURN()--");
            Blackjack blackjack = new Blackjack();
            System.out.println("GAME STATE BEFORE PLAYERTURN:\n" + blackjack);
            blackjack.playerTurn();

            // verify
            System.out.println("GAME STATE AFTER PLAYERTURN:\n" + blackjack);

            // test
            assert blackjack.getDeck().size() <= 50 : "Error in Blackjack::playerTurn()";  // since maximum no. of cards in deck after player turn is 50.
            assert blackjack.getPlayerHand().size() >= 2 : "Error in Blackjack::playerTurn()";  // since minimum no. of cards in player's hand after turn is 2.
        }

        // case 5: testing dealerTurn()
        {
            // set up
            System.out.println("\n--CASE 5: TESTING DEALERTURN()--");
            Blackjack blackjack = new Blackjack();
            System.out.println("GAME STATE BEFORE DEALERTURN:\n" + blackjack);
            blackjack.dealerTurn();

            // verify
            System.out.println("GAME STATE AFTER DEALERTURN:\n" + blackjack);

            // test
            assert blackjack.getDeck().size() <= 50 : "Error in Blackjack::dealerTurn()";  // since maximum no. of cards in deck after dealer turn alone is 50.
            assert blackjack.getDealerHand().size() >= 2 : "Error in Blackjack::dealerTurn()";  // since minimum no. of cards in dealer's hand after turn is 2.
        }

        // case 6: testing reset()
        {
            // set up
            System.out.println("\n--CASE 6: TESTING RESET()--");
            Blackjack blackjack = new Blackjack();
            blackjack.playerTurn();
            blackjack.dealerTurn();
            System.out.println("GAME STATE BEFORE RESET:\n" + blackjack);
            blackjack.reset();

            // verify
            System.out.println("GAME STATE AFTER RESET:\n" + blackjack);

            // test
            assert blackjack.getPlayerHand().size() == 0: "Error in Blackjack::reset()";
            assert blackjack.getDealerHand().size() == 0: "Error in Blackjack::reset()";
        }

        // case 7: testing getReshuffleCutoff()
        {
            // set up
            System.out.println("\n--CASE 7: TESTING GETRESHUFFLECUTOFF()--");
            Blackjack blackjack = new Blackjack(39);

            // verify
            System.out.println("CURRENT RESHUFFLE CUTOFF: " + blackjack.getReshuffleCutoff());

            // test
            assert blackjack.getReshuffleCutoff() == 39: "Error in Blackjack::getReshuffleCutoff()";
        }

        // case 8: testing setReshuffleCutoff()
        {
            // set up
            System.out.println("\n--CASE 8: TESTING SETRESHUFFLECUTOFF()--");
            Blackjack blackjack = new Blackjack();

            // verify
            System.out.println("CURRENT RESHUFFLE CUTOFF: " + blackjack.getReshuffleCutoff());
            blackjack.setReshuffleCutoff(42);
            System.out.println("NEW RESHUFFLE CUTOFF: " + blackjack.getReshuffleCutoff());

            // test
            assert blackjack.getReshuffleCutoff() == 42: "Error in Blackjack::setReshuffleCutoff()";
        }

        // case 9: testing getDeck()
        {
            // set up
            System.out.println("\n--CASE 9: TESTING GETDECK()--");
            Blackjack blackjack = new Blackjack();

            // verify
            System.out.println("DECK --> " + blackjack.getDeck());

            // test
            assert blackjack.getDeck() != null : "Error in Blackjack::getDeck()";
            assert blackjack.getDeck().size() == 52: "Error in Blackjack::getDeck()";
        }

        // case 10: testing getPlayerHand()
        {
            // set up
            System.out.println("\n--CASE 10: TESTING GETPLAYERHAND()--");
            Blackjack blackjack = new Blackjack();

            // verify
            System.out.println("PLAYER HAND --> " + blackjack.getPlayerHand());


            // test
            assert blackjack.getPlayerHand() != null: "Error in Blackjack::getPlayerHand()";
            assert blackjack.getPlayerHand().size() == 0: "Error in Blackjack::getPlayerHand()";
        }

        // case 11: testing getDealerHand()
        {
            // set up
            System.out.println("\n--CASE 11: TESTING GETDEALERHAND()--");
            Blackjack blackjack = new Blackjack();

            // verify
            System.out.println("DEALER HAND --> " + blackjack.getDealerHand());

            // test
            assert blackjack.getDealerHand() != null: "Error in Blackjack::getDealerHand()";
            assert blackjack.getDealerHand().size() == 0: "Error in Blackjack::getDealerHand()";
        }

        System.out.println("\n\n*** Done testing Blackjack! ***\n");
    }

    /**
     * The main entry point into the program.
     * @param args A String array containing all command-line arguments passed to the program.
     */
    public static void main(String[] args) {
        blackjackTests();
    }
}