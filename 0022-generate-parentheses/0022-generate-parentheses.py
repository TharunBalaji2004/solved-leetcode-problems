class Solution:
    def generateParenthesis(self, n: int) -> List[str]:
        res = []
        s = ""

        def dfs(open, closed, s):
            if (len(s) == 2*n):
                res.append(s)
                return

            if (open < n):
                dfs(open + 1, closed, s + "(")
            if (closed < open):
                dfs(open, closed + 1, s + ")")
        
        dfs(0,0,s)
        return res

            