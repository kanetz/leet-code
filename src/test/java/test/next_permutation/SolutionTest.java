package test.next_permutation;

import next_permutation.Solution;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SolutionTest {

    private Solution solution;

    @Before
    public void setup() {
        solution = new Solution();
    }

    @Test
    public void test1() {
        int[] nums = new int[] {1,2,3};
        int[] expected = {1,3,2};
        solution.nextPermutation(nums);
        Assert.assertArrayEquals(expected, nums);
    }

    @Test
    public void test2() {
        int[] nums = new int[] {3,2,1};
        int[] expected = {1,2,3};
        solution.nextPermutation(nums);
        Assert.assertArrayEquals(expected, nums);
    }

    @Test
    public void test3() {
        int[] nums = new int[] {1,1,5};
        int[] expected = {1,5,1};
        solution.nextPermutation(nums);
        Assert.assertArrayEquals(expected, nums);
    }

    @Test
    public void test4() {
        int[] nums = new int[] {1,3,2};
        int[] expected = {2,1,3};
        solution.nextPermutation(nums);
        Assert.assertArrayEquals(expected, nums);
    }

    @Test
    public void test5() {
        int[] nums = new int[] {4,2,0,2,3,2,0};
        int[] expected = {4,2,0,3,0,2,2};
        solution.nextPermutation(nums);
        Assert.assertArrayEquals(expected, nums);
    }
}
