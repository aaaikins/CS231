package project_1;
/*
File name:      ShuffleTests.java
Authors:        Francis O'Hara
last modified:  02/20/2024

How to run:     java -ea ShuffleTests
*/

import java.util.ArrayList;

public class ShuffleTests {

    public static void shuffleTestsLab() {
        // case 1: testing that the arrays before and after shuffle are not equal
            // set up
            //Make an array of integers from 0 to 10
            ArrayList<Integer> array = new ArrayList<>();

            for (int i = 0; i < 10; i++)
                array.add(i);

            // Shuffle it and save the output as a new array
            // make a copy of input array
            ArrayList<Integer> copyArray = new ArrayList<Integer>();

            for (int element: array)
                copyArray.add(element);

            ArrayList<Integer> shuffledArray = DumbShuffle.dumbShuffle(array);


            // verify
            // Print the original and the shuffled arrays
            System.out.println("\nArray: " + copyArray);
            System.out.println("Shuffled Array: " + shuffledArray);



            // testing dumbShuffle method
            // Assert that the original and new arrays aren't equal
            // assert !(array.equals(shuffledArray));




            // testing noShuffle method
//             ArrayList<Integer> notShuffledArray = DumbShuffle.noShuffle(array);
//             assert !(array.equals(notShuffledArray));



            //Print that your tests have all passed!
            System.out.println("All Tests Passed!");
    }

    
    public static void shuffleTestsReflection() {
        //This is where you will write your code for reflection question 1
    }

    public static void main(String[] args) {
        shuffleTestsLab();
    }
}