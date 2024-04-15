class Node {
    int vertex;
    int weight;

    public Node(int vertex, int weight) {
        this.vertex = vertex;
        this.weight = weight;
    }
}

class Solution {
    public int dijkstra(int source, List<List<Node>> adjList) {
        PriorityQueue<Node> minHeap = new PriorityQueue<>(Comparator.comparingInt(node -> node.weight));

        int[] distance = new int[adjList.size()];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[source] = 0;
        minHeap.offer(new Node(source, 0));

        while (!minHeap.isEmpty()) {
            Node curr = minHeap.remove();
            int currVertex = curr.vertex;

            for (Node neighbor: adjList.get(currVertex)) {
                int newDist = distance[currVertex] + neighbor.weight;

                if (newDist < distance[neighbor.vertex]) {
                    distance[neighbor.vertex] = newDist;
                    minHeap.offer(new Node(neighbor.vertex, newDist));
                }
            }
        }

        int maxi = 0;
        for (int i=1;i<distance.length;i++) {
            maxi = Math.max(maxi, distance[i]);
        }

        return (maxi == Integer.MAX_VALUE) ? - 1: maxi;
    }

    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<Node>> adjList = new ArrayList<>();
        for (int i=0;i<=n;i++) adjList.add(new ArrayList<>());

        for (int[] time: times) {
            int source = time[0];
            int dest = time[1];
            int weight = time[2];

            adjList.get(source).add(new Node(dest, weight));
        }

        return dijkstra(k, adjList);
    }
}