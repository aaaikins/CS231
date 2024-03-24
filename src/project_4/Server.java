/*
File Name:   Server.java
Author:      Francis O'Hara
Date:        3/21/2024
Description: Implementation of a model server in a server farm.
How to Run:  N/A
*/
package project_4;

import project_4.lab_4.LinkedList;

public class Server {
    /**
     * Queue of jobs to be processed by the server.
     */
    LinkedList<Job> queue;

    /**
     * The current system time on the server.
     */
    double time;

    /**
     * The total time jobs spent between arriving at the server and being completed.
     */
    double totalWaitingTime;

    /**
     * The remaining amount of processing time required to complete all jobs currently in the queue.
     */
    double remainingTime;

    /**
     * The number of jobs processed so far by the server.
     */
    int numJobs;

    /**
     * Creates a new Server object.
     */
    public Server(){
        queue = new LinkedList<Job>();
        time = 0.0;
        totalWaitingTime = 0.0;
        remainingTime = 0.0;
        numJobs = 0;
    }

    /**
     * Adds the specified job `job` into the queue.
     * @param job The job to be added to the queue.
     */
    public void addJob(Job job){
        // todo: Don't we need to update the arrivalTime field of the job with the server's `time` field?
        queue.offer(job);
        remainingTime += job.getProcessingTimeNeeded();
    }

    /**
     * Processes jobs currently in the queue up to the time specified by `time` and updates the server's system time accordingly.
     * @param time The time at which the jobs currently in the queue should be processed till.
     */
    public void processTo(double time) {
        // todo: throw exception if `time` is less than current system time.

        double timeLeft = time - this.time;



        this.time = time;
    }
}