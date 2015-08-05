package linked_list_cycle;

import common.ListNode;

public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head == null) return false;

        ListNode p = head;
        ListNode q = head;
        while(p.next != null && p.next.next != null) {
            p = p.next.next;
            q = q.next;

            if(p == q) return true;
        }

        return false;
    }
}