package contains_duplicate;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public boolean containsDuplicate(int[] nums) {
        int length = nums.length;
        if(length < 2) return false;

        Set<Integer> set = new HashSet<>(length);
        for (int num : nums) {
            if (!set.add(num)) return true;
        }
        return false;
    }
}