package next_permutation;

import java.util.Arrays;

public class Solution {
    public void nextPermutation(int[] nums) {
        int length = nums.length;

        for(int i = length - 2; i >= 0; i--) {
            for(int j = length - 1; j > i; j--) {
                if(nums[i] < nums[j]) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;

                    Arrays.sort(nums, i + 1, length);
                    return;
                }
            }
        }

        Arrays.sort(nums, 0, length);
    }
}