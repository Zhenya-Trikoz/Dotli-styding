package org.example;

import org.example.operation.Addition;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MainTest {

    @Test
    public void verifyAddition() {
        int result = Main.calculation(5, 6, '+');
        assertEquals(11, result);
    }

    @Test
    public void verifySubtraction() {
        int result = Main.calculation(50, 6, '-');
        assertEquals(44, result);
    }

    @Test
    public void verifyDivision() {
        int result = Main.calculation(55, 5, '/');
        assertEquals(11, result);
    }

    @Test
    public void verifyMultiplication() {
        int result = Main.calculation(100, 5, '*');
        assertEquals(500, result);
    }

    @Test(expected = IllegalStateException.class)
    public void verifyUnknownCharacter() {
        Main.calculation(10, 10, '(');
    }
}
