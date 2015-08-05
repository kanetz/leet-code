package test.path_sum_ii;

import common.TestUtil;
import common.TreeNode;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import path_sum_ii.Solution;

import java.util.Arrays;
import java.util.List;

@RunWith(Parameterized.class)
public class SolutionTest {

    private final Solution solution;
    private final int[][] expected;
    private final Integer[] input;
    private final int sum;

    public SolutionTest(int[][] expected, Integer[] input, int sum) {
        this.expected = expected;
        this.input = input;
        this.sum = sum;
        solution = new Solution();
    }

    @Test
    public void test() {
        TreeNode root = TestUtil.makeTree(input);

        solution.pathSum(root, sum);
    }

    @Parameterized.Parameters
    public static Iterable testData() {
        return Arrays.asList(new Object[][] {
                {null, new Integer[] {0,1,1}, 1}
        });
    }
}
