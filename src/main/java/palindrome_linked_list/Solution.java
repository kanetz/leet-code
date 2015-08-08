package palindrome_linked_list;

import common.ListNode;

public class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) return true;

        ListNode p = head;
        ListNode q = head;
        ListNode qLast = null;
        while(p.next != null && p.next.next != null) {
            p = p.next.next;
            qLast = q;
            q = q.next;
        }

        if(p.next == null) {
            q = q.next;
            qLast.next = null;
        }
        else {
            qLast = q;
            q = q.next;
            qLast.next = null;
        }

        return compareLinkedList(head, reverseLinkedList(q));
    }

    private boolean compareLinkedList(ListNode head1, ListNode head2) {
        while(head1 != null && head2 != null) {
            if(head1.val != head2.val) return false;

            head1 = head1.next;
            head2 = head2.next;
        }

        return head1 == null && head2 == null;
    }

    private static ListNode reverseLinkedList(ListNode head) {
        ListNode reversedTail = head;
        ListNode p = reversedTail.next;

        while(p != null) {
            reversedTail.next = p.next;
            p.next = head;
            head = p;
            p = reversedTail.next;
        }

        return head;
    }
}