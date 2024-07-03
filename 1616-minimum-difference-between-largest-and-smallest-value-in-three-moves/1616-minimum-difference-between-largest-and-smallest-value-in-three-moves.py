class Solution:
    def minDifference(self, nums: List[int]) -> int:
        if (len(nums) <= 4):
            return 0

        nums.sort()
        mini = float("inf")
        
        for left in range(0, 4):
            right = len(nums) - 4 + left
            mini = min (mini, nums[right] - nums[left])

        return mini


