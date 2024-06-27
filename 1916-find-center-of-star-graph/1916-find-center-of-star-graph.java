class Solution {
    public int findCenter(int[][] edges) {
        int common = 0, a = edges[0][0], b = edges[0][1], c = edges[1][0], d = edges[1][1];

        if (a == c || a == d) common = a;
        if (b == c || b == d) common = b;

        for (int i=2;i<edges.length;i++) {
            if (!(edges[i][0] == common || edges[i][1] == common)) return -1;
        }
        
        return common;
    }
}