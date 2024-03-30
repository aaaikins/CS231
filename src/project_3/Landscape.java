/*
File Name:   Landscape.java
Author:      Francis O'Hara
Date:        3/27/24
Description: A data structure storing all Agents in the agent simulation.
How to Run:  N/A
*/
package project_3;

import project_3.lab_3.LinkedList;

import java.awt.*;
import java.util.Random;

public class Landscape {
    /**
     * A LinkedList containing all agents in the Landscape.
     */
    LinkedList<Agent> landscape;

    /**
     * The width of the landscape.
     */
    int width;

    /**
     * The height of the landscape.
     */
    int height;

    /**
     * Creates a new landscape.
     *
     * @param w The width of the landscape.
     * @param h The height of the landscape.
     */
    public Landscape(int w, int h) {
        width = w;
        height = h;
        landscape = new LinkedList<>();
    }

    /**
     * Returns the height of the landscape.
     *
     * @return An integer denoting the height of the landscape.
     */
    public int getHeight() {
        return height;
    }

    /**
     * Returns the width of the landscape.
     *
     * @return An integer denoting the width of the landscape.
     */
    public int getWidth() {
        return width;
    }

    /**
     * Adds an agent to the landscape.
     *
     * @param agent The agent to be inserted into the landscape.
     */
    public void addAgent(Agent agent) {
        landscape.add(agent);
    }

    /**
     * Returns a textual representation of the landscape.
     *
     * @return A String indicating the number of agents in the landscape.
     */
    public String toString() {
        return "Landscape Size: " + landscape.size() + " Agents";
    }

    /**
     * Returns all the neighbors to the Agent located at position (x0, y0) in the landscape.
     *
     * @param x0     The x position of the agent whose neighbors are to be found.
     * @param y0     The y position of the agent whose neighbors are to be found.
     * @param radius The radius within which to consider other agents in the landscape as neighbors.
     * @return A LinkedList of all the neighboring Agents to the current Agent in the landscape.
     */
    public LinkedList<Agent> getNeighbors(double x0, double y0, double radius) {
        LinkedList<Agent> neighbors = new LinkedList<>();

        for (Agent agent : landscape) {
            // todo: account for encountering the same agent within the landscape. What makes an agent unique? Can two
            //       agents have the same x0, y0, and radius?
            if ((Math.abs(agent.getX() - x0) <= radius) && (Math.abs(agent.getY() - y0) <= radius)) {
                neighbors.add(agent);
            }
        }
        return neighbors;
    }

    /**
     * Draws all agents in the landscape.
     *
     * @param g The Graphics object to be used to draw all agents in the landscape.
     */
    public void draw(Graphics g) {
        for (Agent agent : landscape) {
            agent.draw(g);
        }
    }

    /**
     * Replaces a randomly selected agent in the landscape with an antisocial agent, updates the state of all agents in the landscape,
     * and returns the number of agents that moved during the update.
     *
     * @return An integer denoting the number of agents that moved during the update.
     */
    public int updateAgents() {
        // select random agent and replace with antisocial agent
        Random randomGenerator = new Random();
        int randomIndex = randomGenerator.nextInt(landscape.size());
        Agent removedAgent = landscape.remove(randomIndex);
        AntiSocialAgent antiSocialAgent = new AntiSocialAgent(removedAgent.getX(), removedAgent.getY(), removedAgent.getRadius());
        landscape.add(antiSocialAgent);

        int movedAgents = 0;  // no. of agents that moved

        // update state of each agent
        for (Agent agent : landscape) {
            agent.updateState(this);
            movedAgents += agent.getMoved() ? 1 : 0; // increment movedAgents count if agent was moved.
        }

        return movedAgents;
    }
}
