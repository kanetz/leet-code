package implement_strstr;

public class Solution {
    public int strStr(String haystack, String needle) {
        return kmpMatcher(haystack.getBytes(), needle.getBytes());
    }

    private static int kmpMatcher(byte[] s, byte[] p) {
        int n = s.length;
        int m = p.length;

        if(m == 0) return 0;
        if(n < m) return -1;

        int[] numPrefix = numPrefix(p);
        int i = 0;
        int j = 0;
        int limit = n - m;
        while(i <= limit && j < m) {
            if(s[i + j] == p[j]) {
                j++;
            }
            else {
                int k = numPrefix[j];
                if(k == -1) {
                    i++;
                    j = 0;
                }
                else {
                    i += j - k;
                    j = k;
                }
            }
        }

        return j == m ? i : -1;
    }

    private static int[] numPrefix(byte[] p) {
        int length = p.length;

        int[] a = new int[length + 1];
        a[0] = -1;
        a[1] = 0;

        int i = 2;
        int j = 0;
        while(i <= length) {
            if(p[j] == p[i - 1]) {
                a[i++] = ++j;
            }
            else if(j == 0) {
                a[i++] = 0;
            }
            else {
                j = a[j];
            }
        }
        return a;
    }
}