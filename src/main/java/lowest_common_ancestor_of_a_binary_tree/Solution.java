package lowest_common_ancestor_of_a_binary_tree;

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

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        LinkedList<TraversalInfo> list = new LinkedList<>();
        Set<TreeNode> targets = new HashSet<TreeNode>() {{
            add(p); add(q);
        }};
        postOrderTraverse(root, 0, list, targets);

        Integer minLevel = null;
        int count = 2;
        Iterator<TraversalInfo> iterator = list.iterator();
        while(iterator.hasNext()) {
            TraversalInfo t = iterator.next();
            if(t.node == p || t.node == q) {
                count--;
            }

            int level = t.level;
            if(count < 2 && (minLevel == null || level < minLevel)) {
                if(count > 0) {
                    minLevel = level;
                }
                else return t.node;
            }
        }

        return null;
    }

    private static void postOrderTraverse(TreeNode root, int level, List<TraversalInfo> nodes, Set<TreeNode> targets) {
        if(root == null || targets.isEmpty()) return;

        if(root.left != null) postOrderTraverse(root.left, level + 1, nodes, targets);
        if(root.right != null) postOrderTraverse(root.right, level + 1, nodes, targets);

        nodes.add(new TraversalInfo(root, level));
        targets.remove(root);
    }
}