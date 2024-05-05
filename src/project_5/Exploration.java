/*
File Name:   Exploration.java
Author:      Francis O'Hara
Date:        5/4/24
Description: Code for exploring the relationship between number of fixed cells on the board and the probability that
             the board is solvable/insoluble.
How to Run:  java Exploration
*/
package project_5;

public class Exploration {
    /**
     * The main entry point into the program.
     * Runs 5 sudoku board solving simulations for each of 5 different number of initial fixed cells on the board .
     *
     * @param args An array of Strings denoting the command-line arguments passed to the program.
     */
    public static void main(String[] args) throws Exception {
        for (int numInitialValues = 10; numInitialValues <= 40; numInitialValues += 10) {
            double totalSolutionTime = 0;  // time is in milliseconds
            int numSolvable = 0;
            int numInsolvable = 0;

            for (int i = 0; i < 5; i++) {
                Sudoku sudoku = new Sudoku(numInitialValues);
                long startTime = System.currentTimeMillis();
                boolean isSolvable = sudoku.solve(0);
                totalSolutionTime += System.currentTimeMillis() - startTime;
                if (isSolvable)
                    numSolvable ++;
                else
                    numInsolvable ++;
            }

            System.out.println("Trial " + (numInitialValues / 10) + ": " + numInitialValues + " initial values\n-------------------------");
            System.out.println(numSolvable + " out of 5 solvable boards.");
            System.out.println(numInsolvable + " out of 5 insolvable boards.");
            System.out.println("Average Solution Time: " + (totalSolutionTime / 5.0) + " milliseconds.\n");
        }
    }
}
