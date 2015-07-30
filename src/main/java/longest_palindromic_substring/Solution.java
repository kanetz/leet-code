package longest_palindromic_substring;

public class Solution {

    public String longestPalindrome(String s) {
        int n = s.length();
        if(n < 2) return s;

        int maxLength = 0;
        int maxBeginIndex = -1;

        for(int pivotOffset = 0; pivotOffset < n - 1; pivotOffset++) {
            int pivot = n - 1 - pivotOffset;
            boolean isPivotEven = (pivot & 1) == 0;
            int midLeft = (isPivotEven ? pivot - 2 : pivot - 1) >> 1;
            int midRight = (isPivotEven ? pivot + 2 : pivot + 1) >> 1;

            int leftCapacity = midLeft + 1;
            int rightCapacity = n - midRight;
            int maxHalfCapacity = leftCapacity < rightCapacity ? leftCapacity : rightCapacity;
            int maxCapacity = isPivotEven ? (maxHalfCapacity << 1) + 1 : maxHalfCapacity << 1;
            if(maxCapacity <= maxLength) break;

            for(int halfLen = 1; halfLen <= maxHalfCapacity; halfLen++) {
                int beginIndex = getBeginIndex(midLeft, halfLen);
                int endIndex = getEndIndex(midRight, halfLen);
                if(s.charAt(beginIndex) != s.charAt(endIndex)) break;

                int length = endIndex - beginIndex + 1;
                if(length > maxLength) {
                    maxLength = length;
                    maxBeginIndex = beginIndex;
                }
            }

            if(pivotOffset > 0) {
                pivot = n - 1 + pivotOffset;
                midLeft = (isPivotEven ? pivot - 2 : pivot - 1) >> 1;
                midRight = (isPivotEven ? pivot + 2 : pivot + 1) >> 1;

                for(int halfLen = 1; halfLen <= maxHalfCapacity; halfLen++) {
                    int beginIndex = getBeginIndex(midLeft, halfLen);
                    int endIndex = getEndIndex(midRight, halfLen);
                    if(s.charAt(beginIndex) != s.charAt(endIndex)) break;

                    int length = endIndex - beginIndex + 1;
                    if(length > maxLength) {
                        maxLength = length;
                        maxBeginIndex = beginIndex;
                    }
                }
            }

        }

        if(maxLength == 0) return s.substring(0, 1);

        return s.substring(maxBeginIndex, maxBeginIndex + maxLength);
    }

    private static int getBeginIndex(int midLeft, int halfLen) {
        return midLeft - (halfLen - 1);
    }

    private static int getEndIndex(int midRight, int halfLen) {
        return midRight + (halfLen - 1);
    }

}