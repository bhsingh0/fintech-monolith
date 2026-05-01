package com.bharti.fintech.orderservice.copilotest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test suite for CopilotTest.isPrime() method.
 * Tests various scenarios including prime numbers, non-primes, edge cases, and negative numbers.
 */
@DisplayName("CopilotTest - isPrime method tests")
class CopilotTestIsPrimeTest {

    @ParameterizedTest(name = "{0} should be prime")
    @ValueSource(ints = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 97})
    @DisplayName("Should return true for all prime numbers")
    void testPrimeNumbers(int number) {
        assertTrue(CopilotTest.isPrime(number),
            String.format("%d should be recognized as prime", number));
    }

    @ParameterizedTest(name = "{0} should not be prime")
    @ValueSource(ints = {0, 1, 4, 6, 8, 9, 10, 12, 15, 20, 25, 100})
    @DisplayName("Should return false for all non-prime numbers")
    void testNonPrimeNumbers(int number) {
        assertFalse(CopilotTest.isPrime(number),
            String.format("%d should not be recognized as prime", number));
    }

    @ParameterizedTest(name = "{0} is negative and should not be prime")
    @ValueSource(ints = {-1, -2, -3, -5, -10})
    @DisplayName("Should return false for all negative numbers")
    void testNegativeNumbers(int number) {
        assertFalse(CopilotTest.isPrime(number),
            String.format("Negative number %d should not be prime", number));
    }

    @Test
    @DisplayName("Boundary case: 2 is the smallest prime number")
    void testSmallestPrime() {
        assertTrue(CopilotTest.isPrime(2));
    }

    @Test
    @DisplayName("Boundary case: 1 is not prime by definition")
    void testOneIsNotPrime() {
        assertFalse(CopilotTest.isPrime(1));
    }

    @Test
    @DisplayName("Performance test: Large prime number")
    void testLargePrimeNumber() {
        assertTrue(CopilotTest.isPrime(97));
    }

    @Test
    @DisplayName("Performance test: Large non-prime number")
    void testLargeNonPrimeNumber() {
        assertFalse(CopilotTest.isPrime(100));
    }
}
