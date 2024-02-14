package project_0;
/*
 * This is a multi-line comment that begins with a forward slash and an asterisk and ends with an asterisk and a forward slash.
 *
 * The content of this comment is equivalent to the Module Strings that you wrote in Python.
 * Every program you write should have a multiline comment at the top of the file. It should contain a description of the program, the author, and the date it was written.
 *
 *
 * Directions for Task 1 of Lab0:
 * Below is a template for the first lab portion of the course. It contains a series of tasks to be completed by the student.
 * The tasks cover topics found in the first section (mostly) of the W3Schools tutorial (https://www.w3schools.com/java/default.asp)
 * This lab focuses on Java syntax and basic programming concepts.
 *
 * Your job is to complete all the tasks in each topic area by providing the missing code.
 * Once you have finished the tasks related to a topic area, run the program to see if your output matches the expected output.
 * If it does, then move on to the next topic. If it does not, then review your code to find and fix the error(s).
 * If you are unable to find the error, then ask for help from the instructor or a TA.
 *
 * Note: Be sure not to modify any of the program's existing code.
 *
 * Date: 2024-02-13
 * Author: Francis O'Hara
 *
 */

// Single-line comment for the Lab0 class. This is a single-line comment that begins with two forward slashes. It is used to provide short explanations of code.

// Import statements are grouped together at the top of the file above where the code begins and after the program comment.

import java.util.Scanner; // This is an import statement. It is used to import the Scanner class from the java.util package. The Scanner class is used to get user input, and it is part of the Java API.
import java.util.Arrays; // This is another import statement. It is used to import the Arrays class from the java.util package. The Arrays class contains several methods for manipulating arrays, and it is part of the Java API.

public class Lab0 { // Notice that the filename matches the public class name. This is a requirement
    // in Java.

