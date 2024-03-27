/*
File Name:   RandomDispatcher.java
Author:      Francis O'Hara
Date:        3/24/2024
Description: Implementation of JobDispatcher that randomly assigns incoming jobs to servers on the server farm.
How to Run:  N/A
*/
package project_4.preemptive_server_exploration;

import java.util.Random;

public class RandomDispatcher extends JobDispatcher {
    /**
     * Creates a RandomDispatcher object.
     * @param k The number of servers managed by the dispatcher.
     * @param showViz A boolean indicating whether the created servers' visualization should be shown.
     */
    public RandomDispatcher(int k, boolean showViz) {
        super(k, showViz);
    }

    /**
     * Randomly picks a server from the farm and returns it.
     *
     * @param job The job to be handled.
     * @return A randomly picked server for handling the job.
     */
    @Override
    public PreemptiveServer pickServer(Job job) {
        Random random = new Random();
        int randomIndex = random.nextInt(servers.size());
        return servers.get(randomIndex);
    }
}
