/*
File Name:   CellTests.java
Author:      Francis O'Hara
Date:        3/04/2024
Description: Contains tests for the Cell class.
How to Run:  java -ea CellTests
*/
package project_2;

import java.util.ArrayList;

public class CellTests {
    /**
     * Executes tests for the Cell class.
     */
    public static void cellTests() {
        // case 0: testing Cell() and Cell( boolean alive )
        {
            // set up
            System.out.println("--CASE 0: TESTING CELL() AND CELL( BOOLEAN ALIVE)--");
            Cell cell1 = new Cell();
            Cell cell2 = new Cell(true);
            Cell cell3 = new Cell(false);

            // verify
            System.out.println("cell1: " + cell1);
            System.out.println("cell2: " + cell2);
            System.out.println("cell3: " + cell3);

            // test
            assert cell1 != null : "Error in Cell::Cell()";
            assert cell2 != null : "Error in Cell::Cell( boolean alive )";
            assert cell3 != null : "Error in Cell::Cell( boolean alive )";
            assert !cell1.getAlive() : "Error in Cell::Cell()";
            assert cell2.getAlive() : "Error in Cell::Cell( boolean alive )";
            assert !cell3.getAlive() : "Error in Cell::Cell( boolean alive )";
        }

        // case 1: testing getAlive()
        {
            // set up
            System.out.println("\n--CASE 1: TESTING GETALIVE()--");
            Cell cell1 = new Cell();
            Cell cell2 = new Cell(true);

            // verify
            System.out.println("cell1 status: " + cell1.getAlive());
            System.out.println("cell2 status: " + cell2.getAlive());

            // test
            assert !cell1.getAlive(): "Error in Cell::getAlive()";
            assert cell2.getAlive(): "Error in Cell::getAlive()";
        }

        // case 2: testing setAlive()
        {
            // set up
            System.out.println("\n--CASE 2: TESTING SETALIVE()--");
            Cell cell = new Cell();

            // verify
            System.out.println("Cell Status Before: " + cell.getAlive());
            cell.setAlive(true);
            System.out.println("Cell Status After: " + cell.getAlive());

            // test
            cell.setAlive(true);
            assert cell.getAlive(): "Error in Cell::setAlive()";
            cell.setAlive(false);
            assert !cell.getAlive(): "Error in Cell::setAlive()";
        }

        // case 3: testing updateState()
        {
            // set up
            System.out.println("\n--CASE 3: TESTING UPDATESTATE()--");
            Cell deadCell = new Cell();
            Cell liveCell = new Cell(true);

            // initialize 1 live neighbor 7 dead neighbors
            ArrayList<Cell> neighbors1 = new ArrayList<>();
            neighbors1.add(new Cell(true));
            for (int i = 0; i < 7; i++)
                neighbors1.add(new Cell());


            // initialize 2 live neighbors 6 dead neighbors
            ArrayList<Cell> neighbors2 = new ArrayList<>();
            for(int i = 0; i < 2; i ++)
                neighbors2.add(new Cell(true));
            for (int i = 0; i < 6; i ++)
                neighbors2.add(new Cell());


            // initialize 3 live neighbors 5 dead neighbors
            ArrayList<Cell> neighbors3 = new ArrayList<>();
            for(int i = 0; i < 3; i ++)
                neighbors3.add(new Cell(true));
            for (int i = 0; i < 5; i ++)
                neighbors3.add(new Cell());

            // initialize 4 live neighbors 4 dead neighbors
            ArrayList<Cell> neighbors4 = new ArrayList<>();
            for (int i = 0; i < 4; i ++) {
                neighbors4.add(new Cell(true));
                neighbors4.add(new Cell());
            }

            // verify
            System.out.println("DeadCell State Before: " + deadCell);
            System.out.println("liveCell State Before: " + liveCell);
            System.out.println("neighbors1: " + neighbors1);
            System.out.println("neighbors2: " + neighbors2);
            System.out.println("neighbors3: " + neighbors3);
            System.out.println("neighbors4: " + neighbors4);

            // test
            // testing update conditions for live cell
            liveCell.updateState(neighbors1);
            assert !liveCell.getAlive(): "Error in Cell::updateState(ArrayList<Cell> neighbors)";
            liveCell.setAlive(true);

            liveCell.updateState(neighbors2);
            assert liveCell.getAlive(): "Error in Cell::updateState(ArrayList<Cell> neighbors)";
            liveCell.setAlive(true);

            liveCell.updateState(neighbors3);
            assert liveCell.getAlive(): "Error in Cell::updateState(ArrayList<Cell> neighbors)";
            liveCell.setAlive(true);

            liveCell.updateState(neighbors4);
            assert !liveCell.getAlive(): "Error in Cell::updateState(ArrayList<Cell> neighbors)";
            liveCell.setAlive(true);

            // testing update conditions for dead cell
            deadCell.updateState(neighbors1);
            assert !deadCell.getAlive() : "Error in Cell::updateState(ArrayList<Cell> neighbors)";
            deadCell.setAlive(false);

            deadCell.updateState(neighbors2);
            assert !deadCell.getAlive() : "Error in Cell::updateState(ArrayList<Cell> neighbors)";
            deadCell.setAlive(false);

            deadCell.updateState(neighbors3);
            assert deadCell.getAlive() : "Error in Cell::updateState(ArrayList<Cell> neighbors)";
            deadCell.setAlive(false);

            deadCell.updateState(neighbors4);
            assert !deadCell.getAlive() : "Error in Cell::updateState(ArrayList<Cell> neighbors)";
            deadCell.setAlive(false);
        }

        System.out.println("\n\n*** Done testing Cell! *** \n");
    }

    /**
     * The main entry point into the program.
     * @param args An array of Strings denoting the command-line arguments passed to the program.
     */
    public static void main(String[] args) {
        cellTests();
    }
}
