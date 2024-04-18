class Solution {
    public int islandPerimeter(int[][] grid) {
        int perimeter = 0, rows = grid.length, cols = grid[0].length;

        for (int i=0;i<rows;i++) {
            for (int j=0;j<cols;j++) {
                if (grid[i][j] == 1) {
                    if ((i > 0 && grid[i-1][j] == 0) || i == 0) 
                        perimeter++;
                    if ((j > 0 && grid[i][j-1] == 0) || j == 0) 
                        perimeter++;
                    if ((i < rows-1 && grid[i+1][j] == 0) || i == rows-1) 
                        perimeter++;
                    if ((j < cols-1 && grid[i][j+1] == 0) || j == cols-1) 
                        perimeter++;
                }
            }
        }

        return perimeter;
    }
}