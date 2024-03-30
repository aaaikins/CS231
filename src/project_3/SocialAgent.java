/*
File Name:   SocialAgent.java
Author:      Francis O'Hara
Date:        3/27/24
Description: Implementation of a social type of Agent in the agent simulation.
How to Run:  N/A
*/
package project_3;

import java.awt.*;

import project_3.lab_3.LinkedList;
import java.util.Random;

public class SocialAgent extends Agent {

    /**
     * Creates a new SocialAgent.
     *
     * @param x0     The x position of the social agent.
     * @param y0     The y position of the social agent.
     * @param radius The radius of the social agent.
     */
    public SocialAgent(double x0, double y0, int radius) {
        super(x0, y0);
        this.radius = radius;
        moved = false;
    }

    /**
     * Draws the social agent.
     *
     * @param g A Graphics object required for drawing the agent.
     */
    @Override
    public void draw(Graphics g) {
        if (!moved) g.setColor(new Color(0, 0, 255));
        else g.setColor(new Color(125, 125, 255));

        g.fillOval((int) getX(), (int) getY(), 5, 5);
    }

    /**
     * Updates the state of the social agent.
     *
     * @param scape A Landscape of agents in which the agent is located.
     */
    public void updateState(Landscape scape) {
        LinkedList<Agent> neighbors = scape.getNeighbors(getX(), getY(), radius);
        Random randomGenerator = new Random();

        if (neighbors.size() < 4) {
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
}
