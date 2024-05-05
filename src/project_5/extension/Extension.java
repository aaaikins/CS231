/*
File Name:   Extension.java
Author:      Francis O'Hara
Date:        5/5/24
Description: Contains the main code for running the project extension aimed at identifying the relationship between the
            size of the Sudoku board and average time it takes to solve the board.
How to Run:  java Extension
*/
package project_5.extension;

public class Extension {
    /**
     * The main entry point into the program.
     * Executes extension code aimed at testing the average runtime of different sizes of sudoku boards.
     *
     * @param args An array of Strings denoting command-line arguments passed to the program.
     */
    public static void main(String[] args) throws Exception {
        int[] boardSizes = {4, 9, 16, 25};
        for (int boardSize: boardSizes){
            long totalSolutionTime = 0;  // in milliseconds
            for (int i = 0; i < 5; i++) {
                Sudoku sudoku = new Sudoku(0, boardSize);
                long startTime = System.currentTimeMillis();
                sudoku.solve(0);
                totalSolutionTime += System.currentTimeMillis() - startTime;
            }
            System.out.println("Board Size: " + boardSize + "\n--------------");
            System.out.println("Average Solution Time: " + (totalSolutionTime / 5.0) + " millisecond(s)\n");
        }
    }
}
