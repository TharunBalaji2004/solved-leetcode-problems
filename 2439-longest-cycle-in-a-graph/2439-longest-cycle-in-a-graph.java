class Solution {
    int res = -1;

    private void dfs(int node, int[] edges, Map<Integer, Integer> dist, boolean[] visited) {
        visited[node] = true;
        int neighbor = edges[node];

        if (neighbor != -1 && !visited[neighbor]) {
            dist.put(neighbor, dist.get(node) + 1);
            dfs(neighbor, edges, dist, visited);   
        } else if (neighbor != -1 && dist.containsKey(neighbor)) {
            res = Math.max(res, dist.get(node) - dist.get(neighbor) + 1);
        }
    }

    public int longestCycle(int[] edges) {
        int n = edges.length;
        boolean[] visited = new boolean[n];
        
        for (int i=0;i<n;i++) {
            if (!visited[i]) {
                Map<Integer, Integer> dist = new HashMap<>();
                dist.put(i, 1);
                dfs(i, edges, dist, visited);
            }
        }

        return res;
    }
}