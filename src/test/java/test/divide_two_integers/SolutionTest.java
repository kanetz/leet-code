package test.divide_two_integers;

import divide_two_integers.Solution;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class SolutionTest {

    private final int dividend;
    private final int divisor;
    private Solution solution;

    public SolutionTest(int dividend, int divisor) {
        this.dividend = dividend;
        this.divisor = divisor;
        solution = new Solution();
    }

    @Test
    public void test() {
        int expected = dividend / divisor;
        int actual = solution.divide(dividend, divisor);
        assertEquals(String.format("%d / %d = %d <=> %d", dividend, divisor, expected, actual), expected, actual);
    }

    @Parameterized.Parameters
    public static Iterable data() {
        return Arrays.asList(new Object[][] {
                {2, 1},
                {4, 2},
                {4, 3},
                {7, 3},
                {2, -1},
                {4, -2},
                {4, -3},
                {7, -3},
                {-2, 1},
                {-4, 2},
                {-4, 3},
                {-7, 3},
                {-2, -1},
                {-4, -2},
                {-4, -3},
                {-7, -3},
                {2147483647, 3},
                {-1010369383, -2147483648},
                {-2147483648, 1}
        });
    }

}
