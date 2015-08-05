package convert_sorted_list_to_binary_search_tree;

import common.ListNode;
import common.TreeNode;

public class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null) return null;

        if(head.next == null) return new TreeNode(head.val);

        ListNode p = head;
        ListNode q = head;
        ListNode qLast = null;

        while(p.next != null && p.next.next != null) {
            p = p.next.next;
            qLast = q;
            q = q.next;
        }
        p = q.next;
        if(qLast != null) qLast.next = null;
        q.next = null;

        TreeNode root = new TreeNode(q.val);
        if(head != q) root.left = sortedListToBST(head);
        if(p != null) root.right = sortedListToBST(p);

        return root;
    }
}
