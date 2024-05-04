/*
File Name:   SudokuTests.java
Author:      Francis O'Hara
Date:        5/4/24
Description: Contains tests for the Sudoku class.
How to Run:  java -ea SudokuTests
*/
package project_5;

public class SudokuTests {
    /**
     * Executes tests for the Sudoku class.
     */
    public static void sudokuTests(){
        // case 1: testing Sudoku()
        {
            // setup
            Sudoku sudoku = new Sudoku(15);

            // verify
            System.out.println(sudoku.getBoard());

            // test
            assert sudoku.getBoard() != null : "Error in Sudoku::Sudoku()";
            assert sudoku.getBoard().numLocked() == 15 : "Error in Sudoku::Sudoku()";
        }

        // case 2: testing findNextValue()
        {
            // setup
            Sudoku sudoku = new Sudoku(7);
            sudoku.setBoard(new Board("./src/project_5/lab_5/data/board2.txt"));

            // verify
            System.out.println(sudoku.getBoard());

            // test
            assert sudoku.findNextValue(sudoku.getBoard().get(0,1)) == 3 : "Error in Sudoku::findNextValue()";
            assert sudoku.findNextValue(sudoku.getBoard().get(1,2)) == 5: "Error in Sudoku::findNextValue()";
        }

        // case 3: testing findNextCell()
        {
            // setup
            Sudoku sudoku = new Sudoku(7);
            sudoku.setBoard(new Board("./src/project_5/lab_5/data/board2.txt"));

            // verify
            System.out.println(sudoku.getBoard());

            // test
            Cell nextCell = sudoku.findNextCell();
            assert nextCell.getRow() == 0 : "Error in Sudoku::findNextCell()";
            assert nextCell.getColumn() == 0 : "Error in Sudoku::findNextCell()";
            assert nextCell.getValue() == 1 : "Error in Sudoku::findNextCell()";
            nextCell = sudoku.findNextCell();
            assert nextCell.getRow() == 0 : "Error in Sudoku::findNextCell()";
            assert nextCell.getColumn() == 2 : "Error in Sudoku::findNextCell()";
            assert nextCell.getValue() == 3 : "Error in Sudoku::findNextCell()";
        }

        System.out.println("*** Done testing Sudoku class! ***");
    }

    /**
     * The main entry point into the program.
     *
     * @param args An array of Strings denoting command-line arguments passed to the program.
     */
    public static void main(String[] args){
        sudokuTests();
    }
}
