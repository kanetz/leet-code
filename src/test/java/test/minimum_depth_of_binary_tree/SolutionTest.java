package test.minimum_depth_of_binary_tree;

import common.TestUtil;
import minimum_depth_of_binary_tree.Solution;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;

@RunWith(Parameterized.class)
public class SolutionTest {

    private final Solution solution;
    private final int expected;
    private final Integer[] input;

    public SolutionTest(int expected, Integer[] input) {
        this.expected = expected;
        this.input = input;
        solution = new Solution();
    }

    @Test
    public void test() {
        org.junit.Assert.assertEquals(expected, solution.minDepth(TestUtil.makeTree(input)));
    }

    @Parameterized.Parameters
    public static Iterable testData() {
        return Arrays.asList(new Object[][] {
                {2, new Integer[] {1,2,3,4,5}},
        });
    }
}
