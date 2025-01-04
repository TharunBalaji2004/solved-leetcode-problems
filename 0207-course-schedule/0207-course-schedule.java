class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // STEP 1: Create adjList
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i=0;i<numCourses;i++) adjList.add(new ArrayList<>());
        for (int[] course: prerequisites) {
            adjList.get(course[1]).add(course[0]);
        }

        // STEP 2: Create the indegree array
        int[] indegree = new int[numCourses];
        for (int[] course: prerequisites) {
            indegree[course[0]]++;
        }

        // STEP 3: Push the zero indegree nodes to the queue
        Queue<Integer> queue = new LinkedList<>();
        for (int i=0;i<numCourses;i++) {
            if (indegree[i] == 0) queue.add(i);
        }

        // STEP 4: Create res array, and visited the neighbors
        int[] res = new int[numCourses];
        int index = 0;

        while (!queue.isEmpty()) {
            int node = queue.remove();
            res[index] = node;
            index++;

            for (int neighbor:adjList.get(node)) {
                indegree[neighbor]--;

                if (indegree[neighbor] == 0) {
                    queue.add(neighbor);
                }
            }
        }

        // We have visited all the courses, so we can finish all the courses
        if (index == numCourses) return true;

        return false;
    }
}