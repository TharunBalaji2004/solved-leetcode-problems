class Solution {
    public void dfs(int i, int j, boolean[][] visited, char[][] grid) {
        int[][] dir = {{0, 1},{0, -1},{1, 0},{-1, 0}};
        visited[i][j] = true;

        for (int d=0;d<4;d++) {
            int currX = i + dir[d][0];
            int currY = j + dir[d][1];

            if (currX >= 0 && currY >= 0 && currX < grid.length && currY < grid[0].length && grid[currX][currY] == '1' && !visited[currX][currY]) dfs(currX, currY, visited, grid);
        }
    }

    public int numIslands(char[][] grid) {
        int islands = 0, rows = grid.length, cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];

        for (int i=0;i<rows;i++) { 
            for (int j=0;j<cols;j++) {
                if (!visited[i][j] && grid[i][j] == '1') {
                    islands++;
                    dfs(i, j, visited, grid);
                }
            }
        }

        return islands;
    }
}