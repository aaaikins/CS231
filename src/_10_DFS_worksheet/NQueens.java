/*
File Name: LinkedList.java
Author: Francis O'Hara
Date: 5/3/2024
Description: Implementation of the NQueens puzzle solver using Breadth-First-Search and Depth-First-Search approaches.
How to Run: java NQueens
*/
package _10_DFS_worksheet;

import java.util.LinkedList;

public class NQueens {
    /**
     * Class for representing possible coordinates at which queens may be placed on the nxn NQueens board (chessboard).
     */
    private static class Coordinate {
        /**
         * The row value of the coordinate.
         */
        int row;

        /**
         * The column value of the coordinate.
         */
        int col;

        /**
         * Creates a new Coordinate object.
         *
         * @param r The row of the new Coordinate.
         * @param c The column of the new Coordinate.
         */
        public Coordinate(int r, int c) {
            row = r;
            col = c;
        }

        /**
         * Returns a textual representation of the Coordinate object.
         *
         * @return A String representing the Coordinate object.
         */
        public String toString() {
            return "(" + row + ", " + col + ")";
        }
    }

    /**
     * A method for printing a solution.
     *
     * @param curSolution list of Coordinates corresponding to Queen locations.
     * @param size        the size of the board on which the solution is being
     *                    created.
     */
    public static void printBoard(LinkedList<Coordinate> curSolution, int size) {
        boolean[][] board = new boolean[size][size];
        for (Coordinate c : curSolution)
            board[c.row][c.col] = true;

        System.out.println("-".repeat(size + 2));
        for (int row = 0; row < size; row++) {
            System.out.print("|");
            for (int col = 0; col < size; col++) {
                System.out.print(board[row][col] ? "X" : "O");
            }
            System.out.println("|");
        }
        System.out.println("-".repeat(size + 2));
    }

    /**
     * Returns true if a queen at the given Coordinate newCoordinate will not
     * conflict with any of the coordinates in curSolution.
     *
     * @param curSolution   a list of previously placed queens.
     * @param newCoordinate a Coordinate for a new queen to place.
     * @return true if the Coordinate newCoordinate doesn't conflict with any
     * Coordinates in curSolution, otherwise false.
     */
    public static boolean isValid(LinkedList<Coordinate> curSolution, Coordinate newCoordinate) {
        /*
         * Iterate over each Coordinate `coord` in curSolution...
         */
        for (Coordinate coord : curSolution) {
            /*
             * If coord and newCoordinate are in the same row, column, or diagonal, return
             * false.
             */
            if (newCoordinate.row == coord.row || newCoordinate.col == coord.col || Math.abs(newCoordinate.row - coord.row) == Math.abs(newCoordinate.col - coord.col))
                return false;
        }

        /*
         * If no problems found, return true.
         */
        return true;
    }

    /**
     * Returns a valid Coordinate to add to curSolution that hasn't been tried
     * before. If no such Coordinate exists, returns null.
     *
     * @param curSolution        a list of Coordinates corresponding to a valid
     *                           partial solution to the nqueens problem.
     * @param lastUsedCoordinate the last Coordinate used to build curSolution. Most
     *                           of the time, this will be the last Coordinate in
     *                           curSolution. However, when backtracking, this will
     *                           be a Coordinate that has already been tried but
     *                           from which no valid solution could be found.
     * @param size               the size of the board for the given nqueens game.
     * @return a Coordinate that's valid with curSolution if one exists, otherwise
     * null.
     */
    public static Coordinate getNewCoordinate(LinkedList<Coordinate> curSolution, Coordinate lastUsedCoordinate,
                                              int size) {
        // first, iterate over all the remaining columns in the same row of
        // lastUsedCoordinate
        for (int col = lastUsedCoordinate.col + 1; col < size; col++) {
            Coordinate newCoordinate = new Coordinate(lastUsedCoordinate.row, col);
            if (isValid(curSolution, newCoordinate))
                return newCoordinate;
        }

        // if nothing in the same row works, we'll need to iterate over all the
        // remaining rows and columns and try each one.
        for (int row = lastUsedCoordinate.row + 1; row < size; row++) {
            for (int column = 0; column < size; column++) {
                Coordinate newCoordinate = new Coordinate(row, column);
                if (isValid(curSolution, newCoordinate))
                    return newCoordinate;
            }
        }

        // if nothing has worked, return null.
        return null;
    }

