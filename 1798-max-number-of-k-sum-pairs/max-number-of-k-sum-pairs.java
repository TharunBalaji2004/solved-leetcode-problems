class Solution {
    public int maxOperations(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int pairs = 0;

        for (int num: nums) {
            int diff = k - num;

            if (map.containsKey(diff)) {
                pairs++;

                if (map.get(diff) == 1) map.remove(diff);
                else map.put(diff, map.get(diff) - 1);
            } else {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
        }


        return pairs;
    }
}