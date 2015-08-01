package remove_duplicates_from_sorted_array;

public class Solution {
    public int removeDuplicates(int[] nums) {
        int length = nums.length;
        if(length <= 1) return length;

        int u = nums[0];
        int offset = 0;
        for(int i = 1; i < length; i++) {
            int v = nums[i];
            if(v == u) offset++;
            else {
                u = v;
                if(offset > 0) nums[i-offset] = v;
            }
        }

        return length - offset;
    }
}