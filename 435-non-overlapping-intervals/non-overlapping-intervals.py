class Solution:
    def eraseOverlapIntervals(self, intervals: List[List[int]]) -> int:
        # Logic: Sort the intervals based on the end time, to remove minimum overlapped intervals
        ans = 0
        intervals.sort(key = lambda x: x[1])
        index = 0

        for i in range(1, len(intervals)):
            # Current interval overlaps
            if (intervals[i][0] < intervals[index][1]):
                ans += 1
            else:
                index = i

        return ans