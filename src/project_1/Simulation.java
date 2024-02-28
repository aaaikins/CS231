/*
* Author:      Francis O'Hara
* Date:        2/25/2024
* Description: Simulates 1000 games of Blackjack using the Blackjack class and outputs the results.
* How to Run:  java Simulation
*/
package project_1;

public class Simulation {
    /**
     * The main entry point into the program.
     * @param args Array of Strings representing command-line arguments passed to the program.
     */
    public static void main(String[] args) {
        // number of simulations to run
        int totalGames = 1000;

        // important values to record
        int numberOfDealerWins = 0;
        int numberOfPlayerWins = 0;
        int numberOfTies = 0;

        // instantiate Blackjack object for simulating games
        Blackjack blackjack = new Blackjack();

        // simulate games and record outcomes
        for (int i = 0; i < totalGames; i++) {
            int result = blackjack.game(false);

            if (result == -1)
                numberOfDealerWins ++;
            else if (result == 1)
                numberOfPlayerWins ++;
            else
                numberOfTies ++;
        }

        // calculate percentages from outcomes
        double percentageOfDealerWins = ( ((double) numberOfDealerWins) / totalGames ) * 100;
        double percentageOfPlayerWins = ( ((double) numberOfPlayerWins) / totalGames ) * 100;
        double percentageOfTies = ( ((double) numberOfTies) / totalGames ) * 100;

        // display results
        System.out.println("--SIMULATION RESULTS--");
        System.out.printf("Total Number of Games: %d\nNumber of Games Dealer Won: %d\nPercentage of Games Dealer Won: %.2f\nNumber of Games Player Won: %d\nPercentage of Games Player Won: %.2f\nNumber of Games that Tied: %d\nPercentage of Games that Tied: %.2f", totalGames, numberOfDealerWins, percentageOfDealerWins, numberOfPlayerWins, percentageOfPlayerWins, numberOfTies, percentageOfTies);
    }
}
