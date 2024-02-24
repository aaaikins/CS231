package project_1;

/*
Filename: Shuffle.java
Author: Francis O'Hara
Date: 02/20/2024
How to run: java -ea Shuffle
*/

import java.util.ArrayList;
import java.util.Random;

public class Shuffle {

    public static void main(String[] args){
        // create an array of random numbers between 0 and 99
        ArrayList<Integer> arr0 = new ArrayList<Integer>();
        Random random = new Random();

        for (int i = 0;  i < 10; i ++){
            int randomNumber = random.nextInt(100);
            arr0.add(randomNumber);
            System.out.println(randomNumber);
        }

        // print each element of arr0 on newline
        for (int i = 0; i < 10; i ++){
            System.out.println(arr0.get(i));
        }

        // copy all elements of arr0 into arr1
        ArrayList<Integer> arr1 = new ArrayList<>();
        for (int item: arr0)
            arr1.add(item);

        // create a second reference to arr0 called arr2
        ArrayList<Integer> arr2 = arr0;

        // print contents of each array variable
        System.out.println(arr0);
        System.out.println(arr1);
        System.out.println(arr2);

        // compare arrays with == operator
        System.out.println("arr0 == arr1: " + (arr0 == arr1));
        System.out.println("arr1 == arr2: " + (arr1 == arr2));
        System.out.println("arr0 == arr2: " + (arr0 == arr2));


        // compare with .equals method
        System.out.println("arr0.equals(arr1):" + arr0.equals(arr1));
        System.out.println("arr1.equals(arr2):" + arr1.equals(arr2));
        System.out.println("arr0.equals(arr2):" + arr0.equals(arr2));

    }

}