    /**
     * Uses DFS to return a list of Coordinates corresponding to a solution of the
     * given size if one exists, otherwise returns null.
     *
     * @param size the size of the board to be used.
     * @return a list of Coordinates corresponding to a solution of the
     * given size if one exists, otherwise returns null.
     */
    public static LinkedList<Coordinate> dfs_solve(int size) {
        // Create a blank starting solution using Java's LinkedList.
        // Throughout this method, we'll interact with curSolution as if it were
        // a Stack: we'll only use size(), push(), and pop().
        LinkedList<Coordinate> curSolution = new LinkedList<>();

        // Create a 'dummy' starting value for lastCoordinate,
        // starting at (row, col) = (0, -1)
        Coordinate lastCoordinate = new Coordinate(0, -1);

        // We'll iterate until our solution's size reaches the desired size,
        // ie while our solution's size < size (the parameter above)
        while (curSolution.size() < size) {
            // Get the result of calling getNewCoordinate on the current solution
            // with whatever lastCoordinate currently is; let's call it "next"

            Coordinate next = getNewCoordinate(curSolution, lastCoordinate, size);

            // It *might* be the case that there is no valid next coordinate. In
            // this case, we'll need to start backtracking and continue backtracking
            // until we find a valid new Coordinate to use. As such, let's iterate
            // as long as next == null
            while (next == null) {
                // If my solution's size is 0, then I can't backtrack! It basically
                // means I've tried all possibilities and nothing worked, so it's time
                // to call it quits and return null.
                if (curSolution.isEmpty())
                    return null;

                // Otherwise, let's set lastCoordinate to be the result of 'popping' off
                // whatever the last Coordinate is in curSolution

                lastCoordinate = curSolution.pop();

                // Update next accordingly, by recalling getNewCoordinate with our
                // updated solution and lastCoordinate

                next = getNewCoordinate(curSolution, lastCoordinate, size);
            }

            // If I've reached here, then next is now a non-null Coordinate that
            // represents a new Coordinate I can add to curSolution, so let's
            // push it onto the solution
            curSolution.push(next);

            // Since we've added a new Coordinate, lastCoordinate should now be
            // whatever next is.
            lastCoordinate = next;
        }

        // If we've reached here, then we've found a solution of the desired size!
        // Let's return it.
        return curSolution;
    }

    /**
     * Uses BFS to return a list of Coordinates corresponding to a solution of the
     * given size if one exists, otherwise returns null.
     *
     * @param size the size of the board to be used.
     * @return a list of Coordinates corresponding to a solution of the
     * given size if one exists, otherwise returns null.
     */
    public static LinkedList<Coordinate> bfs_solve(int size) {
        // In BFS, instead of a Stack we'll maintain a Queue of partially-completed
        // solutions. So for this method, let's only use size(), poll(), and offer().
        LinkedList<LinkedList<Coordinate>> solutions = new LinkedList<>();

        // Let's first add a blank solution to solutions to get things started.
        solutions.add(new LinkedList<>());

        // Now, we need to keep iterating as long as there are still solutions for
        // us to work on. Equivalently, as long as solutions.size() > 0
        while (!solutions.isEmpty()) {
            // Each round, we'll look at whatever the next solution to consider is
            // by calling poll on solutions.
            LinkedList<Coordinate> solution = solutions.poll();

            // If that solution's size is the desired length, then we can declare
            // victory and return it.
            if (solution.size() == size)
                return solution;

            // Otherwise, we'll need to iterate over all the next possible Coordinates
            // we could add to solution - for any that are valid with it, we'll need to
            // 1. Make a copy of solution (why do I need to do this? think about it...)
            // 2. Add the valid next coordinate to this copy
            // 3. Add this new solution to the back of solutions using the offer method.

            Coordinate lastCoordinate;

            if (solution.isEmpty())
                lastCoordinate = new Coordinate(0, -1);
            else
                lastCoordinate = solution.peek();

            while (true) {
                Coordinate nextCoordinate = getNewCoordinate(solution, lastCoordinate, size);
                if (nextCoordinate != null) {
                    LinkedList<Coordinate> copySolution = new LinkedList<>();
                    for (Coordinate coordinate : solution) {
                        copySolution.addLast(new Coordinate(coordinate.row, coordinate.col));
                    }
                    copySolution.push(nextCoordinate);

                    solutions.offer(copySolution);
                    lastCoordinate = nextCoordinate;
                } else
                    break;
            }
        }

        // If we ever reach here, then there were no solutions possible! So
        // we'll just return null.
        return null;

        // When you've got here, change the main method to use bfs_solve and see if it
        // works!
    }

    /**
     * The main entry point into the program.
     *
     * @param args An array of Strings denoting command-line arguments passed to the program.
     */
    public static void main(String[] args) {
        for (int size = 1; size <= 20; size++) {
            // LinkedList<Coordinate> solution = dfs_solve(size);
            LinkedList<Coordinate> solution = bfs_solve(size);

            if (solution == null) {
                System.out.println("No solution found for size: " + size);
            } else {
                System.out.println("Solution Found for size: " + size);
                printBoard(solution, size);
            }
        }
    }

}