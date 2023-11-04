class Solution {
    public int getLastMoment(int n, int[] left, int[] right) {
        int time = 0;

        for (int l: left){
            time = Math.max(time, l);
        }

        for (int r: right){
            time = Math.max(time, n-r);
        }

        return time;
    }
}