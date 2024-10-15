class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> queue = new LinkedList<>();
        List<Integer> list = new ArrayList<>();

        for (int i=0;i<nums.length;i++) {
            while (!queue.isEmpty() && nums[i] > queue.getLast()) {
                queue.pollLast();
            }

            queue.addLast(nums[i]);

            if (i >= k && nums[i-k] == queue.getFirst()) {
                queue.pollFirst();
            }

            if (i >= k-1) {
                list.add(queue.getFirst());
            }
        }

        int[] res = new int[list.size()];
        for (int i=0;i<list.size();i++) {
            res[i] = list.get(i);
        }

        return res;
    }
}