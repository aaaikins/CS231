/*
file name:      LandscapeTests.java
Authors:        Max Bender & Naser Al Madi
last modified:  9/18/2022
Description:    Contains tests for the Landscape class.
How to run:     java -ea LandscapeTests
*/
package project_2;

import java.util.ArrayList;

public class LandscapeTests {
    /**
     * Executes tests for the Landscape class.
     */
    public static void landscapeTests() {
        // case 1: testing Landscape(int, int)
        {
            // --set up--
            System.out.println("--CASE 1: TESTING LANDSCAPE(INT, INT)--");
            Landscape landscape1 = new Landscape(2, 4);
            Landscape landscape2 = new Landscape(10, 10);

            // --verify--
            System.out.println("landscape1:\n" + landscape1);
            System.out.println("landscape2:\n" + landscape2);

            // --test--
            assert landscape1 != null : "Error in Landscape::Landscape(int, int)";
            assert landscape2 != null : "Error in Landscape::Landscape(int, int)";
        }

        // case 2: testing Landscape(int, int, double)
        {
            // --set up--
            System.out.println("--CASE 2: TESTING LANDSCAPE(INT, INT, DOUBLE)--");
            Landscape landscape1 = new Landscape(10, 10, 0.5);
            Landscape landscape2 = new Landscape(10, 10, 1.0);

            // --verify--
            System.out.println("landscape1:\n" + landscape1);
            System.out.println("landscape2:\n" + landscape2);

            // --test--
            assert landscape1 != null : "Error in Landscape::Landscape(int, int, double)";
            assert landscape2 != null : "Error in Landscape::Landscape(int, int, double)";
        }

        // case 3: testing reset()
        {
            // --set up--
            System.out.println("\n--CASE 3: TESTING RESET()--");
            Landscape landscape = new Landscape(10, 10, 1.0);

            // --verify--
            System.out.println("Original Landscape:\n" + landscape);

            // store the original state of landscape as string for testing
            String originalLandscape = landscape.toString();

            // modify the landscape using advance method() (i.e. the only means of modifying landscape after construction)
            landscape.advance();
            System.out.println("Modified Landscape:\n" + landscape);

            // reset the landscape and store state after reset as a string for testing
            landscape.reset();
            System.out.println("Landscape After Reset:\n" + landscape);
            String resetLandscape = landscape.toString();

            // --test--
            assert landscape != null : "Error in Landscape::reset()";
            assert originalLandscape.equals(resetLandscape) : "Error in Landscape::reset()";
        }

        // case 4: testing getRows()
        {
            // --set up--
            System.out.println("\n--CASE 4: TESTING GETROWS()--");
            Landscape landscape = new Landscape(15, 16);

            // --verify--
            System.out.println("Landscape with 15 rows:\n" + landscape);

            // --test--
            assert landscape.getRows() == 15: "Error in Landscape::getRows()";
        }

        // case 5: testing getCols()
        {
            // --set up--
            System.out.println("\n--CASE 5: TESTING GETCOLS()--");
            Landscape landscape = new Landscape(12, 13);

            // --verify--
            System.out.println("Landscape with 13 columns:\n" + landscape);

            // --test--
            assert landscape.getCols() == 13 : "Error in Landscape::getCols()";
        }

        // case 6: testing getCell(int, int)
        {
            // set up
            System.out.println("\n--CASE 6: TESTING GETCELL(INT, INT)--");
            Landscape landscape = new Landscape(5, 5, 0.25);
            Cell cell = landscape.getCell(2,3);

            // verify
            System.out.println("Landscape:\n" + landscape);
            System.out.println("Cell at row 2 column 3: " + cell);

            // test
            assert cell != null;
        }

        // case 7: testing getNeighbors()
        {
            // set up
            System.out.println("\n--CASE 7: TESTING GETNEIGHBORS()--");
            Landscape landscape = new Landscape(5, 5,0.3);
            ArrayList<Cell> neighbors1 = landscape.getNeighbors(0,0);
            ArrayList<Cell> neighbors2 = landscape.getNeighbors(2,2);
            ArrayList<Cell> neighbors3 = landscape.getNeighbors(2, 4);

            // verify
            System.out.println("Landscape:\n" + landscape);
            System.out.println("Neighbors of cell at row 0 column 0: " + neighbors1);
            System.out.println("Neighbors of cell at row 2 column 2: " + neighbors2);
            System.out.println("Neighbors of cell at row 2 column 4: " + neighbors3);

            // test
            assert neighbors1.size() == 3: "Error in Landscape::getNeighbors()";
            assert neighbors2.size() == 8: "Error in Landscape::getNeighbors()";
            assert neighbors3.size() == 5: "Error in Landscape::getNeighbors()";
        }

        // case 8: testing advance()
        {
            // set up
            System.out.println("\n--CASE 8: TESTING ADVANCE()--");
            Landscape landscape = new Landscape(5, 5, 0.3);

            // verify
            String beforeAdvance = landscape.toString();
            System.out.println("Landscape Before Advance:\n" + beforeAdvance);
            landscape.advance();
            String afterAdvance = landscape.toString();
            System.out.println("Landscape After Advance:\n" + afterAdvance);

            // test
            assert !beforeAdvance.equals(afterAdvance) : "Error in Landscape::advance()";
        }

        System.out.println("\n*** Done testing Landscape! ***");
    }


    /**
     * The main entry point into the program.
     * @param args An array of Strings denoting the command-line arguments passed to the program.
     */
    public static void main(String[] args) {
        landscapeTests();
    }
}
