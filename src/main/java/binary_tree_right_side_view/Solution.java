package binary_tree_right_side_view;

import common.TreeNode;

import java.util.*;

public class Solution {
    static class TraversalInfo {
        TreeNode node;
        int level;

        public TraversalInfo(TreeNode node, int level) {
            this.node = node;
            this.level = level;
        }
    }

    public List<Integer> rightSideView(TreeNode root) {
        if(root == null) return Collections.emptyList();

        List<TraversalInfo> list = new LinkedList<>();
        int maxLevel = rightSideTraverse(root, 0, list);
        int count = maxLevel + 1;
        Integer[] result = new Integer[count];

        Iterator<TraversalInfo> iterator = list.iterator();
        while(count > 0 && iterator.hasNext()) {
            TraversalInfo t = iterator.next();
            int level = t.level;
            if(result[level] == null) {
                result[level] = t.node.val;
                count--;
            }
        }
        return Arrays.asList(result);
    }

    private static int rightSideTraverse(TreeNode root, int level, List<TraversalInfo> list) {
        if(root == null) return -1;

        int maxLevel = level;

        if(root.right != null) {
            int rightLevel = rightSideTraverse(root.right, level+1, list);
            if(rightLevel > maxLevel) maxLevel = rightLevel;
        }

        if(root.left != null) {
            int leftLevel = rightSideTraverse(root.left, level + 1, list);
            if(leftLevel > maxLevel) maxLevel = leftLevel;
        }

        list.add(new TraversalInfo(root, level));
        return maxLevel;
    }

}