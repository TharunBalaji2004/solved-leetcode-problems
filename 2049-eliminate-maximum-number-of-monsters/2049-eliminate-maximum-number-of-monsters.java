class Solution {
    public int eliminateMaximum(int[] dist, int[] speed) {
        int n = dist.length;
        int[] arrival = new int[n];

        for (int i=0;i<n;i++){
            arrival[i] = (dist[i] - 1)/speed[i];
        }

        Arrays.sort(arrival);

        for (int i=0;i<n;i++){
            if (i > arrival[i]){
                return i;
            }
        }

        return n;
    }
}