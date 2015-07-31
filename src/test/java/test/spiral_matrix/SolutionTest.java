package test.spiral_matrix;

import org.junit.Test;
import spiral_matrix.Solution;

import java.util.Arrays;

public class SolutionTest {

    @Test
    public void test() {
        Solution solution = new Solution();

        System.out.println(Arrays.deepToString(solution.generateMatrix(0)));
        System.out.println(Arrays.deepToString(solution.generateMatrix(1)));
        System.out.println(Arrays.deepToString(solution.generateMatrix(2)));
        System.out.println(Arrays.deepToString(solution.generateMatrix(3)));
        System.out.println(Arrays.deepToString(solution.generateMatrix(4)));
    }
}
