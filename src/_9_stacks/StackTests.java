/*
File Name:  StackTests.java
Author:      Francis O'Hara
Date:        3/04/2024
Description: Contains tests for the Stack class.
How to Run: java -ea StackTests
*/
package _9_stacks;

public class StackTests {
    /**
     * The main entry point into the program.
     * @param args A string representing the command-line arguments passed to the program.
     */
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack);
        System.out.println(stack.pop());
        System.out.println(stack);
    }
}