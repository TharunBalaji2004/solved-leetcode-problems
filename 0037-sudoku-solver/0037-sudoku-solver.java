class Solution {
    private boolean isValid(int row, int col, char[][] board, int num) {
        for (int i=0;i<9;i++) {
            // Rule 1 - Horizontal
            if (board[row][i] == num) return false;

            // Rule 2 - Vertical
            if (board[i][col] == num) return false;

            // Rule 3  - Subgrid
            if (board[3 * (row/3) + (i/3)][3 * (col/3) + i%3] == num) return false;
        }

        return true;
    }

    private boolean helper(char[][] board) {
        // Traverse
        for (int i=0;i<9;i++) {
            for (int j=0;j<9;j++) {
                // Empty sqaure
                if (board[i][j] == '.') {
                    for (char num='1';num<='9';num++) {
                        // Check for validity
                        if (isValid(i, j, board, num)) {
                            board[i][j] = num;

                            if (helper(board)) return true;
                            else board[i][j] = '.'; // Reset
                        }
                    }

                    return false;
                }
            }
        }

        return true;
    }

    public void solveSudoku(char[][] board) {
        helper(board);
    }
}