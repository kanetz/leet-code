package binary_tree_maximum_path_sum;

import common.TreeNode;

public class Solution {
    static class TraversalContext {
        int maxSum;

        public TraversalContext() {
            this.maxSum = Integer.MIN_VALUE;
        }
    }

    public int maxPathSum(TreeNode root) {
        if(root == null) return Integer.MIN_VALUE;

        TraversalContext context = new TraversalContext();
        postOrderTraverseWithMaxSum(root, context);
        return context.maxSum;
    }

    private static int postOrderTraverseWithMaxSum(TreeNode root, TraversalContext context) {
        if(root.val > context.maxSum) context.maxSum = root.val;

        int singlePathSum = root.val;
        int doublePathSum = root.val;

        if(root.left != null) {
            int left = postOrderTraverseWithMaxSum(root.left, context);
            if(left > context.maxSum) context.maxSum = left;

            if(left > 0) {
                doublePathSum += left;
                int pathSum = left + root.val;
                if(pathSum > singlePathSum) singlePathSum = pathSum;
            }
        }

        if(root.right != null) {
            int right = postOrderTraverseWithMaxSum(root.right, context);
            if(right > context.maxSum) context.maxSum = right;

            if(right > 0) {
                doublePathSum += right;
                int pathSum = right + root.val;
                if(pathSum > singlePathSum) singlePathSum = pathSum;
            }

        }

        if(doublePathSum > context.maxSum) context.maxSum = doublePathSum;
        if(singlePathSum > context.maxSum) context.maxSum = singlePathSum;

        return singlePathSum;
    }
}