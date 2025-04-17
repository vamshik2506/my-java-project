package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AppTest {

    App app = new App();

    @Test
    public void testAdd() {
        assertEquals(5, app.add(2, 3));
    }

    @Test
    public void testAddNegative() {
        assertEquals(-1, app.add(2, -3));
    }

    @Test
    public void testIsPositiveTrue() {
        assertTrue(app.isPositive(5));
    }

    @Test
    public void testIsPositiveFalse() {
        assertFalse(app.isPositive(-1));
    }
}
