class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int num : nums) {
            pq.add(num); // Adding our numbers to PQ

            if (pq.size() > k) {
                pq.poll(); // Size exceeds k, removing the minimum element
            }
        }

        return pq.poll();
    }
}