class Solution {
    public HashMap<String, List<Integer>> directions;

    public Solution() {
        directions = new HashMap<>();
        directions.put("U", Arrays.asList(-1, 0));
        directions.put("D", Arrays.asList(1, 0));
        directions.put("L", Arrays.asList(0, -1));
        directions.put("R", Arrays.asList(0, 1));
    }

    public boolean exist(char[][] board, String word) {
        List<List<Integer>> startInd = new ArrayList<List<Integer>>();
        boolean res = false;

        // Storing the indexes of initial character of word
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (word.charAt(0) == board[i][j])
                    startInd.add(Arrays.asList(i, j));
            }
        }

        // Performing Backtracking form stored index
        for (int ind = 0; ind < startInd.size(); ind++) {   
            StringBuilder slate = new StringBuilder();
            int row = startInd.get(ind).get(0);
            int col = startInd.get(ind).get(1);
            int pos = 0;
            slate.append(board[row][col]);  // Append the initial character
            res = helper(board, word, slate, row, col, pos + 1);
            if (res) break;
        }

        return res;
    }

    public boolean helper(char[][] board, String word, StringBuilder slate, int row, int col, int pos) {
        // Base case (when slate equals original word)
        if (slate.toString().equals(word)) return true;
        
        // Mark the visited character as '*'
        board[row][col] = '*';

        for (Map.Entry<String, List<Integer>> dir : directions.entrySet()) {
            List<Integer> value = dir.getValue();
            int newRow = row + value.get(0);
            int newCol = col + value.get(1);

            if (isValid(newRow, newCol, board.length, board[0].length) && board[newRow][newCol] != '*' && board[newRow][newCol] == word.charAt(pos)) {
                slate.append(board[newRow][newCol]);
                if (helper(board, word, slate, newRow, newCol, pos + 1)) return true;
                slate.deleteCharAt(slate.length() - 1);
            }
        }

        // Unmark the visited character with original character
        board[row][col] = slate.charAt(pos - 1);  

        return false;
    }

    public static boolean isValid(int row, int col, int m, int n) {
        return (row >= 0 && row < m) && (col >= 0 && col < n);
    }
}
