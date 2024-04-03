class Solution {
    public boolean exist(char[][] board, String word) {
        for (int i=0;i<board.length;i++) {
            for (int j=0;j<board[0].length;j++) {
                if (helper(board, i, j, word, 0)) return true;
            }
        }

        return false;
    }

    public boolean helper(char[][] board, int row, int col, String word, int index) {
        // Base case 
        if (index == word.length()) return true;

        if (row > board.length-1 || row < 0 || col < 0 || col > board[0].length - 1 || board[row][col] != word.charAt(index)) return false;

        board[row][col] = '*';
        boolean res = helper(board, row-1, col, word, index+1) || helper(board, row, col-1, word, index+1) || helper(board, row, col+1, word, index+1) || helper(board, row+1, col, word, index + 1);

        board[row][col] = word.charAt(index);

        return res;
    }
}