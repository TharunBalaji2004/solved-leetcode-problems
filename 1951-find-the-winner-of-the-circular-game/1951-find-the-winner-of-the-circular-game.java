class Solution {
    public int findTheWinner(int n, int k) {
        Queue<Integer> q = new LinkedList<>();

        for (int i=1;i<=n;i++) q.offer(i);

        int count = 1;
        while (q.size() > 1) {
            int element = q.poll();
            
            if (count == k) {
                count = 1;
            } else {
                q.offer(element);
                count++;
            }
        }   

        return q.poll();
    }
}