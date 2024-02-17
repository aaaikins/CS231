package project_0;
/*
file name: Rectangle.java
Author: Francis O'Hara
Date: 2/16/2024
How to run: java -ea Rectangle
*/

//Write a file header with your name and class purpose
//See Lab0.java for an example of the format we want

//Define a rectangle class -- make sure to use capitals for the class name
public class Rectangle {
    //define but don't initialize a width field of type float
    //make sure it has the correct access modifier (private)
    private float width;

    //define but don't initialize a height field of type float
    //make sure it has the correct access modifier
    private float height;

    //Make a constructor that takes in values for the width and height
    //Make sure both of your class fields are initialized by the end of
    //the constructor!
    //Write a JavaDoc comment for your constructor

    /**
     * Creates a rectangle with the specified height and width.
     * @param width  a float representing the width of the rectangle
     * @param height a float representing the height of the rectangle
     */
    public Rectangle(float width, float height){
        this.width = width;
        this.height = height;
    }

    //Make a second constructor that takes in just the width
    //and calls the first constructor with the width and the
    //height equal (i.e. it makes a square)
    //Write a JavaDoc comment for your constructor

    /**
     * Creates a rectangle with equal length and width (i.e. a square).
     * @param width a float representing the side width of the square
     */
    public Rectangle(float width){
        this(width, width);
    }

    //Write a getter method for the width
    //Write a JavaDoc comment for your method
    /**
     * Returns the width of the rectangle.
     * @return a float representing the width of the rectangle
     */
    public float getWidth(){
        return this.width;
    }

    //Write a getter method for the height
    //Write a JavaDoc comment for your method

    /**
     * Returns the height of the rectangle.
     * @return a float representing the height of the rectangle
     */
    public float getHeight(){
        return this.height;
    }


    //Write a setter method for the width
    //Write a JavaDoc comment for your method
    /**
     * Sets the width of the rectangle.
     * @param width a float representing the desired width of the rectangle
     */
    public void setWidth(float width){
        this.width = width;
    }

    //Write a setter method for the height
    //Write a JavaDoc comment for your method
    /**
     * Sets the height of the rectangle.
     * @param height a float representing the desired height of the rectangle
     */
    public void setHeight(float height){
        this.height = height;
    }

    //Write a method that called computeDiagonal that
    //computes the length of the diagonal and returns it as a double
    //Your method should use the Math.sqrt and the Math.pow methods
    //Write a JavaDoc comment for your method
    //Write a single line comment for at least one
    //line in your method

    /**
     * Computes the length of the diagonal of the rectangle.
     * @return a double representing the length of the diagonal of the rectangle.
     */
    public double computeDiagonal(){
        double diagonal = Math.sqrt(Math.pow(this.height, 2) + Math.pow(this.width, 2)); // compute the diagonal length using the Pythagorean theorem (c^2 = a^2 + b^2).
        return diagonal;
    }

    //Write a toString method that has the following format:
    //"Height: [[height]], Width: [[width]], Diagonal: [[length of diagonal]]"

    public String toString(){
        return "Height: " + this.height + ", Width: " + this.width + ", Diagonal: " + this.computeDiagonal();
    }

}



