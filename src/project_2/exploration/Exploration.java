/*
File Name:   Exploration.java
Author:      Francis O'Hara
Date:        3/06/2024
Description: Exploration on the effect of Grid size and initial status chance on quantity of living cells in the Game of Life.
How to Run:  java Exploration
*/
package project_2.exploration;

import project_2.Landscape;

import java.util.HashMap;

public class Exploration {
    /**
     * Convenience method for counting the number of live cells in a landscape of cells.
     *
     * @param landscape The landscape of cells whose quantity of live cells is to be counted.
     * @return An integer denoting the number of cells that are alive in the current landscape.
     */
    public static int countLiveCells(Landscape landscape) {
        int liveCellCount = 0;

        for(int row = 0; row < landscape.getRows(); row ++){
            for(int column = 0; column < landscape.getCols(); column ++){
                if (landscape.getCell(row, column).getAlive())
                    liveCellCount ++;
            }
        }

        return liveCellCount;
    }

    /**
     * The main entry point into the program.
     *
     * @param args An array of Strings denoting command-line arguments passed to the program if any.
     */
    public static void main(String[] args) {
        // case 1: testing Grid Size effect on live cell count after 1000 advancements with initial chance of 25% and 50%
        {
            // create hash maps for storing grid size and corresponding live cell count
            HashMap<Integer, Integer> gridSizeResults25 = new HashMap<>();  // 25 % initial chance
            HashMap<Integer, Integer> gridSizeResults50 = new HashMap<>();  // 50 % initial chance

            // test effect of grid sizes from 5 to 500 in increments of 5
            for (int gridSize = 5; gridSize < 500; gridSize += 5) {
                Landscape landscape25 = new Landscape(gridSize, gridSize, 0.25);
                Landscape landscape50 = new Landscape(gridSize, gridSize, 0.5);

                // conduct 1000 advancements
                for (int i = 0; i < 1000; i ++){
                    landscape25.advance();
                    landscape50.advance();
                }

                // store results after 1000 advancements
                gridSizeResults25.put(gridSize, countLiveCells(landscape25));
                gridSizeResults50.put(gridSize, countLiveCells(landscape50));
            }

            // output results
            System.out.println("Relationship between Grid Size and live cell count after 1000 advancements with 25% initial chance (grid Size = live cell count):\n" + gridSizeResults25);
            System.out.println("Relationship between Grid Size and live cell count after 1000 advancements with 50% initial chance (grid Size = live cell count):\n" + gridSizeResults50);

        }

        // case 2: testing initial status chance effects on the number of living cells after 1000 advancements with grid size of 50 and 100
        {
            // create a hash map for storing initial status chance and corresponding live cell count
            HashMap<Double, Integer> initialChanceResults50 = new HashMap<>();  // 50 x 50 Grid Size
            HashMap<Double, Integer> initialChanceResults100 = new HashMap<>();  // 100 x 100 Grid Size

            // test effect of initial chances from 0% to 100% in increments of 5%
            for (double chance = 0.0; chance <= 1.0; chance += 0.05) {
                Landscape landscape50 = new Landscape(50, 50, chance);
                Landscape landscape100 = new Landscape(100, 100, chance);


                // conduct 1000 advancements
                for (int i = 0; i < 1000; i++) {
                    landscape50.advance();
                    landscape100.advance();
                }

                // store results after 1000 advancements
                initialChanceResults50.put(chance, countLiveCells(landscape50));
                initialChanceResults100.put(chance, countLiveCells(landscape100));
            }

            // output results
            System.out.println("Relationship between initial chance and live cell count after 1000 advancements with 50 x 50 grid size (initial chance = live cell count):\n" + initialChanceResults50);
            System.out.println("Relationship between initial chance and live cell count after 1000 advancements with 100 x 100 grid size (initial chance = live cell count):\n" + initialChanceResults100);
        }
    }
}
