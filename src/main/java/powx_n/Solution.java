package powx_n;

public class Solution {
    public double myPow(double x, int n) {
        if(n == 0) return 1.0D;

        int r = Double.compare(x, 0D);
        boolean xIs0 = r == 0;
        boolean xIsNegative = r < 0;
        if(xIs0) return n < 0 ? Double.NaN : x;

        if(Double.compare(x, 1D) == 0) return x;

        if(n < 0) {
            x = 1.0 / x;
            n = -n;
        }

        if(xIsNegative) {
            x = -x;
        }

        double result = xIsNegative && (n & 1) == 1 ? -1D : 1D;

        while(n > 0) {
            if((n & 1) == 1) {
                result *= x;
            }
            n >>= 1;
            x *= x;
        }

        return result;
    }
}