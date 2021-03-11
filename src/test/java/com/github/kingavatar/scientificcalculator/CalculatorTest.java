package com.github.kingavatar.scientificcalculator;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.*;

class CalculatorTest {
    private Calculator testCalculator;


    @BeforeEach
    void setUp() {
        testCalculator = new Calculator();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    @DisplayName("Ensuring Object returns its String Message")
    void testToString() {
        assertEquals(testCalculator.toString(), "This is a Calculator CLI Application","Calculator Object String method should return its message");
    }
}