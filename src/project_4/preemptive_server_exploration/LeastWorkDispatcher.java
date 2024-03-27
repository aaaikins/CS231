/*
File Name:   LeastWorkDispatcher.java
Author:      Francis O'Hara
Date:        3/25/2024
Description: Implementation of the JobDispatcher class that assigns incoming jobs to the server with the least remaining
             processing time in its queue.
How to Run:  N/A
*/
package project_4.preemptive_server_exploration;

public class LeastWorkDispatcher extends JobDispatcher {
    /**
     * Creates a LeastWorkDispatcher object.
     *
     * @param k The number of servers managed by the dispatcher.
     * @param showViz A boolean indicating whether the server farm's visualization should be shown.
     */
    public LeastWorkDispatcher(int k, boolean showViz) {
        super(k, showViz);
    }

    /**
     * Picks and returns a server for handling the incoming job based on which server has the least remaining processing
     * time in its queue.
     *
     * @param job The job to be handled.
     * @return The server selected to handle the job.
     */
    @Override
    public PreemptiveServer pickServer(Job job) {
        double minRemainingTime = servers.getFirst().getRemainingTime();
        PreemptiveServer selectedServer = servers.getFirst();

        for (PreemptiveServer server : servers) {
            if (server.getRemainingTime() < minRemainingTime) {
                minRemainingTime = server.getRemainingTime();
                selectedServer = server;
            }
        }
        return selectedServer;
    }
}
