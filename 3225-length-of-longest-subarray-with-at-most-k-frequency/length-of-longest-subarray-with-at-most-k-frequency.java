class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int maxLength = 1, n = nums.length;
        
        // Sliding window
        int left = 0, right = 0;
        Map<Integer, Integer> freq = new HashMap<>();

        while (left < n && right < n) {
            freq.put(nums[right], freq.getOrDefault(nums[right], 0)+1);

            while (freq.get(nums[right]) > k) {
                freq.put(nums[left], freq.get(nums[left]) - 1);
                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);
            right++;
        }

        return maxLength;
    }
}