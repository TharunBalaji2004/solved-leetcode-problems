class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        List<Integer> list = new ArrayList<>();
        Deque<Integer> d = new LinkedList<>();
        int n = nums.length;

        for (int ind = 0;ind < n;ind++) {
            // Check with the deque from last
            while (!d.isEmpty() && nums[ind] > d.getLast()) {
                d.pollLast();
            }

            d.addLast(nums[ind]);

            if (ind >= k && nums[ind - k] == d.getFirst()) {
                d.pollFirst();
            }

            if (ind >= k-1) {
                list.add(d.getFirst()); // adding to the res list
            }
        }

        int[] res = new int[list.size()];
        for (int i = 0;i<list.size();i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}