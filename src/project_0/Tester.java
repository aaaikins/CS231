package project_0;
/*
 * Project 0: Java Jump Start
 * Description: A class for representing the rectangle shape with helpful methods for computing various things such as the length of the diagonal of the rectangle.
 * Author: Francis O'Hara
 * Date: 2024-02-13
 */

//Write a file header with your name and class purpose
//See Lab0.java for an example of the format we want

//Once you have completed both the Rectangle class and this Tester class, 
//You should be able to run this file, Tester.java and get the following 
//Output to your terminal.  When evaluating your code, we will run our own 
//version of this tester file and confirm that this is the output we get.
/*** 
4.0
5.0
2.2
2.2
Height: 2.2, Width: 2.2, Diagonal: 3.111269904655767
Height: 1.0, Width: 1.0, Diagonal: 1.4142135623730951
Height: 2.0, Width: 2.0, Diagonal: 2.8284271247461903
Height: 3.0, Width: 3.0, Diagonal: 4.242640687119285
Height: 4.0, Width: 4.0, Diagonal: 5.656854249492381
Height: 1.0, Width: 1.0, Diagonal: 1.4142135623730951
Height: 2.0, Width: 2.0, Diagonal: 2.8284271247461903
Height: 3.0, Width: 3.0, Diagonal: 4.242640687119285
Height: 5.0, Width: 5.0, Diagonal: 7.0710678118654755
*/

//Define a Tester class
public class Tester {

    //Define a static testRectangle method
    public static void testRectangle(){
        //Define and initialize 1 rectangle with width 3 and height 7
        Rectangle rectangle = new Rectangle(3, 7);

        //Set the height to be 4
        rectangle.setHeight(4);

        //Get the height and confirm that it is 4
        //by printing it
        System.out.println(rectangle.getHeight());

        //Call the computeDiagonal method and print the output
        //Confirm that it is 5
        System.out.println(rectangle.computeDiagonal());

        //Initialize 1 square using the second constructor
        //with width and height of 2.2
        Rectangle square = new Rectangle(2.2f);

        //Get the height and width of the square
        //Confirm they are both 2.2 by printing them
        System.out.println(square.getHeight());
        System.out.println(square.getWidth());

        //Print the string representation of the square.  Don't call
        //the toString() method directly, instead use the following
        //line (if your object is named square).  Confirm it calls your toString method
        //System.out.println( square );
        //It should print: Height: 2.2, Width: 2.2, Diagonal: 3.111269904655767
        System.out.println(square);
    }
    //define a static main method
    public static void main(String[] args){
        //Call the testRectangle method to run your tests
        testRectangle();

        //Define an array of Rectangle objects of size 4
        Rectangle[] rectangles = new Rectangle[4];

        //Use an indexed for loop to generate 4 squares of
        //size 1x1, 2x2, 3x3 and 4x4 and put them in the array
        for (int i = 0; i < 4; i++){
            int size = i + 1;
            rectangles[i] = new Rectangle(size);
        }


        //Use another indexed for loop to print each square in order
        for (int i = 0; i < 4; i ++){
            System.out.println(rectangles[i]);
        }

        //Change the last rectangle in the list to be of size 5x5 instead of 4x4
        rectangles[rectangles.length - 1].setHeight(5);
        rectangles[rectangles.length - 1].setWidth(5);

        //Use another indexed for loop to print each square in order
        for (int i = 0; i < 4; i ++){
            System.out.println(rectangles[i]);
        }
    }



}