package project_2.lab_2;
/* Author: Francis O'Hara
 * Date: 2/27/2024
 * Description: Command-line program for creating a 2D grid of random 1-digit integers and displaying a version of the grid rotated clockwise by 90 degrees.
 * How to Run: java Grid i j (where `i` is the number of rows and `j` is the number of columns of the grid to be created and rotated)
 */
import java.util.Random;
public class Grid {

    /**
     * Checks if two grids of integers `arr1` and `arr2` contain the same elements.
     * @param arr1 The first array to be compared.
     * @param arr2 The second array to be compared.
     * @return `true` if grids are equal and `false` otherwise.
     */
    public static boolean gridEquals(int[][] arr1, int[][] arr2) {
        // check for same number of rows
        if (arr1.length != arr2.length)
            return false;

        // check for same number of columns
        for (int i = 0; i < arr1.length; i ++)
            if (arr1[i].length != arr2[i].length)
                return false;

        // check for same elements
        for (int i = 0; i < arr1.length; i ++){
            for (int j=0; j < arr1[i].length; j++) {
                if (arr1[i][j] != arr2[i][j])
                    return false;
            }
        }

        // return true if grids have same dimensions and same elements
        return true;
    }

    /**
     * Rotates a grid clockwise by 90 degrees.
     * @param arr The grid to be rotated.
     * @return The rotated grid.
     */
    public static int[][] rotate(int[][] arr){
        int[][] rotatedGrid = new int[arr[0].length][arr.length];

        for (int i = 0; i < arr.length; i++){
            for (int j = 0; j < arr[i].length; j++){
                rotatedGrid[j][arr.length - i - 1] = arr[i][j];
            }
        }
        return rotatedGrid;
    }


    /**
     * Prints a 2D grid of integers.
     * @param arr The 2D array whose elements are to be printed.
     */
    public static void gridPrint(int[][] arr){
        for (int i = 0; i < arr.length; i ++){
            for (int j = 0; j < arr[i].length; j ++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }


    /**
     * Entry point for the program.
     */
    public static void main(String[] args){

/*        if (args.length < 1){
            String usageStatement = "Usage: java Grid [args...]\n\t\t(to print the list of arguments on a new line before program starts)";
            System.out.println(usageStatement);
        }
        else {
            for(String arg: args)
                System.out.println(arg);
        }


        // declare 3 x 5 integer grid
        Integer[][] grid;
        grid = new Integer[3][5];

        // attempt to print integer grid
        System.out.println(grid);
        System.out.println(grid[0][0]);

        // allocate row size and column size separately
        grid = new Integer[3][];

        // attempt to print; results in null pointer exception
        // System.out.println(grid[0][0]);

        for (int i = 0; i < 3; i++){
            grid[i] = new Integer[i+3];
        }

        // assign random integer to each entry in 2D grid
        Random random = new Random();

        for(int i = 0; i < grid.length; i++){
            for (int j=0; j < grid[i].length; j++){
                grid[i][j] = random.nextInt(10);
            }
        }

        // print contents of 2D grid
        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[i].length; j++){
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }*/

       // print usage statement if program arguments aren't specified
       if (args.length != 2) {
           String usageStatement = "Usage: java Grid i j\n\t(to display a rectangular grid of 1-digit integers with i rows and j columns and display a version of the grid rotated clockwise by 90 degrees.)";
           System.out.println(usageStatement);
       }
       else {
           // obtain number of rows and columns from program arguments
           int rows = Integer.parseInt(args[0]);
           int columns = Integer.parseInt(args[1]);

           // generate grid with `rows` rows and `columns` columns
           int[][] grid = new int[rows][columns];

           // instantiate random object for generating random integers.
           Random random = new Random();

           // fill grid with random numbers
           for (int i = 0; i < grid.length; i ++){
               for (int j = 0; j < grid[i].length; j ++){
                   grid[i][j] = random.nextInt(10);
               }
           }

           // Display grid to user
           System.out.println("Your Grid:");
           gridPrint(grid);

           // rotate grid
           int[][] rotatedGrid = rotate(grid);

           // Display rotated grid to user
           System.out.println("Your rotated Grid:");
           gridPrint(rotatedGrid);
       }

    }
}
