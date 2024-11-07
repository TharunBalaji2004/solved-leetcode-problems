class Solution {
    private void dfs(List<List<Integer>> adjList, int node, boolean[] visited) {
        visited[node] = true;

        for (int neighbor: adjList.get(node)) {
            if (!visited[neighbor]) {
                dfs(adjList, neighbor, visited);
            }
        }
    }

    public int findCircleNum(int[][] isConnected) {
        List<List<Integer>> adjList = new ArrayList<>();
        int V = isConnected.length;

        for (int i=0;i<V;i++) adjList.add(new ArrayList<>());

        for (int i=0;i<V;i++) {
            for (int j=0;j<V;j++) {
                if (i != j && isConnected[i][j] == 1) adjList.get(i).add(j);
            } 
        }

        // DFS calls
        boolean[] visited = new boolean[V];
        int count = 0; 

        for (int i=0;i<V;i++) {
            if (!visited[i]) {
                count++;
                dfs(adjList, i, visited);
            }
        }

        return count;
    }
}