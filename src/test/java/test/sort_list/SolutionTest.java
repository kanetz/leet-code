package test.sort_list;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import sort_list.ListNode;
import sort_list.Solution;

import java.util.Arrays;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class SolutionTest {

    private final Solution solution;
    private final int[] expected;
    private final int[] input;

    public SolutionTest(int[] expected, int[] input) {
        this.expected = expected;
        this.input = input;
        solution = new Solution();
    }

    @Test
    public void test() {
        ListNode head = makeList(input);
        ListNode sorted = solution.sortList(head);
        assertArrayEquals(expected, listToArray(sorted));
    }

    @Parameterized.Parameters
    public static Iterable testData() {
        return Arrays.asList(new Object[][] {
                {new int[] {1}, new int[] {1}},
                {new int[] {1,2}, new int[] {1,2}},
                {new int[] {1,2}, new int[] {2,1}},
                {new int[] {1,2,3}, new int[] {2,1,3}},
                {new int[] {1,2,3,4}, new int[] {4,2,1,3}},
        });
    }

    private int[] listToArray(ListNode head) {
        int length = 0;
        ListNode p = head;
        while(p != null) {
            length++;
            p = p.next;
        }
        p = head;
        int[] a = new int[length];
        for(int i = 0 ; i < length; i++) {
            a[i] = p.val;
            p = p.next;
        }
        return a;
    }

    private ListNode makeList(int[] input) {
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
}
