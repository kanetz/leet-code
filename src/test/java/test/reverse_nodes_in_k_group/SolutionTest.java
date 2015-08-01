package test.reverse_nodes_in_k_group;

import common.ListNode;
import common.TestUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import reverse_nodes_in_k_group.Solution;

import java.util.Arrays;

@RunWith(Parameterized.class)
public class SolutionTest {

    private final Solution solution;
    private int[] expected;
    private int[] input;
    private int k;

    public SolutionTest(int[] expected, int[] input, int k) {
        this.expected = expected;
        this.input = input;
        this.k = k;
        solution = new Solution();
    }

    @Test
    public void test() {
        ListNode nodes = TestUtil.makeList(input);

        ListNode reversedNodes = solution.reverseKGroup(nodes, k);
        int[] actual = TestUtil.nodeListToArray(reversedNodes);

        org.junit.Assert.assertArrayEquals(expected, actual);
    }

    @Parameterized.Parameters
    public static Iterable testData() {
        return Arrays.asList(new Object[][] {
                {new int[] {1}, new int[] {1}, 1},
                {new int[] {1}, new int[] {1}, 2},
                {new int[] {2,1}, new int[] {1,2}, 2},
                {new int[] {2,1,3}, new int[] {1,2,3}, 2},
                {new int[] {3,2,1}, new int[] {1,2,3}, 3},
                {new int[] {1,2,3}, new int[] {1,2,3}, 4},
                {new int[] {2,1,4,3}, new int[] {1,2,3,4}, 2},
        });
    }

}
