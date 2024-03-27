/*
File Name:   ShortestQueueDispatcher.java
Author:      Francis O'Hara
Date:        3/24/2024
Description: An implementation of the JobDispatcher class that assigns incoming jobs to the server with the smallest-sized
             queue.
How to Run:  N/A
*/
package project_4.preemptive_server_exploration;

public class ShortestQueueDispatcher extends JobDispatcher {
    /**
     * Creates a ShortestQueueDispatcher object.
     */
    public ShortestQueueDispatcher(int k, boolean showViz){
        super(k, showViz);
    }

    /**
     * Picks a server for handling the incoming job based on whichever server has the shortest queue.
     * @param job The job to be handled.
     * @return The server picked to handle the job.
     */
    @Override
    public PreemptiveServer pickServer(Job job){
        int minQueueLength = servers.getFirst().size();
        PreemptiveServer selectedServer = servers.getFirst();

        for (PreemptiveServer server: servers){
            if (server.size() < minQueueLength){
                minQueueLength = server.size();
                selectedServer = server;
            }
        }
        return selectedServer;
    }
}
