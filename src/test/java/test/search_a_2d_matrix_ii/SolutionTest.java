package test.search_a_2d_matrix_ii;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import search_a_2d_matrix_ii.Solution;

import java.util.Arrays;

@RunWith(Parameterized.class)
public class SolutionTest {

    private final Solution solution;
    private final boolean expected;
    private final int[][] matrix;
    private final int target;

    public SolutionTest(boolean expected, int[][] matrix, int target) {
        this.expected = expected;
        this.matrix = matrix;
        this.target = target;
        solution = new Solution();
    }

    @Test
    public void test() {
        org.junit.Assert.assertEquals(expected, solution.searchMatrix(matrix, target));
    }

    @Parameterized.Parameters
    public static Iterable testData() {
        return Arrays.asList(new Object[][] {
                {true, new int[][] {{-5}}, -5},
                {false, new int[][] {{-5}}, -10},
                {false, new int[][] {{-5}}, 10},
                {true, new int[][] {{-1, 3}}, -1},
                {true, new int[][] {{-1, 3}}, 3},
                {false, new int[][] {{-1, 3}}, -3},
                {false, new int[][] {{-1, 3}}, 1},
                {false, new int[][] {{-1, 3}}, 4},
                {true, new int[][] {{-1}, {3}}, -1},
                {true, new int[][] {{-1}, {3}}, 3},
                {false, new int[][] {{-1}, {3}}, -3},
                {false, new int[][] {{-1}, {3}}, 1},
                {false, new int[][] {{-1}, {3}}, 4},
        });
    }


}
