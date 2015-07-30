package subsets;

import java.util.*;

public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        int length = nums.length;
        List<List<Integer>> subsets = new ArrayList<List<Integer>>(2 << length) {{
            add(Collections.emptyList());
        }};

        Arrays.sort(nums);
        for (Integer v : nums) {
            int subsetCount = subsets.size();
            for (int i = 0; i < subsetCount; i++) {
                List<Integer> subset = subsets.get(i);
                List<Integer> newSubset = new ArrayList<>(subset.size() + 1);
                newSubset.addAll(subset);
                newSubset.add(v);
                subsets.add(newSubset);
            }
        }

        return subsets;
    }
}