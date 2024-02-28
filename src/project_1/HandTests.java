/*
File Name:   HandTests.java
Author:      Francis O'Hara
Date:        2/24/2024
Description: Contains tests for the Hand class.
How to run:  java -ea HandTests
*/
package project_1;

public class HandTests {
    /**
     * Executes tests for the Hand class.
     */
    public static void handTests() {
        // case 1: testing Hand()
        {
            // set up
            System.out.println("--CASE 1: TESTING HAND()--");
            Hand h1 = new Hand();

            // verify
            System.out.println(h1 + " == [] : 0");

            // test
            assert h1 != null : "Error in Hand::Hand()";
            assert h1.size() == 0 : "Error in Hand::size()";
        }

        // case 2: testing getTotalValue() and size()
        {
            // set up
            System.out.println("\n--CASE 2: TESTING GETTOTALVALUE() AND SIZE()--");
            Hand h1 = new Hand();

            // verify
            System.out.println(h1.getTotalValue() + " == 0");

            // test
            assert h1.getTotalValue() == 0 : "Error in Hand::getTotalValue()";
            assert h1.size() == 0 : "Error in Hand::size()";
        }

        // case 3: testing getTotalValue() and size()
        {
            // set up
            System.out.println("\n--CASE 3: TESTING GETTOTALVALUE() AND SIZE()--");
            Hand h1 = new Hand();
            h1.add(new Card(5));

            // verify
            System.out.println(h1.getTotalValue() + " == 5");

            // test
            assert h1.getTotalValue() == 5 : "Error in Hand::getTotalValue() or Hand::add()";
            assert h1.size() == 1 : "Error in Hand::size()";
        }

        // case 4: testing getTotalValue(), size(), and getCard()
        {
            // set up
            System.out.println("\n--CASE 4: TESTING GETTOTALVALUE(), SIZE(), AND GETCARD()--");
            Hand h1 = new Hand();
            h1.add(new Card(5));
            h1.add(new Card(2));
            h1.add(new Card(3));

            // verify
            System.out.println(h1.getTotalValue() + " == 10");
            System.out.println(h1 + " == [5, 2, 3] : 10");

            // test
            assert h1.getTotalValue() == 10 : "Error in Hand::getTotalValue() or Hand::add()";
            assert h1.size() == 3 : "Error in Hand::size()";
            assert h1.getCard(0).getValue() == 5 : "Error in Hand::getCard()";
            assert h1.getCard(1).getValue() == 2 : "Error in Hand::getCard()";
            assert h1.getCard(2).getValue() == 3 : "Error in Hand::getCard()";  
        }

        // case 5: testing reset()
        {
            // set up
            System.out.println("\n--CASE 5: TESTING RESET()--");
            Hand h1 = new Hand();
            h1.add(new Card(5));
            h1.add(new Card(2));
            h1.add(new Card(3));
            h1.reset();

            // verify
            System.out.println(h1.getTotalValue() + " == 0");
            System.out.println(h1 + " == [] : 0");

            // test
            assert h1.getTotalValue() == 0 : "Error in Hand::getTotalValue() or Hand::add()";
            assert h1.size() == 0 : "Error in Hand::size()";
        }

        // case 6: testing toString()
        {
            // set up
            System.out.println("\n--CASE 6: TESTING TOSTRING()--");
            Hand h1 = new Hand();
            h1.add(new Card(5));
            h1.add(new Card(2));
            h1.add(new Card(3));

            // verify
            System.out.println(h1.getTotalValue() + " == 10");
            System.out.println(h1 + " == [5, 2, 3] : 10");

            // test
            assert h1.toString().equals("[5, 2, 3] : 10") : "Error in Hand::toString()";
        }

        System.out.println("\n\n*** Done testing Hand! ***\n");
    }

    /**
     * The main entry point into the program.
     * @param args Array of Strings representing command-line arguments passed to the program.
     */
    public static void main(String[] args) {
        handTests();
    }
}