class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (i1, i2) -> i1[0] - i2[0]);
        int index = 0;
        
        for (int i=1;i<intervals.length;i++) {
            if (intervals[i][0] <= intervals[index][1]) {
                intervals[index][1] = Math.max(intervals[index][1], intervals[i][1]);
            } else {
                index++;
                intervals[index] = intervals[i];
            }
        }

        return Arrays.copyOf(intervals, index+1);
    }
}