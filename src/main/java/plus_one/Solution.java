package plus_one;

    public class Solution {
        public int[] plusOne(int[] digits) {
            int length = digits.length;
            if(length == 0) return digits;

            boolean overflow;
            for(int i = length - 1; i >= 0; i--) {
                overflow = ++digits[i] > 9;
                if(overflow) digits[i] -= 10;
                else return digits;
            }

            int[] result = new int[length + 1];
            result[0] = 1;
            System.arraycopy(digits, 0, result, 1, length);
            return result;
        }
    }