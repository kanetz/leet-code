package test.subsets;

import org.junit.Test;
import subsets.Solution;

public class SolutionTest {

    private final Solution solution;

    public SolutionTest() {
        solution = new Solution();
    }

    @Test
    public void test() {
        System.out.println(solution.subsets(new int[] {1}));
        System.out.println(solution.subsets(new int[] {1,2}));
        System.out.println(solution.subsets(new int[] {3,1,2}));
    }
}
