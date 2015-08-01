package test.minimum_path_sum;

import minimum_path_sum.Solution;
import org.junit.Test;

public class SolutionTest {

    @Test
    public void test() {
        int actual = new Solution().minPathSum(new int[][]{{1, 2}, {1, 1}});
        org.junit.Assert.assertEquals(3, actual);
    }
}
