/*
File Name:   Cell.java
Author:      Francis O'Hara
Date:        5/3/24
Description: A class for representing a Cell on a Sudoku board.
How to Run:  N/A
*/
package project_5;

import java.awt.Graphics;
import java.awt.*;

public class Cell {
    /**
     * The row of the Cell in the Sudoku grid.
     */
    private int row;

    /**
     * The column of the Cell in the Sudoku grid.
     */
    private int column;

    /**
     * The value stored in the Cell.
     */
    private int value;

    /**
     * A boolean indicating whether or not the value of the cell is locked.
     */
    private boolean locked;

    /**
     * Create a new Sudoku Cell whose value is locked.
     *
     * @param row The row of the cell in the grid.
     * @param col The column of the cell in the grid.
     * @param value The value the cell is storing.
     */
    public Cell(int row, int col, int value){
        this.row = row;
        column = col;
        this.value = value;
        locked = false;
    }

    /**
     * Creates a new Sudoku Cell whose value may or may not be locked.
     *
     * @param row The row of the cell in the grid.
     * @param col The column of the cell in the grid.
     * @param value The value the cell is storing.
     * @param locked Whether or not the cell's value is locked.
     */
    public Cell(int row, int col, int value, boolean locked){
        this.row = row;
        column = col;
        this.value = value;
        this.locked = locked;
    }

    /**
     * Returns the row of the cell.
     *
     * @return The row of the cell.
     */
    public int getRow() {
        return row;
    }

    /**
     * Returns the column of the cell.
     *
     * @return The column of the cell.
     */
    public int getColumn() {
        return column;
    }

    /**
     * Returns the value of the cell.
     *
     * @return The value of the cell.
     */
    public int getValue() {
        return value;
    }

    /**
     * Sets the value of the Cell.
     *
     * @param newValue The new value of the cell.
     */
    public void setValue(int newValue){
        this.value = newValue;
    }

    /**
     * Returns the value of the cell's `locked` field.
     *
     * @return The boolean value of the cell's `locked` field.
     */
    public boolean isLocked(){
        return locked;
    }

    /**
     * Sets the cell's locked field to the new value.
     *
     * @param lock The new boolean value for the cell's `locked` field.
     */
    public void setLocked(boolean lock){
        locked = lock;
    }

    /**
     * Returns a textual representation of the cell.
     *
     * @return A String representing the cell.
     */
    public String toString(){
        return "" + value;
    }

    public void draw(Graphics g, int x, int y, int scale){
        char toDraw = (char) ((int) '0' + getValue());
        g.setColor(isLocked()? Color.BLUE : Color.RED);
        g.drawChars(new char[] {toDraw}, 0, 1, x, y);
    }
}
