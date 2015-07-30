package two_sum;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int[] twoSum(int[] nums, int target) {
        int length = nums.length;
        Map<Integer, Integer> map = new HashMap<>(length);

        for(int i = 1; i <= length; i++) {
            Integer x = nums[i-1];
            Integer i1 = i;
            Integer i0 = map.get(x);

            if(i0 == null) {
                Integer y = target - x;
                Integer i2 = map.get(y);
                if(i2 != null) {
                    return i1 < i2 ? new int[] {i1, i2} : new int[] {i2, i1};
                }

                map.put(x, i1);
            }
            else if((x<<1) == target) {
                return new int[] {i0, i1};
            }
        }

        return null;
    }

}
