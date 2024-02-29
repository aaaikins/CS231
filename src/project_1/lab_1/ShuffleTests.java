/*
File Name:   ShuffleTests.java
Authors:     Francis O'Hara
Date:        02/29/2024
Description: Contains tests for shuffling methods in DumbShuffle.java
How to run:  java -ea ShuffleTests
*/
package project_1.lab_1;

import java.util.ArrayList;

public class ShuffleTests {
    /**
     * Executes tests for the dumbShuffle() and noShuffle() methods in DumbShuffle.java
     */
    public static void shuffleTestsLab() {
        // case 1: testing that the arrays before and after shuffle are not equal
        {
            // set up
            // Make an array of integers from 0 to 10
            ArrayList<Integer> array = new ArrayList<>();

            for (int i = 0; i < 10; i++)
                array.add(i);

            // Shuffle it and save the output as a new array
            ArrayList<Integer> shuffledArray = DumbShuffle.dumbShuffle(array);

            // verify
            // Print the original and the shuffled arrays
            System.out.println("Array: " + array);
            System.out.println("Shuffled Array: " + shuffledArray);

            // test: dumbShuffle()
            // Assert that the original and new arrays aren't equal
            assert !(array.equals(shuffledArray));

            // test: noShuffle()
            /* ArrayList<Integer> notShuffledArray = DumbShuffle.noShuffle(array);
             assert !(array.equals(notShuffledArray));
            */

            //Print that your tests have all passed!
            System.out.println("All Tests Passed!");
        }
    }

    /**
     * Executes tests for the randomness of the smartShuffle() and dumbShuffle() methods in DumbShuffle.java
     * Requires the two convenience functions calculateOptimalProbabilityOfRandomness() and calculateDumbShuffleProbabilityOfRandomness()
     * defined below.
     * The call to calculateOptimalProbabilityOfRandomness() has been commented out below and replaced with the value it generally yields
     * as it is computationally intensive and need not be run all the time.
     */
    public static void shuffleTestsReflection() {
        // set up
        // calculate probability of randomness for smartShuffle
        double optimalProbabilityOfRandomness = 63.12; // calculateOptimalProbabilityOfRandomness();

        // calculate probability of randomness for dumbShuffle
        double dumbShuffleProbabilityOfRandomness = calculateDumbShuffleProbabilityOfRandomness();

        // verify
        System.out.printf("For a shuffle method to be random, it's probability of randomness should be greater than or equal to %.2f %% (minus 5 percentage points).\n", optimalProbabilityOfRandomness);
        System.out.printf("The probability that the current shuffle method is random is %.2f %%", dumbShuffleProbabilityOfRandomness);

        // test
        assert dumbShuffleProbabilityOfRandomness >= (optimalProbabilityOfRandomness - 5.0): "Error in DumbShuffle::dumbShuffle(); This shuffle method implementation is not random";
    }

    /**
     * Returns the average probability of randomness of the smartShuffle() method which is based on the Fisher-Yates shuffle algorithm over 10 trials.
     * This represents the optimal probability of randomness that any shuffle method implementation is expected to have
     * since the Fisher-Yates shuffle algorithm is widely accepted as random.
     * @return A double representing the average probability of randomness of smartShuffle() as a percentage.
     */
    public static double calculateOptimalProbabilityOfRandomness(){
        ArrayList<Double> probabilitiesOfRandomness = new ArrayList<>();  // for storing probability value from each trial
        double totalOfProbabilities = 0.0;  // for storing sum of resulting probabilities
        double averageOptimalProbabilityOfRandomness;  // for storing average of resulting probabilities

        // run the 10 trials
        for (int i = 0; i < 10; i++) {
            // calculate probability of randomness
            double probabilityOfRandomness;  // for storing probability of randomness of current trial
            int inputLength = 7;  // length of input sequence
            int numberOfSimulations = 5040;  // 7!

            // initialize input sequence of length 7
            ArrayList<Integer> inputSequence = new ArrayList<>();
            for (int j = 0; j < inputLength; j++)
                inputSequence.add(j);

            // copy initial input sequence (will be useful when resetting the sequence)
            ArrayList<Integer> initialInputSequence = new ArrayList<>(inputSequence);

            // declare ArrayList for storing outcome of each shuffle as a String
            ArrayList<String> outcomes = new ArrayList<>();

            int numberOfSameOutcomes = 0;  // count for number of shuffles with same outcome

            // shuffle 5040 times and count shuffles with same outcome
            for (int j = 0; j < numberOfSimulations; j++) {
                String currentOutcome = inputSequence.toString();
                for (String outcome: outcomes) {
                    if (currentOutcome.equals(outcome)) {
                        numberOfSameOutcomes++;
                        break;
                    }
                }

                // store current outcome in ArrayList of previous outcomes
                outcomes.add(currentOutcome);

                // reset the input sequence
                inputSequence = new ArrayList<>(initialInputSequence);

                // shuffle the input sequence
                inputSequence = DumbShuffle.smartShuffle(inputSequence);
            }

            // compute probability of randomness as percentage
            probabilityOfRandomness = (((double) numberOfSimulations - numberOfSameOutcomes)/numberOfSimulations) * 100.0;

            // store current probability of randomness
            probabilitiesOfRandomness.add(probabilityOfRandomness);
        }

        // calculate average probability of randomness for the 10 trials
        for(double probability: probabilitiesOfRandomness)
            totalOfProbabilities += probability;

        averageOptimalProbabilityOfRandomness = totalOfProbabilities / 10;

        // return the average
        return averageOptimalProbabilityOfRandomness;
    }

    /**
     * Calculate probability of Randomness for dumbShuffle algorithm.
     * Runs only a single trial of the current implementation of the dumbShuffle algorithm and returns its probability of randomness.
     * @return A double representing the probability of randomness of the dumbShuffle algorithm.
     */
    public static double calculateDumbShuffleProbabilityOfRandomness(){
        double probabilityOfRandomness;  // for storing probability of randomness of current trial
        int inputLength = 7;  // length of input sequence
        int numberOfSimulations = 5040;  // 7!

        // initialize input sequence of length 7
        ArrayList<Integer> inputSequence = new ArrayList<>();
        for (int j = 0; j < inputLength; j++)
            inputSequence.add(j);

        // copy initial input sequence (will be useful when resetting the sequence)
        ArrayList<Integer> initialInputSequence = new ArrayList<>(inputSequence);

        // declare ArrayList for storing outcome of each shuffle as a String
        ArrayList<String> outcomes = new ArrayList<>();

        int numberOfSameOutcomes = 0;  // count for number of shuffles with same outcome

        // shuffle 5040 times and count shuffles with same outcome
        for (int j = 0; j < numberOfSimulations; j++) {
            String currentOutcome = inputSequence.toString();
            for (String outcome: outcomes) {
                if (currentOutcome.equals(outcome)) {
                    numberOfSameOutcomes++;
                    break;
                }
            }

            // store current outcome in ArrayList of previous outcomes
            outcomes.add(currentOutcome);

            // reset the input sequence
            inputSequence = new ArrayList<>(initialInputSequence);

            // shuffle the input sequence
            inputSequence = DumbShuffle.dumbShuffle(inputSequence);
        }

        // compute and return probability of randomness as percentage
        probabilityOfRandomness = (((double) numberOfSimulations - numberOfSameOutcomes)/numberOfSimulations) * 100.0;
        return probabilityOfRandomness;
    }

    /**
     * The main entry point into the program.
     * @param args An array of Strings representing the command-line arguments passed to the program.
     */
    public static void main(String[] args) {
        shuffleTestsLab();
        shuffleTestsReflection();
    }
}