class Solution {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int count = 0, n = nums.length;

        for (int i=n-1;i>=0;i--) {
            int left = 0, right = i-1;

            while (left < right) {
                // Base case
                if (nums[left] + nums[right] > nums[i]) {
                    count += right - left;
                    right--;
                } else {
                    left++;
                }
            }
        }

        return count;
    }
}