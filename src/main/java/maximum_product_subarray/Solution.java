package maximum_product_subarray;

public class Solution {

    public int maxProduct(int[] nums) {
        int length = nums.length;
        if(length == 0) return 0;

        int lastIndex = -1;
        int index = 0;
        int[] partitions = new int[2*length];
        int partitionCount = 0;
        int maxProduct = Integer.MIN_VALUE;

        for(index = 0; index < nums.length; index++) {
            if(nums[index] == 0) {
                maxProduct = 0;

                if(lastIndex == -1) {
                    continue;
                }

                partitions[partitionCount++] = lastIndex;
                partitions[partitionCount++] = index;
                lastIndex = -1;
            }
            else {
                if(lastIndex == -1) lastIndex = index;
            }
        }
        if(lastIndex != -1) {
            partitions[partitionCount++] = lastIndex;
            partitions[partitionCount++] = index;
        }

        if(partitionCount == 0) return maxProductInPartition(nums, 0, length);

        for(int i = 0; i < partitionCount >> 1; i++) {
            int product = maxProductInPartition(nums, partitions[i<<1], partitions[(i<<1) + 1]);
            if(product > maxProduct) {
                maxProduct = product;
            }
        }
        return maxProduct;
    }

    private static int maxProductInPartition(int[] nums, int beginIndex, int endIndex) {
        if(endIndex - beginIndex == 1) return nums[beginIndex];

        int[] negs = new int[endIndex - beginIndex];
        int negsCount = 0;

        for(int i = beginIndex; i < endIndex; i++) {
            int v = nums[i];
            if(v < 0) {
                negs[negsCount++] = i;
            }
        }

        if((negsCount & 1) == 0) {
            return multiply(nums, beginIndex, endIndex);
        }
        else if(negsCount == 1) {
            int maxProduct = Integer.MIN_VALUE;
            int negIndex = negs[0];

            if(negIndex > beginIndex) {
                int left = multiply(nums, beginIndex, negs[0]);
                if(left > maxProduct) maxProduct = left;
            }
            if(negs[0] + 1 < endIndex) {
                int right = multiply(nums, negs[0]+1, endIndex);
                if(right > maxProduct) maxProduct = right;
            }
            return maxProduct;
        }
        else {
            int left = multiply(nums, beginIndex, negs[0]+1);
            int mid = multiply(nums, negs[0]+1, negs[negsCount-1]);
            int right = multiply(nums, negs[negsCount-1], endIndex);
            return left < right ? left * mid : right * mid;
        }
    }

    private static int multiply(int[] nums, int beginIndex, int endIndex) {
        int result = nums[beginIndex];
        for(int i = beginIndex + 1; i < endIndex; i++) {
            result *= nums[i];
        }
        return result;
    }
}