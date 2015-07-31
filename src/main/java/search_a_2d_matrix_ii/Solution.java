package search_a_2d_matrix_ii;

public class Solution {
    static class Position {
        int row;
        int col;
        boolean matched;

        public Position(int row, int col) {
            this.row = row;
            this.col = col;
        }

        public Position(int row, int col, boolean matched) {
            this(row, col);
            this.matched = matched;
        }
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if(m == 0) return false;

        int n = matrix[0].length;
        if(n == 0) return false;

        return searchRecursive(matrix, target, new Position(0, 0), new Position(m, n));
    }

    private static boolean searchRecursive(int[][] matrix, int target, Position begin, Position end) {
        int m = end.row - begin.row;
        if(m < 1) return false;

        int n = end.col - begin.col;
        if(n < 1) return false;

        Position position = findIndexInDiagonal(matrix, target, begin, end);
        if(position == null) return false;
        if(position.matched) return true;

        int row = position.row;
        int col = position.col;

        return searchRecursive(matrix, target, new Position(row + 1, begin.col), new Position(end.row, col+1)) ||
                searchRecursive(matrix, target, new Position(begin.row, col + 1), new Position(row + 1, end.col));
    }

    private static Position findIndexInDiagonal(int[][] matrix, int target, Position begin, Position end) {
        int m = end.row - begin.row;
        int n = end.col - begin.col;
        int diagonalLen = m >= n ? m : n;

        int i = 0;
        int j = diagonalLen;

        while(i < j - 1) {
            int k = (i + j) >> 1;

            int row = begin.row + m * k / diagonalLen;
            int col = begin.col + n * k / diagonalLen;
            int v = matrix[row][col];

            if(target == v) return new Position(row, col, true);

            if(target < v) j = k;
            else i = k;
        }

        int row = begin.row + m * i / diagonalLen;
        int col = begin.col + n * i / diagonalLen;
        int v = matrix[row][col];
        return v > target ? null : new Position(row, col, v == target);
    }
}