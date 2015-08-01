package test.implement_strstr;

import implement_strstr.Solution;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;

@RunWith(Parameterized.class)
public class SolutionTest {

    private final Solution solution;
    private final int expected;
    private final String haystack;
    private final String needle;

    public SolutionTest(int expected, String haystack, String needle) {
        this.expected = expected;
        this.haystack = haystack;
        this.needle = needle;
        solution = new Solution();
    }

    @Test
    public void test() {
        org.junit.Assert.assertEquals(expected, solution.strStr(haystack, needle));
    }

    @Parameterized.Parameters
    public static Iterable testData() {
        return Arrays.asList(new Object[][] {
                {0, "a", "a"},
                {-1, "a", "b"},
                {0, "ab", "a"},
                {1, "ab", "b"},
                {-1, "ab", "abc"},
                {4, "mississippi", "issip"},
        });
    }
}
