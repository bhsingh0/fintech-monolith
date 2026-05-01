package com.bharti.fintech.orderservice.copilotest;

public class CopilotTest {
    // create a method that checks if a number is even
    public static boolean isEven(int number) {
        return number % 2 == 0;
    }

    // create a method that checks if a number is prime
    public static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
