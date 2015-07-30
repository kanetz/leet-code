package test.maximum_product_subarray;

import maximum_product_subarray.Solution;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class SolutionTest {

    private final int expected;
    private final int[] nums;
    private Solution solution;

    public SolutionTest(int expected, int[] nums) {
        this.expected = expected;
        this.nums = nums;
        solution = new Solution();
    }

    @Test
    public void test1() {
        assertEquals(expected, solution.maxProduct(nums));
    }

    @Parameterized.Parameters
    public static Iterable testData() {
        return Arrays.asList(new Object[][] {
                {24, new int[] {1,2,3,4}},
                {4, new int[] {1,2,0,4}},
                {6, new int[] {2,3,-2,4}},
                {24, new int[] {1,2,-3,-4}},
                {12, new int[] {-2,-3,-4}},
                {-2, new int[] {-2}},
                {1, new int[] {-3,0,1,-2}},
        });
    }
}
