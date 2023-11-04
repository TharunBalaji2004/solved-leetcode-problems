class Solution:
    def getLastMoment(self, n: int, left: List[int], right: List[int]) -> int:
        if (not left): return n - min(right)
        if (not right): return max(left)
        val1 = max(left)
        val2 = n - min(right)
        return max(val1, val2)