class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // STEP 1: Count the frequency of elements
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }   

        // STEP 2: Create the PQ
        PriorityQueue<Integer> pq = new PriorityQueue<>(
            (a, b) -> map.get(b) - map.get(a)  // Freq. based Descending order
        );

        // STEP 3: We have to add the elements
        for (int num : map.keySet()) {
            pq.add(num);
        }

        int[] res = new int[k];
        for (int i=0;i<k;i++) {
            res[i] = pq.poll();
        }

        return res;
    }
}