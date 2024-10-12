class Solution {
    public int findTheWinner(int n, int k) {
        Queue<Integer> queue = new LinkedList<>();

        // n friends 
        for (int i=1;i<=n;i++) queue.add(i);
        
        int count = 0;
        // until single friend exists
        while (queue.size() != 1) {
            int element = queue.poll();
            count++;

            if (count == k) {
                count = 0; //Reset
            } else {
                queue.add(element);
            }
        }

        // winner of the game
        return queue.poll();
    }
}