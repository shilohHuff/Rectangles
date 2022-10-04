package test;

import main.Rectangle;
import main.RectangleAnalyzer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RectangleAnalyzerTests {

    @Test
    void canDetectIntersectingRectangles(){
        Rectangle rectangle1 = new Rectangle(0,1,2,3);
        Rectangle rectangle2 = new Rectangle(1,1,2,3);

        assertTrue(RectangleAnalyzer.areRectanglesIntersecting(rectangle1, rectangle2), "RectangleAnalyzer did not detect Intersecting Rectangles");

        Rectangle rectangle3 = new Rectangle(0,0,1,1);
        Rectangle rectangle4 = new Rectangle(1,0,1,1);

        assertFalse(RectangleAnalyzer.areRectanglesIntersecting(rectangle3, rectangle4), "RectangleAnalyzer found Intersection where it did not occur");
    }

    @Test
    void canDetectIfRectangleContainsAnotherRectangle(){
        Rectangle rectangle1 = new Rectangle(0,0,10,10);
        Rectangle rectangle2 = new Rectangle(1,1,1,1);

        assertEquals(RectangleAnalyzer.Contains.RECTANGLE2_IN_RECTANGLE1,RectangleAnalyzer.isRectangleContained(rectangle1, rectangle2), "RectangleAnalyzer did not detect Contained Rectangles");

        Rectangle rectangle3 = new Rectangle(0,0,1,1);
        Rectangle rectangle4 = new Rectangle(2,0,1,1);

        assertEquals(RectangleAnalyzer.Contains.NOT_CONTAINS, RectangleAnalyzer.isRectangleContained(rectangle3, rectangle4), "RectangleAnalyzer found Contained Rectangles where it did not occur");

        assertEquals(RectangleAnalyzer.Contains.RECTANGLES_ARE_EQUAL, RectangleAnalyzer.isRectangleContained(rectangle4, rectangle4), "RectangleAnalyzer found Contained Rectangles where it did not occur when rectangles are the same size");
    }


    @Test
    void canDetectAdjacentRectangles(){
        Rectangle rectangle1 = new Rectangle(0,0,1,1);
        Rectangle rectangle2 = new Rectangle(1,0,1,1);

        assertTrue(RectangleAnalyzer.areRectanglesAdjacent(rectangle1, rectangle2), "RectangleAnalyzer did not detect Adjacent Rectangles");

        Rectangle rectangle3 = new Rectangle(0,0,1,1);
        Rectangle rectangle4 = new Rectangle(2,0,1,1);

        assertFalse(RectangleAnalyzer.areRectanglesAdjacent(rectangle3, rectangle4), "RectangleAnalyzer found Adjacency where it did not occur");
    }

    @Test
    void canDetectOverlappingSegments(){
        assertTrue(RectangleAnalyzer.isOverLapping(0,2,1,2), "RectangleAnalyzer did not detect overlapping segments");
        assertFalse(RectangleAnalyzer.isOverLapping(0,1, 2,1), "RectangleAnalyzer found overlapping segments where it did not occur");
    }

    @Test
    void canDetectIfSegmentIsWithinAnotherSegment(){
        assertTrue(RectangleAnalyzer.isFirstWithinSecond(1,1,0,5), "RectangleAnalyzer did not detect the First segment withing the Second");
        assertFalse(RectangleAnalyzer.isFirstWithinSecond(0,1, 2,1), "RectangleAnalyzer found the First segment withing the Second segment when it should not have");
    }

    @Test
    void canDetectIfSegmentIsTouchingAnotherSegment(){
        assertTrue(RectangleAnalyzer.isTouching(0,1,1,1), "RectangleAnalyzer did not detect overlapping segments");
        assertFalse(RectangleAnalyzer.isTouching(0,1, 3,1), "RectangleAnalyzer found overlapping segments where it did not occur");
    }

}
