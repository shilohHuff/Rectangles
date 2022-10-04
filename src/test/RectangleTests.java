package test;


import static org.junit.jupiter.api.Assertions.assertEquals;

import main.Rectangle;
import org.junit.jupiter.api.Test;


public class RectangleTests {

    @Test
    void canCreateRectangle(){
        Rectangle rectangle = new Rectangle(0,1,2,3);

        assertEquals(0, rectangle.getX(), "X was not set correctly");
        assertEquals(1, rectangle.getY(), "Y was not set correctly");
        assertEquals(2, rectangle.getHeight(), "Height was not set correctly");
        assertEquals(3, rectangle.getWidth(), "Width was not set correctly");
    }
}
