/*
File Name:   JobDispatcher.java
Author:      Francis O'Hara
Date:        3/24/2024
Description: Abstract dispatcher class for creating servers and allocating incoming jobs to servers.
How to Run:  N/A
*/
package project_4.preemptive_server_exploration;

import java.awt.*;
import java.util.ArrayList;

public abstract class JobDispatcher {
    /**
     * The collection of servers managed by the dispatcher.
     */
    protected ArrayList<PreemptiveServer> servers;

    /**
     * The system time of the dispatcher.
     */
    double time;

    /**
     * A ServerFarmViz object for visualizing the servers managed by the dispatcher.
     */
    ServerFarmViz serverFarmViz;

    /**
     * The number of jobs handled so far by the dispatcher.
     */
    int numJobsHandled;

    /**
     * Construct a JobDispatcher with `k` servers in total.
     * Initializes the fields for time and number of jobs handled by each server to 0.
     *
     * @param k       The number of servers to be created and managed by the dispatcher.
     * @param showViz A boolean indicating whether the created servers' visualization should be shown.
     */
    public JobDispatcher(int k, boolean showViz) {
        servers = new ArrayList<>();

        for (int i = 0; i < k; i ++)
            servers.add(new PreemptiveServer());

        time = 0.0;
        numJobsHandled = 0;
        serverFarmViz = new ServerFarmViz(this, showViz);
    }

    /**
     * Returns the system time of the dispatcher
     *
     * @return A double denoting the `time` value of the dispatcher.
     */
    public double getTime() {
        return time;
    }

    /**
     * Returns the collection of servers managed by the dispatcher.
     *
     * @return The ArrayList storing all the servers currently being managed by the dispatcher.
     */
    public ArrayList<PreemptiveServer> getServerList() {
        return servers;
    }

    /**
     * Updates the system time to the specified `time` value and calls the processTo method to update time for each
     * server accordingly.
     *
     * @param time The time to which the current system time is to be advanced.
     */
    public void advanceTimeTo(double time) {
        this.time = time;
        for (PreemptiveServer server : servers)
            server.processTo(time);
    }

    /**
     * Advances system time to the arrival time of `job`, assigns `job` to the appropriate server for processing, and
     * updates visualization of the server farm.
     *
     * @param job The job to be handled.
     */
    public void handleJob(Job job) {
        advanceTimeTo(job.getArrivalTime());
        serverFarmViz.repaint();
        pickServer(job).addJob(job);
        serverFarmViz.repaint();
        numJobsHandled++;
    }

    /**
     * Advances the time to the earliest point when all jobs will have completed.
     */
    public void finishUp(){
        double earliestTime = 0.0;

        for (PreemptiveServer server: servers)
            if (server.getRemainingTime() > earliestTime)
                earliestTime = server.getRemainingTime();

        advanceTimeTo(time + earliestTime);
    }

    /**
     * Returns the number of jobs handled so far across all servers.
     *
     * @return The total number of jobs handled so far across servers.
     */
    public int getNumJobsHandled(){
        return numJobsHandled;
    }

    /**
     * Returns the average waiting time across all servers.
     * @return A double denoting the average waiting time across all servers.
     */
    public double getAverageWaitingTime() {
        double totalWaitingTime = 0.0;

        for(PreemptiveServer server: servers) {
            totalWaitingTime += server.getTotalWaitingTime();
        }

        return totalWaitingTime / servers.size();
    }

    /**
     * Selects which server should handle the job `job` based on the algorithm to be followed for handling jobs.
     * @param job The job to be handled.
     * @return The server selected to handle the job.
     */
    public abstract PreemptiveServer pickServer(Job job);

    /**
     * Draws the visualization of the server farm to the screen.
     * @param g A Graphics object to aid in drawing the visualization.
     */
    public void draw(Graphics g) {
        double sep = (ServerFarmViz.HEIGHT - 20) / (getServerList().size() + 2.0);
        g.drawString("Time: " + getTime(), (int) sep, ServerFarmViz.HEIGHT - 20);
        g.drawString("Jobs handled: " + getNumJobsHandled(), (int) sep, ServerFarmViz.HEIGHT - 10);
        for(int i = 0; i < getServerList().size(); i++){
            getServerList().get( i ).draw(g, (i % 2 == 0) ? Color.GRAY : Color.DARK_GRAY, (i + 1) * sep, getServerList().size());
        }
    }


}
