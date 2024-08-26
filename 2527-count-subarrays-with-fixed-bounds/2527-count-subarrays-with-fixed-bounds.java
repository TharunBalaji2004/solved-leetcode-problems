class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        long res = 0;
        int minPos = -1, maxPos = -1;
        Queue<Integer> queue = new LinkedList<>();

        // Traverse the elements
        for (int num : nums) {
            // num falls in the range
            if (num >= minK && num <= maxK) {
                
                queue.add(num);
                if (num == minK) minPos = queue.size();
                if (num == maxK) maxPos = queue.size();

                if (minPos != -1 && maxPos != -1) {
                    res += (long) Math.min(minPos, maxPos);
                }

            } else {
                queue.clear();
                minPos = -1;
                maxPos = -1;
            }
        }

        return res;
    }
}