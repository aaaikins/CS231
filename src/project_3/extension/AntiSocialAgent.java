/*
File Name:   AntiSocialAgent.java
Author:      Francis O'Hara
Date:        3/27/24
Description: Implementation of an anti-social type of Agent in the agent simulation.
How to Run:  N/A
*/
package project_3.extension;

import project_3.lab_3.LinkedList;

import java.awt.*;
import java.util.Random;

public class AntiSocialAgent extends Agent {
    /**
     * Creates a new AntiSocialAgent
     *
     * @param x0     The x position of the antisocial agent.
     * @param y0     The y position of the antisocial agent.
     * @param radius The radius of the antisocial agent.
     */
    public AntiSocialAgent(double x0, double y0, int radius) {
        super(x0, y0);
        this.radius = radius;
        moved = false;
    }

    /**
     * Draws the antisocial agent.
     *
     * @param g A Graphics object required for drawing the agent.
     */
    public void draw(Graphics g) {
        if (!moved) g.setColor(new Color(255, 0, 0));
        else g.setColor(new Color(255, 125, 125));

        g.fillOval((int) getX(), (int) getY(), 5, 5);
    }

    /**
     * Updates the state of the antisocial agent.
     *
     * @param scape A Landscape of agents in which the agent is located.
     */
    public void updateState(Landscape scape){
        LinkedList<Agent> neighbors = scape.getNeighbors(getX(), getY(), radius);
        Random randomGenerator = new Random();

        if (neighbors.size() > 1) {
            double changeX = randomGenerator.nextDouble(-10, 10);
            double changeY = randomGenerator.nextDouble(-10, 10);
            if ((changeX + getX() > scape.getWidth()) || (changeX + getX() < 0))
                changeX *= -1;
            if ((changeY + getY() > scape.getHeight()) || (changeY + getY() < 0))
                changeY *= -1;
            setX(getX() + changeX);
            setY(getY() + changeY);
            moved = true;
        }
        else
            moved = false;
    }

    /**
     * Returns a copy of the current antisocial agent.
     *
     * @return An AntiSocialAgent object with the exact same field values as the current agent.
     */
    public AntiSocialAgent clone(){
        AntiSocialAgent copy = new AntiSocialAgent(getX(), getY(), getRadius());
        copy.moved = this.moved;
        return copy;
    }
}
