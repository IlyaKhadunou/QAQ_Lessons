package Lesson_14_testng.Test;

import Lesson_14_testng.FactorialNumber;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertThrows;


public class TestFactorialTestng {

    @Test
    public void testFactorialZero() {
        assertEquals(FactorialNumber.getFactorialNumber(0), 1);
    }

    @Test
    public void testFactorialOne() {
        assertEquals(FactorialNumber.getFactorialNumber(1), 1);
    }

    @Test
    public void testFactorialLargeNumber() {
        assertEquals(FactorialNumber.getFactorialNumber(25), 2076180480L);
    }

    @Test
    public void testFactorialOfNegativeNumber() {
        assertThrows(IllegalArgumentException.class, () -> FactorialNumber.getFactorialNumber(-3));
    }
}
