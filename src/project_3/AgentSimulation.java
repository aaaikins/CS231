/*
File Name:   AgentSimulation.java
Author:      Francis O'Hara
Date:        3/27/24
Description: Runs a simulation of a landscape of SocialAgents and AntiSocialAgents inspired by Growing Artificial Societies by Epstein and Axtell.
How to Run:  java AgentSimulation n
*/
package project_3;

import java.util.Random;

public class AgentSimulation {
    /**
     * The main entry point into the program.
     * Runs an agent-based simulation of n social agents, where n is the first command-line argument passed to the program.
     * Each social agent will be given a radius of 25 and placed on a landscape of height 500 and width 500.
     *
     * @param args An array of Strings denoting the command-line arguments passed to the program.
     */
    public static void main(String[] args) throws Exception {
        // verify that the program was called correctly.
        if (args.length < 1) {
            System.out.println("Usage: java AgentSimulation n\n\t(To create an agent simulation with n initial social agents.)");
            throw new Exception("Please specify the number of social agents n.");
        }
        // set the number of agents in the simulation based on command-line argument
        int numberOfAgents = Integer.parseInt(args[0]);

        // create Landscape
        Landscape landscape = new Landscape(500, 500);

        // Generate and randomly place agents unto Landscape
        Random randomGenerator = new Random();
        for (int i = 0; i < numberOfAgents; i++) {
            landscape.addAgent(new SocialAgent(randomGenerator.nextDouble() * landscape.getWidth(),
                    randomGenerator.nextDouble() * landscape.getHeight(), 25));
        }

        // create a LandscapeDisplay for visualizing the landscape
        LandscapeDisplay display = new LandscapeDisplay(landscape);


        // set thresholds for updating the landscape
        int numberOfIterations = 5000;
        int numberOfMovedAgents = 42;  // arbitrary nonzero value

        // update landscape until thresholds are exceeded.
        while (numberOfIterations > 0 && numberOfMovedAgents > 0) {
            Thread.sleep(10);
            numberOfMovedAgents = landscape.updateAgents();
            numberOfIterations--;
            display.repaint();

            // save screenshot of each iteration
//            display.saveImage("src/project_3/data/radius_25/" + (5000 - numberOfIterations) + ".png");
        }

        System.out.println("Total Number of Agents: " + numberOfAgents + "\nNumber of Moved Agents: " + numberOfMovedAgents + "\nNumber of Iterations: " + (5000 - numberOfIterations));
    }
}
