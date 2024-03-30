/*
File Name:   DoublyLinkedListTester.java
Author:      Colby College CS Department, updated by Francis O'Hara
Date:        3/30/24
Description: Contains tests for the DoublyLinkedList class.
How to Run:  java -ea DoublyLinkedListTester
*/
package project_3;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Random;

public class DoublyLinkedListTester {
    /**
     * The main entry point into the program.
     * Executes various tests on the DoublyLinkedList class.
     *
     * @param args An array of Strings denoting the command-line arguments passed to the program if any.
     * @throws IOException Exception thrown when error occurs while writing log file to disk.
     */
    public static void main(String[] args) throws IOException {
        DoublyLinkedList<Integer> test = new DoublyLinkedList<>();
        LinkedList<Integer> control = new LinkedList<>();
        Random rand = new Random();
        StringBuilder log = new StringBuilder();
        boolean error = false;
        for (int i = 0; i < 100000; i++) {
            if (test.size() != control.size()) {
                System.out.println("Incorrect size; control: " + control.size() + "; test:" + test.size() + '\n');
                log.append("Incorrect size; control: " + control.size() + "; test:" + test.size() + '\n');
                error = true;
            }

            switch (rand.nextInt(4)) {
                case 0:
                    int next = rand.nextInt(1000);
                    test.addFirst(next);
                    control.addFirst(next);
                    log.append("addFirst: " + next + '\n');
                    break;
                case 1:
                    next = rand.nextInt(1000);
                    test.addLast(next);
                    control.addLast(next);
                    log.append("addLast: " + next + '\n');
                    break;
                case 2:
                    if (control.size() == 0)
                        break;

                    int controlRemove = control.removeFirst();
                    int testRemove = test.removeFirst();
                    if (controlRemove != testRemove) {
                        error = true;
                        System.out.println(
                                "Incorrect first removal; control: " + controlRemove + "; test: " + testRemove + '\n');
                        log.append(
                                "Incorrect first removal; control: " + controlRemove + "; test: " + testRemove + '\n');
                    } else
                        log.append("Removed first: " + controlRemove + '\n');
                    break;
                default:
                    if (control.size() == 0)
                        break;

                    controlRemove = control.removeLast();
                    testRemove = test.removeLast();
                    if (controlRemove != testRemove) {
                        error = true;
                        System.out.println(
                                "Incorrect last removal; control: " + controlRemove + "; test: " + testRemove + '\n');
                        log.append(
                                "Incorrect last removal; control: " + controlRemove + "; test: " + testRemove + '\n');
                    } else
                        log.append("Removed last: " + controlRemove + '\n');
            }
        }

        if (error) {
            FileWriter fw = new FileWriter("log.txt");
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(log.toString());
            bw.close();
            System.out.println("Error log saved in log.txt");
        }

        System.out.println("** All tests passed successfully! **");
    }
}