/*
File Name:   Server.java
Author:      Francis O'Hara
Date:        3/21/2024
Description: Implementation of a model server in a server farm.
How to Run:  N/A
*/
package project_4;

import project_4.lab_4.LinkedList;

import java.awt.Graphics;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.Font;

public class Server {
    /**
     * Queue of jobs to be processed by the server.
     */
    private LinkedList<Job> queue;

    /**
     * The current system time on the server.
     */
    private double time;

    /**
     * The total time jobs spent between arriving at the server and being completed.
     */
    private double totalWaitingTime;

    /**
     * The remaining amount of processing time required to complete all jobs currently in the queue.
     */
    private double remainingTime;

    /**
     * The number of jobs processed so far by the server.
     */
    private int numJobs;

    /**
     * The number of jobs currently in the server's queue.
     */
    private int size;

    /**
     * Creates a new Server object.
     */
    public Server() {
        queue = new LinkedList<>();
        time = 0.0;
        totalWaitingTime = 0.0;
        remainingTime = 0.0;
        numJobs = 0;
        size = 0;
    }

    /**
     * Adds the specified job `job` into the queue.
     *
     * @param job The job to be added to the queue.
     */
    public void addJob(Job job) {
        // todo: Don't we need to update the arrivalTime field of the job with the server's `time` field?
        queue.offer(job);
        remainingTime += job.getProcessingTimeNeeded();
        size++;
    }

    /**
     * Processes jobs currently in the queue up to the time specified by `time` and updates the server's system time accordingly.
     * As part of my project extension, I added a condition under which processing should stop which is when
     * the number of jobs left in the queue is not greater than 0.
     *
     *
     * @param time The time at which the jobs currently in the queue should be processed till.
     */
    public void processTo(double time) {
        // process the job(s)
        double timeLeft = time - this.time;

        while (timeLeft > 0 && size > 0) { // extension: check that the queue is not empty.
            Job currentJob = queue.peek();
            double timeToProcessFor = Math.min(timeLeft, currentJob.getProcessingTimeRemaining());
            currentJob.process(timeToProcessFor, this.time);
            timeLeft -= timeToProcessFor;
            remainingTime -= timeToProcessFor;

            if (currentJob.isFinished()) {
                numJobs++;
                totalWaitingTime += currentJob.timeInQueue();
                queue.poll();
                size--;
            }
        }

        // update server time
        this.time = time;
    }

    /**
     * Returns the total remaining processing time in the server's queue.
     *
     * @return The total remaining processing time in the server's queue.
     */
    public double remainingWorkInQueue() {
        return remainingTime;
    }

    /**
     * Returns the number of jobs in the server's queue.
     *
     * @return The number of jobs currently in the server's queue.
     */
    public int size() {
        return size;
    }

    /**
     * Renders a visual representation of the server farm.
     *
     * @param g               A Graphics object for drawing.
     * @param c               A color.
     * @param loc             Specifies location on the canvas for drawing.
     * @param numberOfServers The number of servers in the farm.
     */
    public void draw(Graphics g, Color c, double loc, int numberOfServers) {
        double sep = (ServerFarmViz.HEIGHT - 20) / (numberOfServers + 2.0);
        g.setColor(Color.BLACK);
        g.setFont(new Font(g.getFont().getName(), g.getFont().getStyle(), (int) (72.0 * (sep * .5) / Toolkit.getDefaultToolkit().getScreenResolution())));
        g.drawString("Work: " + (remainingWorkInQueue() < 1000 ? remainingWorkInQueue() : ">1000"), 2, (int) (loc + .2 * sep));
        g.drawString("Jobs: " + (size() < 1000 ? size() : ">1000"), 5, (int) (loc + .55 * sep));
        g.setColor(c);
        g.fillRect((int) (3 * sep), (int) loc, (int) (.8 * remainingWorkInQueue()), (int) sep);
        g.drawOval(2 * (int) sep, (int) loc, (int) sep, (int) sep);
        if (remainingWorkInQueue() == 0) g.setColor(Color.GREEN.darker());
        else g.setColor(Color.RED.darker());
        g.fillOval(2 * (int) sep, (int) loc, (int) sep, (int) sep);
    }

    /**
     * Returns the amount of processing time required to complete all jobs currently in the server's queue.
     *
     * @return The amount of processing time required to complete all jobs in the server's queue.
     */
    public double getRemainingTime() {
        return remainingTime;
    }

    /**
     * Returns the total time jobs spent between arriving at the server and being completed (waiting time).
     * @return A double denoting the current waiting time for the server.
     */
    public double getTotalWaitingTime() {
        return totalWaitingTime;
    }
}