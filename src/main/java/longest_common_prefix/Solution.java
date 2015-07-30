package longest_common_prefix;

public class Solution {
    public String longestCommonPrefix(String[] strs) {
        int strCount = strs.length;
        if(strCount == 0) return "";

        byte[] prefix = strs[0].getBytes();
        int prefixLength = prefix.length;

        for(int i = 1; i < strCount; i++) {
            byte[] s = strs[i].getBytes();
            int length = s.length;
            if(length < prefixLength) {
                prefixLength = length;
            }

            int j = 0;
            while(j < prefixLength && prefix[j] == s[j]) {
                j++;
            }

            if(j < prefixLength) {
                prefixLength = j;
            }

            if(prefixLength == 0) return "";
        }

        return new String(prefix, 0, prefixLength);
    }
}