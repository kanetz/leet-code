package test.median_of_two_sorted_array;

import median_of_two_sorted_array.Solution;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;

import static junit.framework.Assert.assertEquals;

@RunWith(Parameterized.class)
public class SolutionTest {

    private final Solution solution;
    private final double expected;
    private final int[] nums1;
    private final int[] nums2;

    public SolutionTest(double expected, int[] nums1, int[] nums2) {
        this.expected = expected;
        this.nums1 = nums1;
        this.nums2 = nums2;
        solution = new Solution();
    }

    @Test
    public void test() {
        assertEquals(expected, solution.findMedianSortedArrays(nums1, nums2));
    }

    @Parameterized.Parameters
    public static Iterable testData() {
        return Arrays.asList(new Object[][] {
                {1.0D, new int[] {1}, new int[] {}},
                {1.0D, new int[] {}, new int[] {1}},
                {1.5D, new int[] {1,2}, new int[] {}},
                {1.5D, new int[] {}, new int[] {1,2}},
                {1.5D, new int[] {1}, new int[] {2}},
                {1.5D, new int[] {2}, new int[] {1}},
                {2D, new int[] {1,2}, new int[] {3}},
                {2D, new int[] {1}, new int[] {2,3}},
                {2.5D, new int[] {1,2}, new int[] {3,4}},
                {2.5D, new int[] {1,3}, new int[] {2,4}},
                {2.5D, new int[] {1,2}, new int[] {3,4}},
                {2.5D, new int[] {1,3}, new int[] {2,4}},
                {3D, new int[] {1,2,3}, new int[] {3,4,5}},

                {3.5D, new int[] {1}, new int[] {2,3,4,5,6}},
                {1.5D, new int[] {1,2}, new int[] {1,2}},
        });
    }
}
