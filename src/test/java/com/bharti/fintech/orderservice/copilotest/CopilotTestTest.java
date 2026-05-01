package com.bharti.fintech.orderservice.copilotest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test suite for CopilotTest.isEven() method.
 * Tests various scenarios including positive, negative, zero, and edge cases.
 */
@DisplayName("CopilotTest - isEven method tests")
class CopilotTestTest {

    @ParameterizedTest(name = "{0} should be even")
    @ValueSource(ints = {0, 2, 4, 100, 1000000, -2, -4, -100})
    @DisplayName("Should return true for all even numbers")
    void testEvenNumbers(int number) {
        assertTrue(CopilotTest.isEven(number));
    }

    @ParameterizedTest(name = "{0} should be odd")
    @ValueSource(ints = {1, 3, 5, 7, 99, 999999, -1, -3, -5})
    @DisplayName("Should return false for all odd numbers")
    void testOddNumbers(int number) {
        assertFalse(CopilotTest.isEven(number));
    }
}
