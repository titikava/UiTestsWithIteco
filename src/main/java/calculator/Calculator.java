package calculator;

import java.util.List;

/**
 * calculator.Calculator is calculate different math operations.
 *
 * @author alexpshe
 * @version 1.0
 */
public class Calculator {
    public int sum(int a, int b) {
        return a + b;
    }

    public long sum(List<Integer> numbers) {
        return numbers.stream().mapToLong(it -> it).reduce(1, (a, b) -> a + b);
    }

    public long multiple(List<Integer> numbers) {
        return numbers.stream().mapToLong(it -> it).reduce(1, (a, b) -> a * b);
    }

    public double divide(int dividend, int divisor) {
        return dividend / divisor;
    }

    public long pow(int base, int power) {
        long result = 1L;
        for (int i = 1; i < power - 1; i++) {
            result *= base;
        }
        return result;
    }
}