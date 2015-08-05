package test.fraction_to_recurring_decimal;

import fraction_to_recurring_decimal.Solution;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;

@RunWith(Parameterized.class)
public class SolutionTest {

    private final Solution solution;
    private final String expected;
    private final int numerator;
    private final int denominator;

    public SolutionTest(String expected, int numerator, int denominator) {
        this.expected = expected;
        this.numerator = numerator;
        this.denominator = denominator;
        solution = new Solution();
    }

    @Test
    public void test() {
        org.junit.Assert.assertEquals(expected, solution.fractionToDecimal(numerator, denominator));
    }

    @Parameterized.Parameters
    public static Iterable testData() {
        return Arrays.asList(new Object[][] {
                {"0.5", 1, 2},
                {"2", 2, 1},
                {"0.(6)", 2, 3},
        });
    }
}
