package _4_more_on_classes;

import java.util.ArrayList;

public class TestArrayLists {
    public static void main(String[] args){
        // declaring an ArrayList in java
        ArrayList<Integer> arr = new ArrayList<>(5);
        arr.add(1);
        arr.add(2);
        arr.add(3);
        System.out.println(arr.size());
        System.out.println(arr);
    }
}
