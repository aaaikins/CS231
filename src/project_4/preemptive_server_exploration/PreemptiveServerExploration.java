/*
File Name:   ServerFarmExploration.java
Author:      Francis O'Hara
Date:        3/25/2024
Description: Simulation to explore effects of using a preemptive server on the average wait time for each type of dispatcher.
How to Run:  java PreemptiveServerExploration
*/
package project_4.preemptive_server_exploration;

public class PreemptiveServerExploration {
    /**
     * The main entry point into the program.
     *
     * @param args An array of Strings denoting the command-line arguments passed to the program.
     */
    public static void main(String[] args) {
        /**
         * Tests the average wait time yielded by each dispatcher to find out which provides the best performance under the preemptive server.
         */

        //How often a new job arrives at the server farm, on average
        int meanArrivalTime = 3;
        //How long a job takes to process, on average
        int meanProcessingTime = 100;


        //Main experiment settings
        int numServers = 34; //Numbers of servers in the farm
        int numJobs = 10000000; //Number of jobs to process
        boolean showViz = false; //Set to true to see the visualization, and false to run your experiments

        //Initialize the job maker with the mean arrival and processing time
        JobMaker jobMaker = new JobMaker(meanArrivalTime, meanProcessingTime);

        //Create each type of dispatcher
        RandomDispatcher randomDispatcher = new RandomDispatcher(numServers, showViz);
        RoundRobinDispatcher roundRobinDispatcher = new RoundRobinDispatcher(numServers, showViz);
        ShortestQueueDispatcher shortestQueueDispatcher = new ShortestQueueDispatcher(numServers, showViz);
        LeastWorkDispatcher leastWorkDispatcher = new LeastWorkDispatcher(numServers, showViz);

        // assign jobs to random dispatcher and output results
        for (int i = 0; i < numJobs; i++)
            randomDispatcher.handleJob(jobMaker.getNextJob());
        randomDispatcher.finishUp(); //Finish all the remaining jobs in Server queues
        System.out.println("Dispatcher: Random" + ", Avg. Wait time: " + randomDispatcher.getAverageWaitingTime());

        // assign jobs to round-robin dispatcher and output results
        for (int i = 0; i < numJobs; i++)
            roundRobinDispatcher.handleJob(jobMaker.getNextJob());
        roundRobinDispatcher.finishUp(); //Finish all the remaining jobs in Server queues
        System.out.println("Dispatcher: Round-Robin" + ", Avg. Wait time: " + roundRobinDispatcher.getAverageWaitingTime());

        // assign jobs to shortest queue dispatcher and output results
        for (int i = 0; i < numJobs; i++)
            shortestQueueDispatcher.handleJob(jobMaker.getNextJob());
        shortestQueueDispatcher.finishUp(); //Finish all the remaining jobs in Server queues
        System.out.println("Dispatcher: Shortest Queue" + ", Avg. Wait time: " + shortestQueueDispatcher.getAverageWaitingTime());

        // assign jobs to least work dispatcher
        for (int i = 0; i < numJobs; i++)
            leastWorkDispatcher.handleJob(jobMaker.getNextJob());
        leastWorkDispatcher.finishUp(); //Finish all the remaining jobs in Server queues
        System.out.println("Dispatcher: Least Work" + ", Avg. Wait time: " + leastWorkDispatcher.getAverageWaitingTime());

    }
}
