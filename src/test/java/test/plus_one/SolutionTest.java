package test.plus_one;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import plus_one.Solution;

import java.util.Arrays;

@RunWith(Parameterized.class)
public class SolutionTest {

    private final Solution solution;
    private final int[] expected;
    private final int[] input;

    public SolutionTest(int[] expected, int[] input) {
        this.expected = expected;
        this.input = input;
        solution = new Solution();
    }

    @Test
    public void test() {
        Assert.assertArrayEquals(expected, solution.plusOne(input));
    }

    @Parameterized.Parameters
    public static Iterable testData() {
        return Arrays.asList(new Object[][] {
                {new int[] {1,0}, new int[] {9}},
        });
    }
}
