class Solution {
    // Apply DFS on each room
    public void helper(List<List<Integer>> rooms, boolean[] visited, int curr) {
        // Base case - If room is already visited
        if (visited[curr]) return;

        visited[curr] = true;

        // Visit rooms using keys
        for (int room: rooms.get(curr)) {
            helper(rooms, visited, room);
        }
    }

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];

        helper(rooms, visited, 0);
        
        for (boolean room: visited) {
            if (!room) return false;
        }

        return true;
    }
}