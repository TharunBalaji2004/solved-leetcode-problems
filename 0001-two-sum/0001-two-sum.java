class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] temp = Arrays.copyOf(nums, nums.length);

        Arrays.sort(temp);
        int left = 0, right = nums.length - 1;

        while (left < right) {
            if (temp[left] + temp[right] == target) break;
            else if (temp[left] + temp[right] < target) left++;
            else right--;
        }

        int[] res = new int[2];
        Arrays.fill(res, -1);

        for (int i=0;i<nums.length;i++) {
            if (temp[left] == nums[i] && res[0] == -1) res[0] = i;
            else if (temp[right] == nums[i] && res[1] == -1) res[1] = i;
        }

        return res;
    }
}           