    // Just like in Python, the main method is the entry point of the program. It is
    // where the JVM begins to execute your program.
    public static void main(String[] args) {

        // The following variables hold the outputs of the different sections of the
        // program.
        StringBuilder studentOutput1 = new StringBuilder(); // Topics: syntax, output, and commenting
        StringBuilder studentOutput2 = new StringBuilder(); // Topics: variables, data types, and operators
        StringBuilder studentOutput3 = new StringBuilder(); // Topics: strings and math
        StringBuilder studentOutput4 = new StringBuilder(); // Topics: if statements
        StringBuilder studentOutput5 = new StringBuilder(); // Topics: loops

        /*
         * Topic 1: Syntax, Output, and Commenting
         * The following ten (10) tasks cover topics related to Java syntax, output, and
         * commenting.
         * The program will store the output of the Java code you write in
         * studentOutput1 and test it for correctness at the end of the program.
         */

        /*
         * TASK 1
         * Assign the symbols that indicate the start of a multi line comment in Java to
         * a variable named 'startMultiLine'.
         */

        // Add your code here
        String startMultiLine = "/*";
        studentOutput1.append("T1:startMultiLine" + startMultiLine);

        /*
         * TASK 2
         * What is the access specifier associated with the main method in Java? Assign
         * the access specifier to a
         * variable named 'accessMain'.
         */

        // Add your code here
        String accessMain = "public";
        studentOutput1.append("T2:endMultiLine" + accessMain);

        /*
         * TASK 3
         * Assign the symbols that indicate a single line comment in Java to a variable
         * named 'startSingleLine'.
         */

        // Add your code here
        String startSingleLine = "//";
        studentOutput1.append("T3:startSingleLine" + startSingleLine);

        /*
         * TASK 4
         * Assign the name of the method that prints its arguments to the console and
         * advances the cursor to the next line to a variable named 'printsNewLine'.
         */

        // Add your code here
        String printsNewline = "println";
        studentOutput1.append("T4:printsNewline" + printsNewline);

        /*
         * TASK 5
         * Create a String variable named 'compiler' and assign to the name of the Java
         * program that
         * compiles a .java file.
         */

        // Add your code here
        String compiler = "javac";
        studentOutput1.append("T5:compiler" + compiler);

        /*
         * TASK 6: Assign the symbol that is used to indicate the end of every complete
         * Java statement to a variable named 'endStatement'.
         */
        // Add your code here
        String endStatement = ";";
        studentOutput1.append("T6:endStatement" + endStatement);

        /*
         * TASK 7: Create a variable named 'scope' and assign to it the pair of symbols
         * (correct order, no spaces) that are used to indicate a new scope in Java.
         */

        // Add your code here
        String scope = "{}";
        studentOutput1.append("T7:startScope" + scope);

        /*
         * TASK 8
         * Create a String variable named 'jvm' and assign to it the name of the Java
         * program that executes a .class file.
         */

        // Add your code here
        String jvm = "java";
        studentOutput1.append("T8:endScope" + jvm);

        /*
         * TASK 9
         * Create a variable named 'params' and assign to it the pair of symbols
         * (correct order, no spaces) that are used to indicate a parameter list after a
         * method name.
         */

        // Add your code here
        String params = "()";
        studentOutput1.append("T9:params" + params);

        /*
         * TASK 10
         * Create a variable named 'printsAndStops' and assign the name of the method
         * that prints its arguments to the console and
         * leaves the cursor on the same line.
         */

        // Add your code here
        String printsAndStops = "print";
        studentOutput1.append("T10:printsAndStops" + printsAndStops);

        String expectedOutput1 = "T1:startMultiLine/*T2:endMultiLinepublicT3:startSingleLine//T4:printsNewlineprintlnT5:compilerjavacT6:endStatement;T7:startScope{}T8:endScopejavaT9:params()T10:printsAndStopsprint";

        System.out.println("Expected and Generated Outputs for Topic 1: Syntax, Output, and Commenting");
        System.out.println("Expected: " + expectedOutput1.toString());
        System.out.println("Output..: " + studentOutput1.toString());

        System.out.println();

        if (studentOutput1.toString().equals(expectedOutput1)) {
            System.out.println("Congratulations: your Topic 1 code is correct!");
        } else {
            System.out.println("Output from your code doesn't match the expected output. Please review your code.");
            System.exit(0);
        }

        System.out.println();

        /*
         * Topic 2: Variables, Data Types, Wrapper Classes and Operators
         * The following tasks cover topics related to Java variables, identifiers, data
         * types and operators.
         * The program will store the output of the Java code you write in
         * studentOutput2 and test it for correctness at the end of the program.
         */

        /*
         * TASK 11
         * How many builtin data types does Java have? Assign this number to an int
         * variable named 'builtins'.
         */

        // Add your code here
        int builtins = 8;
        studentOutput2.append("T11:builtins" + builtins);

        /*
         * TASK 12
         * Declare a builtin type variable named 'isTrue' that can hold the values true
         * or false and assign it a value of true.
         */
        // Add your code here
        boolean isTrue = true;
        studentOutput2.append("T12:isTrue" + isTrue);

        /*
         * TASK 13
         * Declare a char variable named 'letter' and assign it a value of 'A'.
         * Note: Unlike Python, Java has a separate data type for characters. This is
         * not a string!
         */

        // Add your code here
        char letter = 'A';
        studentOutput2.append("T13:letter" + letter);

        /*
         * TASK 14
         * Declare an int variable named 'number' and assign it a value of 1.
         *
         */

        // Add your code here
        int number = 1;
        studentOutput2.append("T14:number" + number);

        /*
         * TASK 15
         * Did you notice the different way we wrote isTrue vs the other variable names?
         * Python would have used Snake Case and written it as is_true.
         * In Java what do we call the style of variable names that look like this
         * xxxYyyZzz?
         * Assign the name of the style to a String variable named 'style'.
         */

        // Add your code here
        String style = "Camel Case";
        studentOutput2.append("T15:style" + style);

        /*
         * TASK 16
         * Create a String variable named 'charWrapper' and assign it the correct name
         * (correct capitalization!) of the wrapper class for the builtin char type.
         *
         */

        // Add your code here
        String charWrapper = "Character";
        studentOutput2.append("T16:charWrapper" + charWrapper);

        /*
         * TASK 17
         * Create a String variable named 'equality' and assign it the relational
         * operator that will check if the contents of two builtin variables
         * contain the same values.
         *
         */
        // Add your code here
        String equality = "==";
        studentOutput2.append("T17:equality" + equality);

        /*
         * TASK 18
         * Remember the % operator? In this task you will use to obtain the remainder of
         * a division.
         * Declare an int variable 'mod' and assign it the remainder of dividing 8 by 2.
         */
        // Add your code here
        int mod = 8 % 2;
        studentOutput2.append("T18:mod" + mod);

        /*
         * TASK 19
         * Yes/No The result of the following operation is 0?
         * 1 / 2
         * Assign your answer to a String variable named 'division1'.
         */

        // Add your code here
        String division1 = "Yes";
        studentOutput2.append("T19:division1" + division1);

        /*
         * TASK 20
         * Yes/No The result of the following operation is 0?
         * 1.0 / 2
         *
         * Do you see the difference between this task and the previous one?
         * Unlike Python, Java will perform floating point division if at least one of
         * the operands is a floating point number.
         *
         * Assign your answer to a String variable named 'division2'.
         */

        // Add your code here
        String division2 = "No";
        studentOutput2.append("T20:division2" + division2);

        String expectedOutput2 = "T11:builtins8T12:isTruetrueT13:letterAT14:number1T15:styleCamel CaseT16:charWrapperCharacterT17:equality==T18:mod0T19:division1YesT20:division2No";

        System.out.println(
                "Expected and Generated Outputs for Topic 2: Variables, Data Types, Wrapper Classes and Operators");
        System.out.println("Expected: " + expectedOutput2.toString());
        System.out.println("Output..: " + studentOutput2.toString());

        System.out.println();

        if (studentOutput2.toString().equals(expectedOutput2)) {
            System.out.println("Congratulations: your Topic 2 code is correct!");
        } else {
            System.out.println("Output from your code doesn't match the expected output. Please review your code.");
            System.exit(0);
        }

        System.out.println();

        /*
         * Topic 3: Strings and Math
         * The following tasks cover topics related to the Java String class and the
         * Math library.
         * The program will store the output of the Java code you write in
         * studentOutput3 and test it for correctness at the end of the program.
         */

        /*
         * TASK 21
         * Concatenate the string 'Hello' and the number 5 (with a space in between) and
         * assign the result to a variable named 'concat'.
         * Notice that unlike Python, Java will automatically convert the number to a
         * string when concatenating it with a string. No need to use the str function.
         */

        // Add your code here
        String concat = "Hello" + " " + 5;
        studentOutput3.append("T21:concat" + concat);

        /*
         * TASK 22
         * Find a way to determine the number of characters in a string.
         * Write the code that will calculate the number characters in 'concat' and
         * store the result in an int variable named 'length'.
         * Refer to https://www.w3schools.com/java/java_ref_string.asp for help.
         *
         */

        // Add your code here
        int length = concat.length();
        studentOutput3.append("T22:length" + length);

        /*
         * TASK 23
         * Find a way to convert a string to all uppercase letters.
         * Write the code that will convert 'concat' to all uppercase letters and store
         * the result in a String variable named 'upper'.
         *
         */
        // Add your code here
        String upper = concat.toUpperCase();
        studentOutput3.append("T23:upper" + upper);

        /*
         * TASK 24
         * What is the exact spelling of the String class method that will check if two
         * strings contain the same characters?
         * Hint: It's not ==
         * Assign the name of the method (without the parentheses) to a String variable
         * named 'sameChars'.
         */

        // Add your code here
        String sameChars = "equals";
        studentOutput3.append("T24:sameChars" + sameChars);

        /*
         * TASK 25
         * Declare a double variable named 'PI' and assign it the value Math.PI
         * The name of PI is not typo! The convention in Java is to use all uppercase
         * letters for constants. Did you need to import the Math module for this to
         * work?
         *
         */
        // Add your code here
        double PI = Math.PI;
        studentOutput3.append("T22:PI" + PI);

        /*
         * TASK 26
         * Java doesn't have an exponentiation operator like Python. But we can use the
         * Math class to do the same thing. Use the pow method to calculate 2 raised to
         * the power of 3 and assign the result to a variable named 'answer'.
         * Remember the 'dot' notation for calling methods on objects.
         *
         */
        double answer = Math.pow(2, 3);
        studentOutput3.append("T17:answer" + answer);

        String expectedOutput3 = "T21:concatHello 5T22:length7T23:upperHELLO 5T24:sameCharsequalsT22:PI3.141592653589793T17:answer8.0";

        System.out.println("Expected and Generated Outputs for Topic 3: Strings and Math");
        System.out.println("Expected: " + expectedOutput3.toString());
        System.out.println("Output..: " + studentOutput3.toString());

        System.out.println();

        if (studentOutput3.toString().equals(expectedOutput3)) {
            System.out.println("Congratulations: your Topic 3 code is correct!");
        } else {
            System.out.println("Output from your code doesn't match the expected output. Please review your code.");
            System.exit(0);
        }

        System.out.println();

        /*
         * Topic 4: If Statements
         * The following tasks cover topics related to how Java allows for the program
         * to be executed in non-sequential order.
         * The program will store the output of the Java code you write in
         * studentOutput4 and test it for correctness at the end of the program.
         */

        /*
         * TASK 27
         * Yes/No: The condition in a Java if statement must go inside of parentheses?
         * Assign your answer to a String variable named 'ifCondition'.
         */

        // Add your code here
        String ifCondition = "Yes";
        studentOutput4.append("T27:ifCondition" + ifCondition);

        /*
         * TASK 28
         * What keyword does Java use to indicate the statement to be executed if the
         * condition is false?
         * Assign your answer to a String variable named 'other'
         *
         */
        // Add your code here
        String other = "else";
        studentOutput4.append("T28:other" + other);

        /*
         * TASK 29
         * What will be printed to the console using the following code:
         * Create a String variable named 'response' and assign it the value that will
         * be printed to the console.
         *
         * int time = 20;
         * if (time < 18) {
         * System.out.println("Hello");
         * } else {
         * System.out.println("Goodbye");
         * }
         *
         */
        // Add your code here
        String response = "Goodbye";
        studentOutput4.append("T29:response" + response);

        /*
         * TASK 30
         * What will be printed to the console using the following code:
         * Create a String variable named 'response2' and assign it the value that will
         * be printed to the console.
         *
         * int time = 18;
         * if (time < 20) {
         * System.out.println("Hello");
         * } else if (time < 20) {
         * System.out.println("Goodbye");
         * } else {
         * System.out.println("See you later");
         * }
         *
         */

        // Add your code here
        String response2 = "Hello";
        studentOutput4.append("T30:response2" + response2);

        String expectedOutput4 = "T27:ifConditionYesT28:otherelseT29:responseGoodbyeT30:response2Hello";

        System.out.println("Expected and Generated Outputs for Topic 4: If Statements");
        System.out.println("Expected: " + expectedOutput4.toString());
        System.out.println("Output..: " + studentOutput4.toString());

        System.out.println();

        if (studentOutput4.toString().equals(expectedOutput4)) {
            System.out.println("Congratulations: your Topic 4 code is correct!");
        } else {
            System.out.println("Output from your code doesn't match the expected output. Please review your code.");
            System.exit(0);
        }

        System.out.println();

        /*
         * Topic 5: Loops
         * The following tasks cover topics related to the loop structures in Java.
         * The program will store the output of the Java code you write in
         * studentOutput4 and test it for correctness at the end of the program.
         */

        /*
         * TASK 31
         * What will be printed to the console using the following code:
         * Create a String variable named 'response3' and assign it the value that will
         * be printed to the console.
         *
         * int i = 0;
         * while (i < 5) {
         *
         * i++;
         * }
         * System.out.println(i);
         */

        // Add your code here
        String response3 = "5";
        studentOutput5.append("T31:response3" + response3);

        /*
         * TASK 32
         * What will be printed to the console using the following code:
         * Create a String variable named 'response4' and assign it the value that will
         * be printed to the console.
         *
         * int j = 0;
         * while (j < 5) {
         *
         * if (j == 3) {
         * break;
         * }
         *
         * j++;
         * }
         * System.out.println(j);
         */

        // Add your code here
        String response4 = "3";
        studentOutput5.append("T32:response4" + response4);

        /*
         * TASK 33
         * What will be printed to the console using the following code:
         * Create a String variable named 'response5' and assign it the value that will
         * be printed to the console.
         *
         * int k = 0;
         * do {
         *
         * k++;
         * } while (k < 5);
         * System.out.println(k);
         */

        // Add your code here
        String response5 = "5";
        studentOutput5.append("T33:response5" + response5);

        /*
         * TASK 34
         * What will be printed to the console using the following code:
         * Create a String variable named 'response6' and assign it the value that will
         * be printed to the console.
         *
         * for (int l = 0; l < 5; l++) {
         *
         * }
         * System.out.println(l);
         */
        // Add your code here
        String response6 = "5";
        studentOutput5.append("T34:response6" + response6);

        /*
         * TASK 35
         * What will be printed to the console using the following code:
         * Create a String variable named 'response7' and assign it the value that will
         * be printed to the console.
         *
         * for (int m = 0; m < 5; m++) {
         *
         * if (m == 3) {
         * break;
         * }
         * }
         * System.out.println(m);
         */

        // Add your code here
        String response7 = "3";
        studentOutput5.append("T35:response7" + response7);

        String expectedOutput5 = "T31:response35T32:response43T33:response55T34:response65T35:response73";

        System.out.println("Expected and Generated Outputs for Topic 5: Loops");

        System.out.println("Expected: " + expectedOutput5.toString());
        System.out.println("Output..: " + studentOutput5.toString());

        System.out.println();

        if (studentOutput5.toString().equals(expectedOutput5)) {
            System.out.println("Congratulations: your Topic 5 code is correct!");
        } else {
            System.out.println("Output from your code doesn't match the expected output. Please review your code.");
            System.exit(0);
        }

    }
}