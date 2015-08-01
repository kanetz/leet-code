package common;

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
}
