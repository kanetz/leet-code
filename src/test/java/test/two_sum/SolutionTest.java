package test.two_sum;

import org.junit.Before;
import org.junit.Test;
import two_sum.Solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {

    private Solution solution;

    @Before
    public void setup() {
        solution = new Solution();
    }

    @Test
    public void should_return_correct_answer() {
        int[] answers = solution.twoSum(new int[]{1, 2}, 3);
        assertArrayEquals(new int[]{1, 2}, answers);
    }

    @Test
    public void should_return_correct_answer_2() {
        int[] answers = solution.twoSum(new int[]{1, 3, 5}, 6);
        assertArrayEquals(new int[]{1, 3}, answers);
    }

    @Test
    public void should_return_correct_answer_3() {
        int[] answers = solution.twoSum(new int[]{3, 2, 4}, 6);
        assertArrayEquals(new int[]{2, 3}, answers);
    }


    @Test
    public void should_return_correct_answer_4() {
        int[] answers = solution.twoSum(new int[]{0, 4, 3, 0}, 0);
        assertArrayEquals(new int[]{1, 4}, answers);
    }

    @Test
    public void should_return_correct_answer_5() {
        int[] answers = solution.twoSum(new int[] {-1,-2,-3,-4,-5}, -8);
        assertArrayEquals(new int[]{3, 5}, answers);
    }

    @Test
    public void should_return_correct_answer_6() {
        int[] answers = solution.twoSum(new int[] {2,1,9,4,4,56,90,3}, 8);
        assertArrayEquals(new int[]{4, 5}, answers);
    }

}
