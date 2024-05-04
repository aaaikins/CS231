/*
File Name:   Board.java
Author:      Francis O'Hara
Date:        5/3/24
Description: Class for representing the board in a game of Sudoku.
How to Run:  java Board
*/
package project_5;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

public class Board {
    /**
     * The underlying 2D array that contains the cells in the Sudoku board.
     */
    private Cell[][] board;

    /**
     * The size of the Sudoku board (9 by default).
     */
    public static final int size = 9;

    /**
     * Creates a new Sudoku board with all cell values initialized to 0.
     */
    public Board() {
        board = new Cell[size][size];
        for (int row = 0; row < 9; row++)
            for (int column = 0; column < 9; column++)
                board[row][column] = new Cell(row, column, 0);
    }

    /**
     * Creates a new Sudoku board using cell values specified in a .txt file.
     *
     * @param filename A String denoting the name of the .txt file containing the cell values for creating the board.
     */
    public Board(String filename) {
        this();
        read(filename);
    }

    /**
     * Creates a new Sudoku board with the given number of locked cells.
     * The values of the cells will be randomly assigned but will be valid.
     *
     * @param numLocked The number of locked cells that should be on the newly created board.
     */
    public Board(int numLocked) {
        this();
        Random randomGenerator = new Random();

        while (numLocked() < numLocked) {
            int row = randomGenerator.nextInt(0, 9);
            int column = randomGenerator.nextInt(0, 9);
            int value = randomGenerator.nextInt(1, 10);
            if (validValue(row, column, value))
                board[row][column] = new Cell(row, column, value, true);
        }
    }

    /**
     * Returns the number of columns of the board.
     *
     * @return An integer denoting the number of columns of the sudoku board.
     */
    public int getCols() {
        return size;
    }

    /**
     * Returns the number of rows of the board.
     *
     * @return An integer denoting the number of rows of the sudoku board.
     */
    public int getRows() {
        return size;
    }

    /**
     * Returns the Cell at the given row and column on the board.
     *
     * @param row The row of the cell.
     * @param col The column of the cell.
     * @return The Cell at the specified row and column.
     */
    public Cell get(int row, int col) {
        return board[row][col];
    }

    /**
     * Returns a boolean indicating whether the cell at the given row and column on the board is locked.
     *
     * @param row    The row of the cell.
     * @param column The column of the cell.
     * @return `true` if the cell is locked. Otherwise, returns `false`.
     */
    public boolean isLocked(int row, int column) {
        return board[row][column].isLocked();
    }

    /**
     * Returns the number of locked Cells on the board.
     *
     * @return An integer denoting the number of locked cells on the board.
     */
    public int numLocked() {
        int counter = 0;
        for (int row = 0; row < getRows(); row++) {
            for (int column = 0; column < getCols(); column++) {
                if (isLocked(row, column))
                    counter++;
            }
        }
        return counter;
    }

    /**
     * Returns the value of the cell at the given row and column.
     *
     * @param row    The row of the cell.
     * @param column The column of the cell.
     * @return An integer denoting the value of the cell at the given row and column.
     */
    public int value(int row, int column) {
        return board[row][column].getValue();
    }

    /**
     * Sets the cell at the given row and column to the given value.
     *
     * @param row   The row of the cell.
     * @param col   The column of the cell.
     * @param value The new value for the cell at the specified row and column.
     */
    public void set(int row, int col, int value) {
        board[row][col].setValue(value);
    }

    /**
     * Sets the value and `locked` fields of the Cell at the specified row and column.
     *
     * @param row    The row of the cell.
     * @param col    The column of the cell.
     * @param value  The new value of the cell.
     * @param locked The new value of the `locked` field of the cell at the specified row and column.
     */
    public void set(int row, int col, int value, boolean locked) {
        set(row, col, value);
        board[row][col].setLocked(locked);
    }

