/*
File Name:   RoundRobinDispatcher.java
Author:      Francis O'Hara
Date:        3/24/2024
Description: An implementation of the JobDispatcher class that assigns incoming jobs to servers on the farm based on a
             round-robin algorithm.
How to Run:  N/A
*/
package project_4;

public class RoundRobinDispatcher extends JobDispatcher {
    /**
     * The number of jobs dispatched so far.
     */
    int numberOfDispatches;

    /**
     * Creates a `RoundRobinDispatcher` object.
     * @param k The number of servers managed by the dispatcher.
     * @param showViz A boolean indicating whether the created servers' visualization should be shown.
     */
    public RoundRobinDispatcher(int k, boolean showViz) {
        super(k, showViz);
        numberOfDispatches = 0;
    }

    /**
     * Picks and returns a server from the server farm following a round-robin process.
     * @param job The job to be handled.
     * @return The server picked to handle the job.
     */
    @Override
    public Server pickServer(Job job) {
        int selectedServer = numberOfDispatches % servers.size();
        numberOfDispatches ++;
        return servers.get(selectedServer);
    }
}
