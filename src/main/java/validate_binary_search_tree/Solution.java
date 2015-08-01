package validate_binary_search_tree;

import common.TreeNode;

public class Solution {
    public boolean isValidBST(TreeNode root) {
        return isValidBSTRecursive(root, null, null);

    }

    private static boolean isValidBSTRecursive(TreeNode node, Integer lowerBound, Integer upperBound) {
        if(node == null) return true;

        int val = node.val;
        if((lowerBound != null && val <= lowerBound) || (upperBound != null && val >= upperBound)) return false;

        boolean hasLeftChild = node.left == null;
        boolean hasRightChild = node.right == null;

        return (hasLeftChild || isValidBSTRecursive(node.left, lowerBound, val)) &&
                (hasRightChild || isValidBSTRecursive(node.right, val, upperBound));

    }
}