class Solution {
    public int findJudge(int n, int[][] trust) {
        List<List<Integer>> adj = new ArrayList<>();

        for (int i=0;i<n;i++) adj.add(new ArrayList<>());

        for (int[] edge: trust) {
            adj.get(edge[0]-1).add(edge[1]-1);
        }

        // Traverse through adj list to adj list, to find adj = 0
        for (int i=0;i<n;i++) {
            List<Integer> children = adj.get(i);

            if (children.size() == 0) {
                for (int j=0;j<n;j++) {
                    if (i != j && !adj.get(j).contains(i)) return -1; 
                }
                return i+1;
            }
        }
        
        return -1;
    }
}