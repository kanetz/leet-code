package recover_binary_search_tree;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public void recoverTree(TreeNode root) {
        if(root == null) return;

        List<TreeNode> swappedNodes = new ArrayList<>(2);
        inOrderTraverse(root, null, swappedNodes);

        int temp = swappedNodes.get(0).val;
        swappedNodes.get(0).val = swappedNodes.get(1).val;
        swappedNodes.get(1).val = temp;
    }

    private static TreeNode inOrderTraverse(TreeNode root, TreeNode lastNode, List<TreeNode> swappedNodes) {
        if(root.left != null) lastNode = inOrderTraverse(root.left, lastNode, swappedNodes);

        if(lastNode != null && root.val < lastNode.val) {
            int length = swappedNodes.size();
            if(length == 0) {
                swappedNodes.add(lastNode);
                swappedNodes.add(root);
            }
            else {
                swappedNodes.set(1, root);
            }
        }

        if (root.right == null) return root;

        return inOrderTraverse(root.right, root, swappedNodes);
    }
}