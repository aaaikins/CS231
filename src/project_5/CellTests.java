/*
File Name:   CellTests.java
Author:      Francis O'Hara
Date:        5/3/24
Description: Contains tests for the Cell class.
How to Run:  java -ea CellTests
*/
package project_5;

public class CellTests {

    /**
     * Executes tests for the Cell class.
     */
    public static void cellTests(){
        // case 0: testing Cell(int, int, int) and Cell(int, int, int, boolean)
        {
            // set up
            System.out.println("--CASE 0: TESTING CELL(INT, INT, INT) AND CELL(INT, INT, INT, BOOLEAN)--");
            project_5.lab_5.Cell cell1 = new project_5.lab_5.Cell(1, 1, 7);
            project_5.lab_5.Cell cell2  = new project_5.lab_5.Cell(2, 3, 9, true);

            // verify
            System.out.println("Cell 1: " + cell1);
            System.out.println("Cell 2: " + cell2);

            // test
            assert cell1 != null: "Error in Cell::Cell(int, int, int)";
            assert cell2 != null: "Error in Cell::Cell(int, int, int, boolean)";
            assert !cell1.isLocked(): "Error in Cell::Cell(int, int, int)";
            assert cell2.isLocked(): "Error in Cell::Cell(int, int, int, boolean)";
        }

        // case 1: testing getRow() and getColumn
        {
            // set up
            System.out.println("\n--CASE 1: TESTING GETROW() AND GETCOLUMN()--");
            project_5.lab_5.Cell cell = new project_5.lab_5.Cell(3, 4, 5, false);

            // verify
            System.out.println("Cell: " + cell);

            // test
            assert cell.getRow() == 3: "Error in Cell::getRow()";
            assert cell.getColumn() == 4: "Error in Cell::getColumn";
        }

        // case 2: testing getValue() and setValue()
        {
            // set up
            System.out.println("\n--CASE 2: TESTING GETVALUE() AND SETVALUE()--");
            project_5.lab_5.Cell cell1 = new project_5.lab_5.Cell(1, 1, 7, false);
            project_5.lab_5.Cell cell2 = new project_5.lab_5.Cell(1, 1, 7, false);

            // verify
            System.out.println("Cell1: " + cell1);
            System.out.println("Cell2 before: " + cell2);
            cell2.setValue(9);
            System.out.println("Cell2 after: " + cell2);

            // test
            assert cell1.getValue() == 7: "Error in Cell::getValue()";
            assert cell2.getValue() == 9: "Error in Cell::setValue()";
        }


        // case 3: testing isLocked and setLocked()
        {
            // set up
            System.out.println("\n--CASE 3: TESTING ISLOCKED() AND SETLOCKED()--");
            project_5.lab_5.Cell cell1 = new project_5.lab_5.Cell(1, 2, 3, false);
            project_5.lab_5.Cell cell2 = new project_5.lab_5.Cell( 1, 2, 3, false);
            cell2.setLocked(true);

            // verify
            System.out.println("Cell1: " + cell1);
            System.out.println("Cell2: " + cell2);

            // test
            assert !cell1.isLocked(): "Error in Cell::isLocked()";
            assert cell2.isLocked(): "Error in Cell::setLocked()";
        }

        // case 4: testing toString()
        {
            // set up
            System.out.println("\n--CASE 4: TESTING TOSTRING()--");
            Cell cell = new Cell(1, 1, 2, true);

            // verify
            System.out.println("Cell: " + cell);

            // test
            assert cell.toString().equals("2"): "Error in Cell::toString()";
        }

        System.out.println("\n** Done testing Cell! **");
    }

    /**
     * The main entry point into the program.
     *
     * @param args An array of Strings denoting the command-line arguments passed to the program.
     */
    public static void main(String[] args){
        cellTests();
    }
}
