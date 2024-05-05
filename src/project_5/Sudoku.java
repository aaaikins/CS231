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
     * The LandscapeDisplay object for visualizing the Sudoku board.
     */
    LandscapeDisplay ld;

    /**
     * Creates a new Sudoku board with the given number of randomly placed values on the board.
     *
     * @param numFilled An integer denoting the number of pre-filled values on the board to be created.
     */
    public Sudoku(int numFilled) {
        board = new Board(numFilled);
        ld = new LandscapeDisplay(board);
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
                    return null;
                }
            }
        }
        return null;
    }

    /**
     * Solves the current sudoku board using a backtracking algorithm, and returns a boolean indicating whether the board
     * solvable.
     *
     * @return `true` if the board is solvable. `false` if the board is not solvable.
     */
    public boolean solve(int delay) throws Exception {
        LinkedList<Cell> solution = new LinkedList<>();
        int numUnspecifiedCells = 81 - board.numLocked();
        while (solution.size() < numUnspecifiedCells) {
            if (delay > 0)
                Thread.sleep(delay);
            if (ld != null)
                ld.repaint();

            Cell next = findNextCell();
            while (next == null && !solution.isEmpty()) {
                Cell current = solution.pop();
                current.setValue(findNextValue(current));
                if (current.getValue() != 0)
                    next = current;
            }

            if (next == null)
                return false;
            else
                solution.push(next);
        }
        board.setFinished(true);
        return true;
    }

    /**
     * The main entry point into the program.
     * Executes tests for the `solve()` method above.
     *
     * @param args An array of Strings denoting the command-line arguments passed to the program.
     */
    public static void main(String[] args) throws Exception {
        Sudoku sudoku1 = new Sudoku(0);
        System.out.println("Board 1 Before:\n" + sudoku1.getBoard());
        if (sudoku1.solve(10))
            System.out.println("Board 1 After:\n" + sudoku1.getBoard());
        else
            System.out.println("Board 1 cannot be solved!");

        Sudoku sudoku2 = new Sudoku(10);
        System.out.println("Board 2 Before:\n" + sudoku2.getBoard());
        if (sudoku2.solve(10))
            System.out.println("Board 2 After:\n" + sudoku2.getBoard());
        else
            System.out.println("Board 2 cannot be solved!");
    }
}
