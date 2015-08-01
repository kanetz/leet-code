package flatten_binary_tree_to_linked_list;

import common.TreeNode;

public class Solution {
    public void flatten(TreeNode root) {
        if(root == null) return;

        flattenRecursively(root);
    }

    private static TreeNode flattenRecursively(TreeNode root) {
        TreeNode tail = root;
        TreeNode left = root.left;
        TreeNode right = root.right;
        TreeNode parentOfRight = root;

        if(left != null) {
            tail = flattenRecursively(left);
            root.right = left;
            root.left = null;
            parentOfRight = tail;
        }

        if(right != null) {
            tail = flattenRecursively(right);
            parentOfRight.right = right;
            parentOfRight.left = null;
        }

        return tail;
    }
}