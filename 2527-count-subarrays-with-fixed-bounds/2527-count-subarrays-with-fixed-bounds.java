class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        Queue<Integer> q = new LinkedList<>();
        int minElementIndex = -1;
        int maxElementIndex = -1;
        Long res= 0L;
        for(int i=0;i<nums.length;i++){
            if(nums[i] >= minK && nums[i] <= maxK){
                q.add(nums[i]);
                if(nums[i] == minK) minElementIndex = q.size();
                if(nums[i] == maxK) maxElementIndex = q.size();
                if(minElementIndex != -1 && maxElementIndex!= -1){
                    res += Long.valueOf(Math.min(minElementIndex,maxElementIndex));
                } 
                
            }
            else{
                q.clear();
                minElementIndex = -1;
                maxElementIndex = -1;
            }
        }
        return res;
    }
}