class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        for (int row=0;row<rows;row++) {
            if (matrix[row][cols-1] >= target) {
                
                for (int j=cols-1;j>=0;j--) {
                    if (matrix[row][j] == target) return true;
                }

                return false;
            }
        }
        
        return false;
    }
}