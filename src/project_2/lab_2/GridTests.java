package project_2.lab_2;

public class GridTests {

    public static void main(String[] args) {
        // case 0: test gridEquals()
        {
            // set up: instantiate arrays for testing gridEquals() method
            int[][] arr1 = new int[3][3];
            int[][] arr2 = new int[3][3];  // same values and size as arr1
            int[][] arr3 = new int[3][3];  // same size but different values from arr1
            int[][] arr4 = new int[2][3];  // different size and values from arr1

            for (int i = 0; i < arr1.length; i++) {
                for (int j = 0; j < arr1[i].length; j++) {
                    arr1[i][j] = i + j;
                    arr2[i][j] = i + j;
                    arr3[i][j] = i * j;
                }
            }

            for (int i = 0; i < arr4.length; i++) {
                for (int j = 0; j < arr4[i].length; j++) {
                    arr4[i][j] = 0;
                }
            }

            // verify
            System.out.println("arr1: ");
            Grid.gridPrint(arr1);
            System.out.println("\narr2: ");
            Grid.gridPrint(arr2);
            System.out.println("\narr3: ");
            Grid.gridPrint(arr3);
            System.out.println("\narr4: ");
            Grid.gridPrint(arr4);

            // test
            assert Grid.gridEquals(arr1, arr2) : "Error in Grid::gridEquals()";  // true
            assert !Grid.gridEquals(arr1, arr3) : "Error in Grid::gridEquals()";  // false
            assert !Grid.gridEquals(arr1, arr4) : "Error in Grid::gridEquals()";  // false
        }

        // case 1: test rotate()
        {
            // setup
            int[][] arr = {{1, 2}, {3, 4}, {5, 6}};
            int[][] rotatedArray = Grid.rotate(arr);

            // verify
            System.out.println("\n\nGrid: ");
            Grid.gridPrint(arr);
            System.out.println("\nRotated Grid:");
            Grid.gridPrint(rotatedArray);

            // test
            assert !(Grid.gridEquals(arr, rotatedArray)) : "Error in Grid::rotate()";
        }
    }
}
