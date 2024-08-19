class Solution {
    private boolean queenSafe(int row, int col, int n, char[][] board) {
        int copyRow = row, copyCol = col;

        // Case 1: Left upward diagonal
        while (row >= 0 && col >= 0) {
            if (board[row][col] == 'Q') return false;
            row--;
            col--;
        }

        row = copyRow;
        col = copyCol;

        // Case 2: Left Horizontal
        while (col >= 0) {
            if (board[row][col] == 'Q') return false;
            col--;
        }

        col = copyCol;

        // Case 3: Left Downward diagonal
        while (row < n && col >= 0) {
            if (board[row][col] == 'Q') return false;
            row++;
            col--;
        }

        return true;
    }

    private List<String> convert(char[][] board) {
        List<String> res = new ArrayList<>();
        
        for (int i=0;i<board.length;i++) {
            String row = new String(board[i]);
            res.add(row);
        }

        return res;
    }

    private void helper(char[][] board, List<List<String>> ans, int n, int col) {
        // Base case
        if (col == n) {
            List<String> solution = convert(board);
            ans.add(solution);
            return;
        }

        // Recursive case
        for (int row=0;row<n;row++) {
            // Queen safe function
            if (queenSafe(row, col, n, board)) {
                board[row][col] = 'Q';
                helper(board, ans, n, col+1);
                board[row][col] = '.';
            }
        }
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();

        // Create chess board
        char[][] board = new char[n][n];

        for (int i=0;i<n;i++) {
            for (int j=0;j<n;j++) {
                board[i][j] = '.';
            }
        }

        helper(board, ans, n, 0);

        return ans;
    }
}