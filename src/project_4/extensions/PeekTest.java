/*
File Name:   PeekTest.java
Author:      Francis O'Hara
Date:        3/24/2024
Description: Contains tests for the `peek` method of the `LinkedList` Queue class.
How to Run:  java -ea PeekTest
*/
package project_4.extensions;

import project_4.lab_4.LinkedList;

public class PeekTest {
    public static void main (String[] args){
        // set up
        LinkedList<Integer> list = new LinkedList<>();

        // verify and test
        list.offer(10);
        System.out.println("Offer 10: " + list);
        System.out.println("Peek: " + list.peek());
        assert list.peek() == 10: "Error in LinkedList::peek()";

        list.offer(99);
        System.out.println("\nOffer 99: " + list);
        System.out.println("Peek: " + list.peek());
        assert list.peek() == 10: "Error in LinkedList::peek()";

        list.offer(30);
        System.out.println("\nOffer 30: " + list);
        System.out.println("Peek: " + list.peek());
        assert list.peek() == 10: "Error in LinkedList::peek()";

        list.poll();
        System.out.println("\nPoll: " + list);
        System.out.println("Peek: " + list.peek());
        assert list.peek() == 99: "Error in LinkedList::peek()";

        list.poll();
        System.out.println("\nPoll: " + list);
        System.out.println("Peek: " + list.peek());
        assert list.peek() == 30: "Error in LinkedList::peek()";

        System.out.println("\n\n*** Done testing LinkedList::peek() ***");
    }
}
