package test.longest_palindromic_substring;

import longest_palindromic_substring.Solution;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class SolutionTest {

    private Solution solution;

    @Before
    public void setup() {
        solution = new Solution();
    }

    @Test
    public void test1() {
        assertEquals("a", solution.longestPalindrome("a"));
    }

    @Test
    public void test2() {
        assertEquals("aba", solution.longestPalindrome("aba"));
    }

    @Test
    public void test3() {
        assertEquals("bcb", solution.longestPalindrome("abcbd"));
    }

    @Test
    public void test4() {
        assertEquals("ccc", solution.longestPalindrome("ccc"));
    }

    @Test
    public void test5() {
        assertEquals("bb", solution.longestPalindrome("bb"));
    }

    @Test
    public void test6() {
        assertEquals("bb", solution.longestPalindrome("abb"));
    }

    @Test
    public void test7() {
        assertEquals("cc", solution.longestPalindrome("ccd"));
    }

    @Test
    public void test8() {
        assertEquals("aaabaaa", solution.longestPalindrome("aaabaaaa"));
    }
}
