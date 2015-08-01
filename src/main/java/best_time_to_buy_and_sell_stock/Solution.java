package best_time_to_buy_and_sell_stock;

public class Solution {
    public int maxProfit(int[] prices) {
        int length = prices.length;
        if(length < 2) return 0;

        int[] delta = new int[length - 1];
        for(int i = 1; i < length; i++) {
            delta[i - 1] = prices[i] - prices[i - 1];
        }

        int maxProfit = maxSumOfSubArray(delta, 0, length - 1);
        return maxProfit > 0 ? maxProfit : 0;
    }

    private int maxSumOfSubArray(int[] array, int beginIndex, int endIndex) {
        if(endIndex - beginIndex == 1) return array[beginIndex];

        int mid = (beginIndex + endIndex) >> 1;
        int maxSum = maxSumOfCrossingSubArray(array, beginIndex, endIndex, mid);

        if(mid > beginIndex) {
            int left = maxSumOfSubArray(array, beginIndex, mid);
            if(left > maxSum) maxSum = left;
        }

        if(endIndex > mid) {
            int right = maxSumOfSubArray(array, mid, endIndex);
            if(right > maxSum) maxSum = right;
        }

        return maxSum;
    }

    private int maxSumOfCrossingSubArray(int[] array, int beginIndex, int endIndex, int mid) {
        int sum = 0;

        if(mid > beginIndex) {
            int max = Integer.MIN_VALUE;
            int temp = 0;
            for(int i = mid - 1; i >= beginIndex; i--) {
                temp += array[i];
                if(temp > max) max = temp;
            }

            sum += max;
        }

        if(endIndex > mid) {
            int max = Integer.MIN_VALUE;
            int temp = 0;
            for(int i = mid; i < endIndex; i++) {
                temp += array[i];
                if(temp > max) max = temp;
            }

            sum += max;
        }

        return sum;
    }
}