/*
File Name:   Sudoku.java
Author:      Francis O'Hara
Date:        5/4/24
Description: Main class for representing the game of Sudoku.
How to Run:  java Sudoku
*/
package project_5;

import java.util.Random;

public class Sudoku {
    /**
     * The board in the sudoku game.
     */
    private Board board;

    /**
     * Creates a new Sudoku board with the given number of randomly placed values on the board.
     *
     * @param numFilled An integer denoting the number of pre-filled values on the board to be created.
     */
    public Sudoku(int numFilled) {
        board = new Board(numFilled);
    }

    /**
     * Returns the board of the sudoku game.
     * This serves as a helper method for testing the Sudoku class.
     *
     * @return The current board of the sudoku game.
     */
    public Board getBoard() {
        return board;
    }

    /**
     * Sets the given Board object as the board for the sudoku game.
     * This serves as a helper for testing the Sudoku class.
     *
     * @param board The board to be set as the new board for the sudoku game.
     */
    public void setBoard(Board board) {
        this.board = board;
    }

    /**
     * Returns the next valid value for the given cell on the Sudoku board.
     *
     * @return An integer that can be correctly used as a value for the given cell on the sudoku board and which has not
     * been previously used as a value for the given cell.
     */
    public int findNextValue(Cell cell) {
        for (int value = cell.getValue() + 1; value < 10; value++)
            if (board.validValue(cell.getRow(), cell.getColumn(), value))
                return value;
        return 0;
    }

    /**
     * Finds the next cell on the grid whose value has not been set, sets a valid value for it if any, and returns the updated cell.
     *
     * @return The updated cell or null if no such cell could be found.
     */
    public Cell findNextCell() {
        for (int row = 0; row < board.getRows(); row++) {
            for (int column = 0; column < board.getCols(); column++) {
                Cell currentCell = board.get(row, column);
                if (currentCell.getValue() == 0) {
                    int nextValue = findNextValue(currentCell);
                    if (nextValue > 0) {
                        currentCell.setValue(nextValue);
                        return currentCell;
                    }
                }
            }
        }
        return null;
    }



}
