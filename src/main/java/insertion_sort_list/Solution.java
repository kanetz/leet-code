package insertion_sort_list;

import common.ListNode;

public class Solution {
    public ListNode insertionSortList(ListNode head) {
        if(head == null) return null;

        ListNode sortedTail = head;
        while(true) {
            ListNode p = sortedTail.next;
            if(p == null) break;

            if(sortedTail.val <= p.val) {
                sortedTail = p;
                continue;
            }

            ListNode appendingPoint = null;
            ListNode q = head;
            while(q != p && q.val <= p.val) {
                appendingPoint = q;
                q = q.next;
            }

            sortedTail.next = p.next;

            if(appendingPoint == null) {
                p.next = head;
                head = p;
            }
            else {
                p.next = appendingPoint.next;
                appendingPoint.next = p;
            }
        }

        return head;
    }
}