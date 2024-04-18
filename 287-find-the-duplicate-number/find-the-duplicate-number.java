class Solution {
    public int findDuplicate(int[] arr) {
        int res = 0, n = arr.length;
        
        for (int i=0;i<n;i++) {
            if (arr[Math.abs(arr[i])] < 0) res = Math.abs(arr[i]);
            else arr[Math.abs(arr[i])] *= -1;
        }
        
        return res;
    }
}