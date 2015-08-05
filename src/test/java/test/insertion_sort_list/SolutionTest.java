package test.insertion_sort_list;

import common.ListNode;
import common.TestUtil;
import insertion_sort_list.Solution;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;

@RunWith(Parameterized.class)
public class SolutionTest {

    private final Solution solution;
    private int[] input;

    public SolutionTest(int[] input) {
        this.input = input;
        solution = new Solution();
    }

    @Test
    public void test() {
        ListNode sorted = solution.insertionSortList(TestUtil.makeList(input));

        Arrays.sort(input);
        org.junit.Assert.assertArrayEquals(input, TestUtil.nodeListToArray(sorted));
    }

    @Parameterized.Parameters
    public static Iterable testData() {
        return Arrays.asList(new Object[][] {
                {new int[] {2,1}}
        });
    }
}
