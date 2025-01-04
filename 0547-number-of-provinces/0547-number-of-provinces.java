class Solution {
    private void dfs(int source, List<List<Integer>> adjList, boolean[] visited) {
        visited[source] = true;

        for (int neighbor: adjList.get(source)) {
            if (!visited[neighbor]) {
                dfs(neighbor, adjList, visited);
            }
        }
    }

    public int findCircleNum(int[][] isConnected) {
        int V = isConnected.length;

        List<List<Integer>> adjList = new ArrayList<>();
        for (int i=0;i<V;i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i=0;i<V;i++) {
            for (int j=0;j<V;j++) {
                if (i != j && isConnected[i][j] == 1) {
                    adjList.get(i).add(j);
                }
            }
        }

        boolean[] visited = new boolean[V];
        int provinces = 0;

        for (int i=0;i<V;i++) {
            if (!visited[i]) {
                provinces++;
                dfs(i, adjList, visited);
            }
        }

        return provinces;
    }
}