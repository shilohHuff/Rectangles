package org.test.rectangle;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class RectangleAnalyzerTests {

    @Test
    public void canDetectIntersectingRectangles(){
        Rectangle rectangle1 = new Rectangle(0,1,2,3);
        Rectangle rectangle2 = new Rectangle(1,1,2,3);

        assertTrue("RectangleAnalyzer did not detect Intersecting Rectangles", RectangleAnalyzer.areRectanglesIntersecting(rectangle1, rectangle2));

        Rectangle rectangle3 = new Rectangle(0,0,1,1);
        Rectangle rectangle4 = new Rectangle(1,0,1,1);

        assertFalse("RectangleAnalyzer found Intersection where it did not occur", RectangleAnalyzer.areRectanglesIntersecting(rectangle3, rectangle4));
    }

    @Test
    public void canDetectIfRectangleContainsAnotherRectangle(){
        Rectangle rectangle1 = new Rectangle(0,0,10,10);
        Rectangle rectangle2 = new Rectangle(1,1,1,1);

        assertEquals("RectangleAnalyzer did not detect Contained Rectangles", RectangleAnalyzer.Contains.RECTANGLE2_IN_RECTANGLE1,RectangleAnalyzer.isRectangleContained(rectangle1, rectangle2));

        Rectangle rectangle3 = new Rectangle(0,0,1,1);
        Rectangle rectangle4 = new Rectangle(2,0,1,1);

        assertEquals("RectangleAnalyzer found Contained Rectangles where it did not occur", RectangleAnalyzer.Contains.NOT_CONTAINS, RectangleAnalyzer.isRectangleContained(rectangle3, rectangle4));

        assertEquals("RectangleAnalyzer found Contained Rectangles where it did not occur when rectangles are the same size", RectangleAnalyzer.Contains.RECTANGLES_ARE_EQUAL, RectangleAnalyzer.isRectangleContained(rectangle4, rectangle4));
    }


    @Test
    public void canDetectAdjacentRectangles(){
        Rectangle rectangle1 = new Rectangle(0,0,1,1);
        Rectangle rectangle2 = new Rectangle(1,0,1,1);

        assertTrue("RectangleAnalyzer did not detect Adjacent Rectangles", RectangleAnalyzer.areRectanglesAdjacent(rectangle1, rectangle2));

        Rectangle rectangle3 = new Rectangle(0,0,1,1);
        Rectangle rectangle4 = new Rectangle(2,0,1,1);

        assertFalse("RectangleAnalyzer found Adjacency where it did not occur", RectangleAnalyzer.areRectanglesAdjacent(rectangle3, rectangle4));
    }

    @Test
    public void canDetectOverlappingSegments(){
        assertTrue("RectangleAnalyzer did not detect overlapping segments", RectangleAnalyzer.isOverLapping(0,2,1,2));
        assertFalse("RectangleAnalyzer found overlapping segments where it did not occur", RectangleAnalyzer.isOverLapping(0,1, 2,1));
    }

    @Test
    public void canDetectIfSegmentIsWithinAnotherSegment(){
        assertTrue("RectangleAnalyzer did not detect the First segment withing the Second", RectangleAnalyzer.isFirstWithinSecond(1,1,0,5));
        assertFalse("RectangleAnalyzer found the First segment withing the Second segment when it should not have", RectangleAnalyzer.isFirstWithinSecond(0,1, 2,1));
    }

    @Test
    public void canDetectIfSegmentIsTouchingAnotherSegment(){
        assertTrue("RectangleAnalyzer did not detect overlapping segments", RectangleAnalyzer.isTouching(0,1,1,1));
        assertFalse("RectangleAnalyzer found overlapping segments where it did not occur", RectangleAnalyzer.isTouching(0,1, 3,1));
    }

}
