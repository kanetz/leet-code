package test.integer_to_roman;

import integer_to_roman.Solution;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class SolutionTest {

    private final Solution solution;
    private final String expected;
    private final int input;

    public SolutionTest(String expected, int input) {
        this.expected = expected;
        this.input = input;
        solution = new Solution();
    }

    @Test
    public void test() {
        assertEquals(expected, solution.intToRoman(input));
    }

    @Parameterized.Parameters
    public static Iterable testData() {
        return Arrays.asList(new Object[][] {
                {"MCMIV", 1904},
                {"MCMLIV", 1954},
                {"MCMXC", 1990},
                {"MMXIV", 2014},
        });
    }
}
