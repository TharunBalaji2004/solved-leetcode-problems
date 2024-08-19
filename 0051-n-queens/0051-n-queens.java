class Solution {
    public boolean isSafe(int col,int row, int n,char[][] board){
        int duprow = row;
        int dupcol  = col;

        while(row>=0 && col>=0){
            if(board[row][col] ==  'Q') return false;
            row--;
            col--;
        }

        row = duprow;
        col = dupcol;

        while(col>=0){
            if(board[row][col] == 'Q') return false;
            col--;
        }

        col = dupcol;

        while(row<n && col>=0){
            if(board[row][col] == 'Q') return false;
            row++;
            col--;
        }

        return true;
    }
    public List<String> construct(char[][] board){
        List<String> rowadd = new ArrayList<>();
        for(int i =0;i<board.length;i++){
            String row = new String(board[i]);
            rowadd.add(row);
        }
        return rowadd;
    }
    public void solve(List<List<String>> ans,char[][] board,int n ,int col){
        if(col == n){
            ans.add(construct(board));
            return;
        }

        for(int row = 0;row<n;row++){
            if(isSafe(col,row,n,board)){
                board[row][col] = 'Q';
                solve(ans,board,n,col+1);
                board[row][col] = '.';
            }
        }

    }
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        solve(ans,board,n,0);
        return ans;
    }
}