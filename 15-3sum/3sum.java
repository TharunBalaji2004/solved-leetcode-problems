class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Set<List<Integer>> set = new HashSet<>();
        List<List<Integer>> res = new ArrayList<>();

        // Sort the array
        Arrays.sort(nums);

        // Three pointers
        for (int i=0;i<n;i++) {
            int j = i+1;
            int k = n-1;
            
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) {
                    List<Integer> ans = Arrays.asList(nums[i], nums[j], nums[k]);
                    set.add(ans);
                }

                if (sum < 0) j++;
                else k--;
            }
        }

        for (List<Integer> list: set) {
            res.add(new ArrayList<>(list));
        }

        return res;
    }
}