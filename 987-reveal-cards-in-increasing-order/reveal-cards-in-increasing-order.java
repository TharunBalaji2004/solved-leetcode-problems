class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);
        int n = deck.length;
        int[] res = new int[n];

        Queue<Integer> queue = new LinkedList<>();
        for (int i=0;i<n;i++) {
            queue.offer(i);
        }

        for (int num: deck) {
            int front = queue.remove();
            res[front] = num;

            if (!queue.isEmpty()) queue.offer(queue.remove());
        }

        return res;
    }
}