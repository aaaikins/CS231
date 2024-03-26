/*
File Name:   ServerFarmExploration.java
Author:      Francis O'Hara
Date:        3/25/2024
Description: Simulation of each type of JobDispatcher to find which one handles jobs best.
How to Run:  java ServerFarmExploration
*/
package project_4;

public class ServerFarmExploration {

    /**
     * Tests the average wait time yielded by each dispatcher to find out which provides the best performance.
     */
    public static void explorationQuestion1() {
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

    /**
     * Tests the Shortest Queue dispatcher for which parameter values lead to the best results.
     */
    public static void explorationQuestion2() {
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
        ShortestQueueDispatcher shortestQueueDispatcher30 = new ShortestQueueDispatcher(numServers30, showViz);

        // create shortest queue dispatcher with 40 servers
        ShortestQueueDispatcher shortestQueueDispatcher40 = new ShortestQueueDispatcher(numServers40, showViz);

        // assign jobs to 30-server dispatcher and output results
        for (int i = 0; i < numJobs; i++)
            shortestQueueDispatcher30.handleJob(jobMaker.getNextJob());
        shortestQueueDispatcher30.finishUp(); // Finish all the remaining jobs in Server queues
        System.out.println("Dispatcher: Shortest Queue, " + "Number of Servers: 30" + ", Avg. Wait time: " + shortestQueueDispatcher30.getAverageWaitingTime());

        // assign jobs to 40-server dispatcher and output results
        for (int i = 0; i < numJobs; i++)
            shortestQueueDispatcher40.handleJob(jobMaker.getNextJob());
        shortestQueueDispatcher40.finishUp(); // Finish all the remaining jobs in Server queues
        System.out.println("Dispatcher: Shortest Queue, " + "Number of Servers: 40" + ", Avg. Wait time: " + shortestQueueDispatcher40.getAverageWaitingTime());
    }

    /**
     * The main entry point into the program.
     *
     * @param args An array of Strings denoting the command-line arguments passed to the program.
     */
    public static void main(String[] args) {
        // run exploration question 1
        explorationQuestion1();

        System.out.println();

        // run exploration question 2
        explorationQuestion2();
    }
}
