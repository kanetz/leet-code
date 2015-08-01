package reverse_nodes_in_k_group;

import common.ListNode;

public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || k < 2) return head;

        ListNode newHead = null;
        ListNode groupHead = head;
        ListNode lastGroupTail = null;
        while(groupHead != null) {
            int count = k-1;
            ListNode groupTail = groupHead;
            while(groupTail != null && count > 0) {
                groupTail = groupTail.next;
                count--;
            }

            if(groupTail == null) break;

            ListNode p = groupHead.next;
            ListNode limit = groupTail.next;
            groupTail = groupHead;
            while(p != limit) {
                groupTail.next = p.next;
                p.next = groupHead;
                groupHead = p;
                p = groupTail.next;
            }

            if(newHead == null) newHead = groupHead;
            if(lastGroupTail != null) lastGroupTail.next = groupHead;
            lastGroupTail = groupTail;
            groupHead = limit;
        }

        return newHead != null ? newHead : head;
    }
}