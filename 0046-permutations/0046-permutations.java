class Solution {
    private void helper(int[] nums, List<Integer> temp, List<List<Integer>> res, boolean[] picked) {
        // Base case
        if (temp.size() == nums.length) {
            res.add(new ArrayList<>(temp));
            return;
        }

        // Recursive case
        for (int i=0;i<nums.length;i++) {
            if (!picked[i]) {
                picked[i] = true;
                temp.add(nums[i]);

                helper(nums, temp, res, picked);

                // Reset
                picked[i] = false;
                temp.remove(temp.size() - 1);
            }
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        boolean[] picked = new boolean[nums.length];

        helper(nums, temp, res, picked);

        return res;
    }
}