class Solution {
    public int maxFrequencyElements(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int maxFreq = 0, count = 0;

        for (int num: nums) {
            map.put(num , map.getOrDefault(num, 0) + 1);
            maxFreq = Math.max(maxFreq, map.get(num));
        }

        for (int key: map.keySet()) {
            if (map.get(key) == maxFreq) count++;
        }

        return count * maxFreq;
    }
}