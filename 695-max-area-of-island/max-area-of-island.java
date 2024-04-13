class Solution {
    public int helper(int[][] grid, int i, int j) {
        // Base case
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0) return 0;

        grid[i][j] = 0; // mark as visited

        return 1 + helper(grid,i+1,j) + helper(grid,i-1,j) + helper(grid,i,j-1) + helper(grid,i,j+1);
    }

    public int maxAreaOfIsland(int[][] grid) {
        int rows = grid.length, cols = grid[0].length, maxi = 0;

        for (int i=0;i<rows;i++) {
            for (int j=0;j<cols;j++) {
                if (grid[i][j] == 1) { // should be land
                    maxi = Math.max(maxi, helper(grid, i, j));
                }
            }
        }

        return maxi;
    }
}