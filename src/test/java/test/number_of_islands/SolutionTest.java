package test.number_of_islands;

import number_of_islands.Solution;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;

@RunWith(Parameterized.class)
public class SolutionTest {
    static final char L = '1';
    static final char W = '0';

    private final Solution solution;
    private final int expected;
    private final char[][] grid;

    public SolutionTest(int expected, char[][] grid) {
        this.expected = expected;
        this.grid = grid;
        solution = new Solution();
    }

    @Test
    public void test() {
        org.junit.Assert.assertEquals(expected, solution.numIslands(grid));
    }

    @Parameterized.Parameters
    public static Iterable testData() {
        return Arrays.asList(new Object[][] {
                {1, new char[][] {
                        {L,L},
                        {L,L},
                }},
                {1, new char[][] {
                        {W,L},
                        {L,L},
                }},
                {1, new char[][] {
                        {W,L},
                        {W,L},
                }},
                {1, new char[][] {
                        {L,L},
                        {W,W},
                }},
                {2, new char[][] {
                        {W,L},
                        {L,W},
                }},
                {2, new char[][] {
                        {L,W},
                        {W,L},
                }},
                {1, new char[][] {
                        {L,L,L,L,W},
                        {L,L,W,L,W},
                        {L,L,W,W,W},
                        {W,W,W,W,W},
                }},
                {3, new char[][] {
                        {L,L,W,W,W},
                        {L,L,W,W,W},
                        {W,W,L,W,W},
                        {W,W,W,L,L},
                }},
                {1, new char[][] {
                        {L,W,L,L,L},
                        {L,W,L,W,L},
                        {L,L,L,W,L},
                }},
        });
    }
}
