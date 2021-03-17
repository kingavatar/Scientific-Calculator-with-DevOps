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
        assertEquals(testCalculator.toString(), "Welcome to the Calculator CLI Application","Calculator Object String method should return its message");
    }

    @Test
    @DisplayName("Testing the SQRT Function")
    void testSquareRoot(){
       assertEquals(testCalculator.SquareRoot(4),2.0);
    }

    @Test
    @DisplayName("Testing the Factorial Function")
    void testFactorial(){
       assertEquals(testCalculator.Factorial(3),6);
    }

    @Test
    @DisplayName("Testing the Log Function")
    void testLog(){
       assertEquals(testCalculator.Log(10),2.302585092994046);
    }
}