package main;

public class RectangleAnalyzer {

    /**
     * Determines if 2 Rectangles are overlapping one another.
     *
     * Assumption was made that Adjacency was not overlapping
     *
     * @param rectangle1
     * @param rectangle2
     * @return boolean - true if the rectangles are overlapping, false otherwise
     */
    public static boolean areRectanglesIntersecting(Rectangle rectangle1, Rectangle rectangle2){
        boolean isIntersectingHorizontally = isOverLapping(rectangle1.getX(), rectangle1.getWidth(), rectangle2.getX(), rectangle2.getWidth());

        boolean isIntersectingVertically = isOverLapping(rectangle1.getY(), rectangle1.getHeight(), rectangle2.getY(), rectangle2.getHeight());

        return isIntersectingHorizontally && isIntersectingVertically;
    }


    /**
     * Determines if 2 Rectangles are containing one another (ie: Rectangle 1 contains rectangle 2 or vice versa).
     *
     * Assumption was made that if the Rectangles are equal, they are containing as well.
     *
     * @param rectangle1
     * @param rectangle2
     * @return int - 1 if rectangle 1 is withing rectangle 2,
     */
    public static Contains isRectangleContained(Rectangle rectangle1, Rectangle rectangle2){

        boolean isRectangle1WithinRectangle2_Horizontal = isFirstWithinSecond(rectangle1.getX(), rectangle1.getWidth(), rectangle2.getX(), rectangle2.getWidth());
        boolean isRectangle1WithinRectangle2_Vertical = isFirstWithinSecond(rectangle1.getY(), rectangle1.getHeight(), rectangle2.getY(), rectangle2.getHeight());

        boolean isRectangle2WithinRectangle1_Horizontal = isFirstWithinSecond(rectangle2.getX(), rectangle2.getWidth(), rectangle1.getX(), rectangle1.getWidth());
        boolean isRectangle2WithinRectangle1_Vertical = isFirstWithinSecond(rectangle2.getY(), rectangle2.getHeight(), rectangle1.getY(), rectangle1.getHeight());

        if(isRectangle1WithinRectangle2_Horizontal && isRectangle1WithinRectangle2_Vertical && isRectangle2WithinRectangle1_Horizontal && isRectangle2WithinRectangle1_Vertical){
            return Contains.RECTANGLES_ARE_EQUAL;
        } else if(isRectangle1WithinRectangle2_Horizontal && isRectangle1WithinRectangle2_Vertical){
            return Contains.RECTANGLE1_IN_RECTANGLE2;
        } else if (isRectangle2WithinRectangle1_Horizontal && isRectangle2WithinRectangle1_Vertical) {
            return Contains.RECTANGLE2_IN_RECTANGLE1;
        } else {
            return Contains.NOT_CONTAINS;
        }
    }

    /**
     * Determines if 2 Rectangles are adjacent to one another. Adjacency is defined as sharing an edge without overlapping.
     *
     * Assumption was made that if the rectangles are overlapping they can not be adjacent (example: 2 identical rectangles)
     *
     * @param rectangle1
     * @param rectangle2
     * @return boolean - true if the rectangles are adjacent, false otherwise
     */
    public static boolean areRectanglesAdjacent(Rectangle rectangle1, Rectangle rectangle2){

        boolean isIntersectingHorizontally = isOverLapping(rectangle1.getX(), rectangle1.getWidth(), rectangle2.getX(), rectangle2.getWidth());

        boolean isIntersectingVertically = isOverLapping(rectangle1.getY(), rectangle1.getHeight(), rectangle2.getY(), rectangle2.getHeight());

        //Effectively an exclusive OR: If there is overlap in both direction or neither directions, it can not be adjacent
        if (isIntersectingHorizontally == isIntersectingVertically){
            return false;
        }

        //There is overlap horizontally, if the vertical edges touch then there is adjacency
        if (isIntersectingHorizontally){
            return isTouching(rectangle1.getY(), rectangle1.getHeight(), rectangle2.getY(), rectangle2.getHeight());
        }

        //There is overlap vertically, if the horizontal edges touch then there is adjacency
        if (isIntersectingVertically){
            return isTouching(rectangle1.getX(), rectangle1.getWidth(), rectangle2.getX(), rectangle2.getWidth());
        }

        //Otherwise they are not adjacent
        return false;
    }


    /**
     * This method is used to determine if 2 segments are overlapping.
     *
     * @param position1 Start of first segment
     * @param length1 Length of first segment
     * @param position2 Start of second segment
     * @param length2 Length of second segment
     * @return boolean - true if the segments are overlapping, false otherwise
     */
    public static boolean isOverLapping(int position1, int length1, int position2, int length2){
        return (position1 < length2+position2  &&  position1+length1 > position2);
    }


    /**
     * Determines if the first segment is within the second segment.
     *
     * @param position1 Start of first segment
     * @param length1 Length of first segment
     * @param position2 Start of second segment
     * @param length2 Length of second segment
     * @return boolean - true if the first segment is within the second segment, false otherwise
     */
    public static boolean isFirstWithinSecond(int position1, int length1, int position2, int length2){

        return (position1 >= position2 && position1+length1 <= position2+length2);
    }

    /**
     * Determines if 2 segments share a start or end.
     *
     * @param position1 Start of first segment
     * @param length1 Length of first segment
     * @param position2 Start of second segment
     * @param length2 Length of second segment
     * @return boolean - true if the segments share a start or end, false otherwise
     */
    public static boolean isTouching(int position1, int length1, int position2, int length2){
        return (length2+position2 == position1   ||  position1+length1 == position2);
    }

    public enum Contains {
        RECTANGLE1_IN_RECTANGLE2,
        RECTANGLE2_IN_RECTANGLE1,
        RECTANGLES_ARE_EQUAL,
        NOT_CONTAINS
    }
}
