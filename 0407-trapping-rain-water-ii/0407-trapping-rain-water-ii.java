class Node {
    int height;
    int row;
    int col;

    public Node(int height, int row, int col) {
        this.height = height;
        this.row = row;
        this.col = col;
    }
}

class Solution {
    public int trapRainWater(int[][] heightMap) {
        int[] dirsRow = {0, 0, 1, -1};
        int[] dirsCol = {1, -1, 0, 0};
        int total = 0;
        int rows = heightMap.length, cols = heightMap[0].length;
        boolean[][] visited = new boolean[rows][cols];

        // Firstly, we have to add all boundary cells to minHeap
        PriorityQueue<Node> pq = new PriorityQueue<>(
            (a,b) -> a.height - b.height
        );

        // Add the 1st and last column cells to PQ and mark as visited
        for (int i=0;i<rows;i++) {
            pq.offer(new Node(heightMap[i][0], i, 0));
            pq.offer(new Node(heightMap[i][cols - 1], i, cols - 1));

            visited[i][0] = visited[i][cols - 1] = true;
        }

        // Add the 1st and last row cells to PQ and mark as visited
        for (int j=0;j<cols;j++) {
            pq.offer(new Node(heightMap[0][j], 0, j));
            pq.offer(new Node(heightMap[rows - 1][j], rows - 1, j));

            visited[0][j] = visited[rows - 1][j] = true;
        }

        while (!pq.isEmpty()) {
            Node curr = pq.remove();

            for (int dir=0;dir<4;dir++) {
                int neighborRow = curr.row + dirsRow[dir];
                int neighborCol = curr.col + dirsCol[dir];

                if (neighborRow >= 0 && neighborRow < rows && neighborCol >= 0 && neighborCol < cols && !visited[neighborRow][neighborCol]) {
                    int neighborHeight = heightMap[neighborRow][neighborCol];

                    // If neighboring height < boundary height, then water can be stored
                    if (neighborHeight < curr.height) {
                        total += curr.height - neighborHeight;
                    }

                    pq.offer(new Node(Math.max(neighborHeight, curr.height), neighborRow, neighborCol));

                    visited[neighborRow][neighborCol] = true;
                }
            }
        }

        return total;
    }
}