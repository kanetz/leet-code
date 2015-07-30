package divide_two_integers;

public class Solution {
    public int divide(int dividend, int divisor) {
        if(divisor == 1) return dividend;

        if(divisor == -1) {
            return dividend == Integer.MIN_VALUE ? Integer.MAX_VALUE : -dividend;
        }

        boolean isDividendNegative = Integer.signum(dividend) == -1;
        if(!isDividendNegative) dividend = -dividend;

        boolean isDivisorNegative = Integer.signum(divisor) == -1;
        if(!isDivisorNegative) divisor = -divisor;

        if(dividend > divisor) return 0;

        int result = 0;
        int boundary = divisor;
        int times = 1;

        for(int temp = boundary << 1; temp >= dividend && temp < 0; temp <<= 1) {
            boundary = temp;
            times <<= 1;
        }

        while(dividend <= divisor) {
            dividend -= boundary;
            result += times;

            while(times > 0 && boundary < dividend) {
                boundary >>= 1;
                times >>= 1;
            }
        }

        return (isDividendNegative ^ isDivisorNegative) ? -result : result;
    }
}