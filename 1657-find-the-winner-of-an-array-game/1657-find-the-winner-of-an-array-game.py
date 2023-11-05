from collections import defaultdict
class Solution:
    def getWinner(self, arr: List[int], k: int) -> int:
        curr = arr[0]
        win = 0

        for i in range(1, len(arr)):
            if (arr[i] > curr):
                curr = arr[i]
                win = 0
                
            win += 1

            if (win == k):
                break

        return curr
            