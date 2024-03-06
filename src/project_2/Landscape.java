/*
File Name:   Landscape.java
Author:      Francis O'Hara
Date:        3/05/2024
Description: Class for representing a grid of cells in Conway's Game of Life.
How to Run:  java Landscape
*/
package project_2;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class Landscape {
    /** The underlying grid of Cells for Conway's Game */
    private Cell[][] landscape;

    /** The number of rows in the grid */
    private int rows;

    /** The number of columns in the grid */
    private int columns;

    /** The original probability each individual Cell is alive */
    private double initialChance;

    /**
     * Constructs a Landscape of the specified number of rows and columns.
     * All Cells are initially dead.
     * 
     * @param rows    the number of rows in the Landscape
     * @param columns the number of columns in the Landscape
     */
    public Landscape(int rows, int columns) {
        landscape = new Cell[rows][columns];
        this.rows = rows;
        this.columns = columns;
        initialChance = 0.0;
        reset();
    }

    /**
     * Constructs a Landscape of the specified number of rows and columns.
     * Each Cell is initially alive with probability specified by chance.
     * 
     * @param rows    the number of rows in the Landscape
     * @param columns the number of columns in the Landscape
     * @param chance  the probability each individual Cell is initially alive.
     *                Should be value between 0.0 and 1.0.
     */
    public Landscape(int rows, int columns, double chance) {
        landscape = new Cell[rows][columns];
        this.rows = rows;
        this.columns = columns;
        initialChance = chance;
        reset();
    }

    /**
     * Recreates the Landscape according to the specifications given
     * in its initial construction.
     */
    public void reset() {
        // populate landscape with live/dead cells based on initialChance.
        Random random = new Random();

        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                boolean isCellAlive = random.nextDouble(0.0, 1.0) < initialChance;
                landscape[row][column] = new Cell(isCellAlive);
            }
        }
    }

    /**
     * Returns the number of rows in the Landscape.
     * 
     * @return the number of rows in the Landscape
     */
    public int getRows() {
        return rows;
    }

    /**
     * Returns the number of columns in the Landscape.
     * 
     * @return the number of columns in the Landscape
     */
    public int getCols() {
        return columns;
    }

    /**
     * Returns the Cell specified by the given row and column.
     * 
     * @param row the row of the desired Cell
     * @param col the column of the desired Cell
     * @return the Cell specified the given row and column
     */
    public Cell getCell(int row, int col) {
        return landscape[row][col];
    }

    /**
     * Returns a String representation of the Landscape.
     */
    public String toString() {
        String result = "";
        for (int row = 0; row < rows; row ++) {
            for (int column = 0; column < columns; column ++) {
                result += landscape[row][column] + " ";
            }
            result += "\n";
        }
        return result;
    }

    /**
     * Returns an ArrayList of the neighboring Cells to the specified location.
     * 
     * @param row the row of the specified Cell
     * @param col the column of the specified Cell
     * @return an ArrayList of the neighboring Cells to the specified location
     */
    public ArrayList<Cell> getNeighbors(int row, int col) {
        ArrayList<Cell> neighbors = new ArrayList<>();  // for storing neighbors

        // compute row and column of all possible neighbors
        for(int rowChange = -1; rowChange < 2; rowChange ++) {
            for (int columnChange = -1; columnChange < 2; columnChange ++) {
                int neighborRow = row + rowChange;  // row of possible neighbor
                int neighborColumn = col + columnChange;  // column of possible neighbor

                // add cells at valid neighborRow and NeighborColumn to list of neighbors
                if (neighborRow >= 0 && neighborRow < rows) {  // filter for valid rows
                    if (neighborColumn >= 0 && neighborColumn < columns) {  // filter for valid columns
                        if (!(neighborRow == row && neighborColumn == col)) {  // filter out same cell from being added as neighbor
                            neighbors.add(landscape[neighborRow][neighborColumn]);
                        }
                    }
                }
            }
        }
        return neighbors;
    }

    /**
     * Advances the current Landscape by one step. 
     */
    public void advance() {
        // copy the current state of the landscape into a new cell grid
        Cell[][] landscapeCopy = new Cell[rows][columns];

        for (int row = 0; row < rows; row ++){
            for (int column = 0; column < columns; column ++){
                boolean cellAliveStatus = landscape[row][column].getAlive();
                landscapeCopy[row][column] = new Cell(cellAliveStatus);
            }
        }

        // update cells in the copied landscape based on current landscape
        for (int row = 0; row < rows; row ++) {
            for (int column = 0; column < columns; column ++) {
                ArrayList<Cell> neighbors = getNeighbors(row, column);
                landscapeCopy[row][column].updateState(neighbors);
            }
        }

        // make the copied landscape the current landscape
        landscape = landscapeCopy;
    }

    /**
     * Draws the Cell to the given Graphics object at the specified scale.
     * An alive Cell is drawn with a black color; a dead Cell is drawn gray.
     * 
     * @param g     the Graphics object on which to draw
     * @param scale the scale of the representation of this Cell
     */
    public void draw(Graphics g, int scale) {
        for (int x = 0; x < getRows(); x++) {
            for (int y = 0; y < getCols(); y++) {
                g.setColor(getCell(x, y).getAlive() ? Color.BLACK : Color.gray);
                g.fillOval(x * scale, y * scale, scale, scale);
            }
        }
    }

    /**
     * The main entry point into the program.
     * @param args An array of Strings denoting the command-line arguments passed to the program.
     */
    public static void main(String[] args) {
        // create a landscape of 20 rows and 20 columns with all cells dead.
        Landscape landscape = new Landscape(20, 20);
        System.out.println("Landscape:\n" + landscape);

        // create a landscape of 30 rows and 50 columns with ~ 70 % survival rate of cells
        Landscape landscape1 = new Landscape(30, 50, 0.7);
        System.out.println("Landscape1:\n" + landscape1);
    }
}
