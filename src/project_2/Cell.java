/*
File Name:   Cell.java
Author:      Francis O'Hara
Date:        3/04/2024
Description: An implementation of a cell in a simulation of Conway's Game of Life.
How to Run:  N/A
*/
package project_2;

import java.util.ArrayList;

public class Cell {
    /** The status of the Cell. */
    private boolean alive;

    /**
     * Constructs a dead cell.
     */
    public Cell() {
        alive = false;
    }

    /**
     * Constructs a cell with the specified status.
     * 
     * @param status a boolean to specify if the Cell is initially alive
     */
    public Cell(boolean status) {
        alive = status;
    }

    /**
     * Returns whether the cell is currently alive.
     * 
     * @return whether the cell is currently alive
     */
    public boolean getAlive() {
        return alive;
    }

    /**
     * Sets the current status of the cell to the specified status.
     * 
     * @param status a boolean to specify if the Cell is alive or dead
     */
    public void setAlive(boolean status) {
        alive = status;
    }

    /**
     * Updates the state of the Cell.
     * 
     * If this Cell is alive and if there are 2 or 3 alive neighbors,
     * this Cell stays alive. Otherwise, it dies.
     * 
     * If this Cell is dead and there are 3 alive neighbors,
     * this Cell comes back to life. Otherwise, it stays dead.
     * 
     * @param neighbors An ArrayList of Cells
     */

    //todo: update this method below with proper rules.
    public void updateState(ArrayList<Cell> neighbors) {
        // count number of live neighbors
        int numberOfLiveNeighbors = 0;

        for (Cell neighbor: neighbors){
            if (neighbor.getAlive())
                numberOfLiveNeighbors ++;
        }

        // update cell status based on no. of live neighbors
        if (alive) {
            if (numberOfLiveNeighbors < 2 || numberOfLiveNeighbors > 3)
                alive = false;
        }
        else if (numberOfLiveNeighbors == 3)
                alive = true;
    }

    /**
     * Returns a String representation of this Cell.
     * 
     * @return 1 if this Cell is alive, otherwise 0.
     */
    public String toString() {
        return alive? "1" : "0";
    }
}