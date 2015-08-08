package integer_to_roman;

public class Solution {

    static final char[][] ROMON_NUMERALS = new char[][]{
            {'I', 'V'},
            {'X', 'L'},
            {'C', 'D'},
            {'M'}
    };

    public String intToRoman(int num) {
        StringBuilder result = new StringBuilder();
        int digit = -1;
        int den = 1;

        for(int i = 1; i <= num; i *= 10) {
            den = i;
            digit++;
        }

        while(num != 0) {
            int q = num / den;
            num %= den;
            if(q == 9) {
                result.append(ROMON_NUMERALS[digit][0]).append(ROMON_NUMERALS[digit + 1][0]);
            }
            else if(q >= 5) {
                result.append(ROMON_NUMERALS[digit][1]);
                for(int i = 0; i < q - 5; i++) {
                    result.append(ROMON_NUMERALS[digit][0]);
                }
            }
            else if(q == 4) {
                result.append(ROMON_NUMERALS[digit][0]).append(ROMON_NUMERALS[digit][1]);
            }
            else {
                for(int i = 0; i < q; i++) {
                    result.append(ROMON_NUMERALS[digit][0]);
                }
            }

            den /= 10;
            digit--;
        }

        return result.toString();
    }
}