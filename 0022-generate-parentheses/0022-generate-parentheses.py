class Solution:
    def generateParenthesis(self, n: int) -> List[str]:
        res = []
        s = []

        def backtrack(open, closed):
            if (open == closed == n):
                res.append("".join(s))
                return
            
            if (open < n):
                s.append("(")
                backtrack(open + 1, closed)
                s.pop()
            
            if (closed < open):
                s.append(")")
                backtrack(open, closed + 1)
                s.pop()

        backtrack(0, 0)
        return res        


            