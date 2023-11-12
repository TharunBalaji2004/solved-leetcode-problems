class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        // HashMap to store the buses passing through each bus stop
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        // Queue for BFS traversal
        Queue<Integer> q = new LinkedList<>();
        // HashSet to track visited buses
        HashSet<Integer> visited = new HashSet<>();

        // If source and target are the same, no need to take any bus
        if (source == target) return 0;

        // Iterating through bus stops and storing the bus numbers passing through each stop
        for (int i = 0; i < routes.length; i++) {
            for (int j = 0; j < routes[i].length; j++) {
                ArrayList<Integer> buses = map.getOrDefault(routes[i][j], new ArrayList<>());
                buses.add(i);
                map.put(routes[i][j], buses);
            }
        }

        // Adding the starting bus stop to the queue
        q.offer(source);

        int ret = 0; // used to keep track of the number of buses needed
        while (!q.isEmpty()) {
            int len = q.size();
            ret++;

            for (int i = 0; i < len; i++) {
                int curr = q.poll();
                ArrayList<Integer> buses = map.get(curr);

                for (int bus : buses) {
                    if (visited.contains(bus)) continue;
                    visited.add(bus);
                    for (int j = 0; j < routes[bus].length; j++) {
                        if (routes[bus][j] == target) return ret; // Found the target bus stop
                        q.offer(routes[bus][j]);
                    }
                }
            }
        }

        return -1;
    }
}
