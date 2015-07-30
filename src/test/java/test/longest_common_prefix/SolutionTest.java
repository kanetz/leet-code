package test.longest_common_prefix;

import longest_common_prefix.Solution;
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
        String[] strs = new String[] {"flower","flow","flight"};
        assertEquals("fl", solution.longestCommonPrefix(strs));
    }

    @Test
    public void test2() {
        String[] strs = new String[] {"aa", "ab"};
        assertEquals("a", solution.longestCommonPrefix(strs));
    }
}
