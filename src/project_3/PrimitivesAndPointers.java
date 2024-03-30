/*
File Name:   PrimitivesAndPointers.java
Author:      Colby College CS Department, updated by Francis O'Hara
Date:        3/30/24
Description: Contains code for testing difference between reference variables and variables that store primitive values.
How to Run:  java PrimitivesAndPointers
*/
package project_3;

import java.util.ArrayList;

public class PrimitivesAndPointers {
    /**
     * Attempts to increment its `x` parameter by 1.
     *
     * @param x
     */
    public static void addOne(int x) {
        x = x + 1;
    }

    public static void addOne(ArrayList<Integer> list){
        list.add(1);
    }

    public static void main(String[] args){
        int x = 5; 
        System.out.println("Before, x = " + x);
        addOne(x);
        System.out.println("After, x = " + x);


        ArrayList<Integer> list = new ArrayList<>();
        System.out.println("Before, list = " + list);
        addOne(list);
        System.out.println("After, list = " + list);
    }
    
}
