package _2_lesson_2;

public class Data {

    // single-line comment

    /*
    public static void main(String[] args){

        String name = "John";
        byte children = 3;
        short distance = 1000;
        int age = 30;
        long population = 1000000000;

        float weight = 70.5f;

        double salary = 70.5f;

        boolean isGood = true;

        char letter = 'A';

        System.out.println("Max Int: " + Integer.MAX_VALUE);

    }
    */

    public static int adder(int a, int b){
        return a + b;
    }

    public static void main(String[] args){
        int a = 10;
        int b = 20;

        int result = adder(a, b);

        System.out.println(result);
    }
}
