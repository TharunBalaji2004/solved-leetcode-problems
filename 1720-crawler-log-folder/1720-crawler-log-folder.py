class Solution:
    def minOperations(self, logs: List[str]) -> int:
        count = 0
        for dir in logs:
            if (dir == "../"):
                if (count != 0):
                    count -= 1
            elif (dir != "./"):
                count += 1

        return count