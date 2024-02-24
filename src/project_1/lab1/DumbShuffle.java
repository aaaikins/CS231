package project_1.lab1;
/*
file name:      DumbShuffle.java
Authors:        Francis O'Hara
last modified:  02/20/2024

How to run:     java -ea DumbShuffle
*/

import java.util.ArrayList;
import java.util.Random;

public class DumbShuffle {

    /**
     * "Shuffles" the arraylist by reversing the order
     */
    public static ArrayList<Integer> dumbShuffle( ArrayList<Integer> integerArray ) {

        ArrayList<Integer> newIntegerArray = new ArrayList<Integer>() ;

        //Add the last to the new list and remove it until the end
        for ( int i = integerArray.size() - 1 ; i >= 0 ; i -- ) {
            newIntegerArray.add( integerArray.get( i ) );
        }

        for (int i = 0; i < 10; i ++){
            // select a valid random index for removing elements
            int removedElement;
            Random random = new Random();
            int randomIndex = random.nextInt(integerArray.size());

            // print out element to be removed at randomIndex
            removedElement = integerArray.get(randomIndex);
            System.out.print(removedElement + " ");

            // remove element at randomIndex
            integerArray.remove(randomIndex);
        }

        return newIntegerArray ;
    }

    /**
     * Doesn't shuffle the arraylist, just returns a copy
     */
    public static ArrayList<Integer> noShuffle( ArrayList<Integer> integerArray ) {

        ArrayList<Integer> newIntegerArray = new ArrayList<Integer>() ;

        //Add the last to the new list and remove it until the end
        for ( int i = 0 ; i < integerArray.size() ; i ++ ) {
            newIntegerArray.add( integerArray.get( i ) );
        }

        return newIntegerArray ;
    }

}