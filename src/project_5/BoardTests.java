/*
File Name:   BoardTests.java
Author:      Francis O'Hara
Date:        5/3/24
Description: Contains tests for the Board class.
How to Run:  java -ea BoardTests
*/
package project_5;

public class BoardTests {
    /**
     * Executes tests for the Board class.
     */
    public static void boardTests() {
        // case 1: testing Board()
        {
            // setup
            Board board = new Board();

            // verify
            System.out.println(board);

            // test
            assert board != null : "Error in Board::board()";

            for (int row = 0; row < Board.size; row++) {
                for (int column = 0; column < Board.size; column++) {
                    assert board.get(row, column).getValue() == 0 : "Error in Board::board()";
                }
            }
        }

        // case 2: testing Board(String)
        {
            // setup
            Board board = new Board("./src/project_5/lab_5/data/board1.txt");

            // verify
            System.out.println(board);

            // test
            assert board != null : "Error in Board::board()";
        }

        // case 3: testing getCols() and getRows()
        {
            // setup
            Board board = new Board();

            // verify
            System.out.println(board);

            // test
            assert board.getCols() == 9 : "Error in Board::getCols()";
            assert board.getRows() == 9 : "Error in Board::getRows()";
        }

        // case 4: testing get(int, int)
        {
            // setup
            Board board = new Board("./src/project_5/lab_5/data/board2.txt");

            // verify
            System.out.println(board);

            // test
            assert board.get(0, 0) != null : "Error in Board::get(int, int)";
            assert board.get(0, 1).getValue() == 2 : "Error in Board::get(int, int)";
            assert board.get(8, 8).getValue() == 7 : "Error in Board::get(int, int)";
        }

        // case 5: testing isLocked()
        {
            // setup
            Board board = new Board();
            board.get(0, 0).setLocked(true);
            board.get(5, 5).setLocked(true);

            // verify
            System.out.println(board);

            // test
            assert board.isLocked(0, 0) : "Error in Board::isLocked()";
            assert board.isLocked(5, 5) : "Error in Board::isLocked()";
            assert !board.isLocked(0, 1) : "Error in Board::isLocked()";
        }

        // case 6: testing numLocked()
        {
            // setup
            Board board = new Board();
            board.get(0, 0).setLocked(true);
            board.get(8, 8).setLocked(true);
            board.get(5, 5).setLocked(true);

            // verify
            System.out.println(board);

            // test
            assert board.numLocked() == 3;
            board.get(0, 0).setLocked(false);
            assert board.numLocked() == 2 : "Error in Board::numLocked()";
            board.get(5, 5).setLocked(false);
            assert board.numLocked() == 1 : "Error in Board::numLocked()";
        }

        // case 7: testing value(int, int)
        {
            // setup
            Board board = new Board("./src/project_5/lab_5/data/board1.txt");

            // verify
            System.out.println(board);

            // test
            assert board.value(7, 6) == 8 : "Error in Board::value()";
            assert board.value(6, 4) == 5 : "Error in Board::value()";
        }

        // case 8: testing set(int, int, int)
        {
            // setup
            Board board = new Board();

            // verify
            System.out.println(board);

            // test
            board.set(0, 0, 1);
            assert board.value(0, 0) == 1 : "Error in Board::set(int, int, int)";
            board.set(8, 8, 4);
            assert board.value(8, 8) == 4 : "Error in Board::set(int, int, int)";
            board.set(8, 8, 7);
            assert board.value(8, 8) == 7 : "Error in Board::set(int, int, int)";
        }

        // case 9: testing set(int, int, int, boolean)
        {
            // setup
            Board board = new Board();

            // verify
            System.out.println(board);

            // test
            board.set(0, 0, 8, true);
            assert board.value(0, 0) == 8 && board.isLocked(0, 0) : "Error in Board::set(int, int, int, boolean)";
            board.set(8, 8, 1, true);
            assert board.value(8, 8) == 1 && board.isLocked(8, 8) : "Error in Board::set(int, int, int, boolean)";
            board.set(0, 0, 5, false);
            assert board.value(0, 0) == 5 && !board.isLocked(0, 0) : "Error in Board::set(int, int, int, boolean)";
        }

        // case 10: testing Board(int)
        {
            // setup
            Board board = new Board(10);

            // verify
            System.out.println(board);

            // test
            assert board != null: "Error in Board::Board(int)";
            assert board.numLocked() == 10 : "Error in Board::Board(int)";
        }

        // case 11: testing validValue(int, int, int)
        {
            // setup
            Board board = new Board();

            // verify
            System.out.println(board);

            // test
            board.set(2, 2, 6);
            assert !board.validValue(0, 0, 6) : "Error in Board::validValue(int, int, int)";
            assert !board.validValue(2, 3, 6) : "Error in Board::validValue(int, int, int)";
            assert !board.validValue(7, 2, 6) : "Error in Board::validValue(int, int, int)";
            assert board.validValue(5, 5, 6) : "Error in Board::validValue(int, int, int)";
        }

        // case 12: testing validSolution()
        {
            // setup
            Board board1 = new Board("./src/project_5/lab_5/data/solution.txt");
            Board board2 = new Board(12);
            Board board3 = new Board();

            // verify
            System.out.print("Board 1:\n" + board1);
            System.out.print("Board 2:\n" + board2);
            System.out.print("Board 3:\n" + board3);


            // test
            assert board1.validSolution() : "Error in Board::validSolution()";
            assert !board2.validSolution() : "Error in Board::validSolution()";
            assert !board3.validSolution() : "Error in Board::validSolution()";
        }

        System.out.println("*** Done testing Board class! ***");
    }


    /**
     * The main entry point into the program.
     *
     * @param args An array of Strings denoting command-line arguments passed to the program.
     */
    public static void main(String[] args) {
        boardTests();
    }
}
