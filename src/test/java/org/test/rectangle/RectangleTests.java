package org.test.rectangle;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class RectangleTests {

    @Test
    public void canCreateRectangle(){
        Rectangle rectangle = new Rectangle(0,1,2,3);

        assertEquals("X was not set correctly", 0, rectangle.getX());
        assertEquals("Y was not set correctly", 1, rectangle.getY());
        assertEquals("Height was not set correctly", 2, rectangle.getHeight());
        assertEquals("Width was not set correctly", 3, rectangle.getWidth());
    }
}
