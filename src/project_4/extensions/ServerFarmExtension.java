/*
File Name:   ServerFarmExtension.java
Author:      Francis O'Hara
Date:        3/25/2024
Description: Simulation to test performance of LeastWorkDispatcher as number of servers increases.
How to Run:  java ServerFarmExtension
*/
package project_4.extensions;

import project_4.JobMaker;
import project_4.LeastWorkDispatcher;

public class ServerFarmExtension {
    public static void main(String[] args) {
        //How often a new job arrives at the server farm, on average
        int meanArrivalTime = 3;
        //How long a job takes to process, on average
        int meanProcessingTime = 100;


        //Main experiment settings
        int numServers30 = 30; //Numbers of servers in the farm = 30
        int numServers40 = 40; //Numbers of servers in the farm = 40
        int numJobs = 10000000; //Number of jobs to process
        boolean showViz = false; //Set to true to see the visualization, and false to run your experiments

        //Initialize the job maker with the mean arrival and processing time
        JobMaker jobMaker = new JobMaker(meanArrivalTime, meanProcessingTime);

        // create shortest queue dispatcher with 30 servers
        LeastWorkDispatcher leastWorkDispatcher30 = new LeastWorkDispatcher(numServers30, showViz);

        // create shortest queue dispatcher with 40 servers
        LeastWorkDispatcher leastWorkDispatcher40 = new LeastWorkDispatcher(numServers40, showViz);

        // assign jobs to 30-server dispatcher and output results
        for (int i = 0; i < numJobs; i++)
            leastWorkDispatcher30.handleJob(jobMaker.getNextJob());
        leastWorkDispatcher30.finishUp(); // Finish all the remaining jobs in Server queues
        System.out.println("Dispatcher: Least Work, " + "Number of Servers: 30" + ", Avg. Wait time: " + leastWorkDispatcher30.getAverageWaitingTime());

        // assign jobs to 40-server dispatcher and output results
        for (int i = 0; i < numJobs; i++)
            leastWorkDispatcher40.handleJob(jobMaker.getNextJob());
        leastWorkDispatcher40.finishUp(); // Finish all the remaining jobs in Server queues
        System.out.println("Dispatcher: Least Work, " + "Number of Servers: 40" + ", Avg. Wait time: " + leastWorkDispatcher40.getAverageWaitingTime());
    }
}
