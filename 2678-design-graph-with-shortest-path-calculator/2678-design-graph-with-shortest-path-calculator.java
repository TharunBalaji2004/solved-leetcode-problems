class Graph {

    private List<List<int []>> adjacencyList;

    // Initialize the graph and add edges
    public Graph(int n, int[][] edges) {    
        adjacencyList = new ArrayList<>(n);

        for (int i=0;i<n;i++) {
            adjacencyList.add(new ArrayList<>());
        }

        for (int[] edge: edges) {
            addEdge(edge);
        }
    }
    
    public void addEdge(int[] edge) {
        // where edge[1] -> neighbor node edge[2] -> cost
        int[] edgeArray = {edge[1], edge[2]};
        adjacencyList.get(edge[0]).add(edgeArray);
    }
    
    public int shortestPath(int node1, int node2) {
        return dijkstra(node1, node2);
    }

    private int dijkstra(int start, int end) {
        int n = adjacencyList.size();
        int[] distances = new int[n];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[start] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(val -> val[0]));
        pq.add(new int[]{0, start});

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int currNode = current[1];
            int currCost = current[0];

            if (currCost > distances[currNode]) continue;

            if (currNode == end) return currCost;

            for (int[] edge: adjacencyList.get(currNode)) {
                int neighbor = edge[0];
                int edgeLength = edge[1];
                int newRouteCost = edgeLength + distances[currNode];

                if (distances[neighbor] > newRouteCost) {
                    distances[neighbor] = newRouteCost;
                    pq.add(new int[] {newRouteCost, neighbor});
                }
            }
        }

        if (distances[end] == Integer.MAX_VALUE) return -1;
        
        return distances[end];
    }
}

/**
 * Your Graph object will be instantiated and called as such:
 * Graph obj = new Graph(n, edges);
 * obj.addEdge(edge);
 * int param_2 = obj.shortestPath(node1,node2);
 */