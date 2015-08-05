package test.binary_tree_right_side_view;

import binary_tree_right_side_view.Solution;
import common.TestUtil;
import common.TreeNode;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertArrayEquals;

public class SolutionTest {

    private Solution solution;

    @Before
    public void setup() {
        solution = new Solution();
    }

    @Test
    public void test1() {
        Integer[] input = {1};
        TreeNode root = TestUtil.makeTree(input);
        List<Integer> actual = solution.rightSideView(root);
        assertArrayEquals(new Integer[] {1}, actual.toArray(new Integer[0]));
    }

}
