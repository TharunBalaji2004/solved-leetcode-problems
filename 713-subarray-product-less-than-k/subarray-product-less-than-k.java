class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k == 0) return 0;

        int n = nums.length, count = 0;

        for (int i=0;i<n;i++) {
            int mul = nums[i];
            if (mul < k) count++;
            if (mul >= k) continue;
            for (int j=i+1;j<n;j++) {
                mul = mul * nums[j];
                if (mul < k) count++;
                if (mul >= k) break;
            }
        }

        return count;
    }
}