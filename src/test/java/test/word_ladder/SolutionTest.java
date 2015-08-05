package test.word_ladder;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import word_ladder.Solution;

import java.util.Arrays;
import java.util.HashSet;

@RunWith(Parameterized.class)
public class SolutionTest {

    private final Solution solution;
    private final int expected;
    private final String begin;
    private final String end;
    private final String[] dict;

    public SolutionTest(int expected, String begin, String end, String[] dict) {
        this.expected = expected;
        this.begin = begin;
        this.end = end;
        this.dict = dict;
        solution = new Solution();
    }

    @Test
    public void test() {
        int actual = solution.ladderLength(begin, end, new HashSet<>(Arrays.asList(dict)));
        org.junit.Assert.assertEquals(expected, actual);
    }

    @Parameterized.Parameters
    public static Iterable testData() {
        return Arrays.asList(new Object[][] {
                {5, "hit", "cog", new String[] {"hot","dot","dog","lot","log"}},
        });
    }
}
