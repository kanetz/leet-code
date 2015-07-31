package spiral_matrix;

public class Solution {

    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        fillMatrix(matrix, n, 0, 1);
        return matrix;
    }

    private static void fillMatrix(int[][] matrix, int n, int offset, int startNum) {
        if(n < 1) return;

        int num = startNum;
        for(int col = offset; col < offset + n; col++) {
            matrix[offset][col] = num++;
        }
        for(int row = offset + 1; row < offset + n; row++) {
            matrix[row][offset + n - 1] = num++;
        }
        for(int col = offset + n - 2; col >= offset; col--) {
            matrix[offset + n - 1][col] = num++;
        }
        for(int row = offset + n - 2; row > offset; row--) {
            matrix[row][offset] = num++;
        }

        if(n > 2) {
            fillMatrix(matrix, n - 2, offset + 1, num);
        }
    }
}