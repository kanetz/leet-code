package path_sum_ii;

import common.TreeNode;

import java.util.*;

public class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if(root == null) return Collections.emptyList();

        List<List<Integer>> result = new LinkedList<>();
        Deque<Integer> path = new LinkedList<>();
        doRecursively(root, sum, path, result);

        return result;
    }

    private static void doRecursively(TreeNode root, int sum, Deque<Integer> path, List<List<Integer>> result) {
        path.addLast(root.val);
        int residual = sum - root.val;

        if (residual == 0 && root.left == null && root.right == null) {
            result.add(new LinkedList<>(path));
        }
        else {
            if(root.left != null) {
                doRecursively(root.left, residual, path, result);
            }

            if(root.right != null) {
                doRecursively(root.right, residual, path, result);
            }
        }

        path.removeLast();
    }
}