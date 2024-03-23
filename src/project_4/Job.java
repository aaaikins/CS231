/*
File Name:   Job.java
Author:      Francis O'Hara
Date:        03/22/2024
Description: Class for simulating jobs to be processed by the server.
How to Run:  N/A
*/
package project_4;

public class Job {
	/**
	 * The time the job arrived at the server.
	 */
	public double arrivalTime ;

	/**
	 * The time at which the job finished processing.
	 */
	private double finishTime ;

	/**
	 * The amount of time the job needs to finish processing at the time it arrives at the server.
	 */
	private double processingTimeNeeded ;

	/**
	 * The total amount of time for which the job has been processed so far.
	 */
	private double processingTimeSpent ;

	/**
	 * Creates a new job object.
	 * @param arrivalTime The time the job arrived at the server.
	 * @param processingTimeNeeded The amount of time required to finish processing the job.
	 */
	public Job(double arrivalTime, double processingTimeNeeded) {
		this.arrivalTime = arrivalTime ;
		this.processingTimeNeeded = processingTimeNeeded ;
		this.processingTimeSpent = 0. ;
	}


	/**
	 * Returns the time at which the job arrived at the server.
	 * @return The time at which the job arrived.
	 */
	public double getArrivalTime() {
		return this.arrivalTime ;
	}

	/**
	 * Returns the amount of time the job needed to finish processing at the time it arrived at the server farm.
	 * @return The amount of time the job needed to finish at the time it initially arrived.
	 */
	public double getProcessingTimeNeeded() {
		return this.processingTimeNeeded ;
	}

	/**
	 * Returns the amount of time the job currently needs to finish processing.
	 * @return The amount of processing time the job currently needs to finish.
	 */
	public double getProcessingTimeRemaining() {
		return this.processingTimeNeeded - this.processingTimeSpent ;
	}

	/**
	 * Returns a boolean indicating whether the job has finished processing.
	 * @return `true` if the job has finished processing. Otherwise, returns `false`.
	 */
	public boolean isFinished() {
		return ( this.getProcessingTimeRemaining() <= 0 ) ;
	}

	/**
	 * Returns the amount of time the job spent in the server's queue.
	 * @return The amount of time the job spent in the server's processing queue.
	 */
	public double timeInQueue() {
		return this.finishTime - this.arrivalTime ;
	}

	/**
	 * Processes the job for a specified amount of time.
	 * @param timeToProcessFor The amount of time for which the server should process the job .
	 * @param timeProcessingStarted The time at which processing began. Based on the current time of the server that began processing the job.
	 */
	public void process ( double timeToProcessFor , double timeProcessingStarted ) {
		this.processingTimeSpent = this.processingTimeSpent + timeToProcessFor ;
		if ( this.isFinished() ){
			this.finishTime = timeProcessingStarted + timeToProcessFor ;
		}
	}

	/**
	 * Returns a textual representation of the job.
	 * @return A String serving as a textual representation of the state of the job.
	 */
	public String toString() {
		return "Arrival: " + arrivalTime + ", Finish: " + finishTime + ", Time Needed: " + processingTimeNeeded + ", Time Spent: " + processingTimeSpent ;
	}

}