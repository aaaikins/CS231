/*
File Name:   PreemptiveServer.java
Author:      Francis O'Hara
Date:        3/26/24
Description: Implementation of Server class that prioritizes whichever job in the queue requires the least processing time.
How to Run:  N/A
*/
package project_4.preemptive_server_exploration;


import project_4.lab_4.LinkedList;

import java.awt.*;
import java.util.Comparator;

public class PreemptiveServer {
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
    public PreemptiveServer() {
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
        queue.offer(job);
        remainingTime += job.getProcessingTimeNeeded();
        size++;
    }

    /**
     * Processes jobs currently in the queue up to the time specified by `time` and updates the server's system time accordingly.
     * As part of my project extension, I added a condition under which processing should stop which is when
     * the number of jobs left in the queue is not greater than 0.
     *
     * @param time The time at which the jobs currently in the queue should be processed till.
     */
    public void processTo(double time) {
        // process the job(s)
        double timeLeft = time - this.time;

        /**
         * Define Comparator for comparing Jobs based on each job's `processingTimeRemaining` value.
         */
        class jobComparator implements Comparator<Job> {
            @Override
            public int compare(Job job1, Job job2) {
                if (job1.getProcessingTimeRemaining() < job2.getProcessingTimeRemaining())
                    return -1;
                else if (job1.getProcessingTimeRemaining() == job2.getProcessingTimeRemaining())
                    return 0;
                else
                    return 1;
            }
        }

        while (timeLeft > 0 && size > 0) {
            // select job with the smallest processing time needed.
            Job selectedJob = queue.findMin(new jobComparator());

            // process selected job
            double timeToProcessFor = Math.min(selectedJob.getProcessingTimeRemaining(), timeLeft);
            selectedJob.process(timeToProcessFor, this.time);
            remainingTime -= timeToProcessFor;

            if (selectedJob.isFinished()) {
                size--;
                numJobs++;
                totalWaitingTime += selectedJob.timeInQueue();
                queue.removeMin(new jobComparator());
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
     *
     * @return A double denoting the current waiting time for the server.
     */
    public double getTotalWaitingTime() {
        return totalWaitingTime;
    }
}
