from collections import defaultdict
class Solution:
    def getWinner(self, arr: List[int], k: int) -> int:
        d = defaultdict(int)
        if (k >= len(arr)):
            return max(arr)
        while (True):
            val1 = arr[0]
            val2 = arr[1] 
            winner, loser = [], []

            if (val1 > val2):
                winner = [0, val1]
                loser = [1, val2]
            else:
                winner = [1, val2]
                loser = [0, val1]
            
            d[winner[1]] += 1
            if (d[winner[1]] == k):
                return winner[1]

            arr.pop(loser[0])
            arr.append(loser[1])
            