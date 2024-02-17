package _5_arrays_and_arraylists;

public class TestArrays2 {
    public static void main(String[] args){
        // IN CODE
        int num = 10;
        int[] arr = new int[4];

        // IN MEMORY
/*
         [][][][] | [][][][] [][][][] [][][][] [][][][] | // where each square is a byte in memory
            num   |                arr                  |
*/

        // ASSIGN VALUES UNTIL FULL
        int size = 0; // represents number of elements currently stored in arr as well as the next insertion index.
        arr[size++] = 4;
        arr[size++] = 2;
        arr[size++] = 3;
        arr[size++] = 9;


        // WHAT DO WE DO WHEN ARRAY IS FULL?
        // CREATE NEW ARRAY WITH THE CAPACITY OF ORIGINAL ARRAY + 1 AND COPY ALL ELEMENTS TO NEW ARRAY BEFORE ADDING NEW ELEMENT
        int[] arr2 = new int[5]; // declare new array

        // copy array elements to new array
        for (int i = 0; i < arr.length; i ++)
            arr2[i] = arr[i];

        // add new element to array
        arr = arr2;
        arr[size] = 5;

        // HOWEVER, COPYING ELEMENTS FROM ONE ARRAY TO THE NEXT IS AN EXPENSIVE OPERATION { O(n) time }.
        // HENCE, NEW ARRAY LENGTH SHOULD BE 50% GREATER THAN CURRENT ARRAY LENGTH SO WE DON'T HAVE TO COPY ARRAYS EVERY
        // TIME WE WANT TO ADD AN ELEMENT TO FULL ARRAY IN THE FUTURE.

        // ^^ THIS IS HOW ARRAYLISTS IN JAVA ARE IMPLEMENTED!
    }
}
