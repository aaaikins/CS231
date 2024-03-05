/*
File Name:   StackInterface.java
Author:      Francis O'Hara
Date:        3/04/2024
Description: Template for implementing the Stack class.
How to Run:  N/A
*/
package _9_stacks;

public interface StackInterface<T>{
    void push(T element);

    T pop();

    T peek();

    int size();

    boolean isEmpty();
}