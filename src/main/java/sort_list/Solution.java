package sort_list;

import common.*;

public class Solution {

    public ListNode sortList(ListNode head) {
        if(head == null) return null;

        if(head.next == null) return head;

        ListNode p = head;
        ListNode q = p;

        while(p.next != null && p.next.next != null) {
            p = p.next.next;
            q = q.next;
        }
        p = q;
        q = q.next;
        p.next = null;
        p = head;

        p = sortList(p);
        q = sortList(q);

        if(q == null) return head;

        if(p.val <= q.val) {
            head = p;
            p = p.next;
        }
        else {
            head = q;
            q = q.next;
        }

        ListNode r = head;
        while(true) {
            if(p == null) {
                r.next = q;
                return head;
            }
            if(q == null) {
                r.next = p;
                return head;
            }

            if(p.val <= q.val) {
                r.next = p;
                p = p.next;
                r = r.next;
            }
            else {
                r.next = q;
                q = q.next;
                r = r.next;
            }
        }
    }

}