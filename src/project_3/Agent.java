/*
File Name:   Agent.java
Author:      Francis O'Hara
Date:        3/27/24
Description: Implementation of an Agent inspired by Growing Artificial Societies by Epstein and Axtell
How to Run:  N/A
*/
package project_3;

import java.awt.*;

public abstract class Agent {
    /**
     * The horizontal position of the agent on the grid.
     */
    private double x;

    /**
     * The vertical position of the agent on the grid.
     */
    private double y;

    /**
     * The radius within which the agent considers another agent a neighbor.
     */
    protected int radius;

    /**
     * A boolean indicating whether the agent changed position during the last state update.
     */
    protected boolean moved;

    /**
     * Creates a new agent located at position (x0, y0) on the grid.
     *
     * @param x0 The x-coordinate of the agent.
     * @param y0 The y-coordinate of the agent.
     */
    public Agent(double x0, double y0) {
        x = x0;
        y = y0;
    }

    /**
     * Returns the x-coordinate of the agent.
     *
     * @return A double denoting the x position of the agent on the grid.
     */
    public double getX() {
        return x;
    }

    /**
     * Returns the y-coordinate of the agent.
     *
     * @return A double denoting the y position of the agent on the grid.
     */
    public double getY() {
        return y;
    }

    /**
     * Returns the radius of the agent.
     *
     * @return An integer denoting the radius of the agent.
     */
    public int getRadius() {
        return radius;
    }

    /**
     * Returns the value of the `moved` field of the agent.
     *
     * @return A boolean denoting whether the agent was moved during the last state update.
     */
    public boolean getMoved() {
        return moved;
    }

    /**
     * Sets the x position of the agent to a desired value.
     *
     * @param newX The desired x position of the agent.
     */
    public void setX(double newX) {
        x = newX;
    }

    /**
     * Sets the y position of the agent to a desired value.
     *
     * @param newY The desired y position of the agent.
     */
    public void setY(double newY) {
        y = newY;
    }

    /**
     * Sets the radius of the agent to a desired value.
     *
     * @param newRadius The desired radius of the agent.
     */
    public void setRadius(int newRadius) {
        radius = newRadius;
    }

    /**
     * Returns a textual representation of the agent in terms of its position.
     *
     * @return A String containing the X and Y positions of the agent. e.g. "(3.024, 4.245)".
     */
    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    /**
     * Updates the state of the agent.
     *
     * @param scape A Landscape of agents in which the agent is located.
     */
    public abstract void updateState(Landscape scape);

    /**
     * Renders a visualization of the agent.
     *
     * @param g A Graphics object required for drawing the agent.
     */
    public abstract void draw(Graphics g);
}
