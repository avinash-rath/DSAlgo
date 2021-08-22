package swiggy;

/**
 * Given a binary matrix (containing only 0 and 1) of order n×n. All rows are sorted already, We need to find the row number with the maximum number of 1s. Also, find the number of 1 in that row. 
Note: in case of a tie, print the smaller row number.
 

Examples : 

Input : mat[3][3] = {0, 0, 1,
                     0, 1, 1,
                     0, 0, 0}
Output : Row number = 2, MaxCount = 2

Input : mat[3][3] = {1, 1, 1,
                     1, 1, 1,
                     0, 0, 0}
Output : Row number = 1, MaxCount = 3
 */

class RowWithMaxNumberOf1s {
    public int findRow(int[][] matrix) {
        int i,j;
        i = 0;
        j = matrix[0].length-1;
        int ans = -1;
        while(i < matrix.length) {
            while(j >= 0 && matrix[i][j] == 1) {
                j--;
                ans = i;
            }
            i++;
        }
        // number of 1s can be found out by `matrix[0].length - j - 1`
        return ans;
    }
}