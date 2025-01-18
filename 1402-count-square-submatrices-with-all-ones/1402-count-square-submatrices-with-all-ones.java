class Solution {
    public int countSquares(int[][] matrix) {
        int rows = matrix.length, cols = matrix[0].length;
        int[][] dp = new int[rows+1][cols+1];
        int res = 0;

        for (int i=1;i<=rows;i++) {
            for (int j=1;j<=cols;j++) {
                if (matrix[i-1][j-1] == 1) {
                    dp[i][j] = 1 + Math.min(Math.min(dp[i][j-1], dp[i-1][j]), dp[i-1][j-1]);  

                    res += dp[i][j];  
                }
            }
        }

        return res;
    }
}