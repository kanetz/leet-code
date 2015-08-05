package common;

import java.util.LinkedList;
import java.util.List;

public class TestUtil {

    public static ListNode makeList(int[] input) {
        int length = input.length;
        if(length == 0) return null;

        ListNode head = new ListNode(input[0]);
        ListNode p = head;
        for(int i = 1; i < length; i++) {
            p.next = new ListNode(input[i]);
            p = p.next;
        }
        return head;
    }

    public static int[] nodeListToArray(ListNode head) {
        int length = 0;
        for(ListNode p = head; p != null; p = p.next) {
            length++;
        }

        int[] result = new int[length];
        for(int i = 0; i < length; i++) {
            result[i] = head.val;
            head = head.next;
        }

        return result;
    }

    public static TreeNode makeTree(Integer[] input) {
        TreeNode nil = new TreeNode(Integer.MIN_VALUE);
        List<TreeNode> list = new LinkedList<>();
        TreeNode root = new TreeNode(input[0]);
        list.add(root);

        for(int i = 1; i < input.length; i++) {
            Integer val = input[i];
            TreeNode n = val == null ? nil : new TreeNode(val.intValue());

            TreeNode p = list.get(0);
            if(p.left == null) p.left = n;
            else {
                p.right = n;
                list.remove(p);
                if(p.left == nil) p.left = null;
                if(p.right == nil) p.right = null;
            }

            if(n != nil) list.add(n);
        }

        return root;
    }
}
