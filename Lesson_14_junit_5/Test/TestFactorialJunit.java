package Lesson_14_junit_5.Test;

import Lesson_14_junit_5.FactorialNumber;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestFactorialJunit {

    @Test
    @DisplayName("Провека факториала 0")
    void testFactorialZero() {
        Assertions.assertEquals(1, FactorialNumber.getFactorialNumber(0));
    }

    @Test
    @DisplayName("Провека факториала 1")
    void testFactorialOne() {
        assertEquals(1, FactorialNumber.getFactorialNumber(1));
    }

    @Test
    @DisplayName("Провека факториала большого числа")
    void testFactorialLargeNumber() {
        assertEquals(2076180480L, FactorialNumber.getFactorialNumber(25));
    }

    @Test
    @DisplayName("Провека исключения при отрицательном числе")
    void testFactorialNegative() {
        Exception exception = assertThrows
                (IllegalArgumentException.class, () -> {
                    FactorialNumber.getFactorialNumber(-1);
                });
        assertEquals("Number must be non-negative.", exception.getMessage());
    }
}
