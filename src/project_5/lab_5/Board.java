/*
File Name:   Board.java
Author:      Francis O'Hara
Date:        4/2/24
Description: Class for representing the board in a game of Sudoku.
How to Run:  N/A
*/
package project_5.lab_5;

import java.io.*;
import java.io.FileReader;
import java.io.BufferedReader;

public class Board {
    /**
     * The underlying 2D array that contains the cells in the Sudoku board.
     */
    private Cell[][] board;

    /**
     * Creates a new Sudoku board with all cell values initialized to 0.
     */
    public Board() {
        board = new Cell[9][9];
        for (int row = 0; row < 9; row++)
            for (int column = 0; column < 9; column++)
                board[row][column] = new Cell(row, column, 0);
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
     * Sets the `locked` field of the Cell at the specified row and column.
     *
     * @param row    The row of the cell.
     * @param col    The column of the cell.
     * @param locked The new value of the `locked` field of the cell at the specified row and column.
     */
    public void set(int row, int col, boolean locked) {
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

                for (int column = 0; column < 9; column++) {
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
        Board board = new Board();
        board.read(filename);
        System.out.println(board);
    }
}
