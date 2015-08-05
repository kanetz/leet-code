package rotate_array;

public class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        if(n < 2) return;

        if(k > n) k %= n;
        if(k == 0) return;

        reverse(nums, 0, n - k);
        reverse(nums, n - k , n);
        reverse(nums, 0, n);
    }

    private static void reverse(int[] nums, int start, int end) {
        if(end - start < 2) return;

        int i = start;
        int j = end - 1;
        int temp;
        while(i < j) {
            temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }
}