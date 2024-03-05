/*
File Name:   Stack.java
Author:      Francis O'Hara
Date:        3/04/2024
Description: An implementation of a stack in Java based on an Interface.
How to Run:  N/A
*/
package _9_stacks;

import java.util.ArrayList;

public class Stack<T> implements StackInterface<T>{
    /** The underlying ArrayList backing the Stack.
     * The position of the last element in this ArrayList is the top of the Stack. */
    private ArrayList<T> stack;

    /**
     * Creates a new Stack object.
     */
    public Stack(){
        stack = new ArrayList<>();
    }

    /**
     * Adds an element to the top of the stack
     * @param element The element to be pushed to the stack.
     */
    public void push(T element) {
        stack.addLast(element);
    }

    /**
     * Removes and returns the element at top of the stack.
     * @return The element at the top of the stack.
     */
    public T pop() {
        return stack.removeLast();
    }

    /**
     * Returns the element at the top of the stack.
     * @return the element at top of the stack.
     */
    public T peek() {
        return stack.getLast();
    }

    /**
     * Returns the number of elements currently in the stack.
     * @return An integer denoting the number of elements currently pushed into the stack.
     */
    public int size() {
        return stack.size();
    }

    /**
     * Returns a boolean denoting whether the stack is empty.
     * @return `true` if the stack is empty and `false` otherwise.
     */
    public boolean isEmpty(){
        return stack.isEmpty();
    }

    /**
     * Returns a textual representation of the Stack and its contents.
     * @return A string representing the stack and its contents.
     */
    public String toString(){
        return stack.toString();
    }
}