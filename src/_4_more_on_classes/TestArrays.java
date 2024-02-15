package _4_more_on_classes;

public class TestArrays {
    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5};

        System.out.println(arr[0]);
        arr[0] = 10;
        System.out.println(arr[0]);

        // print out all values in array with foreach loop
        for(int item: arr){
            System.out.println(" " + item);
        }

        // print out all values in array with index for loop
        for (int i = 0; i < arr.length - 1; i++){
            System.out.print(" " + arr[i]);
        }

//        int j = 0;
        // testing how to maintain iteration variable
        for (int j = 0; j < 5; j++){
            System.out.print(j);
        }

//        System.out.println(j);

        //
    }
}
