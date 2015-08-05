package minimum_depth_of_binary_tree;

import common.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class Solution {
    public int minDepth(TreeNode root) {
        if(root == null) return 0;

        if(root.left == null && root.right == null) return 1;

        Deque<TreeNode> list = new LinkedList<>();
        list.add(root);
        root.val = 1;

        while(!list.isEmpty()) {
            TreeNode n = list.removeFirst();
            if(n.left == null && n.right == null) return n.val;

            if(n.left != null) {
                n.left.val = n.val + 1;
                list.addLast(n.left);
            }
            if(n.right != null) {
                n.right.val = n.val + 1;
                list.addLast(n.right);
            }
        }

        return 0;
    }
}
