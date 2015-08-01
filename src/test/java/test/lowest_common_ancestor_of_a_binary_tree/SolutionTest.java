package test.lowest_common_ancestor_of_a_binary_tree;

import lowest_common_ancestor_of_a_binary_tree.Solution;
import common.TreeNode;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class SolutionTest {

    private Solution solution;

    @Before
    public void setup() {
        solution = new Solution();
    }

    @Test
    public void test1() {
        Integer[] input = {-1,0,3,-2,4,null,null,8};
        List<Integer> targets = Arrays.asList(8,4);
        TreeNode[] nodes = makeTree(input, targets);
        TreeNode actual = solution.lowestCommonAncestor(nodes[0], nodes[1], nodes[2]);
        assertEquals(0, actual.val);
    }

    @Test
    public void test2() {
        Integer[] input = {3,5,1,6,2,0,8,null,null,7,4};
        List<Integer> targets = Arrays.asList(0,8);
        TreeNode[] nodes = makeTree(input, targets);
        TreeNode actual = solution.lowestCommonAncestor(nodes[0], nodes[1], nodes[2]);
        assertEquals(1, actual.val);
    }

    private TreeNode[] makeTree(Integer[] input, List<Integer> targets) {
        TreeNode nil = new TreeNode(Integer.MIN_VALUE);

        TreeNode[] result = new TreeNode[3];
        int targetIndex = 1;

        List<TreeNode> list = new LinkedList<>();
        TreeNode root = new TreeNode(input[0]);
        list.add(root);
        result[0] = root;
        if(targets.indexOf(root.val) != -1) result[targetIndex++] = root;

        for(int i = 1; i < input.length; i++) {
            Integer val = input[i];
            TreeNode n = val == null ? nil : new TreeNode(val.intValue());
            if(val != null && targets.indexOf(val) != -1) result[targetIndex++] = n;

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

        return result;
    }
}
