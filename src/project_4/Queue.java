/*
File Name: Queue.java
Author: Colby College CS Department
Date: 3/19/2024
Description: Simple interface for a Queue data structure.
How to Run: N/A
*/
package project_4;

public interface Queue<T> {
    /**
     * Adds the given {@code item} to the end of this queue.
     * 
     * @param item the item to add to the queue.
     */
    void offer(T item);

    /**
     * Returns the number of items in the queue.
     * @return the number of items in the queue.
     */
    int size();

    /**
     * Returns the item at the front of the queue.
     * @return the item at the front of the queue.
     */
    T peek();

    /**
     * Returns and removes the item at the front of the queue.
     * @return the item at the front of the queue.
     */
    T poll();
}
