package test.unique_binary_search_trees_ii;

import org.junit.Before;
import org.junit.Test;
import unique_binary_search_trees_ii.Solution;
import unique_binary_search_trees_ii.TreeNode;

import java.util.List;

public class SolutionTest {

    private Solution solution;

    @Before
    public void setup() {
        solution = new Solution();
    }

    @Test
    public void test1() {
        List<TreeNode> treeNodes = solution.generateTrees(4);
        System.out.print("done");
    }
}
