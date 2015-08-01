package test.remove_duplicates_from_sorted_array;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import remove_duplicates_from_sorted_array.Solution;

import java.util.Arrays;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class SolutionTest {

    private final Solution solution;
    private final int expectedLength;
    private final int[] expectedArray;
    private final int[] nums;

    public SolutionTest(int expectedLength, int[] expectedArray, int[] nums) {
        this.expectedLength = expectedLength;
        this.expectedArray = expectedArray;
        this.nums = nums;
        solution = new Solution();
    }

    @Test
    public void test() {
        int len = solution.removeDuplicates(nums);

        assertEquals(expectedLength, len);
        assertArrayEquals(expectedArray, Arrays.copyOfRange(nums, 0, len));
    }

    @Parameterized.Parameters
    public static Iterable testData() {
        return Arrays.asList(new Object[][] {
                {0, new int[0], new int[0]},
                {1, new int[] {1}, new int[] {1}},
                {1, new int[] {1}, new int[] {1,1}},
                {2, new int[] {1,2}, new int[] {1,1,2}},
                {2, new int[] {1,2}, new int[] {1,2,2}},
                {2, new int[] {1,2}, new int[] {1,1,2,2}},
                {3, new int[] {1,2,3}, new int[] {1,2,2,3}},
        });
    }
}
