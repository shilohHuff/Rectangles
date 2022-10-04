package org.test.rectangle;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    /**
     * Basic main to exercise the functionality of the project. Will prompt the User for details of the rectangles to compare.
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {

        Scanner input = new Scanner( System.in );
        System.out.println("Hello world!");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("Please input the details for Rectangle 1");
        Rectangle rectangle1 = getRectangleFromInput(input);

        System.out.println("");

        System.out.println("Please input the details for Rectangle 2");
        Rectangle rectangle2 = getRectangleFromInput(input);

        System.out.println("");
        System.out.println("");
        System.out.println("");

        System.out.println("Are the Rectangles Overlapping? " + (RectangleAnalyzer.areRectanglesIntersecting(rectangle1,rectangle2)? "Yes" : "No"));

        System.out.print( "Is one Rectangle contained with the other? ");
        switch (RectangleAnalyzer.isRectangleContained(rectangle1,rectangle2)){
            case RECTANGLE1_IN_RECTANGLE2 -> System.out.println(" Rectangle 1 is inside Rectangle 2");
            case RECTANGLE2_IN_RECTANGLE1 -> System.out.println(" Rectangle 2 is inside Rectangle 1");
            case RECTANGLES_ARE_EQUAL -> System.out.println(" The Rectangles are equal");
            case NOT_CONTAINS -> System.out.println("Neither Rectangle contains the other Rectangle");
        }

        System.out.println("Are the Rectangles Adjacent? " + (RectangleAnalyzer.areRectanglesAdjacent(rectangle1,rectangle2)? "Yes" : "No"));

        System.out.println("");
        System.out.println("");
        System.out.println("This concludes the program, Thank you for the opportunity. Press ENTER to exit");
        System.in.read();
        System.exit(0);
    }

    /**
     * Basic function to prompt the user for details of a Rectangle, then creates and returns it.
     *
     * @param input - Requires parent function to pass in input scanner.
     * @return Rectangle - returns rectangle generated based on user input
     */
    private static Rectangle getRectangleFromInput(Scanner input){
        System.out.print("    Top Left X coordinate:");
        int x = input.nextInt();

        System.out.print("    Top Left Y coordinate:");
        int y = input.nextInt();

        System.out.print("    Height:");
        int height = input.nextInt();

        System.out.print("    Width:");
        int width = input.nextInt();

        return new Rectangle( x, y, height, width);
    };
}