class Solution:
    def insert(self, intervals: List[List[int]], newInterval: List[int]) -> List[List[int]]:
        # Add new interval to existing intervals
        intervals.append(newInterval)

        # Sort the updated intervals based on start time
        intervals.sort(key = lambda x: x[0])

        # Apply Merging intervals algo
        index = 0
        for i in range(1, len(intervals)):
            if (intervals[index][1] >= intervals[i][0]):
                # Update the previous interval in-place
                intervals[index][1] = max(intervals[index][1], intervals[i][1])
            else:
                # If condition not satisfied, update the latest merged index 
                index += 1
                intervals[index] = intervals[i]
        
        return intervals[:index + 1]