    /**
     * Reads the values for a Sudoku board from a file.
     *
     * @param filename A string denoting the path of the file containing Sudoku values.
     * @return A boolean indicating whether the values were read successfully from the file.
     */
    public boolean read(String filename) {
        try {
            // assign to a variable of type FileReader a new FileReader object, passing filename to the constructor
            FileReader fr = new FileReader(filename);
            // assign to a variable of type BufferedReader a new BufferedReader, passing the FileReader variable to the constructor
            BufferedReader br = new BufferedReader(fr);

            // assign to a variable of type String line the result of calling the readLine method of your BufferedReader object.
            String line = br.readLine();
            // start a while loop that loops while line isn't null

            int row = 0;
            while (line != null) {
                // print line
                System.out.println(line);
                // assign to an array of Strings the result of splitting the line-up by spaces (line.split("[ ]+"))
                String[] arr = line.split("[ ]+");
                // let's see what this array holds:
                System.out.println("the first item in arr: " + arr[0] + ", the second item in arr: " + arr[1]);
                // print the size of the String array (you can use .length)
                System.out.println(arr.length);
                // use the line to set various Cells of this Board accordingly

                for (int column = 0; column < getCols(); column++) {
                    board[row][column].setValue(Integer.parseInt(arr[column]));
                }

                // assign to line the result of calling the readLine method of your BufferedReader object.
                line = br.readLine();

                // move to next row on board
                row++;
            }

            // call the close method of the BufferedReader
            br.close();
            return true;
        } catch (FileNotFoundException ex) {
            System.out.println("Board.read():: unable to open file " + filename);
        } catch (IOException ex) {
            System.out.println("Board.read():: error reading file " + filename);
        }

        return false;
    }

    /**
     * Returns a textual representation of the board.
     *
     * @return A String representing the board.
     */
    public String toString() {
        String result = "";
        for (int row = 0; row < 9; row++) {
            for (int column = 0; column < 9; column++) {
                if ((column) % 3 == 0)
                    result += "   ";
                result += " " + board[row][column];
            }
            if ((row + 1) % 3 == 0)
                result += "\n";
            result += "\n";
        }
        return result;
    }

    /**
     * Checks if the given value is a valid value at the given row and column of the sudoku board.
     *
     * @param row    The row of the value.
     * @param column The column of the value.
     * @param value  The value whose validity is being tested.
     * @return `true` if the value is valid. Otherwise, return `false`.
     */
    public boolean validValue(int row, int column, int value) {
        if (value < 1 || value > 9)
            return false;

        // check rows
        for (int c = 0; c < getCols(); c++) {
            if (value(row, c) == value && c != column)
                return false;
        }

        // check columns
        for (int r = 0; r < getRows(); r++) {
            if (value(r, column) == value && r != row)
                return false;
        }

        // checking local 3x3 grid
        for (int r = (row / 3) * 3; r < ((row / 3) * 3) + 3; r++) {
            for (int c = (column / 3) * 3; c < ((column / 3) * 3) + 3; c++) {
                if (value(r, c) == value && (r != row || c != column))
                    return false;
            }
        }

        return true;
    }

    /**
     * Returns a boolean indicating whether the board is solved.
     *
     * @return `true` if the board is solved. Otherwise, returns `false`.
     */
    public boolean validSolution() {
        for (int row = 0; row < getRows(); row++) {
            for (int column = 0; column < getCols(); column++) {
                if (value(row, column) == 0)
                    return false;
                if (!validValue(row, column, value(row, column)))
                    return false;
            }
        }

        return true;
    }

    /**
     * The main entry point into the program.
     * Creates a new Sudoku board based on values read from a text file and prints the resulting board values.
     *
     * @param args An array of strings denoting command-line arguments passed to the program.
     */
    public static void main(String[] args) throws Exception {
        if (args.length < 1) {
            System.out.println("Usage: java Board filename\n\tCreates a new Sudoku board based on values read from a text file whose path is specified by filename.");
            throw new Exception("Error: Filename must be specified!");
        }
        String filename = args[0];

        Board board = new Board(filename);
        System.out.println(board);
    }
}
