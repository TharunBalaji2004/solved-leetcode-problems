class Solution {

    public boolean exist(char[][] board, String word) {
        // Iterate to find the starting character
        for (int i=0;i<board.length;i++) {
            for (int j=0;j<board[0].length;j++){
                if (findWord(board, i, j, word, 0)) return true;
            }
        }

        return false;
    }

    public boolean findWord(char[][] board, int row, int col, String word, int ind) {
        // Base case
        if (ind == word.length()) return true;

        // Check cell is valid or not
        if (row > board.length-1 || row < 0 || col < 0 || col > board[0].length - 1 || board[row][col] != word.charAt(ind)) return false;

        // Mark cell as visited
        board[row][col] = '*';

        boolean res = findWord(board, row-1, col, word, ind+1) || 
                    findWord(board, row, col-1, word, ind+1) || 
                    findWord(board, row+1, col, word, ind+1) || 
                    findWord(board, row, col+1, word, ind+1);

        // Unmark the cell to original character
        board[row][col] = word.charAt(ind);

        return res;
    } 

}
