package unique_binary_search_trees_ii;

import java.util.*;
import common.TreeNode;

public class Solution {

    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> trees = Collections.emptyList();
        for(int i = 1; i <= n; i++) {
            trees = generateTreesRecrusively(i, trees);
        }
        return trees.isEmpty() ?
                new ArrayList<TreeNode>() {{ add(null); }} :
                trees;
    }

    private static List<TreeNode> generateTreesRecrusively(int val, List<TreeNode> subTrees) {
        if(val == 1) return Collections.singletonList(new TreeNode(val));

        List<TreeNode> trees = new LinkedList<>();

        for(TreeNode s : subTrees) {
            trees.addAll(BSTCloneAndInsert(s, val));

            TreeNode t = new TreeNode(val);
            if(s.val < val) {
                t.left = s;
            }
            else {
                t.right = s;
            }
            trees.add(t);
        }

        return trees;
    }

    private static List<TreeNode> BSTCloneAndInsert(TreeNode root, int val) {
        List<TreeNode> trees = new LinkedList<>();

        for(int i = val - 1; i > 0; i--) {
            TreeNode tree = cloneTree(root);
            TreeNode parent = searchInsertPoint(tree, i);
            if(parent == null) continue;

            if(parent.right == null) {
                parent.right = new TreeNode(val);
            }
            else {
                TreeNode n = new TreeNode(val);
                n.left = parent.right;
                parent.right = n;
            }
            trees.add(tree);
        }

        return trees;
    }

    private static TreeNode searchInsertPoint(TreeNode root, int val) {
        TreeNode n = root;
        while(n != null && n.val != val) {
            n = n.right;
        }
        return n;
    }

    private static TreeNode cloneTree(TreeNode treeNode) {
        if(treeNode == null) return null;

        TreeNode t = new TreeNode(treeNode.val);
        t.left = cloneTree(treeNode.left);
        t.right = cloneTree(treeNode.right);
        return t;
    }
}