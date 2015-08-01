package number_of_islands;

public class Solution {

     static class Land {
        static int nextIndex = 0;

        int index;
        Land connectedTo;

        Land() {
            this.index = nextIndex++;
        }

        static boolean connect(Land i1, Land i2) {
            Land r1 = rootOf(i1);
            Land r2 = rootOf(i2);
            if(r1 == r2) return false;

            if(r1.index <= r2.index) {
                r2.connectedTo = r1;
            }
            else {
                r1.connectedTo = r2;
            }
            return true;
        }

        private static Land rootOf(Land i) {
            while(i.connectedTo != null) {
                i = i.connectedTo;
            }
            return i;
        }
    }

    public int numIslands(char[][] grid) {
        int m = grid.length;
        if(m < 1) return 0;

        int n = grid[0].length;
        if(n < 1) return 0;

        int count = 0;
        Land[][] c = new Land[m][n];

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                char slot = grid[i][j];
                if(slot == '0') continue;

                Land top = i > 0 ? c[i-1][j] : null;
                Land left = j > 0 ? c[i][j-1] : null;

                if(top == null && left == null) {
                    c[i][j] = new Land();
                    count++;
                }
                else if(top != null && left != null) {
                    if(Land.connect(top, left)) count--;
                    c[i][j] = top;
                }
                else {
                    c[i][j] = top != null ? top : left;
                }
            }
        }

        return count;
    }
}