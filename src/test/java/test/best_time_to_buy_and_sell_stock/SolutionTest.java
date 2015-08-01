package test.best_time_to_buy_and_sell_stock;

import best_time_to_buy_and_sell_stock.Solution;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;

@RunWith(Parameterized.class)
public class SolutionTest {

    private final Solution solution;
    private final int expected;
    private final int[] prices;

    public SolutionTest(int expected, int[] prices) {
        this.expected = expected;
        this.prices = prices;
        solution = new Solution();
    }

    @Test
    public void test() {
        org.junit.Assert.assertEquals(expected, solution.maxProfit(prices));
    }

    @Parameterized.Parameters
    public static Iterable testData() {
        return Arrays.asList(new Object[][] {
                {1, new int[] {1, 2}},
                {3, new int[] {1, 2, 4}},
        });
    }
}
