class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        int n = nums.length;
        List<Integer> list = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();

        for (int num: nums) {
            if (visited.contains(num)) {
                list.add(num);
            } else {
                visited.add(num);
            }
        }

        return list;
    }
}