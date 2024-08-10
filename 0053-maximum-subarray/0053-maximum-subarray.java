class Solution {
    public int maxSubArray(int[] nums) {
        int maxi = Integer.MIN_VALUE, currSum = 0;

        for (int num : nums) {
            currSum += num;
            maxi = Math.max(maxi, currSum);

            if (currSum < 0) { // Negative sum
                currSum = 0; // Reset to 0
            }
        }

        return maxi;
    }
}