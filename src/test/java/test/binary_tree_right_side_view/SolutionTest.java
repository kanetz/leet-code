package test.binary_tree_right_side_view;

import binary_tree_right_side_view.Solution;
import common.TreeNode;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;
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
        TreeNode root = makeTree(input);
        List<Integer> actual = solution.rightSideView(root);
        assertArrayEquals(new Integer[] {1}, actual.toArray(new Integer[0]));
    }

    private TreeNode makeTree(Integer[] input) {
        TreeNode nil = new TreeNode(Integer.MIN_VALUE);
        List<TreeNode> list = new LinkedList<>();
        TreeNode root = new TreeNode(input[0]);
        list.add(root);

        for(int i = 1; i < input.length; i++) {
            Integer val = input[i];
            TreeNode n = val == null ? nil : new TreeNode(val.intValue());

            TreeNode p = list.get(0);
            if(p.left == null) p.left = n;
            else {
                p.right = n;
                list.remove(p);
                if(p.left == nil) p.left = null;
                if(p.right == nil) p.right = null;
            }

            if(n != nil) list.add(n);
        }

        return root;
    }
}
