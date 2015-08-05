package fraction_to_recurring_decimal;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if(denominator == 0) return "NaN";

        if(numerator == 0) return "0";

        long n = numerator;
        long d = denominator;
        StringBuilder result = new StringBuilder();

        boolean isNumratorNeg = n < 0;
        if(isNumratorNeg) n = -n;

        boolean isDenominatorNeg = d < 0;
        if(isDenominatorNeg) d = -d;

        if(isNumratorNeg ^ isDenominatorNeg) result.append("-");

        if(denominator == 1) {
            return result.append(n).toString();
        }

        Map<Long, Integer> map = new HashMap<>();
        boolean isFraction = false;

        while(true) {
            Integer i = map.get(n);
            if(i != null) {
                int length = result.length();
                String recurringPart = result.substring(i, length);
                return result.delete(i, length)
                        .append("(").append(recurringPart).append(")")
                        .toString();
            }

            long q = n / d;
            result.append(q);

            long r = n % d;
            if(r == 0) break;

            if(!isFraction) {
                result.append(".");
                isFraction = true;
            }
            else {
                map.put(n, result.length() - 1);
            }

            n = r * 10;
        }

        return result.toString();
    }
}