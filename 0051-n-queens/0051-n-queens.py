class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        board = [["."]*n for _ in range(n)]
        res = []

        self.helper(0, res, board)

        return res
    
    def helper(self, row, res, board) -> None:
        # Base case
        if (row == len(board)):
            res.append([''.join(row) for row in board])
            return
        
        # Recursive case
        for col in range(0, len(board)):
            if (self.isValid(row, col, board)):
                board[row][col] = "Q"
                self.helper(row+1, res, board)
                board[row][col] = "."
    
    def isValid(self, row, col, board) -> bool:
        # Check column (towards UP)
        i = row
        while (i >= 0):
            if (board[i][col] == "Q"):
                return False
            i -= 1
        
        # Check Diagonal Left
        i = row
        j = col
        while (i >= 0 and j >= 0):
            if (board[i][j] == "Q"):
                return False
            i -= 1
            j -= 1

        # Check Digaonal Right
        i = row
        j = col
        while (i >= 0 and j < len(board)):
            if (board[i][j] == "Q"):
                return False
            i -= 1
            j += 1
        
        return True