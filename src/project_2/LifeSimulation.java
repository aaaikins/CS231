/*
File Name:   LifeSimulation.java
Author:      Francis O'Hara
Date:        3/06/2024
Description: Class for running one simulation of Conway's Game of Life.
How to Run:  java LifeSimulation
*/
package project_2;

public class LifeSimulation {
    /**
     * The main entry point into the program.
     * Runs a simulation of Conway's Game of Life with conditions based on command-line arguments.
     *
     * @param args An array of Strings denoting command-line arguments passed to the program.
     */
    public static void main(String[] args) throws InterruptedException {
        // default game parameters
        int gridSize = 100;
        int totalSteps = -1;
        double chance = 0.25;

        // set game parameters based on command-line arguments if any
        switch (args.length) {
            case 1:
                gridSize = Integer.parseInt(args[0]);
                break;

            case 2:
                gridSize = Integer.parseInt(args[0]);
                chance = Double.parseDouble(args[1]);
                break;

            case 3:
                gridSize = Integer.parseInt(args[0]);
                chance = Double.parseDouble(args[1]);
                totalSteps = Integer.parseInt(args[2]);
        }

        // display game parameters
        System.out.println("--GAME PARAMETERS--\n" +
                "GridSize: " + gridSize + " x " + gridSize + "\n" +
                "Chance: " + chance + "\n" +
                "Game Steps: " + totalSteps);

        // display initial game state
        Landscape landscape = new Landscape(gridSize, gridSize, chance);
        LandscapeDisplay display = new LandscapeDisplay(landscape, 6);

        // run the game and display state at each step
        int step = 1; // current step of the simulation
        while (true) {
            Thread.sleep(250);  // display current landscape for 0.25 seconds
            landscape.advance();  // update the landscape
            display.repaint();  // display updated landscape

            // save an image of the updated landscape
            display.saveImage("/Users/francisohara/Library/CloudStorage/GoogleDrive-franciskohara@gmail.com/My Drive/LEARN/Spring 2024/CS231/CS231/src/project_2/data/life_frame_" + String.format("%03d", step) + ".png");

            step++;  // increment counter for no. of steps
            if (totalSteps != -1)
                if (step > totalSteps)
                    break;
        }
    }
}
