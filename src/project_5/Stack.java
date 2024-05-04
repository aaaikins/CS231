/*
File Name:   Stack.java
Author:      Francis O'Hara
Date:        5/4/24
Description: An interface for implementing a Stack data structure.
How to Run:  N/A
*/
package project_5;

public interface Stack<T> {

    /**
     * Returns the number of items in the stack.
     * 
     * @return the number of items in the stack.
     */
    int size();

    /**
     * Returns the item on the top of the stack.
     * 
     * @return the item on the top of the stack.
     */
    T peek();

    /**
     * Returns and removes the item on the top of the stack.
     * 
     * @return the item on the top of the stack.
     */
    T pop();

    /**
     * Adds the given {@code item} to the top of the stack.
     * 
     * @param item the item to be added.
     */
    void push(T item);
}
