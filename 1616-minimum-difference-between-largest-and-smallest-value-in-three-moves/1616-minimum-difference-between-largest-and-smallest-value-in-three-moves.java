class Solution {
    public int minDifference(int[] nums) {
        if (nums.length <= 4) return 0;

        // First three smallest elements
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int num : nums) {
            maxHeap.offer(num);
            if (maxHeap.size() > 4) maxHeap.poll();
        }

        List<Integer> list1 = new ArrayList<>(maxHeap);
        Collections.sort(list1);

        // First three largest elements
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int num : nums) {
            minHeap.offer(num);
            if (minHeap.size() > 4) minHeap.poll();
        }

        List<Integer> list2 = new ArrayList<>(minHeap);
        Collections.sort(list2);

        int mini = Integer.MAX_VALUE;
        for (int i=0;i<4;i++) mini = Math.min(mini, list2.get(i) - list1.get(i));

        return mini;
    }
}